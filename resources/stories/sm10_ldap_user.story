Scenario: Login to LDAP system
Given I am at LDAP Login page
When I want to login LDAP page
Then I should see LDAP page

Scenario: SM10.1 Create User
Given I am at create user page
When I want to create user
Then I should see user created sucessfully