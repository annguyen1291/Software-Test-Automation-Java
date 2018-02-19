Narrative:
In order to do smoke test of [SM-2. BLS Bank Management] module  <br> 
As a user <br> 
I want to verify basic function such as: <br> 
1. Create a new bank <br>
2. Create a new branch <br>
3. Create a new version of an existing product <br>


Scenario: Login to BSL system
Given I am at BSL Login page
When I want to login with homerselect and homerselect
Then I should see BSL home page

Scenario: SM2.1 Create new bank
Given I am at create bank page
When I want to create new bank
Then I should see new bank created sucessfully

Scenario: SM2.2 Create new branch
Given I am at create branch page
When I want to create new branch
Then I should see new branch created sucessfully

Scenario: SM2.3 Update existing bank
Given I am at update bank page
When I want to update existing bank
Then I should see existing bank updated sucessfully

Scenario: SM2.4 Update existing branch
Given I am at update branch page
When I want to update existing branch
Then I should see existing branch updated sucessfully