package fadelJmartPK;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a description of class Recognizable here.
 *
 * @author 
 * @version (a version number or a date)
 */
public class Serializable implements Comparable<Serializable>
{
    public final int id;
    
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<Class<?>, Integer>();

    protected Serializable() {
        Integer counter = mapCounter.get(getClass());
        counter = counter == null ? 0 : counter + 1;
        mapCounter.put(getClass(), counter);
        this.id = counter;
    }
        
    public static <T> int getClosingId(Class<T> clazz){
        return mapCounter.get(clazz);
    }

    public static <T> int setClosing(Class<T> clazz, int id){
        return mapCounter.put(clazz, id);
    }

    public boolean equals(Object other) {
        return (other instanceof Serializable) && ((Serializable) other).id == id;
    }

    public boolean equals(Serializable other) {
        return other.id == id;
    }

    @Override
    public int compareTo(Serializable other) {
        return Integer.compare(this.id, other.id);
    }
}