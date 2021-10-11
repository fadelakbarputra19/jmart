package fadelKmartPK;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Algorithm {
 private Algorithm() {
  
 }
 
 public static <T> List<T> collect(T[] array , T value){
     final Iterator<T>it = Arrays.stream(array).iterator();
     return collect(it, value);
 }
 public static <T> List<T> collect(Iterable<T>iterable , T value){
     final Iterable<T>e = (Iterable<T>) iterable.iterator();
     return collect(e, value);
 }
 public static <T> List<T> collect(Iterator<T>iterator , T value){
     final Predicate<T> predicate = value::equals;
     return collect(iterator, value);
 }
 public static <T> List<T> collect(T[] array, Predicate<T> pred){
     final Iterator<T> itArray = Arrays.stream(array).iterator();
     return collect(itArray, pred);
 }
 public static <T> List<T> collect(Iterator<T>iterator, Predicate<T> pred) {
     int count = 0;
     while(iterator.hasNext()){
         count++;
     }
     final Predicate<T> predicate = pred::equals;
     return collect(iterator, pred);
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
 public static <T extends Comparable<? super T>> T max(T first, T second) {
     if(first.hashCode()>second.hashCode()){
         return first;
     }else {
         return second;
     }
 }
 
 public static <T extends Comparable<? super T>> T max(T[] array, T value) {
	 T maT = null;
	 int max = 0;
	 for(T i : array) {
		 if(i.hashCode() > max) {
			 max = i.hashCode();
			 maT = i;
		 }
	 }
	 return maT;
 }
 
 public static <T extends Comparable<? super T>> T max(Iterator<T> iterator) {
	 T maT = null;
	 int max = 0;
	 while(iterator.hasNext()) {
		 if(iterator.next().hashCode() > max) {
			 max = iterator.next().hashCode();
			 maT = iterator.next();
		 }
	 }
	 return maT;
 }
 
 public static <T extends Comparable<? super T>> T max(Iterable<T>iterable , T value){
     if(iterable.hashCode()>value.hashCode()){
         return (T) iterable;
     }else {
         return value;
     }
 }
 
 public static <T> T max(T first, T second, Comparator<?super T> comparator) {
	 int res = ((Comparable<T>) first).compareTo(second);
	 return res == -1 ? second : first;
 }
 
 public static <T extends Comparable<? super T>> T max(T[] array, Comparator<?super T>comparator){
     int max = 0;
     T maT = null;
     for (T i : array) {
         if (i.hashCode() > max) {
             max = i.hashCode();
             maT = i;
         }
     }
     return max(array, comparator);
 }
 public static <T extends Comparable<? super T>> T max(Iterator<T>iterator , T value, Comparator<?super T>comparator){
     int res = ((Comparable<T>) iterator).compareTo(value);
     if(iterator.next().hashCode()>value.hashCode()){
         return iterator.next();
     }else {
         return value;
     }
 }
 
 public static <T extends Comparable<? super T>> T min(T first, T second) {
     if(first.hashCode()>second.hashCode()){
         return second;
     }else {
         return first;
     }
 }
 
 public static <T extends Comparable<? super T>> T min(T[] array, T value) {
	 T miT = null;
	 int min = array[0].hashCode();
	 for(T i : array) {
		 if(i.hashCode() > min) {
			 min = i.hashCode();
			 miT = i;
		 }
	 }
	 return miT;
 }
 
 public static <T extends Comparable<? super T>> T min(Iterable<T>iterable){
     Iterator<T> iterator = iterable.iterator();
     int minn = 0;
     T miT = null;
     if (iterator.hashCode() > minn){
         minn = iterator.hashCode();
         miT = (T) iterator;
     }
     return miT;
 }

 public static <T extends Comparable<? super T>> T min(Iterator<T>iterator) {
     int minn = 0;
     T miT = null;
     while(iterator.hasNext()){
         if(iterator.next().hashCode() > minn){
             minn = iterator.next().hashCode();
             miT = (T) iterator;
         }
     }
     return miT;
 }
 
 public static <T> T min(T first, T second, Comparator<?super T> comparator) {
	 int res = ((Comparable<T>) first).compareTo(second);
	 return res == -1 ? second : first;
 }
 
}