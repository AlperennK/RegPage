package com.stackoverflow.page;

import com.stackoverflow.core.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class RegistrationPage extends PageBase{

    @FindBy(id="labyrinth_cancel")
    private WebElement cancelButton;

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

    @FindBy(xpath = "//*[@id=\"header1\"]/ol/li[6]/div/div/span")
    private WebElement wrongPasswordFormat;

    @FindBy(xpath = "//*[@id=\"header\"]/ul[1]/li[2]/a")
    private WebElement permitsButton;

    @FindBy(xpath = "//*[@id=\"header\"]/ul[1]/li[3]/a")
    private WebElement receiptsButton;

    private WebDriverWait wait;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void fillForm(){
        mobileNumberField.sendKeys("+69372968");
        memberEmail.sendKeys("putrandom@email.here");
        memberPass.sendKeys("putrandompasshere");
        checkBox.click();
        nextButton.click();
    }
    public void goPetmitsPage(){
        permitsButton.click();
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
    public String fillWrongPasswordFormat(){
        memberPass.sendKeys("1a2w3e4r");
        memberEmail.click();
        pause(2000);
        return wrongPasswordFormat.getText();

    }
    public String correctPassword(){
        memberPass.sendKeys("1q2sAaB3");
        memberEmail.click();
        pause(2000);
        return wrongPasswordFormat.getText();
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
   public void goToHomePageByCancelButton(){
        cancelButton.click();
   }
   public void goToReceiptsPage(){
        receiptsButton.click();
   }


    public void getSignUpPage(){
        //signup.click();
    }
}
