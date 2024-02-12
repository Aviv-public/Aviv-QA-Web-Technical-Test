
<img width="100" alt="Screenshot 2021-06-29 at 8 12 27 AM" src="https://user-images.githubusercontent.com/39675511/123728969-d2a87b00-d8b1-11eb-9ece-558d4021f816.png">

# Aviv-test-automation using Cypress for UI 

## Table of Contents

- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running Tests](#running-tests)
- [Reports](#reports)
- [CI with GitHub Action](#ci-with-github-action)
- [Screenshots](#screenshots)
- [Videos Recording](#videos-recording)


## Prerequisites

- Ensure Node.js and npm are installed on your machine.
- Use a code editor (Visual Studio Code is preferred).

## Installation

Clone the repository:

```sh
git clone https://github.com/sumant326541/Aviv-QA-Web-Technical-Test.git
```
install dependencies mentioned in package.json

```sh
npm install
```

## Running Tests
- Running-All-Tests
 : Execute tests in the Electron browser (headless) by default.

    ```js
    npm run test
    ```
    Execute UI tests in Chrome browser in headed mode.

    ```js
    npm run chrome
    ```
## Reports
- Intigrated with mocha awesome report
- An HTML report will be generated in the report folder. 

## Screenshots

Screenshots of failed steps can be found in the Cypress/screenshots folder.

## Videos Recording

Test execution screen recordings are saved in the Cypress/video folder.

## CI with GitHub Action
- The workflow is defined in .github/workflows/push.yml 
- On each push or Pull Request, all tests will be executed.

##################################################################

# Challenges:

### Challenge 1: Registered user not valid any more after some time that cause of failure of login with existing user (this could be a defect)
- Resolution: Alwayas Register a new user before login

### Challenge 2: Registration with same email id not allowed next time 
- Resolution: Used faker to generate random email id during registration and update same in login data sheet

### Challenge 3: Multiple checkout with same account with in minutes has different flow for update address. Also some time chekout not allowed immediatley after one sucessful checkout
- Resolution: for each chekout register a new accout

### Challenge 4:  'Add to Cart' flow is different for different product
- Resolution: Implemented product specific scenario best on behaviour


### Challenge 5: Province displaying only for Country 'United States'
- Resolution: Add condition step for country specific

### Challenge 6: Flakiness in Placing Orders/Add to cart
- Resolution:Sychronise with wait time or conditional acyton on element to optimize test stability.

### Challenge 7:  Data Driven
- Careful thought was given to efficiently manage test data for scenarios involving various product types and quantities. Implemented data-driven strategies and parameterization to ensure optimal test coverage.


########################################################################

# Future Imrovement
- Enhanced test coverage and assertions.
- Implemented BDD cucumber for increased reusability.
- Expanded the repertoire of reusable methods in command.js.
- Implemented exception handling based on conditional steps.
- Utilized CICD with GitLab Runner and Jenkins.
- Introduced additional reporting options, including Allure.
- Adopted a more robust data-driven approach for running tests with multiple sets of data.

