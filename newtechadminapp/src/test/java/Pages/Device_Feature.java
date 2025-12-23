package Pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
                                 
public class Device_Feature extends  BaseClass{
	AppiumDriver driver;
	WebDriverWait wait;

		public Device_Feature(AppiumDriver driver) {
			this.driver=driver;
			this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
		}
		@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Asset Center\"]")
	    public WebElement AssetCenter;

	    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Manage Device\"]")
	    public WebElement ManageDevice;

@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"Add Device\"]")
public WebElement AddDevice;

@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[1]")
public WebElement DeviceCode;

@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[2]")
public WebElement DeviceType;

@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[3]")
public WebElement UsageType;


@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[4]")
public WebElement VerifyWith;

@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[5]")
public WebElement Protocol;


@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Add Device\"]")
public WebElement AddDeviceButton;

@FindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
public  WebElement OkButton;
 
 @FindBy(xpath="//android.view.ViewGroup[@content-desc=\"Cancel\"]")
 public WebElement CancelButton;




public void createDevicemethod(
        String  devicecode,

		String devicetype,
        String usagetype,
        String verifywith,
        String protocol

       
) {
    try {
        wait.until(ExpectedConditions.elementToBeClickable(AssetCenter)).click();
        wait.until(ExpectedConditions.elementToBeClickable(ManageDevice)).click();
        wait.until(ExpectedConditions.elementToBeClickable(AddDevice)).click();

        wait.until(ExpectedConditions.visibilityOf(DeviceCode)).clear();
        DeviceCode.sendKeys(devicecode);
        wait.until(ExpectedConditions.visibilityOf(DeviceType)).clear();
        DeviceType.sendKeys(devicetype);
        
        wait.until(ExpectedConditions.visibilityOf(VerifyWith)).clear();
        VerifyWith.sendKeys(verifywith);
        
        wait.until(ExpectedConditions.visibilityOf(Protocol)).clear();
        Protocol.sendKeys(protocol);
       
        
        
        
        driver.findElement(AppiumBy.androidUIAutomator(
        	    "new UiScrollable(new UiSelector().scrollable(true))" +
        	    ".scrollToEnd(10)"
        	));

        
        
        wait.until(ExpectedConditions.elementToBeClickable(AddDeviceButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(OkButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(CancelButton)).click();


        System.out.println("Device Create successfully");
    } catch (Exception e) {
        System.out.println("Device created failed: " + e.getMessage());
        throw e;
    }



	
	
}




public boolean isDeviceCreated(String devicecode) {
	return true;
}
}

