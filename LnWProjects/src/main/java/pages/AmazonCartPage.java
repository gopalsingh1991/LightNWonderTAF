package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AmazonCartPage extends BasePage {


    public AmazonCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//some/xpath/to/shopping/cart/text")
    private WebElement shoppingCartText;

    @FindBy(xpath = "//some/xpath/to/cart/page/subtotal")
    private WebElement cartPageSubtotalElement;

    @FindBy(css = "span#subtotal")
    private WebElement subtotalElement;

    @FindBy(css = "span.item-price")
    private WebElement itemPriceElement;

    @FindBy(css = "span.item-price")
    private List<WebElement> itemPriceElements;

    public boolean isCartOpen() {
        // Check if the "Shopping Cart" text element is displayed and if its text contains "Shopping Cart"
        return shoppingCartText.isDisplayed() && shoppingCartText.getText().contains("Shopping Cart");
    }

    public double getCartPagePrice() {
        // Get the text of the cart page subtotal element
        String subtotalText = cartPageSubtotalElement.getText();
        return Double.parseDouble(subtotalText.replaceAll("[^\\d.]+", ""));
    }

    public double getCartPageSubtotal() {

        // Get the text of the subtotal element
        String subtotalText = subtotalElement.getText();

        // Extract the subtotal value (assuming it's formatted as a double
        return Double.parseDouble(subtotalText.replaceAll("[^0-9.]", ""));
    }
    // Method to get the item price on the cart page
    public double getItemPrice() {

        // Get the text of the item price element
        String itemPriceText = itemPriceElement.getText();

        // Extract and return the item price value (assuming it's formatted as a double)
        return  Double.parseDouble(itemPriceText.replaceAll("[^0-9.]", ""));
    }
    // Method to calculate the expected subtotal on the cart page
    public double calculateExpectedSubtotal() {

        // Initialize subtotal variable
        double subtotal = 0.0;

        // Iterate through each item price element
        for (WebElement itemPriceElement : itemPriceElements) {
            // Get the text of the item price element
            String itemPriceText = itemPriceElement.getText();

            // Extract the item price value (assuming it's formatted as a double)
            double itemPrice = Double.parseDouble(itemPriceText.replaceAll("[^0-9.]", ""));

            // Add the item price to the subtotal
            subtotal += itemPrice;
        }

        return subtotal;
    }
}

