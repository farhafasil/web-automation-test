Feature: Verify whether the customer is able to order the travel money card online

  @SmokeTest
  Scenario Outline: Order travel money card online
    Given I am on the commbank home page
    When  I click on "Explore products" in sub topics
    When  I click on "Travel products" in explore products
    Then  I should see the travel page
    When  I click on Discover more in Travel Money Card section
    Then  I should see travel money card page
    And   I verify all the "<subTopics>" exist on the page
    When  I click on order online button on travel money card page
    Then  I should see travel money card apply page
    And   I select "Online" for payment mode
    Then  I should be on the net bank login page
    And   I verify login user interface

    Examples:
      | subTopics                                                                                     |
      | Features & benefits,Currency converter,Reload now,Rates & fees,How it works,Manage your card  |