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
	    public WebElement DoctorCenter;

	    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Assign Doctor to Shift\"]")
	    public WebElement AssignDoctorToShift;

	  @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[1]")
	    public WebElement DoctorCode;

	    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[2]")
	    public WebElement WardCode;

	    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[3]")
	    public WebElement ShiftCode;
	    
	    @FindBy(xpath="//android.view.ViewGroup[contains(@content-desc,'Shift')]")
	    public WebElement selectshift;

	    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Assign\"]")
	    public WebElement AssignButton;
	    
	    @FindBy(xpath="//android.widget.TextView[@text=\"Doctor assigned successfully!\"]")
	    public WebElement doctorassignmentsuccesspopup;


	    @FindBy(xpath="//android.view.ViewGroup[@content-desc=\"Ok\"]")
	   public  WebElement OkButton;
	    
 
	    public String AssignDoctorToShiftmethod(
	            String doctorcode,
	            String wardcode,
	            String shiftcode
	           
	    ) throws InterruptedException {
	        
	            wait.until(ExpectedConditions.elementToBeClickable(DoctorCenter)).click();
	            wait.until(ExpectedConditions.elementToBeClickable(AssignDoctorToShift)).click();
	            wait.until(ExpectedConditions.visibilityOf(DoctorCode)).clear();
	            DoctorCode.sendKeys(doctorcode);
	            
	            wait.until(ExpectedConditions.visibilityOf(WardCode)).clear();
	            WardCode.sendKeys(wardcode);
//	            wait.until(ExpectedConditions.visibilityOf(ShiftCode)).clear();
//	            ShiftCode.sendKeys(shiftcode);
	            wait.until(ExpectedConditions.elementToBeClickable(selectshift)).click();

	            
	            wait.until(ExpectedConditions.elementToBeClickable(AssignButton)).click();
	            String doctorassignmentpopuptext=doctorassignmentsuccesspopup.getText();
	    		System.out.println(doctorassignmentpopuptext);
	    		Thread.sleep(5000);
	            wait.until(ExpectedConditions.elementToBeClickable(OkButton)).click();
	            

	           return doctorassignmentpopuptext;
	        } 			
	
}


