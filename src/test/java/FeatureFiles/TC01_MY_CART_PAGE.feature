Feature: My Cart Page - Basic Selenium Project

  Background:
    Given Navigate to homepage

  Scenario Outline: A user should be able to add a product to cart
    When Mouseover on "<category>" and click on "<products>"
    Then Validate page header according to products and url
    And Click on any product
    And Click on any variation if it is exist and add item to cart
    Then Ensure the cart badge been "<value>"
    Given Navigate to "<section>"
    Then Validate your cart has "<value>" product or products
    And Navigate to homepage


    Examples:
      | category | products     | value | section |
      | Aksesuar | Plaj Havlusu | 1     | My Cart |
