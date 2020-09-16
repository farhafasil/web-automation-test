package steps.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DriverHelper {


    private static List<WebDriver> availableDrivers = Collections.synchronizedList(new ArrayList<>());
    private static List<WebDriver> activeDrivers = Collections.synchronizedList(new ArrayList<WebDriver>());


    public static void closeAll() {
        for (WebDriver driver : availableDrivers) {
            driver.quit();
        }
    }

    public WebDriver retrieveDriver() throws Exception {
        WebDriver driver;
        if (availableDrivers.size() > 0) {
            driver = availableDrivers.remove(0);
            activeDrivers.add(driver);
        } else {
            driver = createDriver();
            activeDrivers.add(driver);
        }

        return driver;
    }


    private WebDriver createDriver() throws Exception {

        String os = System.getProperty("os.name").toLowerCase();
        String env = System.getProperty("env.type", "uat").toLowerCase();
        System.out.println("OS that its executing on : " + os);
        String browser_type = Environment.getInstance().properties.getProperty("browser").toString();
        Dimension browser_dimension = null;



        if(System.getProperty("env.width") != null && System.getProperty("env.height") !=null) {
            browser_dimension = new Dimension(Integer.parseInt(System.getProperty("env.width")), Integer.parseInt(System.getProperty("env.height")));
        }

        System.out.println("Current automation directory path : " + System.getProperty("user.dir"));
        System.out.println("Environment that its targeting : " + env);
        System.out.println("Browser that its executing on : " + browser_type);

        WebDriver driver;


        switch (browser_type) {
            case "chrome":
                if(os.contains("mac")) {
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chrome/chromedriver_osx");
                } else if(os.contains("linux")){
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chrome/chromedriver_linux");
                } else {
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chrome/chromedriver.exe");
                }
                driver = new ChromeDriver();
                if(browser_dimension != null) {
                    driver.manage().window().setSize(browser_dimension);
                } else {
                 driver.manage().window().maximize();
                }

                break;

            case "safari":
                //  TODO
                driver = new SafariDriver();
                driver.manage().window().maximize();
                break;

            case "ie":
                //  TODO
                driver = new InternetExplorerDriver();
                driver.manage().window().maximize();
                break;



            default:
                throw new Exception("The browser : " + browser_type + " is not supported yet.");
        }

        driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS); // 120

        return driver;
    }


    public void deleteAllCookies(WebDriver driver) {
        driver.manage().deleteAllCookies();
    }

    public void close(WebDriver driver) {
        deleteAllCookies(driver);
        activeDrivers.remove(driver);
        driver.quit();

    }

    public void release(WebDriver driver) {
        deleteAllCookies(driver);
        activeDrivers.remove(driver);
        availableDrivers.add(driver);
    }



}


