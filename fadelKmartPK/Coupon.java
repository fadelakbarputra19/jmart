package fadelKmartPK;


/**
 * Write a description of class Coupon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coupon
{
   public final String name;
   public  double cut;
   public final Type type;
   public final double minimum;
   private boolean used;
       
   public Coupon (String name, Type type, double cut, double minimum)
   {    
       this.name = name;
       this.type = type;
       this.cut = cut;
       this.minimum = minimum;
       this.used = false;
   }
   
     enum Type{
        DISCOUNT,
        REBATE;

    }   

   public boolean isUsed()
   {
       return used;
   }
   
   public boolean canApply(PriceTag priceTag)
   {
        if(priceTag.getAdjustedPrice() >= minimum && used == false)
        {
            return true;
        }
        else{
            return false;
        }
   }
   
   public double apply(PriceTag priceTag)
   {
       this.used = true;

       switch (type) {
           case REBATE:
                if (priceTag.getAdjustedPrice() >= cut) {
                    return 0.0;
                }
                else{
                    return priceTag.getAdjustedPrice() - cut;
                }
           case DISCOUNT:
                cut = cut /100;
                return ( double)priceTag.getAdjustedPrice() - priceTag.getAdjustedPrice() * cut;
       }
        return ( double)priceTag.getAdjustedPrice() - priceTag.getAdjustedPrice() * cut;
    }
}
