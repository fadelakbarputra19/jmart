package fadelKmartPK;


/**
 * Write a description of class PriceTag here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PriceTag
{
   public static final double COMMISSION_MULTIPLIER = 0.05;
   public static final double BOTTOM_PRICE = 20000.0;
   public static final double BOTTOM_FEE = 1000.0;
   public double price;
   public double discount;
   
   public PriceTag(double price)
   {    
       this.price = price;
       this.discount = 0.0;
   }
   public PriceTag(double price, double discount)
   {    
        this.price = price;
        this.discount = discount;
   }
   
   /*
    * Method untuk getAdjustedPrice
    */
   public double getAdjustedPrice()
   {
       return getDiscountedPrice() + getAdminFee();
   }
   
   /*
    * Method untuk getAdminFee
    */
   public double getAdminFee()
   {
       if (getDiscountedPrice() < BOTTOM_PRICE) return BOTTOM_FEE;
       return getDiscountedPrice() - COMMISSION_MULTIPLIER * getDiscountedPrice();
   }
   
   /*
    * Method untuk getDiscountedPrice
    */
   private double getDiscountedPrice()
   {
       if(discount > 100.0)
       {
           return 100.0;
       }
       else if(discount == 100)
       {    
            return 0.0;
       }
       else 
       {
           return price - discount;
       }
   }
   
}

