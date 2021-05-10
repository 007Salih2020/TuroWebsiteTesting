Feature: Select the first Car

  Scenario: User selecting the first car after filtered
    Given user is on landing page to select
    And User selects the first car in the list and verify the selected car title is present
    Then User selects Pickup location
    And User clicks on Continue button
