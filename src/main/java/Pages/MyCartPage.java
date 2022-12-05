package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MyCartPage extends HelperFunctions {

    // TEXTS
    @FindBy(css = "[class='col-md-12 cart-header mb-20'] span")
    public WebElement PRODUCT_QUANTITY_IN_MY_CART;


    public MyCartPage() {
        PageFactory.initElements(GWD.getDriver(), this);
    }



}