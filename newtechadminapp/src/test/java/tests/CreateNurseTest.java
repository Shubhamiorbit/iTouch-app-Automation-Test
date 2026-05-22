package tests;

import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.Nurse_feature;
import Pages.Utility;
import Pages.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import java.util.Random;


public class CreateNurseTest extends BaseClass{
	 static Calendar calendar = Calendar.getInstance();
	    static int seconds = calendar.get(Calendar.MILLISECOND);
        static String secStr = String.valueOf(System.currentTimeMillis() % 100000);
	    public static String nurseCode = "Nurse" + secStr;
	    
	Nurse_feature nurse_feature;
	ExtentTest test;
	@BeforeMethod
    public void initPage() {
	nurse_feature=new Nurse_feature(BaseClass.driver);
    test = BaseClass.extent.createTest("Create Nurse Test");

	}
	 @Test(dependsOnMethods = {
	            "tests.NewLoginTest.testValidLogin",
	            "tests.OTP_Test.enterOTPTest"
	    })	public void testcreatenurse() throws InterruptedException {
		 
	Random random=new Random();
		    
		 String nursecode =nurseCode;
		 String firstname="Pavani";
		 String lastname="gowda";
		 String speciality="Cardiac Care Nurse,Surgical ICU Nurse";
		 String experince= "5";
		 String sharedphonenumber = "+9190" + String.format("%08d", random.nextInt(100000000));		 
		 String nursecontactname="pallavi";
		 
			String nursecontactphone = "+9190" + String.format("%08d", random.nextInt(100000000));

		 String nursecontactemail=nursecode+"@dqwdteam.testinator.email";
		 String street="karve";
		 String city="pune";
		 String pincode="585221";
		 String state="MH";
		 String country="IN";
		 
			 String actualMessage=nurse_feature.createnursemethod(nursecode,  firstname,  lastname, speciality,  experince,  sharedphonenumber,  nursecontactname,  nursecontactphone,  nursecontactemail,  street,  city,  pincode,  state,  country);
		 
	           Assert.assertTrue(actualMessage.contains("Nurse Information Saved"),  "Doctor creation failed! Actual: " + actualMessage);
		    }
		}