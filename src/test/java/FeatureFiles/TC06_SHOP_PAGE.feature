Feature: Shop Page - Search function

  Background:
    Given Navigate to homepage

  Scenario Outline: Searched or categorized product name should be in url and inside of product names.
    When Search a "<product>"
    Then Validate page header according to products and url

    Examples:
      | product |
      | jean    |

  Scenario Outline: Searched or categorized product name should be in url and inside of product names.
    When Mouseover on "<category>" and click on "<product>"
    Then Validate page header according to products and url

    Examples:
      | category | product      |
      | Aksesuar | Plaj Havlusu |
