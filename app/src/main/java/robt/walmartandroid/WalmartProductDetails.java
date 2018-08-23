package robt.walmartandroid;

import java.net.URL;

/**
 * Created by ChampionRobert on 2018-08-22.
 */

/**
 * This class holds details for Walmart Products.
 * Instances are meant to he held within WalmartProduct instances
 */
public class WalmartProductDetails {

    private String itemID;
    private String parentItemId;
    private String name;
    private Double salePrice;
    private String categoryPath;
    private String shortDescription;
    private String longDescription;
    private String brandName;
    private URL thumbnailImage;
    private URL mediumImage;
    private URL largeImage;

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setParentItemId(String parentItemId) {
        this.parentItemId = parentItemId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public void setCategoryPath(String categoryPath) {
        this.categoryPath = categoryPath;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setThumbnailImage(URL thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    public void setMediumImage(URL mediumImage) {
        this.mediumImage = mediumImage;
    }

    public void setLargeImage(URL largeImage) {
        this.largeImage = largeImage;
    }

    public String getItemID() {
        return itemID;
    }

    public String getParentItemId() {
        return parentItemId;
    }

    public String getName() {
        return name;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public String getCategoryPath() {
        return categoryPath;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getBrandName() {
        return brandName;
    }

    public URL getThumbnailImage() {
        return thumbnailImage;
    }

    public URL getMediumImage() {
        return mediumImage;
    }

    public URL getLargeImage() {
        return largeImage;
    }



    /**
     * FULL constructor
     */
    public WalmartProductDetails(String itemID,
                                 String parentItemId,
                                 String name,
                                 Double salePrice,
                                 String categoryPath,
                                 String shortDescription,
                                 String longDescription,
                                 String brandName,
                                 URL thumbnailImage,
                                 URL mediumImage,
                                 URL largeImage) {
        this.itemID = itemID;
        this.parentItemId = parentItemId;
        this.name = name;
        this.salePrice = salePrice;
        this.categoryPath = categoryPath;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.brandName = brandName;
        this.thumbnailImage = thumbnailImage;
        this.mediumImage = mediumImage;
        this.largeImage = largeImage;
    }
}
