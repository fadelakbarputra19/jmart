package com.fadelJmartPK;
import java.util.Date;

import com.fadelJmartPK.dbjson.Serializable;

import java.text.SimpleDateFormat;

/**
 * Class Complaint akan meyimpan pesan berisi komplain berdasarkan tanggal
 *
 * @author Muhammad Fadel Akbar Putra
 * @version 1.0
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
