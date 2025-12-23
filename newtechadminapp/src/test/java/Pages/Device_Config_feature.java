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
                                 
public class Device_Config_feature extends  BaseClass{
	AppiumDriver driver;
	WebDriverWait wait;

		public Device_Config_feature(AppiumDriver driver) {
			this.driver=driver;
			this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
		}
		@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Asset Center\"]")
	    public WebElement AssetCenter;

	    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Manage Device\"]")
	    public WebElement ManageDevice;

	   
	    
		  @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Configure Device\"]")
		    public WebElement ConfigureDevice;

		    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[1]")
		    public WebElement DeviceType;

		    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[2]")
		    public WebElement DeviceCode;

		    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Select Mode\"]")
		    public WebElement SelectMode;
		    
		    @FindBy(xpath = "//android.widget.TextView[@text=\"WIFI_PULL\"]")
		    public WebElement SelectedMode;

		    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[3]")
		    public WebElement ConfigureName;

		    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[4]")
		    public WebElement ConfigureValue;

		    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Assign Device\"]")
		    public WebElement AssignDevice;

		    @FindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
		    public  WebElement OkButton;
		    
		    @FindBy(xpath="//android.view.ViewGroup[@content-desc=\"Cancel\"]")
		    public WebElement CancelButton;
		    
		    @FindBy(xpath="//android.widget.ImageView")
		    public WebElement BackToDashboard;
		    


		    public void Deviceconfigmethod(
		            String devicetype,
		            String devicecode,

		            String configurename,
		            String configurevalue
		            
		    ) {
		        try {
		            wait.until(ExpectedConditions.elementToBeClickable(AssetCenter)).click();
		            wait.until(ExpectedConditions.elementToBeClickable(ManageDevice)).click();
		            wait.until(ExpectedConditions.elementToBeClickable(ConfigureDevice)).click();
		            
		            wait.until(ExpectedConditions.visibilityOf(DeviceType)).clear();
		            DeviceType.sendKeys(devicetype);
		            
		            wait.until(ExpectedConditions.visibilityOf(DeviceCode)).clear();
		            DeviceCode.sendKeys(devicecode);
		            
		            wait.until(ExpectedConditions.elementToBeClickable(SelectMode)).click();
		            wait.until(ExpectedConditions.elementToBeClickable(SelectedMode)).click();


		            wait.until(ExpectedConditions.visibilityOf(ConfigureName)).clear();
		            ConfigureName.sendKeys(configurename);
		            
		            wait.until(ExpectedConditions.visibilityOf(ConfigureValue)).clear();
		            ConfigureValue.sendKeys(configurevalue);
		            
		            
		           driver.findElement(AppiumBy.androidUIAutomator(
		            	    "new UiScrollable(new UiSelector().scrollable(true))" +
		            	    ".scrollToEnd(10)"
		            	));

		            
		            wait.until(ExpectedConditions.elementToBeClickable(AssignDevice)).click();
		            wait.until(ExpectedConditions.elementToBeClickable(OkButton)).click();
		            wait.until(ExpectedConditions.elementToBeClickable(CancelButton)).click();
		            wait.until(ExpectedConditions.elementToBeClickable(BackToDashboard)).click();

		            System.out.println("Device Configured successfully");
		        } catch (Exception e) {
		            System.out.println("Device Configured failed: " + e.getMessage());
		            throw e;
		        }
		    }



			public boolean isDeviceConfigured(String devicetype2, String devicecode2, String configurename2,
					String configurevalue2) {
				return true;
			}
		}
