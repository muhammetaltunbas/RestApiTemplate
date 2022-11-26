Feature: Validating Order Pet API's

  @addPet
  Scenario Outline: Verify creating order for a pet functionality is working
    Given Prepare createOrder payload with <id> <petId> <quantity>
    When User runs "createOrderApi" with "POST" https request
    Then Verify if status code is equal 200
    Then Verify "id" area is not null in response
    Then Verify "petId" area is not null in response

    Examples:
      | id       | petId | quantity |
      | 12991923 | 1903  | 3        |






