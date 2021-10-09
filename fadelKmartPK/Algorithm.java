import java.util.Arrays;
import java.util.Iterator;

public class Algorithm {
 private Algorithm() {
  
 }
 
    
 public static <T> int count(T[] array,T value){
 	final Iterator<T> it = Arrays.stream(array).iterator();
 	return count(it, value);
  }
  public static <T> int count(Iterable<T> iterable, T value){
	  final Iterator <T> it = iterable.iterator();
	  return count(it, value);
  }
  public static <T> int count(Iterator<T> iterator, T value){
	  int counter = 0;
	  while(iterator.hasNext()) {
		  if(iterator.next() == value) {
			  counter++;
		  }
	  }
	  return counter;
  }
  public static <T> int count(T[] array, Predicate<T> pred){
	  final Iterator<T> it = Arrays.stream(array).iterator();
	  return count(it, pred);
  }
 public static <T> int count(Iterable<T> iterable, Predicate<T> pred){
  final Iterator<T> it = iterable.iterator();
  return count(it, pred);
 }
 public static <T> int count(Iterator<T> iterator, Predicate<T> pred){
	 int counter = 0;
     if (pred.equals(false)) {
         return 0;
     }else{
         while (iterator.hasNext()){
             counter++;
         }
     }
     return counter;
 }
 public static <T> boolean exists(T[] array, T value) {
  final Iterator<T> it = Arrays.stream(array).iterator();
  return exists(it, value);
 }
 public static <T> boolean exists(Iterable<T> iterable, T value){
  final Iterator<T> it = iterable.iterator();
  return exists(it, value);
 }
 public static <T> boolean exists(Iterator<T> iterator, T value){
	 while (iterator.hasNext()){
         if (iterator.next().equals(value)){
             return true;
         }
     }
     return false;
 }
 public static <T> boolean exists(T[] array, Predicate<T> pred){
	 for (T a : array){
         if(a.equals(pred)){
             return true;
         }
     }
     return false;
 }
 public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred){
  final Iterator <T> it = iterable.iterator();
  return exists(it, pred);
 }
 public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred){
	 while (iterator.hasNext()){
         if (iterator.next().equals(pred)){
             return true;
         }
     }
     return false;
 }
 public static <T> T find(T[] array, T value) {
  final Iterator<T> it = Arrays.stream(array).iterator();
  return find(it, value);
 }
 public static <T> T find(Iterable<T> iterable, T value) {
  final Iterator <T> it = iterable.iterator();
  return find(it, value);
 }
 public static <T> T find(Iterator<T> iterator, T value) {
	 while (iterator.hasNext()){
         if(iterator.next().equals(value)){
             return iterator.next();
         }
     }
     return null;
 }
 public static <T> T find(T[] array, Predicate<T> pred) {
	 for (T a : array){
         if(a.equals(pred)){
             return a;
         }
     }
     return null;
 }
 public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
  final Iterator <T> it = iterable.iterator();
  return find(it, pred);
 }
 public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
	 while (iterator.hasNext()){
         if(iterator.next().equals(pred)){
             return iterator.next();
         }
     }
     return null;
 }
 public static <T> T max(T first, T second) {
  return null;
 }
 public static <T> T min(T first, T second) {
  return null;
 }
}