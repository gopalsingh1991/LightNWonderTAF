package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AmazonProductPage extends BasePage {
    public AmazonProductPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;
    @FindBy(id = "nav-cart")
    private WebElement cartIcon;
    @FindBy(xpath = "//some/xpath/to/added/to/cart/message")
    private WebElement addedToCartMessage;
    @FindBy(xpath = "//some/xpath/to/product/page/price")
    private WebElement productPagePriceElement;
    @FindBy(xpath = "//span[@id='subtotal']")
    private WebElement subtotalElement;
    @FindBy(xpath = "//span[@id='price']")
    private WebElement priceElement;
    @FindBy(xpath = "//span[@id='subtotal']")
    private WebElement subtotalElement2;

    private static final By PRODUCT_PAGE_LOAD_INDICATOR = By.xpath("//some/xpath/to/page/load/indicator");

    public void addToCart() {
        addToCartButton.click();
    }
    public void goToCart() {
        cartIcon.click();
    }
    public boolean isItemAddedToCart() {
        // Check if the "Added to Cart" message is present
        return addedToCartMessage.isDisplayed();
    }
    public boolean isPageProductLoaded() {
        try {
            // Check if the page load indicator element is present
            return driver.findElement(PRODUCT_PAGE_LOAD_INDICATOR).isDisplayed();
        } catch (NoSuchElementException e) {
            // Page load indicator element not found, page is not loaded
            return false;
        }
    }
    public double getProductPagePrice() {
        // Get the text of the product page price element
        String priceText = productPagePriceElement.getText();
        return Double.parseDouble(priceText.replaceAll("[^\\d.]+", ""));
    }
    // Method to get the product page subtotal
    public double getProductPageSubtotal() {

        // Get the text of the subtotal element
        String subtotalText = subtotalElement.getText();

        // Extract the subtotal value (assuming it's formatted as a double)
        return Double.parseDouble(subtotalText.replaceAll("[^0-9.]", ""));
    }
    public double getPrice() {

        // Get the text of the price element
        String priceText = priceElement.getText();

        // Extract the price value (assuming it's formatted as a double)
        return Double.parseDouble(priceText.replaceAll("[^0-9.]", ""));
    }

    // Method to get the subtotal on the product page
    public double getSubtotal() {

        // Get the text of the subtotal element
        String subtotalText = subtotalElement2.getText();

        // Extract the subtotal value (assuming it's formatted as a double)
        return Double.parseDouble(subtotalText.replaceAll("[^0-9.]", ""));
    }


}


