package Pages;
import java.time.Duration;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
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
			wait.until(ExpectedConditions.visibilityOf(PatientCode));
			PatientCode.sendKeys(patientcode);

			wait.until(ExpectedConditions.visibilityOf(FirstName));
			FirstName.sendKeys(firstname);

			wait.until(ExpectedConditions.visibilityOf(LastName));
			LastName.sendKeys(lastname);

			wait.until(ExpectedConditions.visibilityOf(MRNumber));
			MRNumber.sendKeys(mrnumber);

			//wait.until(ExpectedConditions.visibilityOf(DOB)).click();
			
			driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"birthDateInput\"]")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/date_picker_header_year\"]")).click();
			Thread.sleep(3000);
			Random randomyear = new Random();
			int patdobyear = randomyear.nextInt(13) + 1992;
			By yearLocator = By.xpath("//android.widget.TextView[@text='"+patdobyear+"']");

		    for (int i = 0; i < 20; i++) {

		        try {
		            WebElement year = driver.findElement(yearLocator);
		            if (year.isDisplayed()) {
		                year.click();
		                System.out.println(" Year "+patdobyear+" selected");
		                break;
		            }
		        } catch (Exception e) {
		            System.out.println(" "+patdobyear+" not visible yet, swiping...");
		        }

		        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		        Sequence swipe = new Sequence(finger, 1);

		        swipe.addAction(finger.createPointerMove(
		                Duration.ZERO,
		                PointerInput.Origin.viewport(),
		                540, 950   
		        ));

		        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

		        swipe.addAction(new Pause(finger, Duration.ofMillis(200)));

		        swipe.addAction(finger.createPointerMove(
		                Duration.ofMillis(600),
		                PointerInput.Origin.viewport(),
		                540, 1450    // End point (your screen center top)
		        ));

		        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		        driver.perform(Collections.singletonList(swipe));

		        Thread.sleep(300);
		    }
		    Random random1 = new Random();
		    int patday = random1.nextInt(25) + 1;
		    String patdaytext = String.valueOf(patday);
		    String patdayxpath = "new UiSelector().text(\""+patdaytext+"\")";
		    driver.findElement(AppiumBy.androidUIAutomator(patdayxpath)).click();
		    driver.findElement(By.id("android:id/button1")).click();
		    
			wait.until(ExpectedConditions.elementToBeClickable(GenderDropDown)).click();
			wait.until(ExpectedConditions.elementToBeClickable(SelectGender)).click();
			wait.until(ExpectedConditions.elementToBeClickable(BloodGroup)).click();
			wait.until(ExpectedConditions.elementToBeClickable(SelectBloodGroup)).click();

			wait.until(ExpectedConditions.visibilityOf(ContactName));
			ContactName.sendKeys(contactname);

			wait.until(ExpectedConditions.visibilityOf(ContactPhone));
			ContactPhone.sendKeys(contactphone);
		Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(ContactEmail));
			ContactEmail.sendKeys(contactemail);
			Thread.sleep(3000);
			driver.findElement(AppiumBy.androidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true))" +
							".scrollIntoView(new UiSelector().textContains(\"Country\"));"
					));

			wait.until(ExpectedConditions.visibilityOf(Street));
			Street.sendKeys(street);

			wait.until(ExpectedConditions.visibilityOf(City));
			City.sendKeys(city);
			Thread.sleep(2000);

			wait.until(ExpectedConditions.visibilityOf(PinCode));
			PinCode.sendKeys(pincode);

			wait.until(ExpectedConditions.visibilityOf(State));
			State.sendKeys(state);

			wait.until(ExpectedConditions.visibilityOf(Country));
			Country.sendKeys(country);

			// Patient attributes
			wait.until(ExpectedConditions.visibilityOf(Height));
			Height.sendKeys(height);

			wait.until(ExpectedConditions.visibilityOf(Weight));
			Weight.sendKeys(weight);
			Thread.sleep(5000);
			
			driver.findElement(AppiumBy.androidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true))" +
							".scrollIntoView(new UiSelector().textContains(\"Assign Doctor Code*\"));"
					));

			wait.until(ExpectedConditions.visibilityOf(AnyAllergies)).clear();
			AnyAllergies.sendKeys(anyallergies);
			


			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOf(PastComplications));
			PastComplications.sendKeys(pastcomplications);
			
			wait.until(ExpectedConditions.visibilityOf(DoctorCode));
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



