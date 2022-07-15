package resources;

import petStore.Category;
import petStore.PetPayload;
import petStore.Tags;

import java.util.ArrayList;
import java.util.List;

public class Data {

    Category cgr = new Category();
    Tags tg = new Tags();
    PetPayload petPayload = new PetPayload();
    List<String> photoList = new ArrayList<String>();
    List<Tags> tag = new ArrayList<Tags>();

    public PetPayload setMethodsForAddPet(int id, String categoryName, String name) {
        petPayload.setId(id);

        cgr.setId(1);
        cgr.setName(categoryName);
        petPayload.setCategory(cgr);

        petPayload.setName(name);

        photoList.add("https://images.app.goo.gl/sa9kMb9HEjnt1wox7");
        petPayload.setPhotoUrls(photoList);

        //Burada birden fazla tag nasıl göndereceğiz bunu düşün!
        tg.setId(1);
        tg.setName("Tag-1");
        tag.add(tg);
        petPayload.setTags(tag);

        petPayload.setStatus("Added");
        return petPayload;
    }

    public PetPayload setMethodsForUpdatePet(int id, String name) {
        petPayload.setId(id);

        cgr.setId(1);
        cgr.setName("Category Updated Name");
        petPayload.setCategory(cgr);

        petPayload.setName(name);

        photoList.add("https://images.app.goo.gl/sa9kMb9HEjnt1wox7");
        petPayload.setPhotoUrls(photoList);

        tg.setId(1);
        tg.setName("Tag-1");
        tag.add(tg);
        petPayload.setTags(tag);

        petPayload.setStatus("Updated");
        return petPayload;
    }

   /* public String test(String name, String status) {
        return "{\n" +
                "    \"name\": \"" + name + "\",\n" +
                "    \"status\": \"" + status + "\",\n" +
                "}";
    }*/


}
