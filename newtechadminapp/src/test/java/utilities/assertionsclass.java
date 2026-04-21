package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class assertionsclass {
	
	public static void verifyadminid(String actual) {
		String expected="Auto44QA";
		
		Assert.assertEquals(actual, expected, "Login failed: Expected '" +expected+ "but got " +actual);
	}
	 
	public static void verifyElementDisplayed(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }
	 
	 

}
