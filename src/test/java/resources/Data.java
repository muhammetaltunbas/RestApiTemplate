package resources;

import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor;
import petStore.Category;
import petStore.OrderPetPayload;
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
    OrderPetPayload orderPayload = new OrderPetPayload();

    public PetPayload setMethodsForAddPet(int id, String categoryName, String name) {
        petPayload.setId(id);

        cgr.setId(1);
        cgr.setName(categoryName);
        petPayload.setCategory(cgr);

        petPayload.setName(name);

        photoList.add("https://cdn.britannica.com/96/76096-050-8CF14F84/Bald-eagle-snag-Alaska-Kenai.jpg");
        petPayload.setPhotoUrls(photoList);

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

        photoList.add("https://cdn.britannica.com/96/76096-050-8CF14F84/Bald-eagle-snag-Alaska-Kenai.jpg");
        petPayload.setPhotoUrls(photoList);

        tg.setId(1);
        tg.setName("Tag-1");
        tag.add(tg);
        petPayload.setTags(tag);

        petPayload.setStatus("Updated");
        return petPayload;
    }

    public OrderPetPayload setMethodsForCreateOrder(int id, int petId, int quantity) {
        orderPayload.setId(id);
        orderPayload.setPetId(petId);
        orderPayload.setQuantity(quantity);
        orderPayload.setShipDate("2022-11-26T21:07:56.331+0000");
        orderPayload.setStatus("completed");
        orderPayload.setComplete(true);

        return orderPayload;
    }


}
