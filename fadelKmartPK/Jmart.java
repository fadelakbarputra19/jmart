package fadelKmartPK;


/**
 * Write a description of class Jmart here.
 *
 * @author Muhammad Fadel Akbar Putra
 * @version 11-09-2021
 */
public class Jmart
{
      public int getPromo(){
           return 0;
       }
       public String getCustomer(){
           return "oop";
       }
       /**
        * Method getDiscountPercentage
        */
       public float getDiscountPercentage(int before, int after){
           if(before < after){
               return 0.0f;
            }
            else{
                return before - after;
            }
               
       }
       /**
        * Method getDiscountedPrice
        */
       public int getDiscountedPrice(int price, float discountPercentage){
           if(discountPercentage > 100.0f){
               return 0;
           }else{
               return (int) (price - (discountPercentage / 100) * (float)price);
            }
       }
       
    /**
     * Method getCommissionMultiplier
     */
        public float getCommissionMultiplier(){
        return 0.05f;
        }   
        
    /**
     * Method getAdjustedPeice
     */
        public int getAdjustedPrice(int price){
            return (int) (price + (0.05 * price));
    }
    /**
     * Method getAdminFee
     */
        public int getAdminFee(int price){
            return (price * 005);
    }
     public static void main(String[] args){
    
}


}  
  