package fadelKmartPK;


/**
 * Write a description of class Recognizable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Recognizable implements Comparable<Recognizable>
{
  public int id;
  
  public static <T> int setClosingId(Class<T> clazz, int id) {
	  if(Class.class.isAssignableFrom(Recognizable.class)) {
		  return 0;
	  }else {
		  return 1;
	  }
	 
  }
  
  public static <T> int getClosingId(Class<T> clazz) {
	  if(Class.class.isAssignableFrom(Recognizable.class)) {
		  return 0;
	  }
	  else {
		  return 1;
	  }
}
  
  protected Recognizable(int id){
      this.id = id;
  
  }
  
  public boolean equals(Object object){
      if(object instanceof Recognizable){
          return equals(object);
      }
      else{
        return false;
      }
  }
  
  public boolean equals(Recognizable recognizable){
     return this.id == recognizable.id; 
  }

  @Override
  public int compareTo(Recognizable other) {

      return Integer.compare(this.id, other.id);
  }
}
