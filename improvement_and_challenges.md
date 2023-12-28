# Issues and Challenges
**Challenge:** Creating and maintaining more code in test automation framework can be complex and time-consuming

**Solution:** Integration of pico container for dependency injection.
Introduced PicoContainer to streamline and manage dependencies within the automation framework.

# Future Improvements
**Scenario Outline**

Scenario Outline in cucumber is a feature in Gherkin, the language used in tools like Cucumber for writing BDD (Behavior-Driven Development) tests. It allows you to run the same test scenario multiple times with different sets of data. It's particularly useful for writing data-driven tests where you want to validate the behavior of a feature against various input values.

*Here is the example:*

Feature: 001 Home Page :User login functionalities-validate user login invalid  functionality is working as  expected

Scenario Outline − Login functionality for a invalid test cases.

when user writes value <username> in element FIRSTNAME_INPUT_FIELD

And user writes value <password> in element LASTNAME_INPUT_FIELD

*Examples:*

*| username  | password  |*

*| username1 | password1 |*

*| username2 | password2 |*


