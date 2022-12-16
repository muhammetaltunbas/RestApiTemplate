Feature: Validating Order Pet API's

  Scenario Outline: Verify creating order for a pet functionality is working
    Given Prepare createOrder payload with <id> <petId> <quantity>
    When User runs "createOrderApi" with "POST" https request
    Then Verify if status code is equal 200
    Then Verify in response body "id" area is not null for order
    Then Verify in response body "petId" area is not null for order
    And Verify in response body "status" area is "placed" for order

    Examples:
      | id       | petId | quantity |
      | 12991923 | 1903  | 5        |
      | 10711071 | 1453  | 1        |






