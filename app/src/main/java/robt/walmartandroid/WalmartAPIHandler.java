package robt.walmartandroid;


import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by ChampionRobert on 2018-08-20.
 */


/**
 * This class contains methods for handling the REST API requests
 */
public class WalmartAPIHandler {

    // - MAKE REST API CALL
    // - GET DATA
    // - PROC INPUT DATA
    // - SHOW UP ON VIEW


    // public List<WalmartCategory> getCategories() {
    public JSONObject getRESTAPICategories() {

        String query = WalmartAPIQueries.getCategoryQueryJSON();

        try {
            // SECTION: process REST API call
            URL url = new URL(query);
            HttpURLConnection c = (HttpURLConnection) url.openConnection();
            c.setRequestMethod("GET");

            c.setConnectTimeout(10000); // 10sec Connection Timeout
            c.setReadTimeout(10000); // 10sec Read Timeout

            c.connect();

            int codeCheck = c.getResponseCode();
            if(codeCheck != 200) throw new RuntimeException("Http Response Code: " +codeCheck);


            // SECTION: Read output from REST API call
            InputStreamReader isr = new InputStreamReader(c.getInputStream(), Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();


 /*           int cp;
            while ((cp = br.read()) != -1) {
                sb.append((char) cp);
            }
*/

            ArrayList<String> strout = new ArrayList<String>();
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sb.append(line);
            }
            String JSONString = sb.toString();






            c.disconnect();

            // SECTION: Create JSON Object
            try {
                StringReader reader = new StringReader("[]");

                // parser = Json.createParser(reader);


            }
            catch (Exception e) {
                // Print/Log code for JSON object creation
            }

        }
        catch (MalformedURLException e) {
            // handle invalid URL

        }
        catch (IOException e) {
            // handle anything else while connecting

        }

        catch (RuntimeException e) {
            // This is for failing response codes to REST API request.
            // Plan: return response to UI, prompting message: "server unavailable"
        }

        // if code reaches here, JSON object creation failed.
        return null;
    }




    public void parseJSONCategories(JSONObject inp) {

    }




    public List<WalmartProduct> getProductsFromCategory(WalmartCategory inp) {
        return null;
    }


}
