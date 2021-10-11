package fadelKmartPK;


/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Payment extends Invoice implements Transactor
{
   public int productId;
   public Shipment shipment;
   
   public Payment(int id, int buyerId, int storeId, int productId, Shipment shipment){
        super(id, buyerId, storeId);
        this.productId = productId;
        this.shipment = shipment;
   }
   
   public boolean validate(){
        return false;
    }
    
    public Invoice perform(){
        return null;
    }
    
    public  double getTotalPay(){
        return 0.0;
    }

  
}
