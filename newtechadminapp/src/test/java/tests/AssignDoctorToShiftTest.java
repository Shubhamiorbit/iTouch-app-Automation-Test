	package tests;
	import java.util.Calendar;
import java.util.Random;

import org.testng.Assert;
	import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
	
	import Pages.Ward_Feature;
import Pages.BaseClass;
import Pages.DoctorAssignToShift;
import Pages.Utility;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

	public class AssignDoctorToShiftTest extends BaseClass{
		
		static Calendar calendar = Calendar.getInstance();
	    static int seconds = calendar.get(Calendar.SECOND);
	    static String secStr = String.format("%03d", seconds);
	    //public static String wardCode = "Ward" + secStr;

	    DoctorAssignToShift doctorassigntoshift;
		ExtentTest test;
		@BeforeMethod
		public void iniassigndocgtortoshiftpage() {
			
			doctorassigntoshift=new DoctorAssignToShift(BaseClass.driver);
	        test = BaseClass.extent.createTest("Assign Doctor to Shift Test");

		}
	
		 @Test(dependsOnMethods = {
				 
		            "tests.NewLoginTest.testValidLogin",
		            "tests.OTP_Test.enterOTPTest"
		    })
		public void testAssigndoctortoshift() throws InterruptedException {
			
	
			 String wardcode = Utility.getWardCode();
			 String shiftcode = Utility.getShiftCode();
			 String doctorcode = Utility.getDoctorCode();

			 String actualMessage= doctorassigntoshift.AssignDoctorToShiftmethod(doctorcode,wardcode, shiftcode);

			 Assert.assertTrue(actualMessage.contains("Doctor assigned successfully!!"),  "Doctor assignment failed! Actual: " + actualMessage);	           
	               
	            }

	        
	    }
	