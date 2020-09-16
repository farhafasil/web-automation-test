package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.ExploreProductsPage;
import pages.HomePage;
import pages.SubTopicPage;
import steps.base.BaseSteps;
import steps.utils.Environment;

public class HomeSteps extends BaseSteps {


    private HomePage homePage = new HomePage();
    private SubTopicPage subTopicPage = new SubTopicPage();
    private ExploreProductsPage exploreProductsPage = new ExploreProductsPage();


    @Given("^I am on the commbank home page$")
    public void i_am_on_the_commbank_home_page() throws Throwable {
        //  TODO make it configurable
        homePage.navigate(Environment.getInstance().properties.getProperty("URL"));

    }

    @When("^I click on \"([^\"]*)\" in sub topics$")
    public void iClickOnSubTopics(String label) throws Throwable {
        homePage.dismissToast();
        subTopicPage.gotoTopicByLabel(label);

    }

    @When("^I click on \"([^\"]*)\" in explore products$")
    public void iClickOnSubProductsInExploreProducts(String label) throws Throwable {
        exploreProductsPage.gotoLinkByLabel(label);
    }


}
