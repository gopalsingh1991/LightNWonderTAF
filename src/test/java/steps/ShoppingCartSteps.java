package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.BasePage;
import utils.CustomPageFactory;
import utils.WebDriverFactory;

public class ShoppingCartSteps extends BasePage {

    private final CustomPageFactory pageFactory;

    public ShoppingCartSteps() {

        super(WebDriverFactory.getDriver());
        pageFactory = new CustomPageFactory(WebDriverFactory.getDriver());
    }

    @Given("^user is on Amazon website$")
    public void userIsOnAmazonWebsite() {

        driver.get("https://www.amazon.com/");
        Assert.assertTrue(pageFactory.getAmazonHomePage().isPageLoaded(), "Product page is not loaded");
    }

    @When("^user types \"([^\"]*)\" in the search field and presses Enter$")
    public void userSearchesForItem(String item) {

        pageFactory.getAmazonHomePage().searchForItem(item);
        Assert.assertEquals(pageFactory.getAmazonSearchPage().getSearchText(), item, "Search text does not match the entered item");
        Assert.assertTrue(pageFactory.getAmazonSearchPage().isListOfItemsDisplayed(item), "List of " + item + " is not displayed");

    }

    @When("^user selects the (\\d+)(?:st|nd|rd|th) item from the list$")
    public void userSelectsItemFromList(int itemNumber) {

        pageFactory.getAmazonSearchPage().clickSearchResultByIndex(itemNumber);
        Assert.assertTrue(pageFactory.getAmazonProductPage().isPageProductLoaded(), "Product page is not loaded");

    }

    @When("^user adds the item to the cart$")
    public void userAddsItemToCart() {

        pageFactory.getAmazonProductPage().addToCart();
        Assert.assertTrue(pageFactory.getAmazonProductPage().isItemAddedToCart(), "Item is not added to the Cart");
    }

    @When("^user opens the cart$")
    public void userOpensCart() {

        pageFactory.getAmazonProductPage().goToCart();
        Assert.assertTrue(pageFactory.getAmazonCartPage().isCartOpen(), "Cart is not open");
    }

    @Then("^verify that the price on the cart page matches the product page$")
    public void verifyPriceOnCartPageMatchesProductPage() {

        double productPagePrice = pageFactory.getAmazonProductPage().getProductPagePrice();
        double cartPagePrice = pageFactory.getAmazonCartPage().getCartPagePrice();
        Assert.assertEquals(cartPagePrice, productPagePrice, "Price on the cart page does not match the product page");
    }

    @Then("^verify that the subtotal on the cart page matches the product page$")
    public void verifySubtotalOnCartPageMatchesProductPage() {

        double productPageSubtotal = pageFactory.getAmazonProductPage().getProductPageSubtotal();
        double cartPageSubtotal = pageFactory.getAmazonCartPage().getCartPageSubtotal();
        Assert.assertEquals(cartPageSubtotal, productPageSubtotal, "Subtotal on the cart page does not match the product page");
    }
    @Then("verify each item total price is correct")
    public void verifyEachItemTotalPriceIsCorrect() {

        double productPagePrice = pageFactory.getAmazonProductPage().getPrice();
        double cartItemPrice = pageFactory.getAmazonCartPage().getItemPrice();
        Assert.assertEquals(cartItemPrice, productPagePrice, "Product page price does not match cart item price");
    }

    @And("verify that the subtotal is calculated correctly")
    public void verifyThatTheSubtotalIsCalculatedCorrectly() {

        double subtotal = pageFactory.getAmazonProductPage().getSubtotal();
        double expectedSubtotal = pageFactory.getAmazonCartPage().calculateExpectedSubtotal();
        Assert.assertEquals(subtotal, expectedSubtotal, "Subtotal is incorrect");
    }
}