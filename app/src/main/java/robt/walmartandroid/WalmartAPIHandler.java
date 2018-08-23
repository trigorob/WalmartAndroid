package robt.walmartandroid;


import javax.json.JsonObject;


/**
 * Created by ChampionRobert on 2018-08-20.
 */


/**
 * This class contains methods for handling the REST API requests
 */
public class WalmartAPIHandler extends APIHandler{

    /**
     * Returns ALL Walmart categories (including all subcategories) as JsonObject
     * @return JsonObject with all Walmart Categories
     */
    public static JsonObject getJSONObjCategories() {
        return processRESTAPIorNull(WalmartAPIQueries.getCategoryQuery());
    }

    /**
     * Returns ALL Products under a given Walmart category (code)
     * Will also be returned paginated, at the maximum 1000 items per page.
     * This query also returns the Products as Page 1
     * @param categoryCode - Category id of the desired category.
     *                       **NOTE: This should match the id field from Taxonomy API**
     * @return JsonObject with all Items under Category
     */
    public static JsonObject getJSONObjAllItemsByCategory(String categoryCode) {
        return processRESTAPIorNull(
                WalmartAPIQueries.getAllPaginatedItemsQueryByCategory(categoryCode));
    }



    /**
     * Returns a set of Products, paginated, under a given category (code),
     *    with a given number of items per page.
     * This also returns the Products as Page 1
     * @param categoryCode - Category id of the desired category.
     *                       **NOTE: This should match the id field from Taxonomy API**
     *
     * @param itemsPerPage - # of items per page
     * @return Items as JsonObject
     */
    public static JsonObject getJSONObjItemsPageByCategory(String categoryCode, int itemsPerPage) {
        return processRESTAPIorNull(
                WalmartAPIQueries.getItemsPageQueryByCategory(categoryCode, itemsPerPage));
    }

    /**
     * Returns a segment of all Products, paginated, under a given category (code),
     *    with a given number of items per page.
     * This segment of all products includes an identifier (maxID).
     * @param categoryCode - Category id of the desired category.
     *                       **NOTE: This should match the id field from Taxonomy API**
     *
     * @param itemsPerPage - # of items per page
     *
     * @param maxID - page ID: identifies which segment (page) from overall search query
     *                these items are from
     * @return Items as JsonObject
     */
    public static JsonObject getJSONObjItemsPageByCategory(String categoryCode, int itemsPerPage, String maxID) {
        return processRESTAPIorNull(
                WalmartAPIQueries.getItemsPageQueryByCategory(categoryCode, itemsPerPage, maxID));
    }


    /**
     * Returns a single Product - including all its possible info
     * @param productCode - Product ID
     * @return Full Product as JsonObject
     *
     * Key Product Info the Walmart API should return:
     *  - Name
     *  - MSRP/Sale Price
     *  - Short/Long Descriptions
     *  - Product Image URLS: Thumbnail, Medium, Large
     *  and more
     */
    public static JsonObject getJSONObjItem(String productCode) {
        return processRESTAPIorNull(
                WalmartAPIQueries.getItemQuery(productCode));
    }


    /**
     * Returns ALL possible Products
     * (Will also be returned paginated by default, at the maximum 1000 items per page.
     * Hence this query also returns the Products as Page 1)
     * @return Items as JsonObject
     */
    public static JsonObject getJSONObjAllPossibleItems() {
        return processRESTAPIorNull(
                WalmartAPIQueries.getAllPossibleItemsQuery());
    }

    /**
     * Returns ALL possible Products
     * (Will also be returned paginated by default, at the maximum 1000 items per page.
     * This overloaded version will view a given segment of all possible products, given its page ID (maxID))
     * @param maxID - page ID: identifies which segment (page) from overall search query
     *                these items are from
     * @return Items as JsonObject
     */
    public static JsonObject getJSONObjAllPossibleItems(String maxID) {
        return processRESTAPIorNull(
                WalmartAPIQueries.getAllPossibleItemsQuery(maxID));
    }








}
