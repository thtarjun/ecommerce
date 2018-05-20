package selenium.arjun.com.pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Utils;

public class Cart {
	
	private WebDriver driver;
	
	public Cart(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCartTab() {
		return Utils.waitForElementPresence(driver, By.xpath("//b[contains(text(), \"Cart\")]/.."), 30);
	}
	
	public WebElement getCartTabCheckOutBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[@id=\"button_order_cart\"]/span[contains(text(), \"Check out\")]"), 30);
	}
}
