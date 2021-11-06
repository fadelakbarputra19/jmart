package fadelJmartPK;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a description of class Recognizable here.
 *
 * @author 
 * @version (a version number or a date)
 */
public abstract class Serializable implements Comparable<Serializable>
{
    public final int id;
    private static Map<Class<?>, Integer> mapCounter;
    
    protected Serializable()
    {
    	Integer counter = mapCounter.get(getClass());
    	counter = counter == null ? 0 : counter + 1;
    	mapCounter.put(getClass(), counter);
    	this.id = counter;
    }

    public int compareTo(Serializable other) {
        return other.id/this.id;
    }
    
    public boolean equals(Object other) {
        if(!(other instanceof Serializable)){
            Serializable checked = (Serializable)other;
            if(checked.id == this.id){
                return true;
            }
        }
        return false;
    }
    public boolean equals(Serializable other) {
        if(this.id == other.id){
            return true;
        }
        return false;
    }

    public Integer getClosingId(Class<Serializable>clazz){
        return id;
    }

    public void setClosingId(Class<Serializable>clazz, int id){
        //this.id = id;
    }
}
