Feature:Create Opportunity in salesforce.com

Scenario Outline: Steps to create opportunity

Given Login salesforce.com 
Then Click toggle menu button from the left corner
And Click view All click Sales from App Launcher
And Click Opportunities tab
And Click New button
And Enter opportunity name get text
Then Choose close date as Tomorrow Date
When Click on save
Then Verify the Alert message