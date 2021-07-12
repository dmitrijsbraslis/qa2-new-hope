Feature: Testing weather endpoint

  Scenario: checking weather for city by ID
    Given city ID: 524901

    When we are requesting weather data

    Then coordinates are:
      | lon | 145.77 |
      | lat | -16.92 |

    And sys is:
      | type    | 1          |
      | id      | 8166       |
      | message | 0.2064     |
      | country | AU         |
      | sunrise | 1485720272 |
      | sunset  | 1485766550 |

    And weathers are:
      | id          | main             | description      | icon |
      | 802         | Clouds           | scattered clouds | 03n  |
#      | 803 | Sunny  | blablka          | 05k  |


#      | id          | 802              |
#      | main        | Clouds           |
#      | description | scattered clouds |
#      | icon        | 03n              |
#
#      | id          | 803              |
#      | main        | Sunny            |
#      | description | blablka          |
#      | icon        | 05k              |

#    Then lon is 145.77
#    And lat is -16.92
#    And base is "stations"
#    ...