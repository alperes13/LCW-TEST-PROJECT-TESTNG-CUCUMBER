package StepDefinations;

import Logs.Log;
import Pages.ShopPage;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ShopPageSteps extends GWD {

    ShopPage sp = new ShopPage();
    Log log = new Log();

    @Then("Validate listed product count with listed product count information.")
    public void validateListedProductCountWithListedProductCountInformation() {
        List<WebElement> productsCount = sp.waitVisibleListAllElement(sp.ALL_PRODUCT_TITLES);
        log.info("Product count is : " + productsCount.size());
        String countInInformation = sp.returnElementTextFunction(sp.PAGINATION_LISTED_PRODUCTS_COUNT_TEXT);
        log.info("Information is : " + countInInformation);
        Assert.assertEquals(String.valueOf(productsCount.size()), countInInformation);
        log.info("Assertion passed");

    }

    @And("Filter products for a {string}")
    public void filterProductsForA(String arg0) {
        sp.filterProductsFor(arg0);
        log.info("Products filtered for " + arg0);
    }

    @And("Sort products price for a {string}")
    public void sortProductsPriceForA(String arg0) {
        sp.clickFunction(sp.CONTENT_DROPDOWN_BUTTON);
        log.info("Clicked on dropdown in page content");
        if (arg0.contains("highest")) {
            sp.clickFunction(sp.CONTENT_DROPDOWN_HIGH_PRICE_BUTTON);
        } else if (arg0.contains("lowest")) {
            sp.clickFunction(sp.CONTENT_DROPDOWN_LOW_PRICE_BUTTON);
        }
        log.info("Products sorted for " + arg0);

    }

    @And("Click on any product")
    public void clickOnAnyProduct() {
        sp.clickRandomElement(sp.ALL_PRODUCT_TITLES);
        log.info("Clicked on random product");
    }

    @Then("Validate filtered product count by products count in that variation")
    public void validateFilteredProductCountByProductsCountInThatVariation() {
        sp.waitUntilVisible(sp.FILTER_APPLIED_FILTER_VALUE);
        String variationCount = sp.returnElementTextFunction(sp.FILTER_ENABLED_VARIATION_PRODUCT_COUNT_TEXT)
                .replace(")", "")
                .replace("(", "");
        log.info("Variation count is : " + variationCount);
        String totalProductCount = sp.returnElementTextFunction(sp.PAGINATION_TOTAL_PRODUCTS_COUNT_TEXT);
        log.info("Information is : " + totalProductCount);
        Assert.assertEquals(totalProductCount, variationCount);
        log.info("Assertion passed");
    }

    @Then("Validate products prices sorted for {string}")
    public void validateProductsPricesSortedFor(String arg0) {
        sp.waitUntilElementsAttributeToBe(sp.PRODUCT_COMPONENT, "class", "product-grid");
        List<WebElement> elements = sp.waitVisibleListAllElement(sp.ALL_PRODUCT_PRICES);
        if (arg0.contains("highest")) {
            for (int i = 0; i < elements.size() - 2; i++) {
                assert Integer.parseInt(elements.get(i).getText().substring(0, elements.get(i).getText().indexOf(',')))
                        >=
                        Integer.parseInt(elements.get(i + 1).getText().substring(0, elements.get(i + 1).getText().indexOf(',')));
            }

        } else if (arg0.contains("lowest")) {
            for (int i = 0; i < elements.size() - 2; i++) {
                assert Integer.parseInt(elements.get(i).getText().substring(0, elements.get(i).getText().indexOf(',')))
                        <=
                        Integer.parseInt(elements.get(i + 1).getText().substring(0, elements.get(i + 1).getText().indexOf(',')));

            }
        }
        log.info("Products sorted correctly.");
    }


    @Then("Validate products count with total products counts of filters in header")
    public void validateProductsCountWithTotalProductsCountsOfFiltersInHeader() {

        List<WebElement> productsQuantitiesInFilters = sp.waitVisibleListAllElement(sp.FILTER_PRODUCT_QUANTITIES_IN_PRODUCT_TYPE);
        int totalQuantity = 0;
        for (WebElement element : productsQuantitiesInFilters) {
            totalQuantity += Integer.parseInt(element.getText().replace("(", "").replace(")", ""));
        }
        log.info("Total quantity in filters : " + totalQuantity);
        int formalTotalQuantity = Integer.parseInt(sp.returnElementTextFunction(sp.PAGINATION_TOTAL_PRODUCTS_COUNT_TEXT));
        log.info("Information of quantity : " + formalTotalQuantity);
        Assert.assertEquals(totalQuantity, formalTotalQuantity);
        log.info("Assertion passed");
    }

    @Then("Validate page header according to products and url")
    public void validatePageHeaderAccordingToProductsAndUrl() {
        String header = sp.returnElementTextFunction(sp.HEADER_TEXT).replace("\"", "").toLowerCase();
        log.info("Page header is : " + header);
        String url = sp.getUrl().toLowerCase();
        log.info("Url is : " + url);
        String productTitle = sp.returnElementTextFunction(sp.FIRST_PRODUCT_TITLE).toLowerCase();
        log.info("Product title is : " + productTitle);
        assert url.contains(header.replace(" ", "-"));
        assert productTitle.contains(header);
        log.info("Assertions passed");
    }
}
