package resources;

//Enum is special class in java which has collection of constants or  methods
public enum ApiResources {

    addPetAPI("v2/pet"),
    getPetAPI("v2/pet/{id}");
    private String resources;

    ApiResources(String resources)
    { // Constructor
        this.resources = resources;
    }

    public String getResources() {
        return resources;
    }


}
