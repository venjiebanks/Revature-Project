Feature: Account Creation
  As a new user I want to open an account with the Planetarium so I can save my celestial findings

  Scenario Outline: User account creation with different inputs
    Given the user is on the login page
    When the user clicks the register link
    And the user provides registration username "<username>" and password "<password>"
    And the user submits the registration credentials
    Then the user should get a browser alert saying "<alert>"
    And the user should <redirection>

    Examples:
      | username                        | password                        | alert                           | redirection                         |
      | Super_man-2001                  | Krypton-was_2000                | Account created successfully    | be redirected to the login page     |
      | Batman                          | Krypton-was_2000                | Invalid username                | stay on the registration page       |
      | Bane                            | Krypton-was_2000                | Invalid username                | stay on the registration page       |
      | wonder_woman_for_the_DC_theming | Krypton-was_2000                | Invalid username                | stay on the registration page       |
      | 2face                           | Krypton-was_2000                | Invalid username                | stay on the registration page       |
      | joker!!!!!!?)                   | Krypton-was_2000                | Invalid username                | stay on the registration page       |
      | Super_man-2001                  | b0Ts                            | Invalid password                | stay on the registration page       |
      | Super_man-2001                  | AlfredIsTheBestButlerToExist111 | Invalid password                | stay on the registration page       |
      | Super_man-2001                  | 3atman                          | Invalid password                | stay on the registration page       |
      | Super_man-2001                  | A1fredIsTheBestButlerToExist!!  | Invalid password                | stay on the registration page       |
      | Super_man-2001                  | batman1                         | Invalid password                | stay on the registration page       |
      | Super_man-2001                  | BATMAN1                         | Invalid password                | stay on the registration page       |
      | Super_man-2001                  | Robin                           | Invalid password                | stay on the registration page       |