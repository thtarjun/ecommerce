package selenium.arjun.com.pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Utils;

public class Account {
	
	private WebDriver driver;
	
	public Account(WebDriver driver) {
		this.driver = driver;
	}

	
	public WebElement getAccountLogout() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[@title=\"Log me out\"]"), 30);
	}


}
