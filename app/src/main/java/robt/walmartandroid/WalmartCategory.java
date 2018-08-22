package robt.walmartandroid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChampionRobert on 2018-08-19.
 */



/**
 * This class outlines the Product Categories from the Walmart API
*/
public class WalmartCategory {

    // FIELDS:
    private String m_id;
    private String m_name;
    private String m_categoryPath;
    private List<WalmartCategory> m_children = new ArrayList<WalmartCategory>();

    // CONSTRUCTORS:
    public WalmartCategory(String id, String name) {
        this.m_id = id;
        this.m_name = name;
    }

    public WalmartCategory(String id, String name, String path) {
        this.m_id = id;
        this.m_name = name;
        this.m_categoryPath = path;
    }

    public WalmartCategory(String id, String name, List<WalmartCategory> children) {
        this.m_id = id;
        this.m_name = name;
        m_children.addAll(children);
    }

    // PROPERTIES:
    public String getID() {return  this.m_id;}
    public String getName() {return this.m_name;}
    public String getCatPath() {return this.m_categoryPath;}
    private List<WalmartCategory> getChildren() {return m_children;}

}
