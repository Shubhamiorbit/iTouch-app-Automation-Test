package Pages;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;



public class Doctor_Centre extends BaseClass{
	
	AppiumDriver driver;
	WebDriverWait wait;

	public void Doctor_feature(AppiumDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	public void AddDoctor() throws InterruptedException{
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Doctor Center\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Add Doctor\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"input-doctorCode\"]")).sendKeys("AutoDoc01");
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"input-firstName\"]")).sendKeys("AutoDocFirstName");
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"input-lastName\"]")).sendKeys("AutoDocLastName");
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Doctor Speciality*\"]/android.widget.EditText")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"General Physician\"]")).click();
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Doctor Speciality*\"]/android.widget.EditText")).sendKeys("Cardiologist");
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Doctor Speciality*\"]/android.widget.EditText")).sendKeys("3");
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Doctor Type*\"]/android.widget.EditText")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"SHIFT\"]")).click();
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Birth Date*\"]/android.widget.EditText")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/date_picker_header_year\"]")).click();
		Thread.sleep(5000);
		By yearLocator = By.xpath("//android.widget.TextView[@text='1985']");

	    for (int i = 0; i < 20; i++) {

	        try {
	            WebElement year = driver.findElement(yearLocator);
	            if (year.isDisplayed()) {
	                year.click();
	                System.out.println(" Year 1985 selected");
	                break;
	            }
	        } catch (Exception e) {
	            System.out.println(" 1985 not visible yet, swiping...");
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
	    driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
	    
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Gender*\"]/android.widget.EditText")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"male\"]")).click();
		
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"input-street1\"]")).sendKeys("NDA, Pune");
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"input-city\"]")).sendKeys("Pune");
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"input-pincode\"]")).sendKeys("411052");
		Dimension size = driver.manage().window().getSize();
	    int width = size.getWidth();
	    int height = size.getHeight();
		driver.executeScript("mobile: swipeGesture", ImmutableMap.of("left", width/4,
				"top", height/4,
				"width", width/2,
				"height", height/2,
				"direction", "up",
				"percent",0.8));
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"input-state\"]")).sendKeys("MH");
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"input-country\"]")).sendKeys("IN");
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"input-contactName\"]")).sendKeys("AutoDoctor");
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"input-contactName\"]")).sendKeys("9874563215");
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"input-email\"]")).sendKeys("autodoc@mailinator.com");
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Save Doctor\"]")).click();	
		
		String doctorcreatedpromptmessage = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Doctor Information Saved successfully!\"]")).getText();
		String expectedpromptmessage= "Doctor Information Saved Successfully!";
		boolean isEqual = doctorcreatedpromptmessage.equals(expectedpromptmessage);
	}
}
