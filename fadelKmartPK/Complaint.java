package fadelKmartPK;


/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Transaction implements FileParser
{
   public int paymentId;
   public String desc;
   
   public Complaint(int id, Payment payment, String desc){
       //super(id);
   }
   
    public boolean read(String content) {
       return false;
   }
   
    public boolean validate(){
        return false;
    }
    
    public Transaction perform(){
        return null;
    }
}
