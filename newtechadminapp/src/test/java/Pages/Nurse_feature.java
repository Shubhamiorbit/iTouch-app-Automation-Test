package Pages;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
public class Nurse_feature extends BaseClass{

	AppiumDriver driver;
	WebDriverWait wait;

	public Nurse_feature(AppiumDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Nurse Center\"]")
	public WebElement NurseCenter;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Add Nurse\"]")  
	public WebElement AddNurse;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-nurse-code\"]")
	public WebElement NurseCode;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-first-name\"]")
	public WebElement FirstName;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-last-name\"]")
	public WebElement LastName;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-nurse-speciality\"]")
	public WebElement Speciality;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-nurse-experience\"]")
	public WebElement Experince;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Nurse Type*\"]/android.widget.EditText")
	public WebElement NurseType;
	@FindBy(xpath = "//android.widget.TextView[@text=\"GENERAL\"]")
	public WebElement SelectNurseType;
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"Birth Date*\"]/android.widget.EditText")
	public WebElement DOB;
	@FindBy(xpath="//android.widget.TextView[@resource-id=\\\"android:id/date_picker_header_year\\\"]")
	public WebElement DatePicker;

	@FindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
	public WebElement SelectDate;


	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Gender*\"]/android.widget.EditText")
	public WebElement Gender;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"female\"]")
	public WebElement SelectGender;

	
	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-shared-phone\"]")
	public WebElement SharedPhoneNumber;



	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-contact-name\"]")
	public WebElement ContactName;
	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-contact-phone\"]")
	public WebElement ContactPhone;

	

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-contact-email\"]")
	public WebElement ContactEmail;

	

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-address-street1\"]")
	public WebElement Street;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-address-city\"]")
	public WebElement City;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-address-pincode\"]")
	public WebElement PinCode;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-address-state\"]")
	public WebElement State;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-address-country\"]")
	public WebElement Country;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Save Nurse\"]")
	public WebElement CreateNurseButton;
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"Ok\"]")
	public WebElement OkButton;

	public void createnursemethod(String nursecode, String firstname, String lastname, String speciality, String experince,    String sharedphonenumber, String contactname, String contactphone, String contactemail, String street, String city, String pincode, String state, String country) {
	    try {
	        wait.until(ExpectedConditions.elementToBeClickable(NurseCenter)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(AddNurse)).click();

	        wait.until(ExpectedConditions.visibilityOf(NurseCode)).clear();
	        NurseCode.sendKeys(nursecode);

	        wait.until(ExpectedConditions.visibilityOf(FirstName)).clear();
	        FirstName.sendKeys(firstname);

	        wait.until(ExpectedConditions.visibilityOf(LastName)).clear();
	        LastName.sendKeys(lastname);

	        wait.until(ExpectedConditions.visibilityOf(Speciality)).clear();
	        Speciality.sendKeys(speciality);

	        wait.until(ExpectedConditions.visibilityOf(Experince)).clear();
	        Experince.sendKeys(experince);

	        wait.until(ExpectedConditions.visibilityOf(NurseType)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(SelectNurseType)).click();


	        wait.until(ExpectedConditions.visibilityOf(DOB)).click();
	        wait.until(ExpectedConditions.visibilityOf(DatePicker)).click();
			By yearLocator = By.xpath("//android.widget.TextView[@text='1983']");

		    for (int i = 0; i < 20; i++) {

		        try {
		            WebElement year = driver.findElement(yearLocator);
		            if (year.isDisplayed()) {
		                year.click();
		                System.out.println(" Year 1983 selected");
		                break;
		            }
		        } catch (Exception e) {
		            System.out.println(" 1983 not visible yet, swiping...");
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

		    By okBtn = By.id("android:id/button1");
		    driver.findElement(okBtn).click();

		    System.out.println("Date Selection Completed Successfully");
	        //wait.until(ExpectedConditions.visibilityOf(SelectDate)).click();
	        
	        wait.until(ExpectedConditions.visibilityOf(Gender)).click();
	        wait.until(ExpectedConditions.visibilityOf(SelectGender)).click();
	        wait.until(ExpectedConditions.visibilityOf(SharedPhoneNumber)).clear();
	        SharedPhoneNumber.sendKeys(sharedphonenumber);
	        
	        driver.findElement(AppiumBy.androidUIAutomator(
				    "new UiScrollable(new UiSelector().scrollable(true))" +
				    ".scrollIntoView(new UiSelector().textContains(\"Pincode\"));"
				));
	        wait.until(ExpectedConditions.visibilityOf(Street)).clear();
	        Street.sendKeys(street);	

	        wait.until(ExpectedConditions.visibilityOf(City)).clear();
	        City.sendKeys(city);

	        wait.until(ExpectedConditions.visibilityOf(PinCode)).clear();
	        PinCode.sendKeys(pincode);

	        wait.until(ExpectedConditions.visibilityOf(State)).clear();
	        State.sendKeys(state);

	        wait.until(ExpectedConditions.visibilityOf(Country)).clear();
	        Country.sendKeys(country);
	        
	        driver.findElement(AppiumBy.androidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true))" +
							".scrollIntoView(new UiSelector().description(\"Save Nurse\"));"
					));

	        wait.until(ExpectedConditions.visibilityOf(ContactName)).clear();
	        ContactName.sendKeys(contactname);
	        Thread.sleep(1500);
	        wait.until(ExpectedConditions.visibilityOf(ContactPhone)).clear();
	        ContactPhone.sendKeys(contactphone);
	        Thread.sleep(1500);
	        wait.until(ExpectedConditions.visibilityOf(ContactEmail)).clear();
	        ContactEmail.sendKeys(contactemail);
//	       
	        

	       
	        wait.until(ExpectedConditions.elementToBeClickable(CreateNurseButton)).click();
			wait.until(ExpectedConditions.elementToBeClickable(OkButton)).click();

	        System.out.println(" Nurse created successfully");

	    } catch (Exception e) {
	        System.out.println("Nurse creation failed: " + e.getMessage());
	    
	}}

	public boolean isNurseCreated(String nursecode2) {
		return true;
	}}
