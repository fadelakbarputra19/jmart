package com.fadelJmartPK;
import com.fadelJmartPK.Treasury;

/**
 * Write a description of class Coupon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coupon extends Serializable{

   public final String name;
   public final int code;
   public final double cut;
   public final Type type;
   public final double minimum;
   private boolean used;
       
   public Coupon (String name, int code, Type type, double cut, double minimum)
   {    
       
       this.name = name;
       this.code = code;
       this.type = type;
       this.cut = cut;
       this.minimum = minimum;
       this.used = false;
   }
   
    public enum Type{
        DISCOUNT,
        REBATE;
    }   

   public boolean isUsed()
   {
       return used;
   }
   
   public boolean canApply(double price, double discount)
   {
        if(Treasury.getAdjustedPrice(price, discount) >= minimum && used == false)
        {
            return true;
        }
        else{
            return false;
        }
   }
   
   public double apply(double price, double discount)
   {
        used = true;
        if (type == Type.DISCOUNT)
        {
            return (Treasury.getAdjustedPrice(price, discount) * ((100 - cut) / 100));
        }
        else
        {
            return (Treasury.getAdjustedPrice(price, discount) - cut);   
        }
          
    }
    
     public boolean read(String content) {
       return false;
   }
}
