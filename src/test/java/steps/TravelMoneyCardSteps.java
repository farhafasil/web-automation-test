package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.SubTopicPage;
import pages.TravelMoneyCardPage;
import pages.TravelPage;
import steps.base.BaseSteps;

public class TravelMoneyCardSteps extends BaseSteps {



    private TravelMoneyCardPage travelMoneyCardPage = new TravelMoneyCardPage();
    private SubTopicPage subTopicPage = new SubTopicPage();

    @Then("^I should see travel money card page$")
    public void i_should_see_the_travel_money_card_page() throws Throwable {
        this.travelMoneyCardPage.waitForPage();
        Assert.assertTrue("Travel money card page tile is ", this.driver.getTitle().equals("Travel Money Card – CommBank"));
        //  Can add more assertions like validating the H1, hero image etc.
    }

    @And("^I verify all the \"([^\"]*)\" exist on the page$")
    public void i_verify_all_the_subtopics_exist_on_the_page(String subTopics) throws Throwable {
        String[] topics = subTopics.split("[,]", 0);
        for(String topic: topics) {
            WebElement link = subTopicPage.getTopicByLabel(topic);
            subTopicPage.gotoTopicByLabel(topic);
            Assert.assertTrue(topic + " container exists ", subTopicPage.getTargetContainer(topic).isDisplayed());

        }

    }



    @When("^I click on order online button on travel money card page$")
    public void i_click_on_order_online_button() throws Throwable {
        this.travelMoneyCardPage.orderOnline();

    }











}
