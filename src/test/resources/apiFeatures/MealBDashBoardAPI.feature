Feature:
  @hong
  Scenario: Verification of GetExpense API
    Given User submits GET request to GetExpense API
    Then User get the total amount of all otherExpenses and validate against the value from Dashboard API
    And User gets the total amount of all travelExpenses and validate against the value from Dashboard API
    And User gets the total amount of all giftExpenses  and validate against the value from Dashboard API

