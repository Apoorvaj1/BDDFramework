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