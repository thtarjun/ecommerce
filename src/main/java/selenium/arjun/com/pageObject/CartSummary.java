package selenium.arjun.com.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Utils;

public class CartSummary {
	
	private WebDriver driver;
	
	public CartSummary(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCartSummaryTable() {
		return Utils.waitForElementPresence(driver, By.id("cart_summary"), 30);
	}

	
	public WebElement getCartSummTotalProductsPrice() {
		return Utils.waitForElementPresence(driver, By.id("total_product"), 30);
	}
	
	public WebElement getCartSummTotalShipping() {
		return Utils.waitForElementPresence(driver, By.id("total_shipping"), 30);
	}
	
	public WebElement getSignInForm() {
		return Utils.waitForElementPresence(driver, By.id("login_form"), 30);
	}
	
	public WebElement getCartSummaryTotalPrice() {
		return Utils.waitForElementPresence(driver, By.id("total_price"), 30);
	}

	public WebElement getCartProceedBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"), 30);
	}

	
	public WebElement getCartProceedBtnTwo() {
		return Utils.waitToBeClickable(driver, By.xpath("//button[@type=\"submit\"]/span[contains(text(), \"Proceed to checkout\")]"), 30);
	}
	
	public WebElement getCartSummBillingAdressName() {
		return Utils.waitForElementPresence(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_firstname address_lastname\"]"), 30);
	}

	
	public WebElement getCartSummBillingAdressOne() {
		return Utils.waitForElementPresence(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_address1 address_address2\"]"), 30);
	}	
	
	public WebElement getCartSummBillingAdressCityState() {
		return Utils.waitForElementPresence(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_city address_state_name address_postcode\"]"), 30);
	}
	
	public WebElement getCartSummBillingAdressCountry() {
		return Utils.waitForElementPresence(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_country_name\"]"), 30);
	}
	
	public WebElement getCartSummBillingAdressHomePhone() {
		return Utils.waitForElementPresence(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_phone\"]"), 30);
	}
	
	public WebElement getCartSummBillingAdressMobile() {
		return Utils.waitForElementPresence(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_phone_mobile\"]"), 30);
	}
	
	public WebElement getCartSummTermsOfServiceCheck() {
		return Utils.waitForElementPresence(driver, By.id("cgv"), 30);
	}
	
	public WebElement getCartSummTermsOfServiceDialog() {
		return Utils.waitForElementPresence(driver, By.xpath("//p[contains(text(), \"You must agree to the terms of service before continuing.\")]"), 30);
	}
	
	public WebElement getCartSummTermsOfServiceDialogClose() {
		return Utils.waitForElementPresence(driver, By.xpath("//a[@class=\"fancybox-item fancybox-close\"]"), 30);
	}
	
	public WebElement getCartSummPayByBankWire() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[@title=\"Pay by bank wire\"]"), 30);
	}
	
	public WebElement getCartSummPayByCheck() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[@title=\"Pay by check.\"]"), 30);
	}
	
	public WebElement getCartSummPayByBankWireConfirm() {
		return Utils.waitForElementPresence(driver, By.xpath("//h3[contains(text(), \"Bank-wire payment.\")]"), 30);
	}
	
	public WebElement getCartSummPayByCheckConfirm() {
		return Utils.waitForElementPresence(driver, By.xpath("//h3[contains(text(), \"Check payment\")]"), 30);
	}
	
	public WebElement getCartSummConfirmOrderBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//button[@type=\"submit\"]/span[contains(text(), \"I confirm my order\")]"), 30);
	}
	
	public WebElement getCartSummOtherPaymentMethods() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[@href=\"http://automationpractice.com/index.php?controller=order&step=3\"]"), 30);
	}
	
	public WebElement getCartSummSuccessMsg() {
		return Utils.waitForElementPresence(driver, By.xpath("//p[contains(text(), \"Your order on My Store is complete.\")]"), 30);
	}
	
	public List<WebElement> getCartSummTotalProductsNum() {
		return driver.findElements(By.xpath("//table[@id=\"cart_summary\"]/tbody/tr"));
	}

	public WebElement getEmailField(){ return driver.findElement( By.id( "email" ) );}

	public void setEmailField(String mail){
		WebElement email = getEmailField();
		email.clear();
		email.sendKeys(mail);
	}

	public WebElement getPasswordField(){ return driver.findElement( By.id( "passwd" ) );}

	public void setPasswordField(String pass){
		WebElement passwd = getPasswordField();
		passwd.clear();
		passwd.sendKeys(pass);
	}

	public WebElement getSignInBtn(){ return driver.findElement( By.id( "SubmitLogin" ) );}

}
