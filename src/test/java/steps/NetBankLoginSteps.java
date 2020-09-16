package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.NetBankLoginPage;
import pages.TravelMoneyCardApplyPage;
import steps.base.BaseSteps;

public class NetBankLoginSteps extends BaseSteps {

    NetBankLoginPage netBankLoginPage = new NetBankLoginPage();


    @Then("^I should be on the net bank login page$")
    public void i_should_see_the_net_bank_login_page() throws Throwable {
        this.netBankLoginPage.waitForPage();
        Assert.assertTrue("Net bank login page tile is ", this.driver.getTitle().equals("NetBank - Log on to NetBank - Enjoy simple and secure online banking from Commonwealth Bank"));
        //  Can add more assertions like validating the H1, hero image etc.
    }

    @And("^I verify login user interface$")
    public void i_verify_login_user_interface() throws Throwable {
        Assert.assertTrue("Client input field should exist ", this.netBankLoginPage.getClientNumberField().isDisplayed());
        Assert.assertTrue("Password field should exist ", this.netBankLoginPage.getPasswordField().isDisplayed());
    }















}
