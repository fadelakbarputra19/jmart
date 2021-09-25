package fadelKmartPK;


/**
 * Write a description of class ShipmentDuration here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ShipmentDuration
{
    public static final ShipmentDuration SAME_DAY = new ShipmentDuration((byte)(1 << 1));
    public static final ShipmentDuration NEXT_DAY = new ShipmentDuration((byte)(1 << 2));
    public static final ShipmentDuration REGULER = new ShipmentDuration((byte)(1 << 3));
    public static final ShipmentDuration KARGO = new ShipmentDuration((byte)(1 << 4));
    private final byte bit;

   private ShipmentDuration(byte bit){
        this.bit = bit;
   }
   public ShipmentDuration(ShipmentDuration...args)
   {
       byte flags = 0;
       for (byte i = 0; i < args.length; i++) {
           flags |= args[i].bit;
       }
       bit = flags; 
   }
   public boolean isDuration(ShipmentDuration reference){
        return (bit & reference.bit) != 0;
   }
}
