package com.stackoverflow.page;

import com.stackoverflow.core.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage extends PageBase{


    @FindBy(id = "field-Member_CLI")
    private WebElement mobileNumberField;

    @FindBy(name= "Member_Email")
    private WebElement memberEmail;

    @FindBy(id="labyrinth_UserDetails_next")
    private WebElement nextButton;

    @FindBy(name = "MemberPassword")
    private WebElement memberPass;

    @FindBy(name = "terms")
    private WebElement checkBox;

    @FindBy(id = "climsgbox")
    private WebElement invalidBox;

    @FindBy(id = "emailmsgbox")
    private WebElement emailPopBox;

    @FindBy(className = "screennotifications")
    private WebElement captchaErr;

    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void fillForm(){
        mobileNumberField.sendKeys("+69372968");
        memberEmail.sendKeys("putrandom@email.here");
        memberPass.sendKeys("putrandompasshere");
        checkBox.click();
        nextButton.click();
    }
    public void fillFormDontClick(){
        mobileNumberField.sendKeys("+69372968");
        memberEmail.sendKeys("putrandom@email.here");
        memberPass.sendKeys("putrandompasshere");
        checkBox.click();
    }
    public void fillNextButton(){
        nextButton.click();
    }
    public String getTitle(WebDriver driver){
        return driver.getTitle();
   }

   public String fillWithInvalidNumber(){
        mobileNumberField.sendKeys("xyz912312");
        memberEmail.click();
        pause(2000);
        //wait.until(ExpectedConditions.textToBePresentInElement(invalidBox, "Phone number is invalid\n"));
        return invalidBox.getText();
   }
   public String fillWithValidNumber(){
        mobileNumberField.sendKeys("1231823121");
        memberEmail.click();
        pause(2000);
        return invalidBox.getText();
   }
    public void pause(Integer milliseconds){
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String fillWrongEmail(){
        memberEmail.sendKeys("asdasdad");
        memberPass.click();
        pause(2000);

        return emailPopBox.getText();
    }
    public String fillCorrectEmail(){
        memberEmail.sendKeys("alp@asz.zq");
        memberPass.click();
        pause(2000);
        return emailPopBox.getText();
    }

   public String fillCorrectly(){
        mobileNumberField.sendKeys("905356920254");
        memberEmail.sendKeys("correct@correct.com");
        memberPass.sendKeys("ThisPass1");
        checkBox.click();
        fillNextButton();
        pause(3000);
        return captchaErr.getText();
   }


    public void getSignUpPage(){
        //signup.click();
    }
}