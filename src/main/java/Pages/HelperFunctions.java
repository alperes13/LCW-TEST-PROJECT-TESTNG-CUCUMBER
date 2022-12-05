package Pages;

import Utilities.GWD;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class HelperFunctions {

    WebDriverWait wait = GWD.wait;
    WebDriver driver = GWD.getDriver();

    public void sendKeysFunction(WebElement element, String value) {

        waitUntilVisible(element);

        scrollToElement(element);

        element.clear();

        element.sendKeys(value);


    }


    public void clickFunction(WebElement element) {

        waitUntilClickable(element);
        element.click();

    }

    public String returnElementTextFunction(WebElement element) {

        waitUntilVisible(element);
        return element.getText();

    }


    public void assertTrue(WebElement element, String value) {


        waitUntilVisible(element);
        scrollToElement(element);

        Assert.assertTrue(element.getText().toLowerCase().contains(value));


    }


    public void waitUntilVisible(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void mouseOverOnElement(WebElement element) {
        waitUntilVisible(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).release().build().perform();
    }

    public WebElement waitUntilClickable(WebElement element) {


        wait.until(ExpectedConditions.elementToBeClickable(element));

        return element;

    }

    public void scrollToElement(WebElement element) {
        waitUntilVisible(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);

    }

    public List<WebElement> waitVisibleListAllElement(List<WebElement> elements) {

        wait.until(ExpectedConditions.visibilityOfAllElements(elements));

        return elements;
    }


    public void waitUntilElementsAttributeToBe(WebElement element, String attribute, String text) {
        wait.until(ExpectedConditions.attributeToBe(element, attribute, text));
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void clickRandomElement(List<WebElement> elements) {

        int randomIndex = (int) Math.random() * elements.size();
        waitUntilClickable(elements.get(randomIndex));
        elements.get(randomIndex).click();

    }


}
