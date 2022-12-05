package StepDefinations;

import Logs.Log;
import Pages.Navbar;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavbarSteps {

    Navbar navbar = new Navbar();
    Log log = new Log();

    @Then("Ensure the cart badge been {string}")
    public void ensureTheCartBadgeBeen(String arg0) {
        navbar.assertTrue(navbar.MY_CART_BADGE, "1");
        log.info("Card badge is " + arg0);
    }

    @Given("Navigate to {string}")
    public void navigateTo(String arg0) {
        arg0 = arg0.toLowerCase();
        if (arg0.contains("my cart") || arg0.contains("sepetim")) {
            navbar.clickFunction(navbar.MY_CART_BUTTON);
        }
        log.info("Navigated to " + arg0);
    }

    @When("Mouseover on {string} and click on {string}")
    public void mouseoverOnAndClickOn(String arg0, String arg1) {
        navbar.mouseOverOnElement(navbar.createElementLinkText(arg0));
        log.info("Mouse overed on " + arg0);
        navbar.waitUntilDropdownVisible();
        navbar.clickFunction(navbar.createElementLinkText(arg1));
        log.info("Clicked on " + arg1);
    }

    @When("Search a {string}")
    public void searchAProduct(String args0) {
        navbar.sendKeysFunction(navbar.SEARCH_INPUT, args0);
        navbar.clickFunction(navbar.SEARCH_BUTTON);
        log.info("Searching for " + args0);
    }
}
