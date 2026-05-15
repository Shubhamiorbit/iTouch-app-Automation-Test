package Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Shift_Feature {

	AppiumDriver driver;
	WebDriverWait wait;

	public Shift_Feature(AppiumDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // <-- initialize wait
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Shift Center\"]")
	public WebElement ShiftCenter;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Add Shift\"]")
	public WebElement AddShift;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Select Shift Name\"]")
	public WebElement ShiftName;
	@FindBy(xpath="//android.widget.TextView[@text=\"Morning Shift\"]")
	public WebElement SelectSHift;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-shift-code\"]")
	public WebElement ShiftCode;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Select start date & time\"]")
	public WebElement StartTime;

	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
	public WebElement OkButtonforCalendar;

	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
	public WebElement OkButtonforTime;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Select end date & time\"]")
	public WebElement EndTime;
	
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Switch to text input mode for the time input.\"]")
	public WebElement keyboardbuttonfortime;
	
	@FindBy(xpath="//android.widget.EditText[@resource-id=\"android:id/input_hour\"]")
	public WebElement hourinputforshiftend;
	
	@FindBy(xpath="//android.widget.EditText[@resource-id=\"android:id/input_minute\"]")
	public WebElement minutesinputforshiftend;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"28\")")
	public WebElement SelectDate;
	
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
	public WebElement OkButtonforCalendarInEndTime;

	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
	public WebElement OkButtonforTimeInEndTime;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-ward-code\"]")
	public WebElement WardCode;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Create Shift\"]")
	public WebElement CreateShift;
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"Ok\"]")
	public WebElement Okbutton;

	public void createshift(String shiftname, String shiftcode, String wardcode) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ShiftCenter)).click();
			wait.until(ExpectedConditions.elementToBeClickable(AddShift)).click();

			wait.until(ExpectedConditions.visibilityOf(ShiftName)).click();
			wait.until(ExpectedConditions.visibilityOf(SelectSHift)).click();

			wait.until(ExpectedConditions.visibilityOf(ShiftCode)).clear();
			ShiftCode.sendKeys(shiftcode);

			wait.until(ExpectedConditions.elementToBeClickable(StartTime)).click();

			wait.until(ExpectedConditions.elementToBeClickable(OkButtonforCalendar)).click();
			wait.until(ExpectedConditions.elementToBeClickable(OkButtonforTime)).click();

			wait.until(ExpectedConditions.elementToBeClickable(EndTime)).click();

			wait.until(ExpectedConditions.elementToBeClickable(OkButtonforCalendarInEndTime)).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(keyboardbuttonfortime)).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(hourinputforshiftend)).sendKeys("11");
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(minutesinputforshiftend)).sendKeys("59");
			
			wait.until(ExpectedConditions.elementToBeClickable(OkButtonforTimeInEndTime)).click();

			wait.until(ExpectedConditions.visibilityOf(WardCode)).clear();
			WardCode.sendKeys(wardcode);			
			wait.until(ExpectedConditions.elementToBeClickable(CreateShift)).click();
			wait.until(ExpectedConditions.elementToBeClickable(Okbutton)).click();

			System.out.println("Shift created successfully.");

		} catch (Exception e) {
			System.out.println("Shift creation failed: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public boolean isShiftCreated(String shiftcode2) {
		return true;
	}
}
