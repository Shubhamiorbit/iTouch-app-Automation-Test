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

	  @FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-nurse-code\"]")
	    public WebElement NurseCode;
	  
	  @FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-shift-code\"]")
	    public WebElement ShiftCode;

	    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-ward-code\"]")
	    public WebElement WardCode;
	    
	    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-bed-code\"]")
	    public WebElement BedCode;

	    

	    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Assign\"]")
	    public WebElement AssignButton;


	    @FindBy(xpath="//android.view.ViewGroup[@content-desc=\"OK\"]")
	   public  WebElement OkButton;
	    
	    @FindBy(xpath="//android.widget.TextView[@text=\"Nurse assigned to bed successfully!\"]")
	    public WebElement nursetobedpopup;
	   


	    public String AssignNurseToBedmethod(
	            String nursecode,
	            String wardcode,
	            String shiftcode,
	            String bedcode

	           
	    ) throws Exception {
	        
	            wait.until(ExpectedConditions.elementToBeClickable(AssetCenter)).click();
	            wait.until(ExpectedConditions.elementToBeClickable(AssignDoctorToBed)).click();
	            wait.until(ExpectedConditions.visibilityOf(NurseCode)).clear();
	            NurseCode.sendKeys(nursecode);	            
	            wait.until(ExpectedConditions.visibilityOf(WardCode)).clear();
	            WardCode.sendKeys(wardcode);
	            wait.until(ExpectedConditions.visibilityOf(BedCode)).clear();
	            BedCode.sendKeys(bedcode);
	            wait.until(ExpectedConditions.visibilityOf(ShiftCode)).clear();
	            ShiftCode.sendKeys(shiftcode);
	            wait.until(ExpectedConditions.elementToBeClickable(AssignButton)).click();
	            String nursetobedpopuptext=nursetobedpopup.getText();
	            Thread.sleep(2000);
	            wait.until(ExpectedConditions.elementToBeClickable(OkButton)).click();

	            return nursetobedpopuptext;
	        } 

			
		}

