package fadelKmartPK;


/**
 * Write a description of class Store here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Store extends Recognizable implements FileParser
{
   public String name;
   public String number;
   public String address;
   
   
   public Store(int accountId, String name, String address, String number){
       super(accountId);
       this.name = name;
       this.address = address;
       this.number = number;
   }
   
   public Store(Account account, String name, String address, String number){
       super(account.id);
       this.name = name;
       this.address = address;
       this.number = number;
   }
   
   public boolean read(String content) {
       return false;
   }
   
   public Object write(){
        return null;
   }
    
   public Object newInstance(String content){
        return null;
   }
}
