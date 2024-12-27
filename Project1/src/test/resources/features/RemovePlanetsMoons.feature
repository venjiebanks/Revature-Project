Feature: Remove Planets and Moons
  As a user I want to remove planets and moons from the Planetarium so I can correct my findings

  Scenario: Positive - Remove a Planet
    Given the user is logged in on the home page
    When the user clicks and selects Planet
    And the user provides valid planet name to be deleted
    Then the user should see the updated table

  Scenario: Positive - Remove a Moon
    Given the user is logged in on the home page
    When the user clicks and selects Moon
    And the user provides valid moon name to be deleted
    Then the user should see the updated table


  Scenario Outline: Negative - Remove a Planet
    Given the user is logged in on the home page
    When the user clicks and selects Planet
    And the user provides invalid "<planet name>" to be deleted
    Then the user should get a planetarium alert saying "<alert>"

    Examples:

      | planet name                                        | alert               |
      | Super_long_planet_name_that_exceeds_limit          | Invalid planet name |
      | Krypton                                            | Invalid planet name |



  Scenario Outline: Negative - Remove a Moon
    Given the user is logged in on the home page
    When the user clicks and selects Moon
    And the user provides invalid "<moon name>" to be deleted
    Then the user should get a planetarium alert saying "<alert>"

    Examples:

      | moon name                                        | alert               |
      | Super_long_moon_name_that_exceeds_limit          | Invalid moon name   |
      | Lina                                             | Invalid moon name   |