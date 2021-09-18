package fadelKmartPK;


/**
 * <h1>JMart Program<h1>
 *
 * @author Muhammad Fadel Akbar Putra
 * @version 11-09-2021
 */
public class Jmart
{
    
    
    public static Product create(Product product)
    {   
        return new Product("Manga", 1, false, new PriceTag(20000), ProductCategory.BOOK);
    }
    
    /**
    * Main 
    */
    public static void main(String[] args)
    {
       
    }
}  
  