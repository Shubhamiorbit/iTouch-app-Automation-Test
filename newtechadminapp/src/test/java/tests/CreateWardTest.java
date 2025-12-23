package tests;

import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.BaseClass;
import Pages.Utility;
import Pages.Ward_Feature;

public class CreateWardTest extends BaseClass {

    static Calendar calendar = Calendar.getInstance();
    static int seconds = calendar.get(Calendar.SECOND);
    static String secStr = String.valueOf(System.currentTimeMillis() % 100000);
    public static String wardCode = "Ward" + secStr;


    Ward_Feature ward_feature;

    @BeforeMethod
    public void initwardpage() {
        ward_feature = new Ward_Feature(BaseClass.driver);
    }

    @Test(dependsOnMethods = {
            "tests.NewLoginTest.testValidLogin",
            "tests.OTP_Test.enterOTPTest"
    })
    public void testcreateward() throws InterruptedException {

        String wardcode = wardCode;
        String wardname = "ward" + secStr;
        String wardtype = "general";

      
            ward_feature.createward(wardcode, wardname, wardtype);
            
            
           
            
            boolean isWardCreated = ward_feature.isWardCreated(wardcode);
            
            Assert.assertTrue(isWardCreated,"Ward creation FAILED for code: " + wardcode);
            Thread.sleep(2000);

            Utility.saveWardCode(wardcode);

            

        
    }
}
