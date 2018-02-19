Scenario: Login to BSL system
Given I am at BSL Login page
When I want to login with default and default
Then I should see BSL home page

Scenario: SM6.1 Create incoming payment
Given I am at create incoming payment page
When I want to create incoming payment
Then I should see incoming payment created sucessfully

Scenario: SM6.2 Decouple incoming payment
Given I am at search incoming payment page
When I want to decouple incoming payment
Then I should see incoming payment decoupled sucessfully

Scenario: SM6.3 Import incoming payment
Given I am at import incoming payment page
When I want to import incoming payment
Then I should see incoming payment imported sucessfully

Scenario: SM6.4 Create outgoing payment
Given I am at create outgoing payment page
When I want to create outgoing payment
Then I should see outgoing payment created sucessfully