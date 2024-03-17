#Feature file to check the two check the two scenarios given in the problem statement.
Feature: Ebay Functionality Check.

  #First Scenario written in the Gherkin style for BDD.
  Scenario: Access a Product via category after applying multiple filters
    Given user is on ebay website page
    When user navigates to Search
    And user clicks on Cell Phones & Smartphones
    And user clicks on All Filters
    And user add three filters - Condition, Price and Item location
    Then verify the filter tags are applied.

  #Second Scenario written in the Gherkin style for BDD.
  Scenario: Access a Product via Search
    Given user is on ebay website
    When user enters Macbook in Search Bar
    And user changes the category and click on Search
    And user verifies that the page is loaded completely.
    Then user first result name matches with the search string.
