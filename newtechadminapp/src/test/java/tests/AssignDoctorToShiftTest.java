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
		public void testAssigndoctortoshift() {
			
	
			 String wardcode = Utility.getWardCode();
			 String shiftcode = Utility.getShiftCode();
			 String doctorcode = Utility.getDoctorCode();

			 doctorassigntoshift.AssignDoctorToShiftmethod(doctorcode,wardcode, shiftcode);

			 boolean isAssigned = doctorassigntoshift.isDoctorAssignedToShift(doctorcode, wardcode, shiftcode);

		        Assert.assertTrue(
		            isAssigned,
		            "Doctor assignment FAILED for doctor code: " + doctorcode +
		            " to shift: " + shiftcode + " in ward: " + wardcode
		        );	           
	               
	            }

	        
	    }
	