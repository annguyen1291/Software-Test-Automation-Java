Narrative:
In order to do smoke test of [SM-1. BLS Product] module  <br> 
As a user <br> 
I want to verify basic functions as following: <br> 
1. Create a new product with type CD and TW from existing products <br>
2. Activate CD and TW product <br>
3. Create new version the product CD and TW <br>
4. Assign product CD and TW to Salesroom

Scenario: Login to BSL system

Given I am at BSL Login page
When I want to login with default and default
Then I should see BSL home page

Scenario: SM1a.1 Create new product from existing CD product
Given I am at Manage Product page
Given Go to Search for a CD product code: default
When I want to create new product CD from existing one
Then I should see new product CD created sucessfully

Scenario: SM1a.2 Activate a product CD

When I want to activate the product that I just made a copy
Then I should see the product is activate

Scenario: SM1a.3 Create new version and activate of product CD

When I want to create new version for the product that I just made a copy
Then I should see the product version increase to number 2

When I want to activate the product that I just made a copy
Then I should see the product is activate

Scenario: SM1b.1 Create new product from existing TW product
Given I am at BSL Homepage
Given I am at Manage Product page

Given Go to Search for a TW product code: default
When I want to create new product TW from existing one
Then I should see new product TW created sucessfully

Scenario: SM1b.2 Activate a product TW

When I want to activate the product that I just made a copy
Then I should see the product is activate

Scenario: SM1b.3 Create new version and activate of product TW

When I want to create new version for the product that I just made a copy
Then I should see the product version increase to number 2

When I want to activate the product that I just made a copy
Then I should see the product is activate

Scenario: SM1a.4 Assign Product CD to Salesroom
Given I am at BSL Homepage
Given I am at Find salesroom page
Given I search for salesroom code default
Given I go to Assign Product to Sale Room page

When I want to add product CD to salesroom
Then I should see product CD added to salesroom successfully

Scenario: SM1b.4 Assign Product TW to Salesroom
Given I am at BSL Homepage
Given I am at Find salesroom page
Given I search for salesroom code default
Given I go to Assign Product to Sale Room page

When I want to add product TW to salesroom
Then I should see product TW added to salesroom successfully