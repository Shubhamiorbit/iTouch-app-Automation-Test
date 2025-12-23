	package tests;
	import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
	
import Pages.BaseClass;
import Pages.NurseAssignToBed_Feature;
import Pages.Utility;

import com.aventstack.extentreports.ExtentTest;
	public class AssignBedToNurse extends BaseClass{
		
		static Calendar calendar = Calendar.getInstance();
	    static int seconds = calendar.get(Calendar.SECOND);
	    static String secStr = String.format("%03d", seconds);
	    //public static String wardCode = "Ward" + secStr;

	    NurseAssignToBed_Feature assignbedtonurse;
		ExtentTest test;
		@BeforeMethod
		public void iniassignnursetobedpage() {
			
			assignbedtonurse=new NurseAssignToBed_Feature(BaseClass.driver);
	        test = BaseClass.extent.createTest("Assign nurse to bed Test");

		}
	
		 @Test(dependsOnMethods = {
				 
		            "tests.NewLoginTest.testValidLogin",
		            "tests.OTP_Test.enterOTPTest"
		    })
		public void testAssignnursetobed() {
			
			 String nursecode = Utility.getNurseCode();

			 String wardcode = Utility.getWardCode();
			 String shiftcode = Utility.getShiftCode();
			 String bedcode = Utility.getBedCode();

			 


			 assignbedtonurse.AssignNurseToBedmethod(nursecode, wardcode, shiftcode, bedcode);

			 boolean isAssigned = assignbedtonurse.isNurseAssignedToBed(
			            nursecode, bedcode
			        );

			        Assert.assertTrue(
			            isAssigned,
			            "Nurse was NOT assigned to the bed"
			        );
			    }
				           
	               
	            }

	        
	    
	