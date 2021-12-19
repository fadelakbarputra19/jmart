package com.fadelJmartPK;


/**
 * ProcuctRating akan memberikan perhitungan untuk rating product
 *
 * @author Muhammad Fadel Akbar Putra
 * @version 1.0
 */
public class ProductRating
{
   private long total;
   private long count;
   
   public ProductRating()
   {
       this.total = 0;
       this.count = 0;
   }
   
   public void insert(int rating)
   {
       total += rating;
       count++;
   }
   
   public double getAverage()
   {
        if (count == 0) return 0.0;
        return (double) total / count;
   }
   
   public long getCount()
   {
       return count;
   }
   
   public long getTotal()
   {
       return total;
   }
}
