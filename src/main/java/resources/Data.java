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

    public PetPayload setMethodsForAddPet() {
        petPayload.setId(19030000);

        cgr.setId(1);
        cgr.setName("Kuş");
        petPayload.setCategory(cgr);

        petPayload.setName("Kara Kartal-3");

        photoList.add("https://images.app.goo.gl/sa9kMb9HEjnt1wox7");
        petPayload.setPhotoUrls(photoList);

        //Burada birden fazla tag nasıl göndereceğiz bunu düşün!
        tg.setId(1);
        tg.setName("Tag-1");
        tag.add(tg);
        petPayload.setTags(tag);

        petPayload.setStatus("Mevcut");
        return petPayload;
    }


}
