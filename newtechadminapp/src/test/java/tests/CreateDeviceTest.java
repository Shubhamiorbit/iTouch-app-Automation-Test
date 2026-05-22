package tests;
import java.util.Calendar;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Utility;
import Pages.BaseClass;
import Pages.Device_Feature;



public class CreateDeviceTest extends BaseClass{
	Device_Feature device_feature;
	public static String devicecode;
	@BeforeMethod
    public void initPage() {
	device_feature=new Device_Feature(BaseClass.driver);
    test = BaseClass.extent.createTest("Create Device Test");

	}
	 @Test(dependsOnMethods = {
	            "tests.NewLoginTest.testValidLogin",
	            "tests.OTP_Test.enterOTPTest"
	    })
	    	public void testcreatedevice() throws InterruptedException {
		 	Calendar calendar = Calendar.getInstance();
	        int seconds = calendar.get(Calendar.MILLISECOND);
	        String secStr = String.format("%06d", seconds);
	        Random random = new Random();
		
		 String devicetype="Contec";
		 String devicecode= devicetype+ secStr;
		 
		 
			 String actualMessage=device_feature.createDevicemethod(devicecode,  devicetype);
		 
Assert.assertTrue(actualMessage.contains("Device added successfully"),  "Device creation failed! Actual: " + actualMessage);
	       
		    
		    }
		}
