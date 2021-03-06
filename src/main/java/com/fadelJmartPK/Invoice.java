package com.fadelJmartPK;
import java.util.Date;

import com.fadelJmartPK.dbjson.Serializable;

import java.util.ArrayList;

/**
 * Invoice menyimpan data dan history Payment yang dilakukan
 *
 * @author Muhammad Fadel Akbar Putra 
 * @version 1.0	
 */
public abstract class Invoice extends Serializable 
{
	public int buyerId;
	public int complaintId;
	public final Date date;
	public int productId;
	public Rating rating;
	   
	protected Invoice(int buyerId, int productId){
		this.buyerId = buyerId;
		this.productId = productId;
		this.complaintId = -1;
		this.date = new Date();
		rating = Rating.NONE;
	}
	
	public abstract double getTotalPay(Product product);

   public enum Status{
       WAITING_CONFIRMATION,
       CANCELLED,
       ON_PROGRESS,
       ON_DELIVERY,
       COMPLAINT,
       FINISHED,
       FAILED;
   }
   
   enum Rating{
       NONE,
       BAD,
       NEUTRAL,
       GOOD;
   }  
  
}
