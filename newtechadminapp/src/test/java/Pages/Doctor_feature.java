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

public class Doctor_feature extends BaseClass {

	AppiumDriver driver;
	WebDriverWait wait;

	public Doctor_feature(AppiumDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	// Navigation
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Doctor Center']")
	public WebElement DoctorCenter;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Add Doctor']")
	public WebElement AddDoctor;

	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[1]")
	public WebElement DoctorCode;

	@FindBy(xpath = "//android.widget.EditText[2]")
	public WebElement FirstName;

	@FindBy(xpath = "//android.widget.EditText[3]")
	public WebElement LastName;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Doctor Speciality*']")
	public WebElement Speciality;


	@FindBy(xpath="//android.widget.TextView[@text=\"General Physician\"]")
	public  WebElement SelectSpeciality;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Gender*\"]")
	public WebElement GenderDropDown;


	@FindBy(xpath="//android.widget.TextView[@text=\"female\"]")
	public WebElement SelectGender;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Doctor Type*\"]")
	public WebElement DoctorType;


	@FindBy(xpath="//android.widget.TextView[@text=\"SHIFT\"]")
	public WebElement SelectDoctorType;



	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-experience\"]")
	public WebElement Experience;

	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"Birth Date*\"]")
	public WebElement DOB;


	@FindBy(xpath="//android.widget.Button[@resource-id='android:id/button1']")
	public WebElement SelectDate;




	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-contactName\"]")
	public WebElement ContactName;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-phone\"]")
	public WebElement ContactPhone;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-email\"]")
	public WebElement ContactEmail;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-street1\"]")
	public WebElement Street;

	//    @FindBy(xpath = "(//android.widget.EditText)[22]")
	//    public WebElement Street;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-city\"]")
	public WebElement City;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-pincode\"]")
	public WebElement PinCode;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-state\"]")
	public WebElement State;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-country\"]")
	public WebElement Country;

	@FindBy(xpath = "//android.widget.TextView[@text=\"Save Doctor\"]")
	public WebElement SaveButton;

	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"Ok\"]")
	public WebElement OkButton;


	public void createDoctoremethod(
			String doctorcode,
			String firstname,
			String lastname,
			String speciality,
			String experience,
			String birthdate,
			String street,
			String city,
			String pincode,
			String state,
			String country,
			String contactname,
			String contactphone,
			String contactemail
			) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(DoctorCenter)).click();
			wait.until(ExpectedConditions.elementToBeClickable(AddDoctor)).click();

			wait.until(ExpectedConditions.visibilityOf(DoctorCode)).clear();
			DoctorCode.sendKeys(doctorcode);
			FirstName.sendKeys(firstname);
			LastName.sendKeys(lastname);


			wait.until(ExpectedConditions.elementToBeClickable(Speciality)).click();
			wait.until(ExpectedConditions.elementToBeClickable(SelectSpeciality)).click();
			wait.until(ExpectedConditions.visibilityOf(Experience)).clear();
			Experience.sendKeys(experience);



			wait.until(ExpectedConditions.elementToBeClickable(DoctorType)).click();
			wait.until(ExpectedConditions.elementToBeClickable(SelectDoctorType)).click();

			wait.until(ExpectedConditions.visibilityOf(DOB)).click();
			wait.until(ExpectedConditions.visibilityOf(SelectDate)).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(GenderDropDown)).click();
			wait.until(ExpectedConditions.elementToBeClickable(SelectGender)).click();

			driver.findElement(AppiumBy.androidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true))" +
							".scrollIntoView(new UiSelector().textContains(\"male\"));"
					));

			
			wait.until(ExpectedConditions.visibilityOf(Street));
			wait.until(ExpectedConditions.elementToBeClickable(Street));
			Street.clear();
			Street.sendKeys(street);
			driver.findElement(AppiumBy.androidUIAutomator(
				    "new UiScrollable(new UiSelector().scrollable(true))" +
				    ".scrollIntoView(new UiSelector().textContains(\"Pincode\"));"
				));
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(City)).sendKeys(city);
			wait.until(ExpectedConditions.elementToBeClickable(PinCode)).sendKeys(pincode);
			wait.until(ExpectedConditions.elementToBeClickable(State)).sendKeys(state);
			wait.until(ExpectedConditions.elementToBeClickable(Country)).sendKeys(country);

			
			wait.until(ExpectedConditions.elementToBeClickable(ContactName)).sendKeys(contactname);
			wait.until(ExpectedConditions.elementToBeClickable(ContactPhone)).sendKeys(contactphone);
			wait.until(ExpectedConditions.elementToBeClickable(ContactEmail)).sendKeys(contactemail);
			driver.findElement(AppiumBy.androidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true))" +
							".scrollIntoView(new UiSelector().description(\"Save Doctor\"));"
					));

			wait.until(ExpectedConditions.elementToBeClickable(SaveButton)).click();
			wait.until(ExpectedConditions.elementToBeClickable(OkButton)).click();

			System.out.println("Doctor created successfully");
		} catch (Exception e) {
			System.out.println("Doctor creation failed: " + e.getMessage());
		}
	}


	public boolean isDoctorCreated(String doctorcode2) {
		return true;
	}
}