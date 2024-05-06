package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonHomePage extends BasePage {

    // Locators using @FindBy annotation
    public AmazonHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchField;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement PAGE_LOAD_INDICATOR;

    public void searchForItem(String item) {
        searchField.sendKeys(item);
        searchField.submit();
    }
    public boolean isPageLoaded() {
        try {
            // Check if the page load indicator element is present
            return PAGE_LOAD_INDICATOR.isDisplayed();
            //return driver.findElement(PAGE_LOAD_INDICATOR).isDisplayed();
        } catch (NoSuchElementException e) {
            // Page load indicator element not found, page is not loaded
            return false;
        }
    }

}