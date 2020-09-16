package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.ExploreProductsPage;
import pages.HomePage;
import pages.SubTopicPage;
import pages.TravelPage;
import steps.base.BaseSteps;

public class TravelSteps extends BaseSteps {



    private SubTopicPage subTopicPage = new SubTopicPage();
    private TravelPage travelPage = new TravelPage();


    @Then("^I should see the travel page$")
    public void i_should_see_the_travel_page() throws Throwable {
        this.travelPage.waitForPage();
        Assert.assertTrue("Travel page tile is ", this.driver.getTitle().equals("Travel - CommBank"));
        //  Can add more assertions like validating the H1, hero image etc.
    }
    @When("^I click on Discover more in Travel Money Card section$")
    public void i_goto_discover_more_in_travel_money_card_section() throws Throwable {
        this.travelPage.gotoDiscoverMoreInTravelMoneyCard();
    }













}
