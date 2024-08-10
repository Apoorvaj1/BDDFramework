Feature: Adding property ID in owned or leased properties section

  Scenario Outline: Add property ID in owned properties section

    Given User reaches to login page of NSW
    When  User enter "<username>" and "<password>"
    Then  User able to navigation to the home page
    When  User clicks on My properties from left navigation pane
    Then  User able to see Owned properties section
    When  User click on Add property button
    Then  Case will initiate
    When  User enters the details from given sheetname "<SheetName>" and rownumber <RowNumber>
    And   Click on Submit_GeneralEnquiry
    Then  User able to see confirmation message

  Examples:
    | username                     | password | SheetName | RowNumber |
    | apoorv.jain+3500@coforge.com |Rules@123 |sheet1     |0          |