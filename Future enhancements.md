**Framework**

Cucumber and Gherkin Feature Files:
Utilized Cucumber to create Gherkin feature files for defining test scenarios in a readable, business-centric language.

Step Definitions in Java:
Developed corresponding step definition files in Java, implementing methods to execute the steps outlined in the Gherkin scenarios.

Configuration Properties:
Maintained a configuration property file to store browser details and the base URL, ensuring centralized management of test environment configurations.

POM File Dependencies:
Configured the project's POM (Project Object Model) file to manage dependencies, including Selenium, Cucumber, and Extent Reports.

Surefire Plugin for Parallel Execution:
Integrated the Surefire plugin to facilitate parallel execution of tests, optimizing test suite performance.

Data-Driven Testing with Excel:
Leveraged an Excel sheet to store page object details and test data.
Implemented data-driven testing using Scenario Outline in Gherkin for small scenarios, with the flexibility to transition to Excel or JSON for more extensive scenarios in the future.

**Enhancements**
I'm in the process of implementing API automation using Rest Assured and mobile automation with Appium (for native apps; alternative tools for consideration). The test runner file includes code for parallel testing, allowing for the creation of additional Chrome threads by uncommenting specific sections.
Looking ahead, future enhancements are planned, including integration with a bug tracking tool for improved issue management. Additionally, I aim to implement more reusable and maintainable data-driven methods to enhance the overall efficiency and scalability of the automation framework.


**Challenges**
Edge Browser and Driver Compatibility Hurdles: Navigated compatibility challenges arising from a recent update in the Edge browser and Edge driver. Resolved by diligently selecting the appropriate driver version to harmonize with the updated browser.
Jenkins-Localhost Webhook Connectivity Obstacles: Encountered obstacles when attempting to utilize webhooks with Jenkins hosted on localhost. Overcame this hurdle by generating a temporary URL using ngrok, thereby facilitating effective communication between GitHub webhooks and the locally hosted Jenkins instance.
Security and Compatibility Quandaries with Jenkins Plugins: Identified concerns regarding the security and compatibility of specific Jenkins plugins. Addressed these issues by either substituting problematic plugins with alternatives or applying necessary updates to ensure a secure and seamlessly compatible continuous integration environment.

