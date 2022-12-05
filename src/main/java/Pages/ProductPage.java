package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends HelperFunctions {

    // Buttons
    @FindBy(id = "pd_add_to_cart")
    public WebElement ADD_TO_CART_BUTTON;
    @FindBy(xpath = "//*[contains(@class, 'option') and (contains(@class, 'active') or contains(@class, 'disabled'))]")
    public List<WebElement> PRODUCT_VARIATIONS;

    // TEXTS
    @FindBy(css = "[class='product-code'] span")
    public WebElement PRODUCT_CODE_LABEL;


    public ProductPage() {
        PageFactory.initElements(GWD.getDriver(), this);
    }


}