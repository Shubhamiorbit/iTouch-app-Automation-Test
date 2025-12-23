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
	    static int seconds = calendar.get(Calendar.SECOND);
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
	    })	public void testcreatenurse() {
		 
	Random random=new Random();
		    
		 String nursecode =nurseCode;
		 String firstname="Pavani";
		 String lastname="gowda";
		 String speciality="Cardiac Care Nurse,Surgical ICU Nurse";
		 String experince= "5";
		 String sharedphonenumber = "+9190" + String.format("%08d", random.nextInt(100000000));		 
		 String contactname="pallavi";
		 
			String contactphone = "+9190" + String.format("%08d", random.nextInt(100000000));

		 String contactemail=nursecode+"@mailinator.com";
		 String street="karve";
		 String city="pune";
		 String pincode="585221";
		 String state="MH";
		 String country="IN";
		 
			 nurse_feature.createnursemethod(nursecode,  firstname,  lastname, speciality,  experince,  sharedphonenumber,  contactname,  contactphone,  contactemail,  street,  city,  pincode,  state,  country);
		 
			 boolean isNurseCreated = nurse_feature.isNurseCreated(nursecode);
		        Assert.assertTrue(isNurseCreated, "Nurse creation FAILED for code: " + nursecode);

		        // Save nurse code
		        try {
		            Utility.saveNurseCode(nursecode);
		        } catch (Exception e) {
		            System.out.println("Failed to save Nurse code: " + e.getMessage());
		        }

		        System.out.println("Nurse Added Successfully: " + nursecode);
		    }
		}