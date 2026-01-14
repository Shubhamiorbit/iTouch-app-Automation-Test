package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.BaseClass;
import Pages.LoginPage;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class NewLoginTest extends BaseClass{
	 LoginPage loginPage;
	    ExtentTest test;

	    @BeforeMethod
	    public void initPage() {
	    	loginPage = new LoginPage(BaseClass.driver);
	    	test = extent.createTest("Valid Login Test");
	    }
	    @Test( groups = {"login"})
	    public void testValidLogin() {
	    	
	        String username = "ethix@mailinator.com";
	        String password = "903134621";

	        try {
	            loginPage.login(username, password);         
	            System.out.println("Login successful for user: " + username);
	        } catch (Exception e) {
	        	 System.out.println("Login test failed: " + e.getMessage());
	            Assert.fail("Exception occurred: " + e.getMessage());
	        }
	    }		
}
	


