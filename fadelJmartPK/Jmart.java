package fadelJmartPK;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

/**
 * <h1>JMart Program<h1>
 *
 * @author Muhammad Fadel Akbar Putra
 * @version 11-09-2021
 */
public class Jmart
{
	public static long DELIVERED_LIMIT_MS = 1;
	public static long ON_DELIVERY_LIMIT_MS = 2;
	public static long ON_PROGRESS_LIMIT_MS = 3;
	public static long WAITING_CONF_LIMIT_MS = 4;
	private static Invoice.Status status;
    
	public static boolean paymentTimekeeper(Payment payment){
        long startTime = System.currentTimeMillis();
        if(System.currentTimeMillis() - startTime > WAITING_CONF_LIMIT_MS){
            payment.history.add(new Payment.Record(Invoice.Status.FAILED, "FAILED"));
        }
        else if(System.currentTimeMillis() - startTime > ON_PROGRESS_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.FAILED, "FAILED"));
        }
        else if(System.currentTimeMillis() - startTime > ON_DELIVERY_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.ON_DELIVERY, "ON_DELIVERY"));
        }
        else if(System.currentTimeMillis() - startTime > DELIVERED_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.FINISHED, "DELIVERED"));
            return true;
        }
        return false;
    }
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
    	try {
			JsonTable<Payment> table = new JsonTable<>(Payment.class, "D:\\Materi Teknik Komputer\\Semester 3\\OOP\\Praktikum\\Modul 7\\randomPaymentList.json");
			ObjectPoolThread<Payment> paymentPool = new ObjectPoolThread<Payment>("Thread-PP", Jmart::paymentTimekeeper);
			 paymentPool.start();
	            table.forEach(payment -> paymentPool.add((Payment) payment));
	            while (paymentPool.size() != 0);
	            paymentPool.exit();
	            while (paymentPool.isAlive());
	            System.out.println("Thread exit successfully");
	            Gson gson = new Gson();
	            table.forEach(payment -> {
	                String history = gson.toJson(payment);
	                System.out.println(history);
	            });
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
  