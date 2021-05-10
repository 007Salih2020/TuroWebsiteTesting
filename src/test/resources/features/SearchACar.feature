Feature: Verifying the Search

  Scenario Outline: User fill out the search option
    Given user is on landing page to search
    Then User enter "<location>" in Where text box
    Then User select "<dateFrom>" and "<dateUntil>" under From
    Then User select "<timeFrom>" and "<timeUntil>" under Until
    Then User clicks Search button



    Examples:
      | location        | dateFrom | dateUntil | timeFrom | timeUntil |
      | Los Angeles, CA | 23       | 25        | 1000AM   | 1000AM    |
