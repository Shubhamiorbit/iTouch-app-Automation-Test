package tests;

import Pages.BaseClass;
import Pages.OTP_Class;
import io.appium.java_client.HidesKeyboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OTP_Test extends BaseClass {

    @BeforeTest
    public void initTestReport() {
        test = extent.createTest("OTP Test");
    }

    @Test(dependsOnMethods = "tests.NewLoginTest.testValidLogin")
    public void enterOTPTest() throws Exception {
//    	OTP_Class otpclass = new OTP_Class();
//    	otpclass.OTPfrommailinatorpublic();
        // Fetch OTP
        String otp = OTP_Class.fetchLatestOTP();
        Assert.assertNotNull(otp, "OTP should not be null.");
        test.log(Status.INFO, "Latest OTP fetched: " + otp);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        test.log(Status.INFO, "Waiting for OTP input fields...");

        List<WebElement> otpFields = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//android.widget.EditText"))
        );
        Assert.assertTrue(otpFields.size() >= 6, "OTP input fields count is insufficient!");
        test.log(Status.PASS, "OTP input fields loaded successfully.");

        for (int i = 0; i < otp.length(); i++) {
            otpFields.get(i).click();
            otpFields.get(i).sendKeys(String.valueOf(otp.charAt(i)));
        }

        System.out.println("OTP entered, locating Submit button...");
        try { ((HidesKeyboard) driver).hideKeyboard(); } catch (Exception e) {}

        WebElement submitBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@content-desc='Submit']"))
        );
        submitBtn.click();
        System.out.println("OTP submitted successfully.");
    }
}


