How To Run:

Preconditions: 
1. Java must be installed.
2. Eclipse with testNG plugin.

Steps:
1. Download the repository from the git and import to eclipse.
2. Right click on project -> Maven -> Update project.
3. Open UIAssignmentTests.java -> Right click -> Run as TestNG (triggers the UI tests).


Issues and Challenges: 
1. App does not allow user to perform multiple purchase with short period of time.
2. Emails are no more valid after few minutes.
3. App does not respond to the automation scripts sometimes.

Solutions for above challenges:
1. Verification point is added for first scenario and used refresh.
2. Used custom waits to identify element.
3. I have used random email id generated to Sign up.


Future Improvements: We can improve the tests by:
1. Create individual pages and separating the methods into different pages.
2. Adding necessary logs.
3. Separate the tests for different goals like Smoke and regression.
4. Capturing the screenshots on failure.
5. Using excel to store the data.
6. Handling more browsers types.
7. creating small re-usuable methods.
8. Username can also be moved to env variables.


Bonus Points
1. Implementing parameterized tests. Done
2. Using environmental configurations. Done (Password is read from Env variables)
3. Demonstrating knowledge of parallel test execution. N/A = Since we have only 4 scenarios and all of them are mostly dependent on each other, parallel testing is not effiecient in this case. However we can achive parallel testing using testNG by passing below syntax.

<suite name = "Parallel Testing Suite">
   <test name = "Parallel Tests" parallel = "methods">
      <classes>
         <class name = "ParallelTest" />
      </classes>
   </test>
</suite>