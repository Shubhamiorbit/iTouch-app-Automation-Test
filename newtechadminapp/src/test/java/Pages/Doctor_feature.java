package Pages;

import java.time.Duration;
import java.util.Collections;
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
import io.appium.java_client.pagefactory.AndroidFindBy;
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

	//@FindBy(xpath = "(//android.widget.EditText)[22]")
	//public WebElement Street;

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
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Doctor Information Saved successfully!\"]")
	public WebElement doctorcreationsuccesspopup;


	public String createDoctormethod(
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
			String doctorcontactname,
			String docotrcontactphone,
			String doctorcontactemail
			) throws InterruptedException {
		
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
			Thread.sleep(2000);

			driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Birth Date*\"]/android.widget.EditText")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/date_picker_header_year\"]")).click();
			Thread.sleep(3000);
			Random random = new Random();
			int docdobyear = random.nextInt(11)+ 1975;
			By yearLocator = By.xpath("//android.widget.TextView[@text='"+docdobyear+"']");

		    for (int i = 0; i < 20; i++) {

		        try {
		            WebElement year = driver.findElement(yearLocator);
		            if (year.isDisplayed()) {
		                year.click();
		                System.out.println(" Year "+docdobyear+" selected");
		                break;
		            }
		        } catch (Exception e) {
		            System.out.println(" "+docdobyear+" not visible yet, swiping...");
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
		    int day = random1.nextInt(25) + 1;
		    String docdaytext = String.valueOf(day);
		    String docdayxpath = "new UiSelector().text(\""+docdaytext+"\")";
		    driver.findElement(AppiumBy.androidUIAutomator(docdayxpath)).click();
		    driver.findElement(By.id("android:id/button1")).click();
			wait.until(ExpectedConditions.elementToBeClickable(GenderDropDown)).click();
			wait.until(ExpectedConditions.elementToBeClickable(SelectGender)).click();

			driver.findElement(AppiumBy.androidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true))" +
							".scrollIntoView(new UiSelector().textContains(\"male\"));"
					));

			
			wait.until(ExpectedConditions.visibilityOf(Street));
			Street.sendKeys(street);
			wait.until(ExpectedConditions.elementToBeClickable(City)).sendKeys(city);
			wait.until(ExpectedConditions.elementToBeClickable(PinCode)).sendKeys(pincode);
			driver.findElement(AppiumBy.androidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true))" +
							".scrollIntoView(new UiSelector().description(\"Save Doctor\"));"
					));
			wait.until(ExpectedConditions.elementToBeClickable(State)).sendKeys(state);
			wait.until(ExpectedConditions.elementToBeClickable(Country)).sendKeys(country);
			wait.until(ExpectedConditions.elementToBeClickable(ContactName)).sendKeys(doctorcontactname);
			wait.until(ExpectedConditions.elementToBeClickable(ContactPhone)).sendKeys(docotrcontactphone);
			wait.until(ExpectedConditions.elementToBeClickable(ContactEmail)).sendKeys(doctorcontactemail);
			wait.until(ExpectedConditions.elementToBeClickable(SaveButton)).click();
			
			String doctorpopotext=doctorcreationsuccesspopup.getText();
			System.out.println(doctorpopotext);
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(OkButton)).click();
			
			Utility.saveDoctorCode(doctorcode);
			return doctorpopotext;
		}
}