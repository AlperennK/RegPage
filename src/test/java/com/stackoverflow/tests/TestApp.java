package com.stackoverflow.tests;
import com.stackoverflow.page.HomePage;
import com.stackoverflow.driver.MyDriver;
import com.stackoverflow.page.LoginPage;
import com.stackoverflow.page.TopQuestions;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

public class TestApp {
    WebDriver driver = MyDriver.getDriver();
    HomePage homePage;

    @Before
    public void setUp(){
        homePage=new HomePage(driver);
    }

//    @Test
//    public void iShouldSeeTitle(){
//        Assert.assertEquals(homePage.getTitle(driver),"RingGo Cashless Parking Solution: Register for a RingGo account");
//    }
    @Test
    public void iShouldReceiveErrorForInvalidNumber(){
        Assert.assertEquals(homePage.fillWithInvalidNumber(), "Phone number is invalid");

    }
    @Test
    public void iShouldReceiveAvailableToRegister(){
        Assert.assertEquals(homePage.fillWithValidNumber(), "Number available to register");
    }
    @Test
    public void iShouldSeeCaptchaErr(){
        Assert.assertEquals(homePage.fillCorrectly(), "There is an error in the form. Please check for details below.");
    }

    @Test
    public void iShouldSeeEmailInvalid(){
        Assert.assertEquals(homePage.fillWrongEmail(), "Email is invalid");
    }


    @After
    public void tearDown(){
        driver.close();
        driver.quit();

    }
}
