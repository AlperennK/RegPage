package com.stackoverflow.page;

import com.stackoverflow.core.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CorporateRegisterPage extends PageBase {
    @FindBy(css = "#header-navigation > li:nth-child(4) > p > a")
    WebElement loginButton;

    public CorporateRegisterPage (WebDriver driver){
        super(driver);
    }
    public void getLoginPage(){
        waitUntilClickable(loginButton).click();
    }

}
