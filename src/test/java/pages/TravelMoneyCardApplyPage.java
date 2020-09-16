package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

import java.util.List;

public class TravelMoneyCardApplyPage extends BasePage {



    @FindBy(css = "div.quickOption label")
    private List<WebElement> options;



    public TravelMoneyCardApplyPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void waitForPage() {
        this.switchWindowHandle();
        wait.until(ExpectedConditions.urlContains("/TravelMoneyCardApply/"));
    }

    public void orderOnline() {
        this.options.get(0).click();
    }

    public void orderThroughBranch() {
        //  TODO

    }





}
