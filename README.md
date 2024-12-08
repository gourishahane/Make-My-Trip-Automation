## Make My Trip Automation
## Project Title
Automating Make My Trip Functionality Using Selenium

## Description
This project automates various aspects of the Make My Trip website to verify search functionalities and retrieve travel details for flights, trains, and buses. It includes dynamic date selection, URL validation, and price comparison for different travel modes. Key features demonstrate Selenium’s capabilities in handling web elements dynamically and validating user interactions.

## Key Features
- Validation: Ensures the URL of Make My Trip homepage contains "makemytrip."
- Flight Details Retrieval: Automates the process of fetching flight details, including the price for a specified route and date.
- Train Details Retrieval: Fetches train details for a specific route and class.
- Bus Search Validation: Verifies that no buses are available for a specific route and date.
- Dynamic Date Selection: Automates the selection of future dates.
- Price Comparison: Stores and prints travel prices for flights and trains for comparison.

## Installation
1. Clone this repository:
   git clone https://github.com/gourishahane/MakeMyTrip-Automation.git
2. Set up the environment:
3. Install Java 11 or higher.
4. Install Maven or Gradle for dependency management.
5. Download and set up the ChromeDriver compatible with your Chrome version.
6. Install dependencies:
   Add Selenium, TestNG, and other required dependencies in your pom.xml or build.gradle.
7. Build the project:
   gradle build
8. Run the test cases:
   gradle test
   
## Usage
1. Navigate to the project directory:
   cd MakeMyTrip-Automation
2. Execute the test cases using TestNG or Gradle:
   gradle test
3. View the results in the console and reports generated in the output folder.

## Test Cases
- TestCase01: Verify Make My Trip Homepage URL
- TestCase02: Get Flight Details from Bangalore to New Delhi
- TestCase03: Get Train Details from Bangalore to New Delhi
- TestCase04: Verify No Buses from Bangalore to Kathmandu

## Skills Used
- Selenium WebDriver
- TestNG
- Dynamic XPaths
- Dynamic Date Handling
- Browser Interaction and Validation
- Dependencies
- Java 11 or higher
- Selenium WebDriver
- TestNG
- Gradle or Maven

## Contact Information
- Name: Gouri Shahane
- Email: gourishahane@gmail.com
- GitHub: github.com/gourishahane
- LinkedIn: linkedin.com/in/gourishahane
