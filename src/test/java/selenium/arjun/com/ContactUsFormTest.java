package selenium.arjun.com;

import selenium.arjun.com.pageObject.ContactForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Utils;


public class ContactUsFormTest {

	private WebDriver driver;
	private ContactForm contact;
	private Utils utils;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		driver = new ChromeDriver();

		contact = new ContactForm(driver);
		utils = new Utils();

		String baseUrl = "http://automationpractice.com/index.php?controller=contact";
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	@AfterClass
	public void closeAll() throws Exception{
		utils.takeSnapShot( driver,this.getClass()+".png" );
		driver.quit();
	}


	@Test
	public void invalidEmailContactUsTest() {

		contact.getContactForm();
		contact.setContactSubjectField( "Customer service" );
		contact.setContactEmailField( "InvalidEmail" );
		contact.setContactOrderRefField( "123456" );
		contact.setContactMsgField( "Testing Invalid Email Error" );
		contact.getContactSubmitBtn().click();

		Assert.assertTrue(contact.getInvalidEmailError().isDisplayed());

	}


}
