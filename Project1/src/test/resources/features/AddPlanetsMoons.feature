Feature: Add Planets and Moons
  As a user, I want to add new planets and moons to the Planetarium so I can update my findings.

  Scenario: Positive - Add Planet
    Given the user is logged in on the home page
    When the user clicks and selects Planet
    And the user provides valid planet data
    Then the user should see the updated table with the new Planet

  Scenario: Positive - Add Moon
    Given the user is logged in on the home page
    When the user clicks and selects Moon
    And the user provides valid moon data
    Then the user should see the updated table with the new Moon

  Scenario Outline: Negative - Invalid Planet Data
    Given the user is logged in on the home page
    When the user clicks and selects Planet
    And the user provides an invalid planet name "<planet name>" or file type "<file type>"
    Then the user should get a planetarium alert saying "<alert>"
    And the user should stay on the home page
    Examples:
      | planet name                                        | file type    | alert               |
      | Super_long_planet_name_that_exceeds_limit          |              | Invalid planet name |
      | Krypton                                            | .txt         | Invalid file type   |

  Scenario Outline: Negative - Invalid Moon Data
    Given the user is logged in on the home page
    When the user clicks and selects Moon
    And the user provides an invalid moon name "<moon name>" or owning planet "<planet id>"
    Then the user should get a planetarium alert saying "<alert>"
    And the user should stay on the home page
    Examples:
      | moon name                                | planet id    | alert                          |
      | Super_long_moon_name_that_exceeds_limit  | 1            | Invalid moon name              |
      | Zodiac                                   | 99           | Invalid planet id              |