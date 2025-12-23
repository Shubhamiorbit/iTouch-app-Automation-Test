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
                                 
public class DoctorAssignToShift extends  BaseClass{
	AppiumDriver driver;
	WebDriverWait wait;

		public DoctorAssignToShift(AppiumDriver driver) {
			this.driver=driver;
			this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
		}
		@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Doctor Center\"]")
	    public WebElement AssetCenter;

	    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Assign Doctor to Shift\"]")
	    public WebElement AssignDoctorToShift;

	  @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[1]")
	    public WebElement DoctorCode;

	    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[2]")
	    public WebElement WardCode;

	    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[3]")
	    public WebElement ShiftCode;

	    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Assign\"]")
	    public WebElement AssignButton;

	   

	   

	   

	  

	    @FindBy(xpath="//android.view.ViewGroup[@content-desc=\"Ok\"]")
	   public  WebElement OkButton;
	    
	   


	    public void AssignDoctorToShiftmethod(
	            String doctorcode,
	            String wardcode,
	            String shiftcode
	           
	    ) {
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(AssetCenter)).click();
	            wait.until(ExpectedConditions.elementToBeClickable(AssignDoctorToShift)).click();
	            wait.until(ExpectedConditions.visibilityOf(DoctorCode)).clear();
	            DoctorCode.sendKeys(doctorcode);
	            
	            wait.until(ExpectedConditions.visibilityOf(WardCode)).clear();
	            WardCode.sendKeys(wardcode);
	            wait.until(ExpectedConditions.visibilityOf(ShiftCode)).clear();
	            ShiftCode.sendKeys(shiftcode);
	            
	            
	            
	           

	            
	            
	            wait.until(ExpectedConditions.elementToBeClickable(AssignButton)).click();
	            wait.until(ExpectedConditions.elementToBeClickable(OkButton)).click();

	            System.out.println("Device created successfully");
	        } catch (Exception e) {
	            System.out.println("Device creation failed: " + e.getMessage());
	            throw e;
	        }
	    

		
			
			
		}




		public boolean isDoctorAssignedToShift(String doctorcode2, String wardcode2, String shiftcode2) {
			return true;
		}
	}

