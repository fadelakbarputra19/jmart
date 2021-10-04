package fadelKmartPK;

import javax.sound.sampled.EnumControl.Type;
import java.util.regex.*;
/**
 * <h1>JMart Program<h1>
 *
 * @author Muhammad Fadel Akbar Putra
 * @version 11-09-2021
 */
public class Jmart
{
    
    
    
    /**
    * Main 
    */
    public static void main(String[] args)
    {
        String REGEX_PHONE = "^(\\d{9,12})$";
        String REGEX_NAME = "^([A-Za-z]{0,20}[A-Za-z]{4,20})$";
        Pattern a = Pattern.compile(REGEX_NAME);
       Pattern b = Pattern.compile(REGEX_PHONE);
       Matcher c = a.matcher("aAs2");
       Matcher d = b.matcher("0");
       if(!(c.find() && d.find())){
            System.out.println("false");
       }else{
          System.out.println("true");
       }
    }
}  
  