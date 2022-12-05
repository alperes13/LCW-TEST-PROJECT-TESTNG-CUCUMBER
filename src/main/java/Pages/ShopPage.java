package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShopPage extends HelperFunctions {

    // Buttons
    @FindBy(xpath = "//span[text()='XL']/preceding-sibling::div")
    public WebElement FILTER_XL_RADIO_BUTTON;
    @FindBy(className = "dropdown-button__button")
    public WebElement CONTENT_DROPDOWN_BUTTON;
    @FindBy(xpath = "//*[text()='En yüksek fiyat']")
    public WebElement CONTENT_DROPDOWN_HIGH_PRICE_BUTTON;
    @FindBy(xpath = "//*[text()='En düşük fiyat']")
    public WebElement CONTENT_DROPDOWN_LOW_PRICE_BUTTON;

    // TEXTS
    @FindBy(xpath = "//*[@class='container-fluid product-list-heading']//child::*[contains(@class,'product-list-heading__product-count__count') or contains(@class,'product-list-heading__heading')]")
    public WebElement HEADER_TEXT;
    @FindBy(className = "product-card__title")
    public List<WebElement> ALL_PRODUCT_TITLES;
    @FindBy(xpath = "//*[@class='product-price__price product-price__price--only' or @class='product-price__cart-price' or @class='product-price__price']")
    public List<WebElement> ALL_PRODUCT_PRICES;
    @FindBy(xpath = "//span[text()='XL']/following-sibling::span")
    public WebElement FILTER_ENABLED_VARIATION_PRODUCT_COUNT_TEXT;
    @FindBy(xpath = "//div[text()='Ürün Tip']/following-sibling::div//div[@class='filter-option']//span[@class='filter-option__product-count']")
    public List<WebElement> FILTER_PRODUCT_QUANTITIES_IN_PRODUCT_TYPE;
    @FindBy(className = "applied-filters__value")
    public WebElement FILTER_APPLIED_FILTER_VALUE;
    @FindBy(className = "paginator__info-text-viewed-products")
    public WebElement PAGINATION_LISTED_PRODUCTS_COUNT_TEXT;
    @FindBy(className = "paginator__info-text-product-count")
    public WebElement PAGINATION_TOTAL_PRODUCTS_COUNT_TEXT;
    @FindBy(className = "product-card__title")
    public WebElement FIRST_PRODUCT_TITLE;

    // COMPONENTS
    @FindBy(className = "product-grid")
    public WebElement PRODUCT_COMPONENT;


    public ShopPage() {
        PageFactory.initElements(GWD.getDriver(), this);
    }


    WebElement element;

    public void filterProductsFor(String strElement) {
        strElement = strElement.toLowerCase();
        switch (strElement) {
            case "xl":
                element = FILTER_XL_RADIO_BUTTON;
                break;
        }

        clickFunction(element);

    }

}