Feature:  Is it Summer? Everybody likes Summer

#  Scenario: Winter isn't Summer
#
#    Given today is last day of December
#    When  I ask whether it's Summer
#    Then  I should be told "Nope"
#
#  Scenario: Summer is Summer
#
#    Given today is first day of August
#    When  I ask whether it's Summer
#    Then  I should be told "Yes! Summer!"

  Scenario Outline: Today is or isn't summer

    Given today is <day>
    When  I ask whether it's Summer
    Then  I should be told <answer>
    Examples:
      | day | answer |
      | last day of December | "Nope" |
      | first day of August | "Yes! Summer!" |
      | 10th day of February | "Nope" |
      | 20th day of June | "Nope"|