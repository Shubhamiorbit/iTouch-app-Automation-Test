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
	    	public void testcreatedevice() {
		 	Calendar calendar = Calendar.getInstance();
	        int seconds = calendar.get(Calendar.SECOND);
	        String secStr = String.format("%04d", seconds);
	        Random random = new Random();
		
	        String verifywith ="SERIALNO";
		 String usagetype="Fixed";
		 String devicetype="Contec";
		 String devicecode= devicetype+ secStr;
		 String protocol ="HL7";
		 
			 device_feature.createDevicemethod(devicecode,  devicetype,  usagetype, verifywith, protocol);
		 
			 boolean isDeviceCreated = device_feature.isDeviceCreated(devicecode);
		        Assert.assertTrue(isDeviceCreated, "Device creation FAILED for code: " + devicecode);

		        // Save the device code for later tests
		        try {
		            Utility.saveDeviceCode(devicecode);
		        } catch (Exception e) {
		            System.out.println("Failed to save device code: " + e.getMessage());
		        }

		        System.out.println("Device Added Successfully: " + devicecode);
		    }
		}
