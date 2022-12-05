package StepDefinations;

import Pages.MyCartPage;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class MyCartPageSteps {

    MyCartPage mcp = new MyCartPage();


    @Then("Validate your cart has {string} product or products")
    public void validateYourCartHasProductProducts(String arg0) {

        String myCartText = mcp.returnElementTextFunction(mcp.PRODUCT_QUANTITY_IN_MY_CART);
        Assert.assertEquals(myCartText.substring(myCartText.indexOf("(") + 1, myCartText.lastIndexOf(" ")), arg0);


    }

}
