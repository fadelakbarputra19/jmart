package fadelKmartPK;
import java.util.Date;
import java.util.ArrayList;

/**
 * Write a description of class Invoice here.
 *
 * @author 
 * @version (a version number or a date)
 */
public abstract class Invoice extends Serializable 
{
    public ArrayList<Record> history = new ArrayList<Record>();

   enum Status{
       WAITING_CONFIRMATION,
       CANCELLED,
       ON_PROGRESS,
       ON_DELIVERY,
       COMPLAINT,
       FINISHED,
       FAILED;
   }
   
   enum Rating{
       NONE,
       BAD,
       NEUTRAL,
       GOOD;
   }
   
   public class Record{
        public Status status;
        public Date date;
        public String message;
   }

   public Date date;
   public int buyerId;
   public int productId;
   public int complaintId;
   public Rating rating;
   public Status status;
   
   protected Invoice(int buyerId, int productId){
	   this.buyerId = buyerId;
       this.productId = productId;
       System.out.println(date.toString());
       this.complaintId = -1;
       this.date = new Date();
       rating = Rating.NONE;
       status = Status.WAITING_CONFIRMATION;
   }
   
   public abstract double getTotalPay();
   
  
}
