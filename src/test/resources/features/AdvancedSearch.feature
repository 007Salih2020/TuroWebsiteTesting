Feature: Making more filters in the advance search page

  Scenario Outline: User fill out more filters option in the advance search page
    Given User is on landing page to advanced search
    And User clicks on More filters menu and select All-Star Host
    And select CAR Vehicle types and select "<Vehicle_makes>" then clicks on upper arrow
    And User adjust the Vehicle years range
    Then User select the Transmission clicks on view results

    And User clicks on Sort By menu and select an option then clicks on apply
    And User clicks on Price menu and adjust the price range then clicks on view results
    And User clicks on Book instantly menu and clicks on view results
    And User clicks on Delivery menu and adjust the distance range then clicks on view results
    And User clicks on Distance included menu and select the distance then clicks on  apply button
    Examples:
      | Vehicle_makes |
      | Toyota        |
