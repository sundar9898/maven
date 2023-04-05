#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: errorValidation
  I want to use this template for my feature file


  @tag2
  Scenario Outline: Error page validation
   Given I Landed on Ecommerce page
   Then login with username <name> and password <password>
   Then "Incorrect email or password" error is displayed on Confirmationpage

    Examples: 
      | name                         | password     |
      | arumugamsaravana05@gmail.com | S00tur123    | 
  
