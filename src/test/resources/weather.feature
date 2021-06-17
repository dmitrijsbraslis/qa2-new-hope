Feature: Testing weather endpoint

  Scenario: checking weather for city by ID
    Given city ID: 524901

    When we are requesting weather data

    Then coordinates are:
      | lon | 145.77 |
      | lat | -16.92 |

#    Then lon is 145.77
#    And lat is -16.92
    And base is "stations"
#    ...