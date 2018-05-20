package selenium.arjun.com;

import selenium.arjun.com.pageObject.Homepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Utils;

import javax.rmi.CORBA.Util;

public class SubscribeToNewsletterTest {

    private WebDriver driver;
    private Homepage homepage;
    private Utils utils;

    //Credit for random method: https://dzone.com/articles/generate-random-alpha-numeric

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();

        homepage = new Homepage(driver);
        utils = new Utils();

        String baseUrl = "http://automationpractice.com/index.php";
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterClass
    public void closeAll() throws Exception{
        utils.takeSnapShot( driver,this.getClass()+".png" );
        driver.quit();
    }


    @Test
    public void successfulSubscriptionTestWithRandomEmail() {
        String email = randomAlphaNumeric(10) + "@yopmail.com";
        homepage.getNewsLetterForm();
        homepage.setNewsLetterFieldEmail( email );
        homepage.getNewsLetterSubmitButton().click();

        Assert.assertTrue( homepage.getSuccessfulSubscriptionMsg().isDisplayed() );
    }
}
