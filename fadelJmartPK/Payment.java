package fadelJmartPK;


/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Payment extends Invoice
{
   public int productCount;
   public Shipment shipment;
   
   public Payment(int buyerId, int productId, Shipment shipment, int productCount){
        super(buyerId, productId);
        this.productId = productId;
        this.shipment = shipment;
        this.productCount = productCount;
   }
   
    public  double getTotalPay(){
        return 0.0;
    }

  
}
