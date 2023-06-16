Feature: Create Account in salesforce.com

Scenario Outline: Steps to Create Account

Given Login salesforce app 
Then Click toggle menu button
And Click view All click Sales App Launcher
And Click on Accounts tab
And ClickNewbutton
Given Enter your Name as account name
Then Select Ownership as Public
When ClickSave
Then Verify the Account Name