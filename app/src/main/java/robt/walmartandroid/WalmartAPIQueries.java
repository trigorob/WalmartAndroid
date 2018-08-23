package robt.walmartandroid;

/**
 * Created by ChampionRobert on 2018-08-20.
 */


/**
 * This class holds the Collection of Walmart API queries
 * They can be all accessed without creating an instance of this class. (a la Static modifier)
 *  (this class has no modifiable fields)
 */
public class WalmartAPIQueries {


    /** Personal API Key from my account:
     */
    protected static final String MYAPIKEY = "tcefd9shdkvmqnq2b6657ra8";
    protected static final String URLBASE = "http://api.walmartlabs.com/v1/";

    /** ======== ======== ======== ======== ======== ========  */

    /**
     * CATEGORY QUERIES:
     *      "Taxonomy API exposes the category taxonomy used by walmart.com
     *  to categorize items. It describes three levels - Departments, Categories and Sub-categories
     * as available on Walmart.com."
     *              - via Walmart API
     */


    /**
     * QUERY: Returns ALL categories (including all subcategories)
     * @return Category query in JSON format:
     */
    public static String getCategoryQuery() {
        return URLBASE + "taxonomy?apiKey=" + MYAPIKEY +"&format=json";
    }

    /** ======== ======== ======== ======== ======== ========  */


    /**
     * CATEGORY-PRODUCT QUERIES:
     *      "Paginated Products API allows a developer to retrieve the
     * products catalog in a paginated fashion."
     *                         - via Walmart API
     */


    /**
     * QUERY: Returns ALL Products under a given category (code)
     * Will also be returned paginated, at the maximum 1000 items per page.
     * This query also returns the Products as Page 1
     * @param categoryCode - Category id of the desired category.
     *                       **NOTE: This should match the id field from Taxonomy API**
     * @return Items query
     */
    public static String getAllPaginatedItemsQueryByCategory(String categoryCode) {
        return URLBASE + "paginated/items?category="
                +categoryCode+"&apiKey="+ MYAPIKEY +"&format=json";
    }


    /**
     * QUERY: Returns a set of Products, paginated, under a given category (code),
     *    with a given number of items per page.
     * This also returns the Products as Page 1
     * @param categoryCode - Category id of the desired category.
     *                       **NOTE: This should match the id field from Taxonomy API**
     *
     * @param itemsPerPage - # of items per page
     * @return Items query
     */
    public static String getItemsPageQueryByCategory(String categoryCode, int itemsPerPage) {
        return getAllPaginatedItemsQueryByCategory(categoryCode) +
                "&count="+String.valueOf(itemsPerPage);
    }

    /**
     * QUERY: Returns a segment of all Products, paginated, under a given category (code),
     *    with a given number of items per page.
     * This segment of all products includes an identifier (maxID).
     * @param categoryCode - Category id of the desired category.
     *                       **NOTE: This should match the id field from Taxonomy API**
     *
     * @param itemsPerPage - # of items per page
     *
     * @param maxID - page ID: identifies which segment (page) from overall search query
     *                these items are from
     * @return Items query
     */
    public static String getItemsPageQueryByCategory(String categoryCode, int itemsPerPage, String maxID) {
        return getItemsPageQueryByCategory(categoryCode, itemsPerPage)+"&maxId="+maxID;
    }


    /** ======== ======== ======== ======== ======== ========  */


    /**
     * INDIVIDUAL PRODUCT QUERIES:
     *  This section includes queries for product details
     *      "Product Lookup API gives access to item price and availability in real-time.
     *  Item id needs to be specified for doing a lookup. Response type returned is full response. "
     *                         - via Walmart API
     */

    /**
     * QUERY: Returns a single Product - including all its possible info
     * @param productCode - Product ID
     * @return Full Product query
     *
     * Key Product Info the Walmart API should return:
     *  - Name
     *  - MSRP/Sale Price
     *  - Short/Long Descriptions
     *  - Product Image URLS: Thumbnail, Medium, Large
     *  and more
     */
    public static String getItemQuery(String productCode) {
        return URLBASE + "items/"
                +productCode+"?&apiKey="+ MYAPIKEY +"&format=json";
    }


    /** ======== ======== ======== ======== ======== ========  */


    /**
     * MASS PRODUCT QUERIES:
     */

    /**
     * QUERY: Returns ALL possible Products
     * (Will also be returned paginated by default, at the maximum 1000 items per page.
     * Hence this query also returns the Products as Page 1)
     * @return Items query
     */
    public static String getAllPossibleItemsQuery() {
        return URLBASE + "paginated/items?apiKey=" + MYAPIKEY +"&format=json";
    }

    /**
     * QUERY: Returns ALL possible Products
     * (Will also be returned paginated by default, at the maximum 1000 items per page.
     * This overloaded version will view a given segment of all possible products, given its page ID (maxID))
     * @param maxID - page ID: identifies which segment (page) from overall search query
     *                these items are from
     * @return Items query
     */
    public static String getAllPossibleItemsQuery(String maxID) {
        return getAllPossibleItemsQuery()+"&maxId="+String.valueOf(maxID);
    }


}
