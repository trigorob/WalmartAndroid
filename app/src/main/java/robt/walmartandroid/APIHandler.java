package robt.walmartandroid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class APIHandler {


    protected static final int CONNECTIONTIMEOUT_SECS = 20000; // 20sec Connection Timeout
    protected static final int APIREADTIMEOUT_SECS = 20000;    // 20sec Read Timeout

    //List of notable Status Codes
    protected static final int STATUS_OK = 200;
    protected static final int STATUS_BADREQUEST = 200;
    protected static final int STATUS_UNAUTHORIZED = 401;
    protected static final int STATUS_FORBIDDEN = 403;
    protected static final int STATUS_NOTFOUND = 404;
    protected static final int STATUS_TIMEDOUT = 408;
    protected static final int STATUS_SERVERERROR = 500;
    protected static final int STATUS_BADGATEWAY = 502;
    protected static final int STATUS_SERVICEUNAVAIL = 503;
    protected static final int STATUS_GATEWAYTIMEDOUT = 504;


    /**
     * PRIMARY REST API Processor
     * Procedure:
     *  - Setup & Connect to REST API
     *  - Read/Create JSON Object from REST API call, Return afterwards
     *
     * @param query - REST API query to process
     * @return result as JsonObject OR null if failed
     */
    public static JsonObject processRESTAPIorNull(String query) {


        try {
            // SECTION: Setup & Connect to REST API
            HttpURLConnection c = connectRESTAPIQuery(query);

            // Check for connection Response Codes
            int codeCheck = c.getResponseCode();
            if(codeCheck != STATUS_OK) throw new IOException("Http Response Code: " +codeCheck);

            // SECTION: Read JSON Response from REST API call
            try {
                return makeJSONfromRESTAPIConnect(c);
            }
            catch (Exception e) {
                // TODO Print/Log code for JSON object creation attempt
                String note = e.getMessage();
            }

        }

        catch (MalformedURLException e) {
            // TODO handle invalid URL
            String note = e.getMessage();

        }
        catch (IOException e) {
            // TODO handle any errors while connecting
            String note = e.getMessage();
        }

        catch (RuntimeException e) {
            // This is for failing response codes to REST API request.
            // TODO Plan: return response to UI, prompting message: "resource unavailable"
            String note = e.getMessage();
        }

        catch (Exception e) {
            // TODO Catch anything else that can possibly go wrong here.
            // Handle it afterwards
            String note = e.getMessage();
        }
        // if code reaches here, JSON object creation failed.
        return null;
    }


    /**
     * PRIMARY QUERY CONNECTOR
     * Procedure:
     *  - Setup & Connect to HTTP URL
     *  - Read/Create JSON Object from REST API call, Return afterwards
     *
     * @param query - REST API query to process
     * @return HTTP Connection
     */
    public static HttpURLConnection connectRESTAPIQuery(String query) throws MalformedURLException, ProtocolException, IOException
    {
        URL url = new URL(query);
        HttpURLConnection connection  = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(CONNECTIONTIMEOUT_SECS); // 20sec Connection Timeout
        connection.setReadTimeout(APIREADTIMEOUT_SECS); // 20sec Read Timeout
        connection.connect();
        return connection;
    }

    /**
     * PRIMARY JSONOBJECT CREATOR CONNECTOR
     * Procedure:
     *  - Setup Readers
     *  - Fully read from Input Connection
     *  - Create JSONObject from read, Return afterwards
     *
     * @param conn - Connection to REST API Results
     * @return result as JsonObject
     */
    public static JsonObject makeJSONfromRESTAPIConnect(HttpURLConnection conn) throws IOException
    {
        JsonObject mainObject; // output object;
        InputStreamReader isr = new InputStreamReader(conn.getInputStream(), Charset.forName("UTF-8"));
        BufferedReader br = new BufferedReader(isr);
        JsonReader reader = Json.createReader(br);

        // Create JSON Object
        mainObject = reader.readObject();

        // Close/Disconnect all connections
        reader.close();
        conn.disconnect();
        br.close();
        isr.close();

        return mainObject;
    }


}
