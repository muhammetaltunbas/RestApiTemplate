package PetStoreAPIObjects;

import java.util.List;

public class Pet {

    private int id;
    private Category category;
    private String name;
    private List photoUrls;
    private List<Tags> tags;
    private String status;

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List photoUrls) {
        this.photoUrls = photoUrls;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
