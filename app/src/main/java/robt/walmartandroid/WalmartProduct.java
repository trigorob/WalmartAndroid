package robt.walmartandroid;

/**
 * Created by ChampionRobert on 2018-08-19.
 */


/**
 * This class outlines Products from the Walmart API
*/
public class WalmartProduct {

    // FIELDS
    private String ItemID;
    private String ParentItemId;
    private String Name;
    private WalmartProductDetails Details;


    // GET/SET PROPERTIES
    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String itemID) {
        ItemID = itemID;
    }

    public String getParentItemId() {
        return ParentItemId;
    }

    public void setParentItemId(String parentItemId) {
        ParentItemId = parentItemId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public WalmartProductDetails getDetails() {
        return Details;
    }

    public void setDetails(WalmartProductDetails details) {
        Details = details;
    }
}
