package robt.walmartandroid;

import android.support.annotation.NonNull;

import java.util.ArrayList;

import javax.json.JsonArray;
import javax.json.JsonObject;

public class WalmartObjectCreator {

    private static ArrayList<WalmartCategory> asdf;

    public static ArrayList<WalmartCategory> makeWalmartCategoriesFromJSON(JsonObject inp) {
      //  Set<Map.Entry<String, JsonValue>> name = inp.entrySet();
        JsonArray categories = inp.getJsonArray("categories");

        return getWalmartCategories(categories);
    }

    @NonNull
    private static ArrayList<WalmartCategory> getWalmartCategories(JsonArray categories) {
        ArrayList<WalmartCategory> ret = new ArrayList<WalmartCategory>();
        for (int i=0;i<categories.size();i++){
            JsonObject jso = (JsonObject) categories.get(i);
            WalmartCategory wmc = new WalmartCategory(
                    jso.get("id").toString(), jso.get("name").toString(), jso.get("path").toString()
            );
            ret.add(wmc);
            if (jso.containsKey("children")) {
                JsonArray children = jso.getJsonArray("children");
                ArrayList<WalmartCategory> childrenObj = getWalmartCategories(children);
                wmc.addChildren(childrenObj);
                ret.addAll(childrenObj);
            }

        }

        return ret;
    }

}
