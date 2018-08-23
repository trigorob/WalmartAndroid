package robt.walmartandroid;

import org.junit.Test;

import java.net.HttpURLConnection;

import javax.json.JsonObject;

import static org.junit.Assert.assertTrue;


/**
 * These merely test the viabilities of every REST API query used in this app
 */
public class WalmartAPIQueriesTests {
    // Setup
    private int COUNT = 10;

    // Sample data IDs for testing
    private String SAMPLECAT = "1334134_5899871_8844202";
    private String SAMPLECAT_MAXID = "23781518";
    private String SAMPLEPRODCODE = "732";
    private String ALLPRODS_MAXID = "219623";

    @Test
    public void TestRESTAPIQueries() throws Exception {

        // Get Queries
        String CCatQ = WalmartAPIQueries.getCategoryQuery();
        String CAPIQ = WalmartAPIQueries.getAllPaginatedItemsQueryByCategory(SAMPLECAT);
        String CIPQC1 = WalmartAPIQueries.getItemsPageQueryByCategory(SAMPLECAT, COUNT);
        String CIPQC2 = WalmartAPIQueries.getItemsPageQueryByCategory(SAMPLECAT, COUNT,SAMPLECAT_MAXID);
        String CIQ = WalmartAPIQueries.getItemQuery(SAMPLEPRODCODE);
        String CAPIQ1 = WalmartAPIQueries.getAllPossibleItemsQuery();
        String CPIQ12 = WalmartAPIQueries.getAllPossibleItemsQuery(ALLPRODS_MAXID);


        // Attempt Connections
        HttpURLConnection Conn_CatQ = APIHandler.connectRESTAPIQuery(CCatQ);
        HttpURLConnection Conn_APIQ = APIHandler.connectRESTAPIQuery(CAPIQ);
        HttpURLConnection Conn_IPQC1 = APIHandler.connectRESTAPIQuery(CIPQC1);
        HttpURLConnection Conn_IPQC2 = APIHandler.connectRESTAPIQuery(CIPQC2);
        HttpURLConnection Conn_IQ = APIHandler.connectRESTAPIQuery(CIQ);
        HttpURLConnection Conn_APIQ1 = APIHandler.connectRESTAPIQuery(CAPIQ1);
        HttpURLConnection Conn_PIQ12 = APIHandler.connectRESTAPIQuery(CPIQ12);

        HttpURLConnection[] ConnectionsList = {Conn_CatQ, Conn_APIQ, Conn_IPQC1, Conn_IPQC2,
                Conn_IQ, Conn_APIQ1, Conn_PIQ12};

        // Test for connectivity:
        // - all queries should be valid
        // - all queries should connect properly (assumes system is online)
        for (HttpURLConnection h : ConnectionsList)
        {
            boolean check = h.getResponseCode() == 200;
            assertTrue(check);
        }


        // Test for JSONObject Retrieval
        // - all connections should retrieve respective JSONObjects
        for (HttpURLConnection h : ConnectionsList)
        {
            JsonObject j = APIHandler.createJSONfromRESTAPIConnect(h);
            assertTrue(j != null);
        }


        // Finally, close connections
        for (HttpURLConnection h : ConnectionsList)
        {
            h.disconnect();
        }
    }
}


