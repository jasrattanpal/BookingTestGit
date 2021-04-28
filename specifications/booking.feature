Feature: Booking

  Scenario: The booking homepage
    Given The menu is expandale on the booking homepage
    Then Click Accept Button

  Scenario Outline: Sign in page invalid test
    Then Check the logo
    Then sign in page
    Then invalid email address "<email>"
    Examples:
    |email|
    |jas |
    |dan@|
    |11111|

  Scenario Outline: Sign in page valid test
    Then valid email address "<email2>"
    Then valid password "<password>"
    Examples:
    |email2|password|
    |jas@mailinator.com|Rattanpal01|










