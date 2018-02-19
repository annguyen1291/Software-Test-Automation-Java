Narrative:
In order to do smoke test of [SM-3. BLS Contract Creation] module  <br> 
As a user <br> 
I want to verify basic function such as: <br> 
1. Create a TW contract <br>
2. Sign and register TW contract <br>

Scenario: Login to BSL system
Given I am at BSL Login page
When I want to login with default and default
Then I should see BSL home page

Scenario: SM3b.1 Create new TW contract
Given I am at create TW contract page
When I want to create new contract
Then I should see new contract created sucessfully

Scenario: SM3b.2 Sign and register TW contract
Given I have approved contract automatically or manually
When I want to sign and register contract
Then I should see contract registered sucessfully