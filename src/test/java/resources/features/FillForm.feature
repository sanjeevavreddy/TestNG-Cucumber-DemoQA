Feature: Fill Form

  @Demo
  Scenario Outline: Fill Form
    Given user launch the url
    Then user enter First and last name as "<FirstName>" and "<LastName>"

    Examples:
      | FirstName | LastName |
      | Sanjeev   | Reddy    |

  @Demo1
  Scenario Outline: Fill Form1
    Given user launch the url
    Then user enter First and last name as "<FirstName>" and "<LastName>"
    When user click on submit button
    Then user should see the success message

    Examples:
      | FirstName | LastName |
      | Sanjeev   | Reddy    |

    Examples:
      | FirstName | LastName |
      | Sanjeev   | Reddy    |
