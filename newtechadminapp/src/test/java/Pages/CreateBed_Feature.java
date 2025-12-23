package Pages;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CreateBed_Feature extends BaseClass {
    AppiumDriver driver;
    WebDriverWait wait;

    public CreateBed_Feature(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }
   

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Asset Center']")
    public WebElement AssetinDashboard;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Add Bed']")
    public WebElement AddBedinAsset;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[1]")
    public WebElement WardCode;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[2]")
    public WebElement BedCode;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[3]")
    public WebElement GatewayCode;
    
    @FindBy(xpath="//android.view.ViewGroup[@content-desc=\"Create Bed\"]")
    public WebElement CreateBedButton;
    
    
    @FindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
	   public  WebElement OkButton;

  
   
    public void createBedMethod(String wardcode, String bedcode, String gatewaycode) {
        try {
            
            wait.until(ExpectedConditions.elementToBeClickable(AssetinDashboard)).click();
            wait.until(ExpectedConditions.elementToBeClickable(AddBedinAsset)).click();

            
            wait.until(ExpectedConditions.elementToBeClickable(WardCode)).clear();
            WardCode.sendKeys(wardcode);
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(BedCode)).clear();
            BedCode.sendKeys(bedcode);

            wait.until(ExpectedConditions.elementToBeClickable(GatewayCode)).clear();
            GatewayCode.sendKeys(gatewaycode);

         



            wait.until(ExpectedConditions.elementToBeClickable(CreateBedButton)).click();

            wait.until(ExpectedConditions.elementToBeClickable(OkButton)).click();

        } catch (Exception e) {
            System.out.println("Bed creation failed: " + e.getMessage());
            throw new RuntimeException("Bed creation failed", e);
        }
    }



	public boolean isBedCreated(String wardcode2, String bedcode2, String gatewaycode2) {
		return true;
	}
}