
Feature: Smoke
  I want to use this template for my feature file

  Scenario: Verify item in Mobile List page can be sorted by `Name`
    Given User navigate to URL
    Then Page title should be "This is demo site"
    And Click on `MOBILE` menu
    Then Page title should be "Mobile"
    And User selects `SORT BY` dropdown as "Name"
    Then All products should be sorted by name
