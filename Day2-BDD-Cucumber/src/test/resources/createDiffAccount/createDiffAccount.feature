@account
Feature: create different accounts for valid users
create accounts like savings, current, rd and fd

Scenario Outline: create different account
	Given Customer details and opening balance
	When for valid customer with minimum opening balance <value>
	Then create new <accounttype> accounts

Examples:
		| accounttype | value    |
		| savings     | 1000     |
		| current     | 10000    |
		| RD          | 100      |
		| FD          | 500      |