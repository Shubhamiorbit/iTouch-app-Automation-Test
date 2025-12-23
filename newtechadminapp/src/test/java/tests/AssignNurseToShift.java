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
import Pages.NurseAssignToShift;
import Pages.Utility;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

	public class AssignNurseToShift extends BaseClass{
		
		static Calendar calendar = Calendar.getInstance();
	    static int seconds = calendar.get(Calendar.SECOND);
	    static String secStr = String.format("%03d", seconds);

	    NurseAssignToShift nurseassigntoshift;
		ExtentTest test;
		@BeforeMethod
		public void iniassignnursetoshiftpage() {
			
			nurseassigntoshift=new NurseAssignToShift(BaseClass.driver);
	        test = BaseClass.extent.createTest("Assign Nurse to Shift Test");

		}
	
		 @Test(dependsOnMethods = {
				 
		            "tests.NewLoginTest.testValidLogin",
		            "tests.OTP_Test.enterOTPTest"
		    })
		public void testAssignnursetoshift() {
			
	
			 String wardcode = Utility.getWardCode();
			 String shiftcode = Utility.getShiftCode();
			 String nursecode = Utility.getNurseCode();

			 nurseassigntoshift.AssignNurseToShiftmethod(nursecode, wardcode, shiftcode);

			 boolean isAssigned = nurseassigntoshift.isNurseAssignedToShift(nursecode, wardcode, shiftcode);

		        Assert.assertTrue(
		            isAssigned,
		            "Nurse assignment FAILED for nurse code: " + nursecode +
		            " to shift: " + shiftcode + " in ward: " + wardcode
		        );	               
	            }

	        
	    }
	