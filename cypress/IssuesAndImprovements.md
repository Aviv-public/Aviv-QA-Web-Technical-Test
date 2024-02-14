Tools /Frameworks Used:

1. Cypress with Mocha using javaScript
2. MochaAwesome report
3. Data driven and POM
3. Parallel Execution : npm-run-all
4. Automation design: POM with Data Driven
5. GitHub Actions
6. Parameterized tests
7. Environmental Variables

INSTALLATION:

1. Node.js and npm are installed on your system

2. Clone the Repository

3. Install cypress: npm install cypress

4. To Run Cypress tests:
npx cypress open
or
npm test (for parallel runs in Electron, headless by defalut)

5. Reports: 
MochaAwesome reports --> /reports/html/index.html

ISSUES AND CHALLENGES:

1. Remove items from cart has so many loaders/spinners and whole page loads for each item removal which was disrupting the over all flow
      Resolve: Added cy.intercept for all the APIs to load fully and added waits until spinners dissappear and element appear
      
 2. The Login credentials that is generated becomes invalid after sometime, This was an time consuming process while running the tests multiple times. 

    Resolve: Had to Register everytime the script was run

 3. Flaky Tests: I am not sure why but sometimes some errors would show up and the tests would fail because the website was down and work perfectly the next time.

 4. Add elements to cart functionality was flaky: the shopping cart would should shouw different quantities tiime to time.

    Resolve: Had Explicit waits for spinners and elements to be visible

 5. State or Province is not a mandatory field for United states yet throwing error while US is selected.

    Resolve: This may be a Bug but any ways added a flow for the US


IMPROVEMENTS:

1. Imtroducing a custom methods including specific waits to make the tests non-flaky.
2. Introducing a master custom library of common actions and workflow
3. A simple git actions workflow hhas been added but it can be enhanced for more actions in future
4. Logging scripts can be added for better understanding of the flow.


 

