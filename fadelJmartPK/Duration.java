package fadelJmartPK;


/**
 * Write a description of class ShipmentDuration here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Duration
{
    public static final Duration SAME_DAY = new Duration((byte)(1 << 1));
    public static final Duration NEXT_DAY = new Duration((byte)(1 << 2));
    public static final Duration REGULER = new Duration((byte)(1 << 3));
    public static final Duration KARGO = new Duration((byte)(1 << 4));
    private final byte bit;

   private Duration(byte bit){
        this.bit = bit;
   }
}
