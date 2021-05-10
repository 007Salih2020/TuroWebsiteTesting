Feature:Verifying the Main Page

  Scenario: Homepage verification
    Given user is in landing page
    Then Verify that Turo logo is present
    Then Verify that "Log in" is present
    And Verify that "Sign up" is present
    Then Verify that Liberty mutual insurance logo is present
