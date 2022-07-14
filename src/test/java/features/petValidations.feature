Feature: Validating PetStore API's

  Scenario Outline: Verify if Add Pet functionality is working
    Given Prepare addPetAPI payload with <id> "<categoryName>" "<name>"
    When User calls "addPetAPI" with "POST" https request
    Then The api call gets success with status code 200
    Then Verify in response body "id" area is not null
    Then Verify in response body "status" area is "Added"
    Then Verify "<name>" is proper using "getPetAPI"


    Examples:
      | id        | categoryName | name                       |
      | 190300020 | Kuş          | Kuş Name From Feature File |
    #  | 190300011 | Kuş          | Pet Name |

  @UpdatePet
  Scenario Outline: Verify if Update Pet functionality is working
    Given Prepare updatePetAPI payload with "<name>"
    When User calls "updatePetAPI" with "PUT" https request
    Then The api call gets success with status code 200
    Then Verify in response body "id" area is not null
    Then Verify in response body "status" area is "Updated"
    And Verify "<name>" is proper using "getPetAPI"

    Examples:
      | name                                          |
      | Kara Kartal Name is Updated From Feature File |

  @DeletePet
  Scenario: Verify if Delete Pet functionality is working
    Given Prepare deletePetAPI payload
    When User calls "deletePetAPI" with "DELETE" https request
    Then The api call gets success with status code 200
    Then Verify in response body "code" area is 200
    And User calls "getPetAPI" with "GET" https request
    Then Verify in response body "message" area is "Pet not found"
    Then The api call gets success with status code 404

