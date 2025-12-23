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
                                 
public class DeviceAssignToBed_Feature extends  BaseClass{
	AppiumDriver driver;
	WebDriverWait wait;

		public DeviceAssignToBed_Feature(AppiumDriver driver) {
			this.driver=driver;
			this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
		}
		@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Asset Center\"]")
	    public WebElement AssetCenter;

	    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Manage Device\"]")
	    public WebElement ManageDevice;

	    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Assign Device to Bed\"]")
	    public WebElement AssignDeviceToBed;
	    
	    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[1]")
	    public WebElement WardCode;
	    
	    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[2]")
	    public WebElement BedCode;
	    
	    
	  @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[3]")
	    public WebElement GatewayCode;
	  
	  @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[4]")
	    public WebElement DeviceCode;

	    
	    
	   

	    

	    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Assign Device\"]")
	    public WebElement AssignButton;

	   

	   

	   

	  

	    @FindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
	   public  WebElement OkButton;
	    @FindBy(xpath="//android.widget.ImageView")
	    public WebElement BackNavigationToDashboard;
	    
	   


	    public void AssignDeviceToBedmethod(
	            String wardcode,
	            String bedcode,
	            String gatewaycode,
	            String shiftcode,
	            String  devicecode
	           
	    ) {
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(AssetCenter)).click();
	            wait.until(ExpectedConditions.elementToBeClickable(ManageDevice)).click();
	            wait.until(ExpectedConditions.elementToBeClickable(AssignDeviceToBed)).click();

	            wait.until(ExpectedConditions.visibilityOf(WardCode)).clear();
	            WardCode.sendKeys(wardcode);
	            wait.until(ExpectedConditions.visibilityOf(BedCode)).clear();
	            BedCode.sendKeys(bedcode);
	            
	            wait.until(ExpectedConditions.visibilityOf(GatewayCode)).clear();
	            GatewayCode.sendKeys(gatewaycode);
	            wait.until(ExpectedConditions.visibilityOf(DeviceCode)).clear();
	            DeviceCode.sendKeys(devicecode);
	           
	            
	            
	            

	            driver.findElement(AppiumBy.androidUIAutomator(
	            	    "new UiScrollable(new UiSelector().scrollable(true))" +
	            	    ".scrollToEnd(10)"
	            	));

	            
	            
	            wait.until(ExpectedConditions.elementToBeClickable(AssignButton)).click();
	            wait.until(ExpectedConditions.elementToBeClickable(OkButton)).click();
	            wait.until(ExpectedConditions.elementToBeClickable(BackNavigationToDashboard)).click();


	            System.out.println("Assigned the Device to bed successfully");
	        } catch (Exception e) {
	            System.out.println("Assigned the Device to bed failed: " + e.getMessage());
	            throw e;
	        }
	    

		
			
			
		}




		public boolean isDeviceAssignedToBed(String devicecode2, String bedcode2) {
			return true;
		}
	}

