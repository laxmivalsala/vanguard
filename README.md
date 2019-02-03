# Vanguard Automation Excercise

The following soution contains UI and API Automation test scripts to validate Vanguard functionalities

 * Java,Cucumber,Gradle, Selenium - for UI Automation
 *  Java,Cucumber,Gradle, Restassured - for API Automation


# Running UI Tests

  - Scripts are developed in Intellij (Get Cucumber Plugins to get BDD features in Intellij)
  - Use TestRunner class / Feature file to run the UI test cases
  - Environment/Browser configurations are read from config.properties file, supports both Chrome and Firefox
  - Implemented using Page Object Model 
  - Page Objects are available in Pages package
  - Selenium wrapper methods are created in Commands class
  - Cucumber scenario hooks are used for initialise and clean up 
  - Pico Container to share the state between the steps (driver)
  
  # Running API Tests

  - API Tests are available in the same project under package apiTest
  - API tests in VanguardAPITest class can be run using junit 

# Important

- Test cases are verified to be run in following configurations

- Chrome Version - Version 71.0.3578.98 (Official Build) (64-bit)
- Selenium version -version: '3.141.59'
- Firefox version - 65.0 (64-bit)
- Firefox driver version- geckodriver-23.exe
- Chrome driver version- chromedriver latest
