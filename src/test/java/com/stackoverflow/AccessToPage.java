package com.stackoverflow;

import com.stackoverflow.page.RegistrationPage;
import com.stackoverflow.driver.MyDriver;
import org.openqa.selenium.WebDriver;

public class AccessToPage {
    public static void main(String[] args) {
        RegistrationPage registrationPage;
        WebDriver driver= MyDriver.getDriver();
        registrationPage =new RegistrationPage(driver);
        registrationPage.goToHomePageByCancelButton();

    }
}
