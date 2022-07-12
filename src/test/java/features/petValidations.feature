Feature: Validating PetStore API's

  Scenario Outline: Verify if a pet is being successfully added using addPetAPI
    Given Prepare addPet payload with <id> "<categoryName>" "<name>"
    When User calls "addPetAPI" with "POST" https request
    Then The api call gets success with status code 200
    Then Verify in response body "id" area is not null
    Then Verify "<name>" is proper using "getPetAPI"


    Examples:
      | id        | categoryName | name    |
      | 190300006 | Kuş          | Kara Kartal Test |


