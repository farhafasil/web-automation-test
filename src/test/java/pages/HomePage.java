package pages;

import net.bytebuddy.implementation.bind.annotation.Super;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import pages.base.BasePage;

import java.util.List;


public class HomePage extends BasePage {


    @FindBy(css="div.toast-module  a.toast-dismiss-button")
    private WebElement toastDismissButton;




    public HomePage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }


    public void dismissToast() {
        if(this.toastDismissButton.isDisplayed()) {
            this.toastDismissButton.click();
        }
    }





}



