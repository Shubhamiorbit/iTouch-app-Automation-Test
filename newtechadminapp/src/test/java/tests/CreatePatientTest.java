package tests;
import java.util.Calendar;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import Pages.Patient_Feature;
import Pages.Utility;
import Pages.BaseClass;

public class CreatePatientTest extends BaseClass{
	Patient_Feature patient_feature;
	CreateDoctorTest DC=new CreateDoctorTest();
    static String secStr = String.valueOf(System.currentTimeMillis() % 100000);

	
	@BeforeMethod
    public void initPage() {
        patient_feature = new Patient_Feature(BaseClass.driver);
        test = BaseClass.extent.createTest("Create Doctor Test");
    }
	@Test(dependsOnMethods = {
            "tests.NewLoginTest.testValidLogin",
            "tests.OTP_Test.enterOTPTest"
    })
    
	public void testcreatepatient() {
	    
		Calendar calendar = Calendar.getInstance();
        int seconds = calendar.get(Calendar.SECOND);
        Random random = new Random();
		 String patientcode ="Patient"+secStr;
		 String patientname="pallavi gowda";
		 String firstname="pallavi";
		 String lastname="gowda";
		 String mrnumber=secStr;
		 String contactname="pallavi gowda";
		String contactphone = "90" + String.format("%08d", random.nextInt(100000000));
        String contactemail = patientcode+"@mailinator.com";
		 String street="karve";
		 String city="pune";
		 String pincode="585221";
		 String state="MH";
		 String country="IN";
		 String height="170";
		 String weight="70";
		 String anyallergies="no";
		 String pastcomplications="no";
		 String doctorcodeforpatient = Utility.getDoctorCode();
		
			 patient_feature.createpatient(patientcode,patientname,  firstname,  lastname, 
					 mrnumber, contactname,  contactphone,  contactemail,  street, 
					 city,  pincode,  state,  country,  height,  
						weight, anyallergies,  pastcomplications, doctorcodeforpatient );
			
		 
			 boolean isPatientCreated =patient_feature.isPatientCreated(patientcode);

		        Assert.assertTrue(isPatientCreated,"Patient creation FAILED for patient code: " + patientcode );

		        Utility.savePatientCode(patientcode);
		    }
		}

