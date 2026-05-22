package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.BaseClass;
import Pages.CreateBed_Feature;
import Pages.Utility;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.lang.reflect.Method; 
import java.util.Calendar;

public class CreateBedTest extends BaseClass {
	static Calendar calendar = Calendar.getInstance();
    static int seconds = calendar.get(Calendar.MILLISECOND);
    static String secStr = String.format("%04d", seconds);
    public static String bedCode = "Bed" + secStr;

    CreateBed_Feature createbed_feature;
    ExtentTest test;

    @BeforeMethod
    public void initPage(Method method) {
        createbed_feature = new CreateBed_Feature(BaseClass.driver);
        test = BaseClass.extent.createTest("Create bed Test");
    }

    @Test(dependsOnMethods = {
			 
            "tests.NewLoginTest.testValidLogin",
            "tests.OTP_Test.enterOTPTest"
    })    public void testcreatebed() throws InterruptedException {
    	
    	
        String wardcode = Utility.getWardCode();
        String bedcode = bedCode;
        String gatewaycode = Utility.getGatewayCode();



           String actualMessage= createbed_feature.createBedMethod(wardcode,bedcode, gatewaycode);
            
           Assert.assertTrue(actualMessage.contains("Bed created successfully!"),  "Bed creation failed! Actual: " + actualMessage);

            
        }
    }