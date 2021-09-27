package fadelKmartPK;


/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Invoice extends Recognizable implements FileParser
{
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
   
   public String date;
   public int buyerId;
   public int productId;
   public int complaintId;
   public Rating rating;
   public Status status;
   
   protected Invoice(int id, int buyerId, int productId){
        super(id);
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = "date";
        this.rating = Rating.BAD;
        this.status = Status.FINISHED;
   }
   
   public abstract double getTotalPay();
   
   public boolean read(String content){
       return false;
   }
}
