package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.Utility;
import Pages.BaseClass;
import Pages.Patient_Admit_Feature;
public class AdmitPatientTest extends BaseClass{
	Patient_Admit_Feature patient_admit_feature;
	
	
	@BeforeMethod
    public void initPage() {
        patient_admit_feature = new Patient_Admit_Feature(BaseClass.driver);
    }
	@Test(dependsOnMethods = {
            "tests.NewLoginTest.testValidLogin",
            "tests.OTP_Test.enterOTPTest"
    })
    
	public void testadmitpatient() {
	    
		 String patientcode =Utility.getPatientCode();
		 System.out.println("pat: "+ patientcode);
		 
		 String medicalhistroy="High BP";
		 String admissionreason="BP higher than Normal";
		 String wardcode=Utility.getWardCode();
		 
		 String bedcode=Utility.getBedCode();
		
		
			 patient_admit_feature.admitpatient(patientcode, medicalhistroy, admissionreason, wardcode, bedcode);
			 boolean isAdmitted = patient_admit_feature.isPatientAdmitted(patientcode);

		        Assert.assertTrue(
		            isAdmitted,
		            "Patient admission FAILED for patient code: " + patientcode
		        );
		    }
		 
		     
	    }
	

