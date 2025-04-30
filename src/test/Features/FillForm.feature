Feature: Fill Form
  Scenario Outline: Fill Form
    Given user launch the url
    Then user enter First and last name as "<FirstName>" and "<LastName>"

    Examples:
    |FirstName|LastName|
    |Sanjeeva |Reddy   |