package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Navbar extends HelperFunctions {

    // Buttons
    @FindBy(xpath = "//*[text()='Sepetim']")
    public WebElement MY_CART_BUTTON;
    @FindBy(css = "[class='search-form__input-field__btn-search false']")
    public WebElement SEARCH_BUTTON;

    // INPUTS
    @FindBy(id = "search-form__input-field__search-input")
    public WebElement SEARCH_INPUT;

    // TEXTS
    @FindBy(xpath = "//*[text()='Sepetim']/following-sibling::span")
    public WebElement MY_CART_BADGE;


    public Navbar() {
        PageFactory.initElements(GWD.getDriver(), this);
    }


    public WebElement createElementLinkText(String elementText) {
        return waitUntilClickable(driver.findElement(By.xpath("//a[text()='" + elementText + "']")));
    }

    public void waitUntilDropdownVisible() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class='menu-header-item menu-header-item--active ']")));
    }
}
