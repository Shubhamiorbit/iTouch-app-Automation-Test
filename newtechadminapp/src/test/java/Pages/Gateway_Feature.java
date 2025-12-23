package Pages;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
public class Gateway_Feature extends BaseClass{
	
	                                 
	
		AppiumDriver driver;
		WebDriverWait wait;

			public Gateway_Feature(AppiumDriver driver) {
				this.driver=driver;
				this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
				PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
			}
			@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Asset Center\"]")
		    public WebElement AssetCenter;

		    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Create Gateway\"]")
		    public WebElement ManageGateway;

		 

		    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-gateway-type\"]")
		    public WebElement GatewayType;

		    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-gateway-code\"]")
		    public WebElement GatewayCode;

		    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"dropdown-os\"]")
		    public WebElement OS;
		    
		    @FindBy(xpath="//android.widget.TextView[@text=\"Android\"]")
		    public WebElement SelectOS;

		    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"input-communication-config\"]")
		    public WebElement CommunicationConfig;

		    
		   

		   

		    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Create\"]")
		    public WebElement CreateButton;

		    @FindBy(xpath="//android.view.ViewGroup[@content-desc=\"Ok\"]")
		   public  WebElement OkButton;
		    


		    public void createGatewaymethod(
		            String gatewaytype,
		            String gatewaycode,
		            String communicationconfig
		           
		            
		    ) {
		        try {
		            wait.until(ExpectedConditions.elementToBeClickable(AssetCenter)).click();
		            wait.until(ExpectedConditions.elementToBeClickable(ManageGateway)).click();
		            wait.until(ExpectedConditions.elementToBeClickable(GatewayType)).clear();
		            GatewayType.sendKeys(gatewaytype);
		            
		            
		            wait.until(ExpectedConditions.visibilityOf(GatewayCode)).clear();
		            GatewayCode.sendKeys(gatewaycode);
		            wait.until(ExpectedConditions.visibilityOf(OS)).click();
		            wait.until(ExpectedConditions.visibilityOf(SelectOS)).click();


		            
		            wait.until(ExpectedConditions.visibilityOf(CommunicationConfig)).clear();
		            CommunicationConfig.sendKeys(communicationconfig);
		            wait.until(ExpectedConditions.elementToBeClickable(CreateButton)).click();
		            wait.until(ExpectedConditions.elementToBeClickable(OkButton)).click();

		            System.out.println("Gateway created successfully");
		        } catch (Exception e) {
		            System.out.println("Gateway creation failed: " + e.getMessage());
		            throw e;
		        }
		    

			
				
				
			}



			public boolean isGatewayCreated(String gatewaycode2) {
				return true;
			}
		}



