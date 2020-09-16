package steps.hooks;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import steps.base.BaseSteps;
import steps.utils.DriverHelper;
import cucumber.api.Scenario;
import cucumber.api.java.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks extends BaseSteps {
    private DriverHelper driverHelper = new DriverHelper();

    @Before()
    public void testInitialize(Scenario scenario) throws Exception {
        driver = driverHelper.retrieveDriver();
        ScenarioName = scenario.getName();
    }

    @After()
    public void teardown(Scenario scenario) throws Exception {

        if(scenario.isFailed()) {

            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());


                String timestamp = new SimpleDateFormat("dd.mm.yyy.HH.mm.ss").format(new Date());
                String folderPath = "target/screenshots/";
                File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                File destfile = new File(folderPath + scenario.getName() + ".png");
                FileUtils.copyFile(screenshot, destfile);

                byte[] data = FileUtils.readFileToByteArray(screenshot);
                scenario.embed(data, "image/png");

            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }


        }

        driverHelper.deleteAllCookies(driver);
        driverHelper.close(driver);

    }

}
