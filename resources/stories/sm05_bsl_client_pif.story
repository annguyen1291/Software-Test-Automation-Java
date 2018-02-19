Narrative:
In order to do smoke test of [SM-5. BLS Client Profile] module  <br> 
As a user <br> 
I want to verify basic functions as following: <br> 
1. Search for Client detail based on Contract and CUID <br>
2. Single sign on to PIF via link Manage Client <br>
3. Update client info at PIF and check info updated at BSL <br>

Scenario: Login to BSL system

Given I am at BSL Login page
When I want to login with default and default
Then I should see BSL home page

Scenario: SM5.1 Search for Client detail based on Contract and CUID 
Given I am at Search Client page

When I want to search for Client having CUID number: default
Then I should see client detail page display accordingly

Scenario: SM5.2 Single sign on to PIF via link Manage Client

When I click on button Manage Client
Then I should see PIF page open with same client info at BSL

Scenario: SM5.3a Update basic client info at PIF 

When I want to update client basic info at PIF
Then I should see basic info updated accordingly at BIF

Scenario: SM5.3b Cross check basic client info updated accordingly at BSL
Given Now swicth back to BSL system
And I am at Search Client page

When I want to search for Client having CUID number: default
Then I should see client basic info updated at BSL same as BIF