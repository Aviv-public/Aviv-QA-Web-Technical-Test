## Work in progress - AVIV QA Web Technical Test with Java and Selenium WebDriver

This repository includes code for automating test scenarios on the https://demo.nopcommerce.com/ website using Java and the Selenium WebDriver library.
The automation follows the principles of the Page Object Model (POM) and Data-Driven Testing (DDT).

## Project Structure

- **src/main/java/pageObjects:** Contains classes representing individual pages, each containing web elements and corresponding action methods.
- **src/main/java/utilities:** Contains helper classes and methods for common functionalities and reusable utilities
- **src/main/java/waitTimes:** Contains predefined wait times for explicit waits

- **src/test/java/testBase:** Contains common setup and teardown methods.
- **src/test/java/testCases:** Contains test classes and methods
- **pom.xml:** Maven configuration file with project dependencies and settings.


### Continuous Integration (CI) with Jenkins
- This project is set up for CI using Jenkins.
- Jenkins will trigger a new build whenever changes are pushed to the repository.

### Reporting with Extent Report
- Extent Report is used for comprehensive test reporting.
- Reports are generated after each test execution and can be found in the /reports directory.
