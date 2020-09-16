package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

import java.util.List;

public class NetBankLoginPage extends BasePage {



    @FindBy(css = "#txtMyClientNumber_field")
    private WebElement clientNumberInputField;

    @FindBy(css = "#txtMyPassword_field")
    private WebElement passwordInputField;



    public NetBankLoginPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void waitForPage() {
        wait.until(ExpectedConditions.urlContains("/netbank/Logon/Logon.aspx"));
    }

    public WebElement getClientNumberField() {
        return this.clientNumberInputField;
    }

    public WebElement getPasswordField() {
        return this.passwordInputField;
    }





}
