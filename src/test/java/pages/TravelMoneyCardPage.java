package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

import java.util.List;

public class TravelMoneyCardPage extends BasePage {

    @FindBy(css = "div.anchor nav")
    private WebElement navigation;

    @FindBy(css = "div.carditem")
    private List<WebElement> cards;

    @FindBy(css = ".anchor-nav-cta a[title='Order online']")
    private WebElement orderOnlineBtn;

    public TravelMoneyCardPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    public void waitForPage() {
        wait.until(ExpectedConditions.urlContains("/travel-money-card.html"));
    }

    public void orderOnline() {
        this.orderOnlineBtn.click();
    }





}
