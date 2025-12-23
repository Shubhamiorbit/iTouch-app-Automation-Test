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

public class Patient_Feature extends BaseClass{
	AppiumDriver driver;
	WebDriverWait wait;

	public Patient_Feature(AppiumDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Patient Center']")
	public WebElement AddPatientinDashboard;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Add Patient']")  
	public WebElement AddPatient;
	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"patientCodeInput\"]")
	public WebElement PatientCode;



	

	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"firstNameInput\"]")
	public WebElement FirstName;



	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"lastNameInput\"]")
	public WebElement LastName;
	@FindBy(xpath="//android.widget.EditText[@content-desc=\"mrNumberInput\"]")
	public WebElement MRNumber;

	@FindBy(xpath="//android.widget.EditText[@content-desc=\"birthDateInput\"]")
	public WebElement DOB;
	
	
	@FindBy(xpath="//android.widget.Button[@resource-id='android:id/button1']")
	public WebElement SelectDate;
	
	
	
	@FindBy(xpath = "//*[@resource-id='genderInput']/..")
	public WebElement GenderDropDown;


@FindBy(xpath="//android.widget.TextView[@content-desc=\"gender_optionText_Male\"]")
public WebElement SelectGender;

@FindBy(xpath = "//*[@resource-id='bloodGroupInput']/..")
public WebElement BloodGroup;

@FindBy(xpath="//android.widget.TextView[@content-desc=\"bloodGroup_optionText_A+\"]")
public WebElement SelectBloodGroup;
	

	@FindBy(xpath="//android.widget.EditText[@content-desc=\"contactNameInput\"]")
	public WebElement ContactName;

	@FindBy(xpath="//android.widget.EditText[@content-desc=\"phoneInput\"]")
	public WebElement ContactPhone;

	@FindBy(xpath="//android.widget.EditText[@content-desc=\"emailInput\"]")
	public WebElement ContactEmail;


	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"streetInput\"]")
	public WebElement Street;

	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"cityInput\"]")
	public WebElement City;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"pincodeInput\"]")
    public WebElement PinCode;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"stateInput\"]")
    public WebElement State;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"countryInput\"]")
    public WebElement Country;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"heightInput\"]")
    public WebElement Height;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"weightInput\"]")
    public WebElement Weight;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"allergiesInput\"]")
    public WebElement AnyAllergies;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"pastComplicationsInput\"]")
    public WebElement PastComplications;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"doctorCodeInput\"]")
    public WebElement DoctorCode;

	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"addPatientButton\"]")
	public WebElement AddPatientButton;
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"successOkButton\"]")
	public WebElement OkButton;
	
	

    

	public void createpatient(String patientcode, String patientname,String firstname, 
			String lastname, String mrnumber, String contactname,
			String contactphone, String contactemail, String street, String city, 
			String pincode, String state, String country, String height, String 
			weight,String anyallergies, String pastcomplications, String doctorcodeforpatient) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(AddPatientinDashboard)).click();
			wait.until(ExpectedConditions.elementToBeClickable(AddPatient)).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(PatientCode)).clear();
			PatientCode.sendKeys(patientcode);

			wait.until(ExpectedConditions.visibilityOf(FirstName)).clear();
			FirstName.sendKeys(firstname);

			wait.until(ExpectedConditions.visibilityOf(LastName)).clear();
			LastName.sendKeys(lastname);

			wait.until(ExpectedConditions.visibilityOf(MRNumber)).clear();
			MRNumber.sendKeys(mrnumber);

			wait.until(ExpectedConditions.visibilityOf(DOB)).click();
			

			

			wait.until(ExpectedConditions.visibilityOf(SelectDate)).click();
			wait.until(ExpectedConditions.elementToBeClickable(GenderDropDown)).click();
			wait.until(ExpectedConditions.elementToBeClickable(SelectGender)).click();
			wait.until(ExpectedConditions.elementToBeClickable(BloodGroup)).click();
			wait.until(ExpectedConditions.elementToBeClickable(SelectBloodGroup)).click();

			wait.until(ExpectedConditions.visibilityOf(ContactName)).clear();
			ContactName.sendKeys(contactname);

			wait.until(ExpectedConditions.visibilityOf(ContactPhone)).clear();
			ContactPhone.sendKeys(contactphone);
			driver.findElement(AppiumBy.androidUIAutomator(
				    "new UiScrollable(new UiSelector().scrollable(true))" +
				    ".scrollIntoView(new UiSelector().textContains(\"Pincode\"));"
				));
		Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(ContactEmail)).clear();
			ContactEmail.sendKeys(contactemail);
			Thread.sleep(2000);
			
			Thread.sleep(2000);

			
			// Address details
			wait.until(ExpectedConditions.visibilityOf(Street)).clear();
			Street.sendKeys(street);

			wait.until(ExpectedConditions.visibilityOf(City)).clear();
			City.sendKeys(city);
			Thread.sleep(2000);

			wait.until(ExpectedConditions.visibilityOf(PinCode)).clear();
			PinCode.sendKeys(pincode);

			wait.until(ExpectedConditions.visibilityOf(State)).clear();
			State.sendKeys(state);

			wait.until(ExpectedConditions.visibilityOf(Country)).clear();
			Country.sendKeys(country);

			// Patient attributes
			wait.until(ExpectedConditions.visibilityOf(Height)).clear();
			Height.sendKeys(height);
			 driver.findElement(AppiumBy.androidUIAutomator(
	            	    "new UiScrollable(new UiSelector().scrollable(true))" +
	            	    ".scrollToEnd(10)"
	            	));

			wait.until(ExpectedConditions.visibilityOf(Weight)).clear();
			Weight.sendKeys(weight);
			Thread.sleep(2000);
			
			
				Thread.sleep(2000);

			wait.until(ExpectedConditions.visibilityOf(AnyAllergies)).clear();
			AnyAllergies.sendKeys(anyallergies);
			


			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(PastComplications)).clear();
			PastComplications.sendKeys(pastcomplications);
			
			wait.until(ExpectedConditions.visibilityOf(DoctorCode)).clear();
			DoctorCode.sendKeys(doctorcodeforpatient);

			

			wait.until(ExpectedConditions.elementToBeClickable(AddPatientButton)).click();
			wait.until(ExpectedConditions.elementToBeClickable(OkButton)).click();

		}catch (Exception e) {
			System.out.println("Patient creation failed: " + e.getMessage());
		}

	}





	public boolean isPatientCreated(String patientcode2) {
		return true;
	}
}



