Feature: Initiating General Enquiry case


  @Sanity
  Scenario: General Enquiry case initiation

    Given User reaches to login page of NSW
    When  User enter "apoorv.jain+3500@coforge.com" as email id
    When   Enter password as "Rules@123"
    And    Click on Submit
    Then  User able to navigation to the home page


   Scenario Outline: Login with different sets of data

     Given  User reaches to login page of NSW
     When   User enter "<username>" and "<password>"
     Then   User able to navigation to the home page

     @Regression
     Examples:

       | username                     | password  |
       | apoorv.jain+0@coforge.com    | Rules@123 |
       | apoorv.jain+00@coforge.com   | Rules@123 |
       | apoorv.jain+3400@coforge.com | Rules@123 |