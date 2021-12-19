package com.fadelJmartPK;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Store akan meminta detail data yang dibutuhkan untuk membuat Store
 *
 * @author Muhammad Fadel Akbar Putra
 * @version 1.0
 */
public class Store
{
    public static final String REGEX_PHONE = "^(\\d{9,12})$";
    public static final String REGEX_NAME = "^(?=^[A-Z])(?![A-Z a-z]{20,})((?=[A-Z a-z]{4,}).)((?!\\s{2}).)*$";
    public String name;
    public String phoneNumber;
    public String address;
    public double balance;
   
   public Store(String name, String address, String phoneNumber, double balance){
       
       this.name = name;
       this.address = address;
       this.phoneNumber = phoneNumber;
       this.balance = balance;
   }
  
   public boolean validate(){
       Pattern a = Pattern.compile(REGEX_NAME);
       Pattern b = Pattern.compile(REGEX_PHONE);
       Matcher c = a.matcher(name);
       Matcher d = b.matcher(phoneNumber);
       if(c.find() == true && d.find() == true){
            return true;
       }else{
           return false;
       }
   }
  
   public String toString() {
	return "nanti";
	   
   }
  
}
