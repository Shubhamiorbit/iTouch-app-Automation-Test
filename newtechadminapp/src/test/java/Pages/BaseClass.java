package Pages;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseClass {
    public static AndroidDriver driver;
    public static ExtentReports extent; 
    public static ExtentTest test; 

    @BeforeTest
    public void setup() throws MalformedURLException {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);

        File app = new File("D:\\itouch-qa\\newtechadminapp\\Apps\\iTouchTechAdminAppNew22.apk");


        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("emulator-5554");
        options.setUdid("emulator-5554");

        options.setApp(app.getAbsolutePath());
        options.setAppPackage("com.itouchtechadminapp");
        options.setAppActivity("com.itouchtechadminapp.MainActivity");

        options.setAutoGrantPermissions(true);
        options.setNoReset(true); 
        options.setDisableWindowAnimation(true);

        options.setNewCommandTimeout(Duration.ofSeconds(600));
        options.setAdbExecTimeout(Duration.ofSeconds(120));
        options.setUiautomator2ServerInstallTimeout(Duration.ofSeconds(120));
        options.setUiautomator2ServerLaunchTimeout(Duration.ofSeconds(120));

        // 
        options.setIgnoreHiddenApiPolicyError(true);
        options.setSkipDeviceInitialization(false);
        options.setSkipServerInstallation(false);

        options.setCapability("waitForIdleTimeout", 10000);




        driver = new AndroidDriver(
        	    new URL("http://127.0.0.1:4723"), 
        	    options
        	);
        	
    }

	public static String captureScreen(String tname) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot takeScreenshot= (TakesScreenshot) driver;
		File sourcefile= takeScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath= System.getProperty("user.dir")+"\\Screenshots\\"+tname+ timeStamp+ ".png";
		File targetfile= new File(targetFilePath);
		sourcefile.renameTo(targetfile);

		return targetFilePath; 
	}
}
