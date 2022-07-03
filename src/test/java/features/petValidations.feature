Feature: Validating PetStore API's
  Scenario: Verify if a pet is being successfully added using addPetAPI
    Given Add pet payload
    When User calls "addPetAPI" with post https request
    Then The api call gets success with status code 200
    Then Verify in response body "id" area is not null
