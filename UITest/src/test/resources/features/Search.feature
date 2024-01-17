@search_feature
Feature: Search Feature

  Scenario: Check all title
    Given Navigate to the home page
    And Click cookies accept button on home page
    And Fetch "batman" search response from api
    And Check search titles with api result