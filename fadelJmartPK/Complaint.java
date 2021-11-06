package fadelJmartPK;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Serializable  
{
    public Date date;
    public String desc;
    
    public Complaint(int id, String desc){
    	
        this.desc = desc;
        date = new Date();
    }
    
    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = sdf.format(this.date);
        return "Complaint{date=" + date + ", desc='" + desc + "'}";

    }  
}
