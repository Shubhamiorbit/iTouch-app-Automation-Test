package Pages;
import java.util.Calendar;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.Patient_Feature;
import Pages.Utility;
import tests.CreateDoctorTest;
import Pages.BaseClass;
import Pages.Doctor_feature;

public class CreatePatientTest extends BaseClass{
	Patient_Feature patient_feature;
	CreateDoctorTest DC=new CreateDoctorTest();
	
	
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
        String secStr = String.format("%04d", seconds);
        Random random = new Random();
		 String patientcode ="Pat"+secStr;
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
			
		 
		     test.log(Status.PASS, "Patient Added Sucussfully");
	            try {
	            	
					Utility.savePatientCode(patientcode);
	                test.log(Status.INFO, "patient code saved to file: " + patientcode);
	            } catch (Exception e) {
	                test.log(Status.WARNING, "Failed to save patient code: " + e.getMessage());
	            }

	        
	    }
	}
	

