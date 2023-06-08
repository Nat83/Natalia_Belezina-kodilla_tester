Feature: Cash Withdrawal

  Scenario: Successful withdrawal from a wallet in credit
    Given I have deposited $200 in my wallet
    When I request $30
    Then $30 should be dispensed
    And Cashier will reply "Here you are. Thank you for using our bank"

  Scenario: Successful withdrawal of all funds from a wallet in credit
    Given I have deposited $200 in my wallet
    When I request $200
    Then $200 should be dispensed
    And Cashier will reply "Here are all your funds. Thank you for using our bank"

  Scenario Outline: Unsuccessful withdrawal of funds from a wallet if requested amount exceed the available funds
    Given I have deposited $200 in my wallet
    When I request $<amount>
    Then Cashier will reply "Sorry, you have insufficient funds in your wallet."
    Examples:
      | amount |
      | 201    |
      | 2000   |

  Scenario Outline: Unsuccessful withdrawal of funds from a wallet if requested amount has incorrect format
    Given I have deposited $200 in my wallet
    When I request amount in decimal format $<amount>
    Then Cashier will reply "Sorry, you can only withdraw round amount without cents"
    Examples:
      | amount |
      | 10.5   |
      | 150,45 |
      | 30.67  |
      | 30.50  |