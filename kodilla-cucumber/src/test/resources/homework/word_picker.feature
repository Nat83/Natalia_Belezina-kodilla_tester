Feature:  Word picker. Which word do you pick?

  Scenario Outline: The word <word> is displayed when choosing number <number>

    Given I choose number <number>
    When  Chosen number is divisible by <divider>
    Then  Program should display word <word>
    Examples:
      | number | divider | word   |
      | -3     | 3       | "Fizz" |
      | 9      | 3       | "Fizz" |
      | -5     | 5       | "Buzz" |
      | 21     | 3       | "Fizz" |
      | 10     | 5       | "Buzz" |
      | 20     | 5       | "Buzz" |

  Scenario Outline: The word "FizzBuzz" is displayed when chosen number divisible by 3 and 5

    Given I choose number <number>
    When  Chosen number is divisible by 3 and 5
    Then  Program should display word "FizzBuzz"
    Examples:
      | number |
      | -15    |
      | 0      |
      | 15     |
      | 30     |
      | -45    |
      | 600    |

  Scenario Outline: The word "None" is displayed when chosen number in not divisible by 3 or 5 or both those numbers

    Given I choose number <number>
    When  Chosen number is not divisible by 3 or 5 or both those numbers
    Then  Program should display word "None"
    Examples:
      | number |
      | -17    |
      | 22     |
      | 31     |
      | -42    |
      | 601    |

