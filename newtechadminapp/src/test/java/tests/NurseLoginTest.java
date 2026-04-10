package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import Pages.BaseClass;
import Pages.LoginPage;

public class NurseLoginTest extends BaseClass {
	LoginPage loginPage;
	ExtentTest test;
	
	@BeforeMethod
	public void initPage() {
		loginPage = new LoginPage(BaseClass.driver);
		test = extent.createTest("Valid Login Test");
	}
	
	@Test(groups = {"login"})	
	public void testValidLogin() {
		String email= "Nurse26778@iorbitteam813038.testinator.email";
		String pass = "716659557";
		
		try {
			loginPage.login(email, pass);
			System.out.println("Login successful for user: " + email);
		}catch (Exception e) {
			System.out.println("Login test failed: " + e.getMessage());
			Assert.fail("Exception occured: "+ e.getMessage());
		}
	}
}
