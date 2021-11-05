package fadelKmartPK;

import java.text.SimpleDateFormat;
import java.util.Date;



import java.util.Calendar;

/**
 * Write a description of class Shipment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shipment
{
	public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("E MMMMM dd yyyy");
    public static final Plan INSTANT = new Plan((byte)(1 << 0));
    public static final Plan SAME_DAY = new Plan((byte)(1 << 1));
    public static final Plan NEXT_DAY = new Plan((byte)(1 << 2));
    public static final Plan REGULER = new Plan((byte)(1 << 3));
    public static final Plan KARGO = new Plan((byte)(1 << 4));
    public String address;
    public int cost;
    public byte plan;
    public String receipt;
    
    public Shipment(String address, int cost, byte plan, String receipt){
        this.address = address;
        this.cost =cost;
        this.plan = plan;
        this.receipt = receipt;
    }
    public String getEstimatedArrival(Date reference){
        Calendar cal = Calendar.getInstance();
        if(this.plan == 1<<0|| this.plan == 1<<1){
            return ESTIMATION_FORMAT.format(reference.getTime());
        }else if(this.plan == 1<<2){
            cal.setTime(reference);
            cal.add(Calendar.DATE,1);
            return ESTIMATION_FORMAT.format(cal);
        }else if(this.plan == 1<<3){
            cal.setTime(reference);
            cal.add(Calendar.DATE,2);
            return ESTIMATION_FORMAT.format(cal);
        }else{
            cal.setTime(reference);
            cal.add(Calendar.DATE,5);
            return ESTIMATION_FORMAT.format(cal);
        }
    }
    
    public boolean isDuration(Plan reference){
        if((reference.bit & plan) != 0){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isDuration(byte object, Plan reference){
        if((reference.bit & object) != 0){
            return true;
        }else{
            return false;
        }
    }
    public static class Plan
    {
        private final byte bit;

        private Plan(byte bit){
            this.bit = bit;
        }
    }  
}

   
