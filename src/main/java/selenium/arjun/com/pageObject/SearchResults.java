package selenium.arjun.com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class SearchResults {
    private WebDriver driver;
    private Utils utils;
    public SearchResults(WebDriver driver) {
        this.driver = driver;
        this.utils = new Utils();
    }

    public WebElement getSearchField(){ return driver.findElement( By.id("search_query_top") );}

    public WebElement getSearchSubmitBtn(){ return driver.findElement( By.name("submit_search"  ) );}

    public WebElement getSortFilter(){return driver.findElement( By.id("selectProductSort") );}

    public void setSearchField(String keyword){
        WebElement field = getSearchField();
        field.clear();
        field.sendKeys( keyword );
    }

    public void setSortFilter(String sortFiler){
        WebElement filter = getSortFilter();
        filter.sendKeys( sortFiler );
    }

    public int checkSortedItemsPresent(){
        utils.waitForElementPresence(driver,By.id("center_column"),30);

        String temp;
        String newStr;
        int count =7;
        int productPriceArray[] = new int[8];
        for(int i=1;i<8;i++){
            if(driver.findElements( By.xpath( "//*[@id=\"center_column\"]/ul/li["+count+"]/div/div[2]/div[1]/span[3]" ) ).size() != 0){
                temp = driver.findElement( By.xpath( "//*[@id=\"center_column\"]/ul/li["+count+"]/div/div[2]/div[1]/span[2]" ) ).getText();
                newStr = temp.replaceAll("[^\\d.]+", "");
            }
            else{
                temp = driver.findElement( By.xpath( "//*[@id=\"center_column\"]/ul/li["+count+"]/div/div[2]/div[1]/span" ) ).getText();
                newStr = temp.replaceAll("[^\\d.]+", "");
            }

            productPriceArray[i-1] = (int) Float.parseFloat( newStr );
        }

        return utils.arraySortedOrNot(productPriceArray,7) ;
    }


}
