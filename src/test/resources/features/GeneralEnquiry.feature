Feature: Initiating General Enquiry case


  @Sanity
  Scenario: General Enquiry case initiation

    Given User reaches to login page of NSW
    When  User enter "apoorv.jain+3500@coforge.com" as email id
    When   Enter password as "Rules@123"
    And    Click on Submit
    Then  User able to navigation to the home page
    When  User clicks on Submit a service request or enquiry option
    And   Click on GeneralEnquiry button
    Then  GeneralEnquiry case will initiate
    When  User enters selects No or Yes
    And   Enter all the details
    Then  Confirmation text will display

  @Smoke
  Scenario: General Enquiry Resolution

  Given Internal CSR reaches to login page of NSW
  When  CSR enter "apoorv.jain+730@coforge.com" as email id
  When  Enter password as "Rules@123"
  And   Click on Submit
  Then  CSR able to navigation to the home page of Interaction portal
  When  CSR clicks on My workbaskets
  And   Select Customer Experience dropdown
  Then  CSR able to see SR case
  When  CSR clicks on SR case
  And   Enter all the detail
  And   Click on Finish
  Then  Case will resolve and display confirmation message



#   Scenario Outline: Login with different sets of data
#
#     Given  User reaches to login page of NSW
#     When   User enter "<username>" and "<password>"
#     Then   User able to navigation to the home page
#
#     @Regression
#     Examples:
#
#       | username                     | password  |
#       | apoorv.jain+0@coforge.com    | Rules@123 |
#       | apoorv.jain+00@coforge.com   | Rules@123 |
#       | apoorv.jain+3400@coforge.com | Rules@123 |