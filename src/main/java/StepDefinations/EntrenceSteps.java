package StepDefinations;

import Utilities.GWD;
import io.cucumber.java.en.Given;

import java.time.Duration;

public class EntrenceSteps extends GWD {
    @Given("Navigate to homepage")
    public void navigateToHomepage() {
        GWD.getDriver().get("https://www.lcwaikiki.com/tr-TR/TR");
        GWD.getDriver().manage().window().maximize();
        GWD.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }
}
