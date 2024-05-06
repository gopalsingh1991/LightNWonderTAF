package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AmazonSearchPage extends BasePage {


    public AmazonSearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@data-component-type='s-search-result']//a[@class='a-link-normal']")
    private List<WebElement> searchResults;
    @FindBy(xpath = "//some/xpath/to/search/result/items")
    private List<WebElement> searchResultItems;
    private static final By SEARCH_TEXT_LOCATOR = By.xpath("//some/xpath/to/search/text");

    public boolean isListOfItemsDisplayed(String item) {
        // Check if any of the search result items contain the specified item
        for (WebElement searchResultItem : searchResultItems) {
            if (searchResultItem.getText().contains(item)) {
                return true;
            }
        }
        return false;
    }
    public String getSearchText() {
        // Retrieve the text of the search text element
        WebElement searchTextElement = driver.findElement(SEARCH_TEXT_LOCATOR);
        return searchTextElement.getText();
    }
    public void clickSearchResultByIndex(int itemNumber) {
        // Ensure itemNumber is within the range of available search results
        if (itemNumber > 0 && itemNumber <= searchResults.size()) {
            // Click on the search result at the specified index (itemNumber - 1 to adjust for 0-based index)
            searchResults.get(itemNumber - 1).click();
        } else {
            throw new IllegalArgumentException("Invalid item number: " + itemNumber);
        }
    }


}
