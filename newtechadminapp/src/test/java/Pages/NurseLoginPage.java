package Pages;


import java.time.Duration;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;

public class NurseLoginPage extends BaseClass {
	
    AppiumDriver driver;
    WebDriverWait wait;
    

    public NurseLoginPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }
    @AndroidFindBy(accessibility ="E-mail Address")
    public WebElement nurseapploginwithemailaddress;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Email Address\")")
    public WebElement nurseusername;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Password\")")
    public WebElement nursepassword;

    @AndroidFindBy(accessibility = "Get OTP")
    public WebElement nurseloginButton;

    public void login(String user, String pass) throws Exception {
       
        	wait.until(ExpectedConditions.visibilityOf(nurseapploginwithemailaddress));
        	nurseapploginwithemailaddress.click();
        
    	try {
            wait.until(ExpectedConditions.visibilityOf(nurseusername));
//            username.click();
//            username.clear();
            nurseusername.sendKeys(user);

            try { ((HidesKeyboard) driver).hideKeyboard(); } catch (Exception e) {}

            
            wait.until(ExpectedConditions.visibilityOf(nursepassword));

            //password.click();
            //Thread.sleep(1000);
            try { ((HidesKeyboard) driver).hideKeyboard(); } catch (Exception e) {}

            nursepassword.sendKeys(pass);


            wait.until(ExpectedConditions.elementToBeClickable(nurseloginButton)).click();
        } catch (Exception e) {
            System.out.println("Login failed: " + e.getMessage());
            throw e;
        }
    
        }         
}
