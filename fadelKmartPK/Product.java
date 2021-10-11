package fadelKmartPK;


/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product extends Recognizable
{
    public int storeId;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public Shipment.MultiDuration multiDuration;
    
    public Product(int id, int storeId, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category, Shipment.MultiDuration multiDuration)
    {
        this.storeId = storeId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating= new ProductRating();
        this.multiDuration = multiDuration;
    }
   public String toString(){
        return "name: " + this.name + "\nweight: " + this.weight + "\nconditionUsed: " + this.conditionUsed + "\npriceTag: " + this.priceTag + "\nCategory: " + this.category + "\nRating: " + this.rating + "\nstoreId: " + this.storeId;
    }
}

