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
                                 
public class NurseAssignToBed_Feature extends  BaseClass{
	AppiumDriver driver;
	WebDriverWait wait;

		public NurseAssignToBed_Feature(AppiumDriver driver) {
			this.driver=driver;
			this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
		}
		@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Nurse Center\"]")
	    public WebElement AssetCenter;

	    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Assign Nurse to Bed\"]")
	    public WebElement AssignDoctorToBed;

	  @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[1]")
	    public WebElement NurseCode;
	  
	  @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[2]")
	    public WebElement ShiftCode;

	    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[3]")
	    public WebElement WardCode;
	    
	    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[4]")
	    public WebElement BedCode;

	    

	    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Assign\"]")
	    public WebElement AssignButton;

	   

	   

	   

	  

	    @FindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
	   public  WebElement OkButton;
	    
	   


	    public void AssignNurseToBedmethod(
	            String nursecode,
	            String wardcode,
	            String shiftcode,
	            String bedcode

	           
	    ) {
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(AssetCenter)).click();
	            wait.until(ExpectedConditions.elementToBeClickable(AssignDoctorToBed)).click();
	            wait.until(ExpectedConditions.visibilityOf(NurseCode)).clear();
	            NurseCode.sendKeys(nursecode);
	            wait.until(ExpectedConditions.visibilityOf(ShiftCode)).clear();
	            ShiftCode.sendKeys(shiftcode);
	            
	            wait.until(ExpectedConditions.visibilityOf(WardCode)).clear();
	            WardCode.sendKeys(wardcode);
	            wait.until(ExpectedConditions.visibilityOf(BedCode)).clear();
	            BedCode.sendKeys(bedcode);
	           
	            
	            
	            
	           

	            
	            
	            wait.until(ExpectedConditions.elementToBeClickable(AssignButton)).click();
	            wait.until(ExpectedConditions.elementToBeClickable(OkButton)).click();

	            System.out.println("Assigned the Nurse to Bed successfully");
	        } catch (Exception e) {
	            System.out.println("Assigned the Nurse to Bed failed: " + e.getMessage());
	            throw e;
	        }
	    

		
			
			
		}




		public boolean isNurseAssignedToBed(String nursecode2, String bedcode2) {
			return true;
		}
	}

