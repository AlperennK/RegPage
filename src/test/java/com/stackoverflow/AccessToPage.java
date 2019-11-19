package com.stackoverflow;

import com.stackoverflow.page.HomePage;
import com.stackoverflow.driver.MyDriver;
import org.openqa.selenium.WebDriver;

public class AccessToPage {
    public static void main(String[] args) {
        HomePage homePage;
        WebDriver driver= MyDriver.getDriver();
        homePage=new HomePage(driver);
        homePage.correctPassword();
    }
}
