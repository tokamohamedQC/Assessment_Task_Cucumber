Feature: Assert that results in second page equals results in third page

  Scenario: user search ith keyword "Vodafone" in Bing search engine
    Given user open browser
    And user navigates to Bing search engine
    Then enters keyword Vodafone in search input
    And click search icon
    Then user scrolls down to pagination and select 2 in pagination
    And Assert that age 2 is selected
    And Assert that results in page 2 is 10
    Then user scroll down to pagination and select 3 in pagination
    And Assert that results in page 3 is 10
    And Assert that age 3 is selected
    Then Assert that second page results equals to third page results
    And close browser
