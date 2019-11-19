package com.stackoverflow.tests;
import com.stackoverflow.page.RegistrationPage;
import com.stackoverflow.driver.MyDriver;
import org.junit.*;
import org.openqa.selenium.WebDriver;

public class TestApp {
    WebDriver driver = MyDriver.getDriver();
    RegistrationPage registrationPage;

    @Before
    public void setUp(){
        registrationPage =new RegistrationPage(driver);
    }

    @Test
    public void iShouldReceiveErrorForInvalidNumber(){
        Assert.assertEquals(registrationPage.fillWithInvalidNumber(), "Phone number is invalid");

    }
    @Test
    public void iShouldReceiveAvailableToRegister(){
        Assert.assertEquals(registrationPage.fillWithValidNumber(), "Number available to register");
    }
    @Test
    public void iShouldSeeCaptchaErr(){
        Assert.assertEquals(registrationPage.fillCorrectly(), "There is an error in the form. Please check for details below.");
    }
    @Test
    public void iShouldSeeWrongPasswordFormatError(){
        Assert.assertEquals(registrationPage.fillWrongPasswordFormat(), "The password does not meet the correct format.");
    }
    @Test
    public void iShouldGoBackHomePage(){
        registrationPage.goToHomePageByCancelButton();
        Assert.assertEquals(driver.getCurrentUrl(), "http://myRingGoTest:W4t3Rf4lls@myrgo-preprod.ctt.co.uk/home");
    }
    @Test
    public void iShouldGoBackToPermits(){
        registrationPage.goPetmitsPage();
        Assert.assertEquals(driver.getCurrentUrl(), "http://myRingGoTest:W4t3Rf4lls@myrgo-preprod.ctt.co.uk/permits");
    }
    @Test
    public void iShouldGoReceiptsPage(){
        registrationPage.goToReceiptsPage();
        Assert.assertEquals(driver.getCurrentUrl(), "http://myRingGoTest:W4t3Rf4lls@myrgo-preprod.ctt.co.uk/statements");
    }


    @Test
    public void iShouldSeeEmailInvalid(){
        Assert.assertEquals(registrationPage.fillWrongEmail(), "Email is invalid");
    }


    @After
    public void tearDown(){
        driver.close();
        driver.quit();

    }
}
