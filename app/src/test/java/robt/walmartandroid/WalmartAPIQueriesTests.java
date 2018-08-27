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
        String Q_AllCats = WalmartAPIQueries.getCategoryQuery();
        String Q_ItemsInCat = WalmartAPIQueries.getAllPaginatedItemsQueryByCategory(SAMPLECAT);
        String Q_ItemsInCatPaged1 = WalmartAPIQueries.getItemsPageQueryByCategory(SAMPLECAT, COUNT);
        String Q_ItemsInCatPaged2 = WalmartAPIQueries.getItemsPageQueryByCategory(SAMPLECAT, COUNT,SAMPLECAT_MAXID);
        String Q_Item = WalmartAPIQueries.getItemQuery(SAMPLEPRODCODE);
        String Q_AllItems1 = WalmartAPIQueries.getAllPossibleItemsQuery();
        String Q_AllItems2 = WalmartAPIQueries.getAllPossibleItemsQuery(ALLPRODS_MAXID);


        // Attempt Connections
        HttpURLConnection Conn_CatQ = APIHandler.connectRESTAPIQuery(Q_AllCats);
        HttpURLConnection Conn_APIQ = APIHandler.connectRESTAPIQuery(Q_ItemsInCat);
        HttpURLConnection Conn_IPQC1 = APIHandler.connectRESTAPIQuery(Q_ItemsInCatPaged1);
        HttpURLConnection Conn_IPQC2 = APIHandler.connectRESTAPIQuery(Q_ItemsInCatPaged2);
        HttpURLConnection Conn_IQ = APIHandler.connectRESTAPIQuery(Q_Item);
        HttpURLConnection Conn_APIQ1 = APIHandler.connectRESTAPIQuery(Q_AllItems1);
        HttpURLConnection Conn_PIQ12 = APIHandler.connectRESTAPIQuery(Q_AllItems2);

        HttpURLConnection[] ConnectionsList = {Conn_CatQ, Conn_APIQ, Conn_IPQC1, Conn_IPQC2,
                Conn_IQ, Conn_APIQ1, Conn_PIQ12};


        // Test for connectivity:
        // - all queries should be valid
        // - all queries should connect properly (assumes system is online)
        boolean checkConn_CatQ = Conn_CatQ.getResponseCode() == 200;
        boolean checkConn_APIQ = Conn_APIQ.getResponseCode() == 200;
        boolean checkConn_IPQC1 = Conn_IPQC1.getResponseCode() == 200;
        boolean checkConn_IPQC2 = Conn_IPQC2.getResponseCode() == 200;
        boolean checkConn_IQ = Conn_IQ.getResponseCode() == 200;
        boolean checkConn_APIQ1 = Conn_APIQ1.getResponseCode() == 200;
        boolean checkConn_PIQ12 = Conn_PIQ12.getResponseCode() == 200;

        assertTrue(checkConn_CatQ);
        assertTrue(checkConn_APIQ);
        assertTrue(checkConn_IPQC1);
        assertTrue(checkConn_IPQC2);
        assertTrue(checkConn_IQ);
        assertTrue(checkConn_APIQ1);
        assertTrue(checkConn_PIQ12);


        // Test for JSONObject Retrieval
        JsonObject jsonObj_CatQ = APIHandler.createJSONfromRESTAPIConnect(Conn_CatQ);
        JsonObject jsonObj_APIQ = APIHandler.createJSONfromRESTAPIConnect(Conn_APIQ);
        JsonObject jsonObj_IPQC1 = APIHandler.createJSONfromRESTAPIConnect(Conn_IPQC1);
        JsonObject jsonObj_IPQC2 = APIHandler.createJSONfromRESTAPIConnect(Conn_IPQC2);
        JsonObject jsonObj_IQ = APIHandler.createJSONfromRESTAPIConnect(Conn_IQ);
        JsonObject jsonObj_APIQ1 = APIHandler.createJSONfromRESTAPIConnect(Conn_APIQ1);
        JsonObject jsonObj_PIQ12 = APIHandler.createJSONfromRESTAPIConnect(Conn_PIQ12);

        assertTrue(jsonObj_CatQ != null);
        assertTrue(jsonObj_APIQ != null);
        assertTrue(jsonObj_IPQC1 != null);
        assertTrue(jsonObj_IPQC2 != null);
        assertTrue(jsonObj_IQ != null);
        assertTrue(jsonObj_APIQ1 != null);
        assertTrue(jsonObj_PIQ12 != null);

        // Finally, close connections
        for (HttpURLConnection h : ConnectionsList)
        {
            h.disconnect();
        }
    }
}


