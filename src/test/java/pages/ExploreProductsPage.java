package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

public class ExploreProductsPage extends BasePage {

    @FindBy(css = "#products")
    private WebElement section;



    public ExploreProductsPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }


    public void gotoLinkByLabel(String label) throws Exception {
        WebElement link = this.getLinkByLabel(label);
        this.scrollToElement(link);
        link.click();
    }

    public WebElement getLinkByLabel(String label) {
        WebElement link = this.section.findElement(By.xpath(".//div[contains(text(),'"+label+"')]/ancestor::a"));
        return link;
    }
}
