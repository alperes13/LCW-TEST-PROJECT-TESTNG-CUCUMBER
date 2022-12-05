Feature: Shop Page - Listed Products Quantity

  Background:
    Given Navigate to homepage

  Scenario Outline: Product count must be same by information count
    When Search a "<product>"
    Then Validate listed product count with listed product count information.

    Examples:
      | product |
      | blazer  |
