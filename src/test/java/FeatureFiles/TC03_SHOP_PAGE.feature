Feature: Shop Page - Product counts in filter

  Background:
    Given Navigate to homepage

  Scenario Outline: Product count in filter must be same with filtered products count by that filter.
    When Search a "<product>"
    And Filter products for a "<variation>"
    Then Validate filtered product count by products count in that variation
    Examples:
      | variation | product |
      | XL        | jogger  |


