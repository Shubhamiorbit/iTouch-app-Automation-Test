package tests;
import java.util.Calendar;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.Nurse_feature;
import Pages.Utility;
import Pages.BaseClass;
import Pages.Device_Config_feature;
import Pages.Device_Feature;
import java.util.Random;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class DeviceConfigTest extends BaseClass{
	Device_Config_feature device_config_feature;
	public static String devicecode;
	@BeforeMethod
    public void initPage() {
		device_config_feature=new 	Device_Config_feature(BaseClass.driver);
    test = BaseClass.extent.createTest("Device Config Test");

	}
	 @Test(dependsOnMethods = {
	            "tests.NewLoginTest.testValidLogin",
	            "tests.OTP_Test.enterOTPTest"
	    })
	    	public void testdeviceconfig() {
		 	Calendar calendar = Calendar.getInstance();
	        int seconds = calendar.get(Calendar.SECOND);
	        String secStr = String.format("%03d", seconds);
		
		 String configurevalue="8"+secStr;
		 String devicetype="Contec";
		 String devicecode= Utility.getDeviceCode();
		 String configurename ="port";
		 
		 device_config_feature.Deviceconfigmethod(devicetype, devicecode, configurename, configurevalue);
		 
		 boolean isConfigured = device_config_feature.isDeviceConfigured(devicetype, devicecode, configurename, configurevalue);
	        Assert.assertTrue(isConfigured, "Device configuration FAILED for device: " + devicecode);

	        System.out.println("Device configured Successfully: " + devicecode);
	    }
	}

