import java.util.Arrays;
import java.util.Iterator;

public class Algorithm {
 private Algorithm() {
  
 }
 
    
 public static <T> int count(T[] array,T value){
 	final Iterator<T> a = Arrays.stream(array).iterator();
 	return count(a, value);
  }
  public static <T> int count(Iterable<T> iterable, T value){
	  final Iterator <T> a = iterable.iterator();
	  return count(a, value);
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
	  final Iterator<T> a = Arrays.stream(array).iterator();
	  return count(a, pred);
  }
 public static <T> int count(Iterable<T> iterable, Predicate<T> pred){
  final Iterator<T> a = iterable.iterator();
  return count(a, pred);
 }
 public static <T> int count(Iterator<T> iterator, Predicate<T> pred){
  return 0;
 }
 
 
 public static <T> boolean exists(T[] array, T value) {
  final Iterator<T> a = Arrays.stream(array).iterator();
  return exists(a, value);
 }
 public static <T> boolean exists(Iterable<T> iterable, T value){
  final Iterator<T> a = iterable.iterator();
  return exists(a, value);
 }
 public static <T> boolean exists(Iterator<T> iterator, T value){
  return false;
 }
 public static <T> boolean exists(T[] array, Predicate<T> pred){
  return false;
 }
 public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred){
  final Iterator <T> a = iterable.iterator();
  return exists(a, pred);
 }
 public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred){
  return false;
 }
 
 
 public static <T> T find(T[] array, T value) {
  final Iterator<T> a = Arrays.stream(array).iterator();
  return find(a, value);
 }
 public static <T> T find(Iterable<T> iterable, T value) {
  final Iterator <T> a = iterable.iterator();
  return find(a, value);
 }
 public static <T> T find(Iterator<T> iterator, T value) {
  return null;
 }
 public static <T> T find(T[] array, Predicate<T> pred) {
  return null;
 }
 public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
  final Iterator <T> a = iterable.iterator();
  return find(a, pred);
 }
 public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
  return null;
 }
 
 
 public static <T> T max(T first, T second) {
  return null;
 }
 public static <T> T min(T first, T second) {
  return null;
 }
}