Feature: Account Login
  As a user, I want to securely access my account so I can interact with the Planetarium in a secure environment.

  Scenario Outline: Secure login with valid credentials
    Given the user is on the login page
    When the user provides login username "<username>" and password "<password>"
    And the user submits the login credentials
    Then if the credentials are valid, the user should be redirected to the home page


    Examples:
      | username  | password           |
      | Batman    | Iamthenight1939    |


  Scenario Outline: Secure login with invalid credentials
    Given the user is on the login page
    When the user provides login username "<username>" and password "<password>"
    And the user submits the login credentials
    Then if the credentials are invalid, the user should get a browser alert saying "Invalid credentials"
    And the user should stay on the login page

    Examples:
      | username  | password           |
      | Robin     | b0Ts               |
      | Batman    | b0Ts               |