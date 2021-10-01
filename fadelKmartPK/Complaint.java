package fadelKmartPK;


/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Recognizable implements FileParser
{
    public String date = "Sabtu";
    public String desc;
    
    public Complaint(int id, String desc){
        super(id);
        this.desc = desc;
    }
    
    public boolean read(String content){
        return false;
    }

    public Object write(){
        return null;
    }
}
