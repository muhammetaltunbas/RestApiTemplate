package OperationalWorks;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.Iterator;

public class GetDataFromJsonFile {

    public static void main(String[] args) {
        Iterator iterator;
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("/Users/maltunbas/git/APIProjects/APIWorking/Towns.json"));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray subjects = (JSONArray) jsonObject.get("TownRestrictions");
            iterator = subjects.iterator();
            while (iterator.hasNext()) {
                JSONObject item = (JSONObject) iterator.next();
                System.out.println(item.get("TownId")+",");
                //System.out.println(iterator.next()); => {"TownId": 1101, "TownName": "ABANA"} şeklinde yazar.
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
