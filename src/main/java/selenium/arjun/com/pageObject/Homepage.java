package selenium.arjun.com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Utils;

public class Homepage {
	
	private WebDriver driver;
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
	}


	public WebElement getNewsLetterForm(){ return Utils.waitForElementPresence( driver, By.id("newsletter_block_left"), 30 ); }

	public WebElement getNewsLetterField(){ return driver.findElement( By.id( "newsletter-input" ) ); }

	public WebElement getNewsLetterSubmitButton(){ return driver.findElement( By.name( "submitNewsletter" ) );}

	public void setNewsLetterFieldEmail(String Email){
		WebElement field = getNewsLetterField();
		field.clear();
		field.sendKeys( Email );
	}

	// SUCCESSFUL SUBSCRIPTION
	public WebElement getSuccessfulSubscriptionMsg(){
		return Utils.waitForElementPresence( driver, By.xpath("//*[@id=\"columns\"]/p"), 30 );
	}
}
