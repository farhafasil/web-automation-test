package pages.base;

import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.base.BaseSteps;

public class BasePage extends BaseSteps {

    protected WebDriverWait wait;

    public BasePage() {
        wait = new WebDriverWait(driver,90);
    }

    public void navigate(String url) {
        driver.get(url);
    }

    public String getJsProperty(String property) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return " + property);
    }




    public void scrollToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }


    public void switchWindowHandle(){
        for(String winHandle : this.driver.getWindowHandles()){
            this.driver.switchTo().window(winHandle);
        }
    }







}
