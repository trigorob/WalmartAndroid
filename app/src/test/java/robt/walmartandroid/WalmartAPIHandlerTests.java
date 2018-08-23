package robt.walmartandroid;

import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by ChampionRobert on 2018-08-21.
 */

public class WalmartAPIHandlerTests {
    @Test
    public void TestGetRESTAPICategories() throws Exception {
        WalmartAPIHandler wmAPIH = new WalmartAPIHandler();
        JSONObject output = wmAPIH.getRESTAPICategories();

        // Check:
        assertTrue(output != null);
    }
}

