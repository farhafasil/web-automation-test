package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.SubTopicPage;
import pages.TravelMoneyCardApplyPage;
import pages.TravelMoneyCardPage;
import steps.base.BaseSteps;

public class TravelMoneyCardApplySteps extends BaseSteps {

    TravelMoneyCardApplyPage applyPage = new TravelMoneyCardApplyPage();


    @Then("^I should see travel money card apply page$")
    public void i_should_see_the_travel_money_card_apply_page() throws Throwable {
        this.applyPage.waitForPage();
        Assert.assertTrue("Travel money card apply page tile is ", this.driver.getTitle().equals("Apply for Travel Money Card"));
        //  Can add more assertions like validating the H1, hero image etc.
    }

    @And("^I select \"([^\"]*)\" for payment mode$")
    public void i_select_payment_mode(String paymentMode) throws Throwable {
        if(paymentMode.equals("Online")) {
            this.applyPage.orderOnline();
        } else {
            this.applyPage.orderThroughBranch();
        }
    }















}
