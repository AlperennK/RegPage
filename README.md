# RegPage
Registration Page POM

How to run
    
    # Run tests.
    $ mvn test

    # Run multiple test classes.
    $ mvn -Dtest=TestApp1,TestApp2 test
    
How to generate auto report

    - install allure from here https://docs.qameta.io/allure/#_installing_a_commandline
    
    When test execution finished, enter below command inside epam project

    - allure serve target/surefire-reports/
    
Should be implemented:

    -Change pause method with ExpectedConditions
    -Write features, add RunCuke etc..
    -Set scenario to wait user input to skip Captcha and continue to success page
    -Add Cross platform option for firefox and explorer. 
    