Feature: assert equilateral triangle
Scenario: Calculation by the param of the three side of the triangle
Given I open Triangle Calculate
When I clear all param
And I set value "2" for "A"
And I set value "3" for "B"
And I set value "10" for "C"
And I click button "Calculate"
Then The calculated result is "The sum of two sides must be larger than the third."