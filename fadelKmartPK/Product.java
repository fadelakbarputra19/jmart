package fadelKmartPK;


/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product
{
    private static int idCounter = 0;
    public int id;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating productRating;
    
    public Product(int id, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category)
    {
        this.id = idCounter++;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.productRating = new ProductRating();
    }
    
    
}

