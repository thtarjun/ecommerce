package selenium.arjun.com.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Utils;

public class Clothes {
	
	private WebDriver driver;
	
	public Clothes(WebDriver driver) {
		this.driver = driver;
	}
	

	public WebElement getDressesBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]"), 30);
	}


	public WebElement getSummerDressesBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]//a[contains(text(), \"Summer Dresses\")]"), 30);
	}


	public WebElement getSummerDressProduct(int dressNum) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id=\"center_column\"]/ul/li[" + dressNum + "]"), 30);	
	}

}
