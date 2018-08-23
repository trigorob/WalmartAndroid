package robt.walmartandroid;

import org.junit.Test;

import javax.json.JsonObject;

import static org.junit.Assert.assertTrue;

/**
 * Created by ChampionRobert on 2018-08-21.
 */

public class WalmartAPIHandlerTests {
    @Test
    public void TestGetRESTAPICategories() throws Exception {
        JsonObject output = WalmartAPIHandler.getJSONObjCategories();

        // Check:
        assertTrue(output != null);
    }
}

