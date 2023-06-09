Feature: Prevent users from taking out more money than their wallet contains

  Scenario: User tries to take out more money than their balance

    Given there is $100 in my wallet
    When I withdraw $200
    Then nothing should be dispensed
    And I should be told that I don't have enough money in my wallet

  Scenario Outline: User tries to take out when there is a debit on wallet because of administration fees
    Given there is $<balance> in my wallet
    When I withdraw $<amount>
    Then nothing should be dispensed
    And I should be told that money can not be withdrawn and there is a debit on the account
    Examples:
      | balance | amount |
      | -100    | 200    |
      | -1      | 2      |
