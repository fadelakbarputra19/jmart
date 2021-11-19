package com.fadelJmartPK;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a description of class Account here.
 *
 * @author 
 * @version (a version number or a date)
 */
public class Account extends Serializable 
{
    public static final String REGEX_EMAIL = "^\\w+([.&`~-]?\\w+)*@\\w+([.-]?\\w+)+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{8,}$";
    public String name;
    public String email;
    public String password;
    public double balance;
    public Store store;
    
    public Account(String name, String email, String password, double balance){
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }
    
    public boolean validate(){
        Pattern a = Pattern.compile(REGEX_EMAIL);
        Pattern b = Pattern.compile(REGEX_PASSWORD);
        Matcher c = a.matcher(name);
        Matcher d = b.matcher(email);
        if(c.find() == true && d.find() == true){
             return true;
        }else{
            return false;
        }
    }

}
