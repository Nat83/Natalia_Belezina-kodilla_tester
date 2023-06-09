Feature: Display balance

  Scenario: User checks the balance of their wallet
    Given there is $100 in my wallet
    When I check the balance of my wallet
    Then I should see that the balance is $100

  Scenario Outline: User checks the balance of their wallet and get message about account balance
    Given there is $<balance> in my wallet
    When I check the balance of my wallet
    Then I should see that the balance is $<balance>
    And I get message <message>
    Examples:
      | balance | message                                                                                |
      | -1      | "Warning, after reaching $300 debit you will be charged $1000 fee"                     |
      | -300    | "Warning, You have reached $300 debit an your account will be charged with $1000 fee." |
      | -301    | "Warning, You have reached $300 debit an your account will be charged with $1000 fee." |
      | 50000   | "Your balance allows you to upgrade to our premium account? Are you interested?"       |
      | 50001   | "Your balance allows you to upgrade to our premium account? Are you interested?"       |
      | 0       | "Here is your balance. Visit our website www.funnyBank.com if you have any questions." |
      | 49999   | "Here is your balance. Visit our website www.funnyBank.com if you have any questions." |

