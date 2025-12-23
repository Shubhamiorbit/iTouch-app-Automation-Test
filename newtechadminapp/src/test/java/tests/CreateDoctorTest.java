package tests;

import java.util.Calendar;
import Pages.Utility;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.BaseClass;
import Pages.Doctor_feature;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import java.util.Random;

public class CreateDoctorTest extends BaseClass {
	static Calendar calendar = Calendar.getInstance();
    static int seconds = calendar.get(Calendar.SECOND);
    static String secStr = String.valueOf(System.currentTimeMillis() % 100000);
    public static String doctorCode = "Dr" + secStr;

    static Doctor_feature doctor_feature;
    ExtentTest test;

    @BeforeMethod
    public void initPage() {
        doctor_feature = new Doctor_feature(BaseClass.driver);
        test = BaseClass.extent.createTest("Create Doctor Test");
    }

    @Test(dependsOnMethods = {
            "tests.NewLoginTest.testValidLogin",
            "tests.OTP_Test.enterOTPTest"
    })
    
    
    public void testcreatedoctor() {
    	Random random = new Random();
        
        String doctorcode=doctorCode;
        String firstname = "sahana";
        String lastname = "gowda";
        String speciality = "General";
        String experince = "5";
        String birthdate = "1990-12-12";
        String street = "karve";
        String city = "pune";
        String pincode = "585221";
        String state = "MH";
        String country = "IN";
        String contactname = "sahana";
		String contactphone = "+9190" + String.format("%08d", random.nextInt(100000000));
        String contactemail = firstname+doctorcode+"@mailinator.com";

        try {

            doctor_feature.createDoctoremethod(
                    doctorcode,
                    firstname,
                    lastname,
                    speciality,
                    experince,
                    birthdate,
                    street,
                    city,
                    pincode,
                    state,
                    country,
                    contactname,
                    contactphone,
                    contactemail
            );


            boolean isDoctorCreated = doctor_feature.isDoctorCreated(doctorcode);
            Assert.assertTrue(isDoctorCreated, "Doctor creation FAILED for code: " + doctorcode);

            // Save doctor code
            try {
                Utility.saveDoctorCode(doctorCode);
            } catch (Exception e) {
                System.out.println("Failed to save doctor code: " + e.getMessage());
            }


        } catch (Exception e) {
            Assert.fail("Doctor creation failed: " + e.getMessage());
        }
    }
}