package robt.walmartandroid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChampionRobert on 2018-08-19.
 */



/**
 * This class outlines the Product Categories from the Walmart API.
 * Future developers are free to derive from this class
*/
public class WalmartCategory {

    // FIELDS:
    protected String Id;
    protected String Name;
    protected String CategoryPath;
    protected List<WalmartCategory> m_children = new ArrayList<WalmartCategory>();

    // CONSTRUCTORS:
    public WalmartCategory(String id, String name) {
        Id = id;
        Name = name;
    }
    public WalmartCategory(String id, String name, List<WalmartCategory> m_children) {
        Id = id;
        Name = name;
        this.m_children = m_children;
    }

    // PROPERTIES:


}
