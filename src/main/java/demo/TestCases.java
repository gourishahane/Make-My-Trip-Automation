package demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;




public class TestCases {
    private static RemoteWebDriver driver;

    public TestCases() throws MalformedURLException {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        if (driver != null) {
            driver.quit();
        }
    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get(" https://www.makemytrip.com/ ");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        try {
            WebElement fromCity = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//label[@for='fromCity']")));
            System.out.println("User landed on MMT site successfully");
        } catch (Exception e) {
            System.out.println("User failed to land on MMT site.");
        }
        String url = driver.getCurrentUrl();

        if (url.contains("makemytrip")) {
            System.out.println("Url contains 'makemytrip'.");
        } else {
            System.out.println("Url does not contain 'makemytrip'.");
        }
        System.out.println("End Test case: testCase01");
    }


    public void testCase02() throws InterruptedException {
        System.out.println("Start Test case: testCase02");

        WebDriverWait wait = new WebDriverWait(driver, 30);
       

        try {
            driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
            System.out.println("switched to frame");

            WebElement closeAd = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath(" //div[@class='container']/a")));
            closeAd.click();

            System.out.println("Ad modal closed successfully.");
        } catch (Exception e) {
            System.out.println("No modal appeared.");
        }

        try {
            WebElement closeModal = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//span[@class='commonModal__close']")));
            closeModal.click();
            System.out.println("Sign Up modal closed successfully.");

        } catch (Exception e) {
            System.out.println("No modal appeared.");
        }

        try {
            WebElement fromCity = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='fromCity']")));
            fromCity.click();

            WebElement fromInput = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//input[@placeholder='From']")));
            fromInput.sendKeys("BLR");
            Thread.sleep(5000);

            wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//span[contains(text(),'Bengaluru')]")))
                    .click();

            System.out.println("From city selected successfully.");

        } catch (Exception e) {
            System.out.println("From city selection failed.");

        }

        try {
            WebElement tocity = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='toCity']")));
            tocity.click();

            WebElement toInput = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//input[@placeholder='To']")));
            toInput.sendKeys("del");
            Thread.sleep(5000);

            wait.until(ExpectedConditions
                    .elementToBeClickable(By.id("react-autowhatever-1-section-0-item-0"))).click();

            System.out.println("To city selected successfully.");
        } catch (Exception e) {
            System.out.println("To city selection failed.");

        }
        try {
            
            String xpathExpression = "//div[@class='DayPicker-Months']/div[2]//p[text()='29']";
            WebElement dayToSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            String day=dayToSelect.getText();
            if(day.contains("29")){
            System.out.println("29 date selected successfully.");
            dayToSelect.click();
        }else{
            System.out.println("Date selection failed.");
        }
       } catch (Exception e) {
            System.out.println("Date selection failed.");
        }
        
        try {
            WebElement search = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Search']")));
            search.click();
            System.out.println("Search button clicked.");
        } catch (Exception e) {
            System.out.println("Search button not found.");
        }

        try {
            WebElement flightPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By
                    .xpath("//div[@class='listingCard  appendBottom5']/div[2]/div[2]/div[1]/div[1]/div[1]")));
            String price = flightPrice.getText();
            System.out.println("Flight price: " + price);
        } catch (Exception e) {
            System.out.println("Flight price element not found.");
        }

        System.out.println("End Test case: testCase02");
    }


    public void testCase03() {
    System.out.println("Start Test case: testCase03");

    driver.navigate().back();
    System.out.println("navigated back");

    WebDriverWait wait = new WebDriverWait(driver, 30);

    try {
    WebElement trainsTab = wait.until(ExpectedConditions.elementToBeClickable(
    By.xpath("//a[@href='https://www.makemytrip.com/railways/']")));
    trainsTab.click();
    System.out.println("Trains tab selected successfully.");

    } catch (Exception e) {
    System.out.println("Trains tab selection failed");
    }

    try {
    WebElement fromCity = wait.until(
    ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='fromCity']")));
    fromCity.click();

    WebElement fromInput = wait.until(ExpectedConditions
    .elementToBeClickable(By.xpath("//input[@placeholder='From']")));
    fromInput.sendKeys("ypr");

    wait.until(ExpectedConditions
    .elementToBeClickable(By.xpath("//span[contains(text(),'Bangalore')]")))
    .click();

    System.out.println("From city selected successfully.");

    } catch (Exception e) {
    System.out.println("From city selection failed.");

    }

    try {
    WebElement toCity = wait.until(
    ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='toCity']")));
    // toCity.click();

    WebElement toInput = wait.until(ExpectedConditions
    .elementToBeClickable(By.xpath("//input[@placeholder='To']")));
    toInput.sendKeys("ndls");

    wait.until(ExpectedConditions.elementToBeClickable(
    By.xpath("//span[@class='sr_city blackText' and text()='Delhi']"))).click();

    System.out.println("To city selected successfully.");

    } catch (Exception e) {
    System.out.println("To city selection failed.");

    }

    try {
        String xpathExpression = "//div[contains(@class,'DayPicker-Month')][2]//div[text()='29' and not(contains(@class, 'outside'))]";
        WebElement dayToSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
        String day=dayToSelect.getText();
        if(day.contains("29")){
            System.out.println("29 date selected successfully.");
            dayToSelect.click();
        }else{
            System.out.println("Date selection failed.");
        }
       } catch (Exception e) {
        System.out.println("Date selection failed.");
    }
    

    try {
    WebElement thirdAC = wait.until(
    ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Third AC']")));
    thirdAC.click();

    System.out.println("Third AC selected successfully.");
    } catch (Exception e) {
    System.out.println("Travel class selection failed.");
    }

    try {
    WebElement search = wait.until(
    ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Search']")));
    search.click();
    System.out.println("Search button clicked.");
    } catch (Exception e) {
    System.out.println("Search button not found.");

    }
    try {
    WebElement trainPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(
    By.xpath("//div[@class='card ']/div/div[2]")));
    String price = trainPrice.getText();
    System.out.println("Train price (3A): " + price);
    } catch (Exception e) {
    System.out.println("Train price element not found.");
    }

    System.out.println("End Test case: testCase03");
    }

    public void testCase04() {
    System.out.println("Start Test case: testCase04");

    driver.navigate().back();

    WebDriverWait wait = new WebDriverWait(driver, 30);

    try {
    WebElement busTab = wait.until(ExpectedConditions.elementToBeClickable(
    By.xpath("//a[@href='https://www.makemytrip.com/bus-tickets/']")));
    busTab.click();
    System.out.println("Bus tab selected successfully.");

    } catch (Exception e) {
    System.out.println("Bus tab selection failed");
    }
    
    
    try {
    WebElement fromCityElement = wait.until(
    ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='fromCity']")));
    fromCityElement.click();

    WebElement fromInput = wait.until(ExpectedConditions
    .elementToBeClickable(By.xpath("//input[@placeholder='From']")));
    fromInput.sendKeys("bangl");

    wait.until(ExpectedConditions
    .elementToBeClickable(By.xpath("//span[text()='Bangalore, Karnataka']")))
    .click();

    System.out.println("From city selected successfully.");

    } catch(Exception e) {
    System.out.println("From city selection failed.");

    }
    
    try {
    WebElement toCity = wait.until(
    ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='toCity']")));
    // toCity.click();

    WebElement toInput = wait.until(ExpectedConditions
    .elementToBeClickable(By.xpath("//input[@placeholder='To']")));
    toInput.sendKeys("kathma");

    wait.until(ExpectedConditions
    .elementToBeClickable(By.xpath("//span[text()='Kathmandu, Nepal']"))).click();

    System.out.println("To city selected successfully.");

    } catch (Exception e) {
    System.out.println("To city selection failed.");

    }

    try {
        String xpathExpression = "//div[contains(@class,'DayPicker-Month')][2]//div[text()='29' and not(contains(@class, 'outside'))]";

        WebElement dayToSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
        String day=dayToSelect.getText();
        if(day.contains("29")){
            System.out.println("29 date selected successfully.");
            dayToSelect.click();
        }else{
            System.out.println("Date selection failed.");
        }
    } catch (Exception e) {
        System.out.println("Date selection failed.");
    }
    

    try {
    WebElement search = wait.until(
    ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Search']")));
    search.click();

    System.out.println("Search button clicked");

    } catch (Exception e) {
    System.out.println("Search button not found.");

    }


    try {
    WebElement errorTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By
    .xpath("//span[contains(text(),'No buses found')]")));
    

    String title = errorTitle.getText();
    System.out.println("text: "+title);
    
    if (title.contains("No buses found")) {
        System.out.println("Error title displayed correctly for the next month.");
    } else {
        System.out.println("Error title is not displayed correctly for the next month.");
    }

    } catch (Exception e) {
    System.out.println("Error title is not displayed correctly.");
    }

    System.out.println("End Test case: testCase04");
    }
}
