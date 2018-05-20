package selenium.arjun.com;

import selenium.arjun.com.pageObject.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Utils;

public class CompleteShoppingTest {

    private WebDriver driver;
    private Actions action;

    private Clothes clothes;
    private Cart cart;
    private ShoppingActions shoppingActions;
    private CartSummary summary;
    private Account account;
    private Utils utils;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();

        action = new Actions(driver);

        clothes = new Clothes(driver);
        cart = new Cart(driver);
        shoppingActions = new ShoppingActions(driver);
        summary = new CartSummary(driver);
        account = new Account(driver);
        utils = new Utils();

        String baseUrl = "http://automationpractice.com/index.php";
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterClass
    public void closeAll() throws Exception{
        utils.takeSnapShot( driver,this.getClass()+".png" );
        account.getAccountLogout().click();
        driver.quit();
    }

    @Test
    public void completeCheckoutTestForOneItem(){
        Assert.assertTrue(clothes.getDressesBtn().isDisplayed());
        action.moveToElement(clothes.getDressesBtn()).perform();
        Assert.assertTrue(clothes.getSummerDressesBtn().isDisplayed());

        action.moveToElement(clothes.getSummerDressesBtn()).perform();
        clothes.getSummerDressesBtn().click();

        action.moveToElement(clothes.getSummerDressProduct(1)).perform();
        action.moveToElement(shoppingActions.getAddToCartBtn()).perform();


        action.click(shoppingActions.getAddToCartBtn()).build().perform();
        action.click(shoppingActions.getContinueShopingBtn()).build().perform();


        action.moveToElement(cart.getCartTab()).perform();
        action.moveToElement(cart.getCartTabCheckOutBtn()).perform();

        Assert.assertTrue(cart.getCartTabCheckOutBtn().isDisplayed());

        action.click(cart.getCartTabCheckOutBtn()).build().perform();
        Assert.assertTrue(summary.getCartSummaryTable().isDisplayed());
        Assert.assertEquals(summary.getCartSummTotalProductsNum().size(), 1);
        Assert.assertEquals(summary.getCartSummTotalProductsPrice().getText(), "$28.98");
        Assert.assertEquals(summary.getCartSummaryTotalPrice().getText(), "$30.98");
        Assert.assertEquals(summary.getCartSummTotalShipping().getText(), "$2.00");

        summary.getCartProceedBtn().click();

        Assert.assertTrue(summary.getSignInForm().isDisplayed());

        summary.setEmailField("testcart@yopmail.com");
        summary.setPasswordField("Smart@123");
        //TODO: Write util to read Creds from file

        summary.getSignInBtn().click();

        Assert.assertEquals(summary.getCartSummBillingAdressName().getText(), "Johny Walker");
        Assert.assertEquals(summary.getCartSummBillingAdressOne().getText(), "S 507, Some Lane some block");
        Assert.assertEquals(summary.getCartSummBillingAdressCityState().getText(), "Redwood Shores, California 12345");
        Assert.assertEquals(summary.getCartSummBillingAdressCountry().getText(), "United States");
        Assert.assertEquals(summary.getCartSummBillingAdressHomePhone().getText(), "83274");
        Assert.assertEquals(summary.getCartSummBillingAdressMobile().getText(), "9999999999");


        summary.getCartProceedBtnTwo().click();
        summary.getCartProceedBtnTwo().click();

        action.moveToElement(summary.getCartSummTermsOfServiceDialog()).perform();

        Assert.assertTrue(summary.getCartSummTermsOfServiceDialog().isDisplayed());

        action.moveToElement(summary.getCartSummTermsOfServiceDialogClose()).perform();
        action.click(summary.getCartSummTermsOfServiceDialogClose()).build().perform();

        driver.navigate().refresh();

        summary.getCartSummTermsOfServiceCheck().click();
        summary.getCartProceedBtnTwo().click();

        summary.getCartSummPayByBankWire().click();

        Assert.assertEquals(summary.getCartSummPayByBankWireConfirm().getText(), "BANK-WIRE PAYMENT.");

        summary.getCartSummOtherPaymentMethods().click();
        summary.getCartSummPayByCheck().click();

        Assert.assertEquals(summary.getCartSummPayByCheckConfirm().getText(), "CHECK PAYMENT");


        summary.getCartSummConfirmOrderBtn().click();

        Assert.assertTrue(summary.getCartSummSuccessMsg().isDisplayed());
        Assert.assertEquals(summary.getCartSummSuccessMsg().getText(), "Your order on My Store is complete.");

        // Can do more here like , check order history for the exact transaction id. But we are good for the usecase


    }
}
