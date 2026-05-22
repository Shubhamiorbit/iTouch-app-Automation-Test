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
import Pages.Device_Feature;
import Pages.Gateway_Feature;

import java.util.Random;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class CreateGatewayTest extends BaseClass{
	Calendar calendar = Calendar.getInstance();
    int seconds = calendar.get(Calendar.SECOND);
    String secStr = String.format("%05d", seconds);

	Gateway_Feature gateway_feature;
	public static String devicecode;
	@BeforeMethod
    public void initPage() {
		gateway_feature=new Gateway_Feature(BaseClass.driver);
    test = BaseClass.extent.createTest("Create Gateway Test");

	}
	 @Test(dependsOnMethods = {
	            "tests.NewLoginTest.testValidLogin",
	            "tests.OTP_Test.enterOTPTest"
	    })
	    	public void testcreategateway() {
		 
		 String gatewaytype="Radxa";
		 String gatewaycode="gateway"+secStr;
		 String communicationconfig= "WI-FI";
		 
		
			  String actualMessage=gateway_feature.createGatewaymethod(gatewaytype,  gatewaycode,  communicationconfig);
			  
			  Assert.assertTrue(actualMessage.contains("Gateway created successfully!"),  "Gateway creation failed! Actual: " + actualMessage);
	 }
		}
