Feature: Hello web page
  As a user I want to make sure I can't login with an empty username

  Scenario: Login fails with empty name
    Given I am on the userlogin page
    When I enter ""
    Then I see an error message
