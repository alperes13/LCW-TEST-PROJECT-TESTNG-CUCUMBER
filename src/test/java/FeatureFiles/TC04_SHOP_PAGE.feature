Feature: Shop Page - Sorting Function

  Background:
    Given Navigate to homepage

  Scenario Outline: Sorting function in the shop page must be work correctly.
    When Search a "<product>"
    And Sort products price for a "<variation>"
    Then Validate products prices sorted for "<variation>"

    Examples:
      | product | variation |
      | bere    | highest   |
      | bere    | lowest    |
