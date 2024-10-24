@regression
Feature: Swag Labs website log out testing
Description: Must be a Logged in user.

  Scenario Outline: As a logged user, I want to log out  from the Swag Labs Website for security purpose.
Given Open the Browser
And pass the website url  "<URL>"
When Enter the username "<username>"
And Enter the password "<password>"
And Click on Login Button
And Click on Open menu side bar
And Click on Logout Button
Then Validate the Logout  is successful
Given Quit the Browser
Examples:
|URL 																																													|username				 	| password						|
|https://www.saucedemo.com/v1/index.html									|standard_user		|secret_sauce				|
|https://www.saucedemo.com/v1/index.html									|problem_user		|secret_sauce				|