package tests;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.BaseClass;
import Pages.Shift_Feature;
import Pages.Utility;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class CreateShiftTest extends BaseClass{
	Shift_Feature shift_feature;
	ExtentTest test;
    static String secStr = String.valueOf(System.currentTimeMillis() % 100000);

	
	@BeforeMethod
	public void initshiftpage() {
		shift_feature=new Shift_Feature(BaseClass.driver);

	}
	@Test(dependsOnMethods = {
            "tests.NewLoginTest.testValidLogin",
            "tests.OTP_Test.enterOTPTest"
    }) 
	public void testcreateshift() throws InterruptedException {
		Calendar calendar = Calendar.getInstance();
        int seconds = calendar.get(Calendar.MILLISECOND);
		String shiftname= "Morning Shift";
		String shiftcode= "Shift"+secStr;
		 String wardcode = Utility.getWardCode();



			String actualMessage=shift_feature.createshift(shiftname, shiftcode, wardcode);
			
			Assert.assertTrue(actualMessage.contains("Shift created successfully!"),  "Shift creation failed! Actual: " + actualMessage);
	      
	       
	    }
	}


