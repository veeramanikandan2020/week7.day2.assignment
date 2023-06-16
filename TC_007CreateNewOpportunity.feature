Feature: Create New Opportunity in salesforce.com


Scenario Outline: Steps to create new opportunity

Given Login to salesforce.com 
Then Click on toggle menu button from the left corner
And Click view All and click Sales from App Launcher
And Click on Opportunities tab
And Click on New button
Given Enter Opportunity name as Salesforce Automation by Your Name
Then Choose close date as Today
When Select Stage as Needs Analysis
Then click Save and Verify Opportunity Name
