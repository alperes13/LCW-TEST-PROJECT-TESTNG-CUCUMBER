Feature: Shop Page - Product counts of filters in the header

  Background:
    Given Navigate to homepage

  Scenario Outline: Total of products count in filters in shop page header must be same with total product count.
    When Search a "<product>"
    Then Validate products count with total products counts of filters in header

    Examples:
      | product |
      | spor    |