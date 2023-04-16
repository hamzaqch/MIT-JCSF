@Smoke
Feature: MainPage
  As a user i should be able to sorted all products by name

  @Smoke
  Scenario: Verify item in Mobile List page can be sorted by `Name`
    Given I navigate to "http://live.techpanda.org/index.php/"
    Then I take screenshot
    Then I should be able to see page title as "This is demo site"
    And I click on element having xpath "//a[contains(text(),'Mobile')]"
    Then I should be able to see page title as "Mobile"
    And I select "Name" option by text from dropdown having xpath "//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/select[1]" 
    Then I should see all products sorted by name
