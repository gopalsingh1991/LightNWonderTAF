package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.AmazonCartPage;
import pages.AmazonHomePage;
import pages.AmazonProductPage;
import pages.AmazonSearchPage;

public class CustomPageFactory {

    private final WebDriver driver;

    public CustomPageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public AmazonHomePage getAmazonHomePage() {
        return PageFactory.initElements(driver, AmazonHomePage.class);
    }

    public AmazonProductPage getAmazonProductPage() {
        return PageFactory.initElements(driver, AmazonProductPage.class);
    }
    public AmazonSearchPage getAmazonSearchPage() {
        return PageFactory.initElements(driver, AmazonSearchPage.class);
    }

    public AmazonCartPage getAmazonCartPage() {
        return PageFactory.initElements(driver, AmazonCartPage.class);
    }


}