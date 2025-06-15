Feature: Fill Form

  @Demo
  Scenario Outline: Fill Form
    Given user launch the url
    Then user enter UserName and Password as "<User>" and "<Password>"

    Examples:
      | User | Password |
      | Sanjeev   | Reddy    |

  @Demo1
  Scenario Outline: Fill Form1
    Given user launch the url
    Then user enter UserName and Password as "<User>" and "<Password>"

    Examples:
      | User | Password |
      | Sanjeev   | Reddy    |
