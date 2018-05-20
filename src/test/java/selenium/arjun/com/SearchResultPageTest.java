package selenium.arjun.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium.arjun.com.pageObject.SearchResults;
import utils.Utils;


public class SearchResultPageTest {

    private WebDriver driver;
    private SearchResults searchResults;
    private Utils utils;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();

        searchResults = new SearchResults(driver);
        utils = new Utils();

        String baseUrl = "http://automationpractice.com/index.php";
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterClass
    public void closeAll() throws Exception {
        utils.takeSnapShot( driver,this.getClass()+".png" );
        driver.quit();
    }

    @Test
    public void verifySortingAlgorithm() {

        searchResults.setSearchField( "dress" );
        searchResults.getSearchSubmitBtn().click();
        searchResults.setSortFilter( "Price: Lowest first" );
        Assert.assertEquals(searchResults.checkSortedItemsPresent(),1);
    }

}
