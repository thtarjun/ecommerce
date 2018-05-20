package selenium.arjun.com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Utils;

public class ContactForm {
	
	private WebDriver driver;
	
	public ContactForm(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getContactForm() {
		return Utils.waitForElementPresence(driver, By.id("contact"), 30);
	}

	public WebElement getContactSubjectField() {
		return Utils.waitForElementPresence(driver, By.id("id_contact"), 30);
	}

	public WebElement getContactEmailField() {
		return Utils.waitForElementPresence(driver, By.id("email"), 30);
	}

	public WebElement getContactOrderRefField() {
		return Utils.waitForElementPresence(driver, By.id("id_order"), 30);
	}

	public WebElement getContactMsgField() {
		return Utils.waitForElementPresence(driver, By.id("message"), 30);
	}

	public WebElement getContactSubmitBtn() {
		return Utils.waitForElementPresence(driver, By.id("submitMessage"), 30);
	}
	
	
	public void setContactSubjectField(String subject) {
		WebElement sub = this.getContactSubjectField();
		sub.sendKeys(subject);
	}
	
	public void setContactEmailField(String mail) {
		WebElement email = this.getContactEmailField();
		email.clear();
		email.sendKeys(mail);
	}

	public void setContactOrderRefField(String orderRef) {
		WebElement order = this.getContactOrderRefField();
		order.clear();
		order.sendKeys(orderRef);
	}

	public void setContactMsgField(String msg) {
		WebElement message = this.getContactMsgField();
		message.clear();
		message.sendKeys(msg);
	}

	
	/*
	*
	*
	* **** ERRORS ***
	*
	*
	*/

	
	public WebElement getInvalidEmailError() {
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"Invalid email address.\")]"), 30);
	}

}
