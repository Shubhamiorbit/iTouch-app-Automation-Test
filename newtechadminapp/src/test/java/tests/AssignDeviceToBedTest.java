package tests;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.BaseClass;
import Pages.DeviceAssignToBed_Feature;
import Pages.Utility;

import com.aventstack.extentreports.ExtentTest;

public class AssignDeviceToBedTest extends BaseClass{

	static Calendar calendar = Calendar.getInstance();
	static int seconds = calendar.get(Calendar.SECOND);
	static String secStr = String.format("%03d", seconds);
	//public static String wardCode = "Ward" + secStr;

	DeviceAssignToBed_Feature deviceassigntobed;
	ExtentTest test;
	@BeforeMethod
	public void iniassigndocgtortoshiftpage() {

		deviceassigntobed=new DeviceAssignToBed_Feature(BaseClass.driver);
		test = BaseClass.extent.createTest("Assign Doctor to Shift Test");

	}

	@Test(dependsOnMethods = {

			"tests.NewLoginTest.testValidLogin",
			"tests.OTP_Test.enterOTPTest"
	})
	public void testAssigndevicetobed() throws InterruptedException {


		String wardcode = Utility.getWardCode();
		String bedcode = Utility.getBedCode();
		String gatewaycode= Utility.getGatewayCode();
		String shiftcode = Utility.getShiftCode();
		String devicecode=Utility.getDeviceCode();

		String actualMessage= deviceassigntobed.AssignDeviceToBedmethod( wardcode,
				bedcode,
				gatewaycode,
				shiftcode,
				devicecode
				);


        Assert.assertTrue(actualMessage.contains("Device assigned successfully!"), "Device assignement failed: " + actualMessage);
   

	}


}
