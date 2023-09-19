Feature: Verify user is able to add requirements in the application

  Scenario: Verify user is able to enter requirement fields
    Given user is on the Add Requirement section
    When user enters Title
    And enters Search for Client
    And selects options from Employment Type dropdown
    And selects an option from Workplace dropdown
    And adds job description
    And selects a value from the Open Positions dropdown
    And adds Conract Duration
    And Status is Open by default and disabled
    And adds skills required
    Then user is able to enter the values for these fields
    
    #Scenario: Verify user fills the address fields in the Address wizard page
    Given user partially enters a valid address in the Search for Address field
    And search field displays auto suggesstion of matching address
    And user selects a matching address
    And all address fields are filled automatically
    When user clicks on the Create Requirement button
    Then new requirement is created
    And Requirement saved messages is displayed
    
    #Scenario: Verify new record of requirement is created in DB table
    Given user created a new requirement sucessfully
    When user connects to the DB table
    And executes the select statement
    Then new record should be available in the DB table 
