
@tag
Feature: Purchase order from ecommerce website
  I want to use this template for my feature file

Background:
  Given I Landed on Ecommerce page

  @Regression
  Scenario Outline: Positive test for submitting the order
    Given login with username <name> and password <password>
    When I add product <Productname> to cart
    And Checkout <Productname> and submit order
    Then "THANKYOU FOR THE ORDER." message is displayed on Confirmationpage

    Examples: 
      | name                         | password     | Productname  |
      | arumugamsaravana05@gmail.com | S@ttur123    | ZARA COAT 3      |
  
