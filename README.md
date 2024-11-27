#  FitPeo-Web Automation Script

## Overview

This is an automation script developed using **JAVA**, **Selenium WebDriver** and **TestNG** for testing a  FitPeo web application. The script handles dynamic web elements and performs various actions like navigating to pages, interacting with sliders, updating text fields, and validating results.

## Features

- Navigate to a Revenue Calculator Page.
- Interact with dynamic elements (e.g., buttons, sliders).
- Perform assertions to verify correct behavior.
- Integrates with **TestNG** for test management and reporting.

## Prerequisites

Before running the script, ensure you have the following installed on your system:

- **Java 8 or higher**: You can download it from [Oracle JDK site](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- **Maven** (optional for dependency management): Download from [Maven official site](https://maven.apache.org/download.cgi).
- **Selenium WebDriver** libraries.
- **TestNG** library for running tests and generating reports.
- **ChromeDriver** or appropriate WebDriver for the browser you are testing with. Download from [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/downloads).

## Setting Up the Project

### Step 1: Clone the Repository

Clone the repository to your local machine using Git:

```bash
git clone <repository-url>

```
### Step 2: Install Dependencies

If you're using **Maven**, you can add the necessary dependencies in the `pom.xml` file.

#### Example `pom.xml` dependency for TestNG and Selenium:

```xml
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.10.2</version>
</dependency>

<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.26.0</version>
</dependency>

<dependency>
    <groupId>com.aventstack</groupId>
    <artifactId>extentreports</artifactId>
    <version>5.1.2</version>
</dependency>
```

Run the following command to install dependencies:

```bash
mvn install
```

### Step 3: Set Up WebDriver

- Download **ChromeDriver** (or the respective WebDriver for your browser) from the appropriate site based on your browser version.
- Place the WebDriver in a known location and update the script with the correct path to `chromedriver.exe`.

For example:

```java
System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
```

### Step 4: Configure and Run Tests

1. **Run Tests Using TestNG**:
   - If you are using an IDE (e.g., IntelliJ IDEA or Eclipse), right-click the test class `WebAutomationTest.java` and select **Run with TestNG**.
   - Alternatively, run the tests via the command line using Maven:

   ```bash
   mvn test
   ```

## Test Case Breakdown

### Test 1: Navigate to the FitPeo Homepage

- Navigates to the specified URL.
- Verifies the page title.

### Test 2: Navigate To Revenue Calculator Page

- Waits for a  Revenue Calculator Page to appear.


### Test 3: Scroll Down to the Slider section and Adjust the Slider

- Adjusts the slider to a specified value and validates the text field associated with it.

### Test 4: Update Text Field And Validate Slider Value

- Updates the text field and validates that the corresponding slider value changes accordingly.

### Test 5: Select CPT Codes


  ### Test 6: Validate Total Recurring Reimbursement
  

## Error Handling

The script includes basic error handling with try-catch blocks for each test. If an error occurs, it will log the error message and mark the test as failed.

## Notes

- **Dynamic Element Handling**: The script uses `WebDriverWait` with `ExpectedConditions` to handle elements that might be loaded dynamically.
- **Cross-Browser Testing**: The WebDriver can be easily configured to run on different browsers (e.g., Firefox, Edge) by updating the WebDriver setup.
- **Assertions**: The script verifies whether the web application behaves as expected using assertions to validate elements on the page.

## Maintenance and Best Practices

- Use **Page Object Model** (POM) pattern for better maintainability.
- Implement reusable functions for common actions like clicking buttons, waiting for elements, etc.
- Structure test cases in a modular way so that they can be easily extended in the future.

## Conclusion

This automation script is designed to be simple, maintainable, and adaptable to different web applications. By following the setup instructions, you can easily run the script in your local environment and extend it for more complex test scenarios.

```

### Key Points:
- This `README.md` provides a comprehensive setup guide for your automation script.
- It includes step-by-step instructions for setting up dependencies, configuring the WebDriver, and running the tests.
- It explains the purpose and details of each test case, making the script understandable and maintainable.

