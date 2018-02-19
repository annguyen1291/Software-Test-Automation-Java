Narrative:
In order to do smoke test of [SM-8b. BLS Partner] module  <br> 
As a user <br> 
I want to verify basic functions as following: <br> 
1. Search for existing Partner and click to view detail Partner page <br>
2. Click every tab Notices, Contact, Contact person,... to check info <br>

Scenario: Login to BSL system

Given I am at BSL Login page
When I want to login with default and default
Then I should see BSL home page

Scenario: SM8b.1 Search for existing Partner and click to view detail Partner page
Given I am at Search Partner page

When I want to search for Partner having code: default
Then I should see Partner detail page display accordingly

Scenario: SM8b.2 Click every tab to check row data info

When I click on tab Contact Information
Then I should see row data of Contact Information display accordingly

When I click on tab Contact Person
Then I should see row data of Contact Person display accordingly

When I click on tab Bank Accounts
Then I should see row data of Bank Accounts display accordingly

When I click on tab Addresses
Then I should see row data of Addresses display accordingly

When I click on tab Salesrooms
Then I should see row data of Salesrooms display accordingly

When I click on tab Extended Properties
Then I should see row data of Extended Properties display accordingly
