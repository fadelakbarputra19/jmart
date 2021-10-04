package fadelKmartPK;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a description of class Account here.
 *
 * @author 
 * @version (a version number or a date)
 */
public class Account extends Recognizable implements FileParser
{
    public static final String REGEX_EMAIL = "^\\w+([.&`~-]?\\w+)*@\\w+([.-]?\\w+)+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{8,}$";
    public String name;
    public String email;
    public String password;
    
    public Account(int id, String name, String email, String password){
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
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

    @Override
    public boolean read(String content){
        return true;
    }


}
