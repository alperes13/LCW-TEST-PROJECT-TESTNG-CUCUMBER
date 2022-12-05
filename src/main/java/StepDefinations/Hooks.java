package StepDefinations;

import Utilities.ExcelUtility;
import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {

    @Before
    public void before() {
        System.out.println(" -------------------- Scenario has been initialized. -------------------- ");


    }


    @After
    public void after(Scenario scenario) {


        System.out.println("Scenario Result =" + scenario.getStatus());
        System.out.println(" -------------------- Scenario has been over. -------------------- ");



        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy--HH-mm-ss");

        ExcelUtility.writeExcel("src/test/java/Reports/ExcelReports/ScenarioStatus.xlsx",
                scenario, GWD.threadBrowserName.get(), date.format(formatter));



        if (scenario.isFailed()) {
            // klasöre
            TakesScreenshot screenshot = (TakesScreenshot) GWD.getDriver();
            File ekranDosyasi = screenshot.getScreenshotAs(OutputType.FILE);

            try {
                FileUtils.copyFile(ekranDosyasi,
                        new File("src/test/java/Reports/Screenshots/" + scenario.getName() + "-" + date.format(formatter) + ".png"));

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        GWD.quitDriver();


    }

}
