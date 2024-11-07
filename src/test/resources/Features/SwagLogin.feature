@functional
Feature: Swaglabs Login Testing
Description: User  should already have an account in Parabank
#Background:
@smoke @regression
Scenario Outline: As a user, I want to log in to the Parabank Website with valid credentials so that I can Use the bank website.
Given Open the Browser
And pass the website url  "<URL>"
When Enter the username "<username>"
And Enter the password "<password>"
And Click on Login Button
Then Validate the Login is successful
Given Quit the Browser
Examples:
|URL 																																					|username 					| password						|
|https://www.saucedemo.com/v1/index.html	|standard_user		|secret_sauce				|
|https://www.saucedemo.com/v1/index.html	|problem_user		|secret_sauce				|

@smoke @regression
Scenario Outline: As a user, I want to log in to the Parabank Website with username but no password so that it denies to log in.
Given Open the Browser
And pass the website url  "<URL>"
When Enter the username "<username>"
And Click on Login Button
Then Validate the Login is failed
Given Quit the Browser
Examples:
|URL 																																						|username 							|
|https://www.saucedemo.com/v1/index.html		|standard_user				|

@smoke @regression
Scenario Outline: As a user, I want to log in to the Parabank Website without the username but with the password.
Given Open the Browser
And pass the website url  "<URL>"
When Enter the password "<password>"
And Click on Login Button
Then Validate the Login is failed
Given Quit the Browser
Examples:
|URL 																																					| password					|
|https://www.saucedemo.com/v1/index.html	|	secret_sauce		|

@smoke @regression
Scenario Outline: As a user, I want to log in to the Parabank Website without the username and password so that it denies to log in.
Given Open the Browser
And pass the website url  "<URL>"
When Click on Login Button
Then Validate the Login is failed
Given Quit the Browser
Examples:
|URL 																																			| 
|https://www.saucedemo.com/v1/index.html	|