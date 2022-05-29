Feature: Football field reservation operations
  Checking operations regarding reservation of the football field

  Scenario: Successfully reserve when football field is free
    Given the field is free from 12 to 14
    When "Agustin" tries to reserve from 12 to 14
    Then reservation is made from 12 to 14 by "Agustin"

  Scenario: Cannot reserve when football field is not free
    Given the field is reserved from 12 to 14 by "Carlos"
    When "Agustin" tries to reserve from 12 to 14
    Then reservation is denied due to occupied field
    And period from 12 to 14 should remain reserved by "Carlos"

  Scenario: Cannot reserve when the football field is closed
    Given the field is open from 7 to 20
    When trying to reserve from 4 to 6
    Then reservation is denied due to closed field

  Scenario: Cannot reserve for more than 3 hours
    Given the field is free from 12 to 16
    When trying to reserve from 12 to 16
    Then reservation is denied due to excess of reservation time