package com.fadelJmartPK;


/**
 * Write a description of class PriceTag here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Treasury
{
   public static final double COMMISSION_MULTIPLIER = 0.05;
   public static final double BOTTOM_PRICE = 20000.0;
   public static final double BOTTOM_FEE = 1000.0;
   public double price;
   public double discount;
   
  
   /*
    * Method untuk getAdjustedPrice
    */
   public static double getAdjustedPrice(double price, double discount)
   {
       return getDiscountedPrice(price, discount) + getAdminFee(price, discount);
   }
   
   /*
    * Method untuk getAdminFee
    */
   public static double getAdminFee(double price, double discount)
   {
       double discountedPrice = getDiscountedPrice(price, discount);
       if (discountedPrice < BOTTOM_PRICE){
        return BOTTOM_FEE;
       } 
       else{
        return COMMISSION_MULTIPLIER * discountedPrice;
       }
       
   }
   
   /*
    * Method untuk getDiscountedPrice
    */
   public static double getDiscountedPrice(double price, double discount)
   {
       if(discount >= 100.0)
       {
            return 0.0;
       }
       else 
       {
            double cut = price * discount / 100;
            return price - cut;
       }
   }

   
}
