package com.fadelJmartPK;
import com.fadelJmartPK.Treasury;
import com.fadelJmartPK.dbjson.Serializable;

/**
 * Coupon digunakan untuk memberikan jenis coupon yang ada dan dapat digunakan jika syarat terpenuhi pada Payment 
 *
 * @author Muhammad Fadel Akbar Putra
 * @version 1.0
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
