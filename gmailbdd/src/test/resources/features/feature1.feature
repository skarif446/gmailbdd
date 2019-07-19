Feature: Gmail home page title
@smoketest
Scenario: validate gmail home page title
Given launch gmail site
Then title is "Gmail" for home page
And close gmail site

Scenario: Validate userid visibility
Given launch gmail site
Then Userid field is displayed
And close site

