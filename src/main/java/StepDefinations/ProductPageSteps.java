package StepDefinations;

import Logs.Log;
import Pages.ProductPage;
import io.cucumber.java.en.And;

public class ProductPageSteps {

    ProductPage pp = new ProductPage();
    Log log = new Log();
    @And("Click on any variation if it is exist and add item to cart")
    public void clickOnAnyVariationIfItIsExistAndAddItemToCart() {
        validateProductPage();
        pp.clickRandomElement(pp.PRODUCT_VARIATIONS);
        log.info("Clicked on any variation if it exist");
        pp.clickFunction(pp.ADD_TO_CART_BUTTON);
        log.info("Product added to cart");

    }

    public void validateProductPage() {
        pp.assertTrue(pp.PRODUCT_CODE_LABEL, "ürün kodu");
        log.info("Product page validated");
    }



}
