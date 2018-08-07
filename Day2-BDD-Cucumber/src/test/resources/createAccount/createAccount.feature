@account
Feature: Create new account
create new account for the valid customer details 
	Scenario: For valid customer create new account
	Given customer details
	When valid customer
	And valid opening balance
	Then create new account
Scenario: For Invalid Customer
For invalid customer details throw error message
	Given Customer details
	When Invalid customer
	Then throw 'Invalid Customer' error message

Scenario: For invalid opening balance
	Given customer details and opening balance
	When invalid opening balance
	Then throw 'Insufficient Balance' error message 

Scenario: create a new saving account with minimun balance
	Given customer details and opening balance
	When valid customer
	And valid opening balance
	Then 