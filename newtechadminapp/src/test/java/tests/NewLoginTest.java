package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.BaseClass;
import Pages.LoginPage;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import utilities.assertionsclass;

public class NewLoginTest extends BaseClass{
	 LoginPage loginPage;
	    ExtentTest test;

	    @BeforeMethod
	    public void initPage() {
	    	loginPage = new LoginPage(BaseClass.driver);
	    	test = extent.createTest("Valid Login Test");
	    }
	    @Test( groups = {"login"})
	    public void testValidLogin() throws Exception {
	    	
	        String username = "autoqa2@dqwdteam.testinator.email";
	        String password = "673657802";
	       
	            loginPage.login(username, password);         	            	          
	        } 
	    }		

	


