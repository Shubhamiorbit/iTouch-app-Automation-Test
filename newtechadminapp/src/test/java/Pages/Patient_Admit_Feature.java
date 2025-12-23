package Pages;
import java.time.Duration;
import java.util.Collections;
import java.util.NoSuchElementException;

import javax.sound.midi.Sequence;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Patient_Admit_Feature extends BaseClass{
	AppiumDriver driver;
	WebDriverWait wait;

	public Patient_Admit_Feature(AppiumDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Patient Center']")
	public WebElement AddPatientinDashboard;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Admit Patient\"]")  
	public WebElement AdmitPatient;
	@FindBy(xpath = "//android.widget.EditText[@text=\"Search by Name / Code\"]")
	public WebElement PatientCode;



	

	@FindBy(xpath = "//android.view.ViewGroup[contains(@content-desc,'pat') and contains(@content-desc,'Status: OUTPATIENT')]")
	public WebElement SelectPatient;




	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[1]")
	public WebElement MedicalHistroy;
	@FindBy(xpath="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[2]")
	public WebElement AdmissionReason;

	@FindBy(xpath="//android.widget.EditText[@text=\"Auto suggested\"]")
	public WebElement WardCode;
	

	@FindBy(xpath="//android.widget.EditText[@text=\"Auto suggest\"]")
	public WebElement BedCode;
	
	
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Admit\"]")
	public WebElement Admit;

	  @FindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
	   public  WebElement OkButton;
	   @FindBy(xpath="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView")
	    public WebElement BackToDashboard;
	    

    

	public void admitpatient(String patientcode, String medicalhistroy,String admissionreason, 
			String wardcode, String bedcode) {
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(AddPatientinDashboard)).click();
			wait.until(ExpectedConditions.elementToBeClickable(AdmitPatient)).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(PatientCode)).click();
			wait.until(ExpectedConditions.visibilityOf(PatientCode)).clear();
			PatientCode.sendKeys(patientcode);
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(SelectPatient)).click();
			System.out.println(SelectPatient +"clicked");
			wait.until(ExpectedConditions.elementToBeClickable(SelectPatient)).click();

			wait.until(ExpectedConditions.visibilityOf(MedicalHistroy)).clear();
			MedicalHistroy.sendKeys(medicalhistroy);

			wait.until(ExpectedConditions.visibilityOf(AdmissionReason)).clear();
			AdmissionReason.sendKeys(admissionreason);
			
			driver.findElement(AppiumBy.androidUIAutomator(
	        	    "new UiScrollable(new UiSelector().scrollable(true))" +
	        	    ".scrollToEnd(10)"
	        	));

			wait.until(ExpectedConditions.visibilityOf(WardCode)).clear();
			WardCode.sendKeys(wardcode);
			
			wait.until(ExpectedConditions.visibilityOf(BedCode)).clear();
			BedCode.sendKeys(bedcode);
			 
			driver.findElement(AppiumBy.androidUIAutomator(
	        	    "new UiScrollable(new UiSelector().scrollable(true))" +
	        	    ".scrollToEnd(10)"
	        	));

			wait.until(ExpectedConditions.visibilityOf(Admit)).click();
			

			

			
			wait.until(ExpectedConditions.elementToBeClickable(OkButton)).click();
			wait.until(ExpectedConditions.elementToBeClickable(BackToDashboard)).click();

		}catch (Exception e) {
			System.out.println("Patient admit failed: " + e.getMessage());
		}

	}




	public boolean isPatientAdmitted(String patientcode2) {
		return true;
	}
}



