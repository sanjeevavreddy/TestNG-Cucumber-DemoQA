Feature: Fill Form

  @Demo
  Scenario Outline: Fill Form
    Given user launch the url
    Then user enter First and last name as "<FirstName>" and "<LastName>"

    Examples:
      | FirstName | LastName |
      | Sanjeeva  | Reddy    |

  @Demo1
  Scenario Outline: Fill Form1
    Given user launch the url
    Then user enter First and last name as "<FirstName>" and "<LastName>"

    Examples:
      | FirstName | LastName |
      | Sanjeeva  | Reddy    |