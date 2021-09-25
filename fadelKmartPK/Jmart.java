package fadelKmartPK;

import javax.sound.sampled.EnumControl.Type;

/**
 * <h1>JMart Program<h1>
 *
 * @author Muhammad Fadel Akbar Putra
 * @version 11-09-2021
 */
public class Jmart
{
    
    
    public static Product createProduct(Product product)
    {   
        return new Product(12012, "Manga", 1, false, new PriceTag(20000), ProductCategory.BOOK);
    }
    
    public static ShipmentDuration createShipmentDuration(ShipmentDuration shipmentDuration)
    {   
        return new ShipmentDuration(ShipmentDuration.SAME_DAY, ShipmentDuration.NEXT_DAY);
    }
      public static Coupon createCoupon(Coupon coupon)
    {   
        return new Coupon("My kupon", 11111, Coupon.Type.REBATE, 100000, 500000);
    }
    /**
    * Main 
    */
    public static void main(String[] args)
    {
       
    }
}  
  