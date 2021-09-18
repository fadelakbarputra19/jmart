package fadelKmartPK;


/**
 * <h1>JMart Program<h1>
 *
 * @author Muhammad Fadel Akbar Putra
 * @version 11-09-2021
 */
public class Jmart
{
    
    Product product;
    public static Product create(Product product)
    {   
        return new Product("Manga", 1, true, new PriceTag(20000), ProductCategory.BOOK, new ProductRating());
    }
    
    /**
    * Main 
    */
    public static void main(String[] args)
    {
       
    }
}  
  