package Pages;

import java.time.Duration;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;

public class LoginPage extends BaseClass {

    AppiumDriver driver;
    WebDriverWait wait;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @FindBy(xpath = "//android.widget.EditText[@text='Enter Username']")
    public WebElement username;

    @FindBy(xpath = "//android.widget.EditText[@text='Password']")
    public WebElement password;




    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Log in']")
    public WebElement loginButton;

    public void login(String user, String pass) throws Exception {
        try {
            wait.until(ExpectedConditions.visibilityOf(username));
            username.click();
            username.clear();
            username.sendKeys(user);

            try { ((HidesKeyboard) driver).hideKeyboard(); } catch (Exception e) {}

            
            wait.until(ExpectedConditions.visibilityOf(password));

            password.click();
            Thread.sleep(1000);
            try { ((HidesKeyboard) driver).hideKeyboard(); } catch (Exception e) {}

            password.sendKeys(pass);


            wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        } catch (Exception e) {
            System.out.println("Login failed: " + e.getMessage());
            throw e;
        }
    }


    
            
}
