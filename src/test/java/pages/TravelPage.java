package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

import java.util.List;

public class TravelPage extends BasePage {

    @FindBy(css = "div.anchor nav")
    private WebElement navigation;

    @FindBy(css = "div.carditem")
    private List<WebElement> cards;

    public TravelPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    public void waitForPage() {
        wait.until(ExpectedConditions.urlContains("/travel.html"));
    }

    public void gotoDiscoverMoreInTravelMoneyCard() throws Exception {
        WebElement discoverMoreLink = this.cards.get(0).findElement(By.cssSelector("a[title='Discover more']"));
        this.scrollToElement(discoverMoreLink);
        discoverMoreLink.click();
    }



}
