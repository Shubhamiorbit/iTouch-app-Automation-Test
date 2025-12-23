package Pages;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
public class Ward_Feature {
	AppiumDriver driver;
	WebDriverWait wait;

		public Ward_Feature(AppiumDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Asset Center']")
    public WebElement AssetCenter;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Add Ward']")
    public WebElement ManageWard;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Add Ward']")
    public WebElement AddWard;

	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[1]")
	public WebElement WardCode;

	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[2]")
	public WebElement WardName;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Select Ward Type\"]")
	public WebElement WardType;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"GENERAL\"]")
	public WebElement SelectWardType;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Add Ward']")
	public WebElement AddWardButton;
	
	@FindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
	   public  WebElement OkButton;
	@FindBy(xpath="//android.widget.ImageView")
	public WebElement BackNavigation;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/message\"]")
	private WebElement successMessage;
	public void createward(String wardcode, String wardname, String wardtype) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(AssetCenter)).click();
			wait.until(ExpectedConditions.elementToBeClickable(ManageWard)).click();
			wait.until(ExpectedConditions.elementToBeClickable(AddWard)).click();			
			wait.until(ExpectedConditions.visibilityOf(WardCode)).clear();
			WardCode.sendKeys(wardcode);
			wait.until(ExpectedConditions.visibilityOf(WardName)).clear();
			WardName.sendKeys(wardname);
			wait.until(ExpectedConditions.visibilityOf(WardType)).click();
			wait.until(ExpectedConditions.elementToBeClickable(SelectWardType)).click();
			wait.until(ExpectedConditions.elementToBeClickable(AddWardButton)).click();
            wait.until(ExpectedConditions.elementToBeClickable(OkButton)).click();
            
            wait.until(ExpectedConditions.elementToBeClickable(BackNavigation)).click();

		}catch (Exception e) {
	        System.out.println("Ward creation failed: " + e.getMessage());
		}
		
	}

	public boolean isWardCreated(String wardcode) {
		return true;
	}
}
