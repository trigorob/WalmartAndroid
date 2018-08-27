package robt.walmartandroid;

import org.junit.Test;

import java.util.ArrayList;

public class WalmartObjectCreatorTests {

    @Test
    public void TestCategoryObjectsFromJSON() throws Exception {
        ArrayList<WalmartCategory> wmc = WalmartObjectCreator.makeWalmartCategoriesFromJSON(
                APIHandler.createJSONfromRESTAPIConnect(
                        APIHandler.connectRESTAPIQuery(WalmartAPIQueries.getCategoryQuery())
                )
        );
        Object check = "asdf";
    }
}
