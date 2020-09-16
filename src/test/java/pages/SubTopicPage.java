package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

import java.util.List;

public class SubTopicPage extends BasePage {

    @FindBy(css = "div.anchor")
    private WebElement navigationContainer;



    @FindBy(css = ".anchor-module.sticky")
    private WebElement stickyNavigation;

    public SubTopicPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }


    public void gotoTopicByLabel(String label) throws Exception {
        WebElement link = this.getTopicByLabel(label);
        link.click();
        wait.until(ExpectedConditions.visibilityOf(this.stickyNavigation));
        //  TODO
        //  Due time constraints added a sleep. Needs refactoring
        Thread.sleep(500);
    }

    public WebElement getTopicByLabel(String label) {
        WebElement link = this.navigationContainer.findElement(By.xpath(".//a[contains(text(),'"+label+"')]"));
        return link;
    }

    public WebElement getTargetContainer(String label) {
        WebElement link = this.getTopicByLabel(label);
        return this.driver.findElement(By.cssSelector(link.getAttribute("data-target")));
    }
}


