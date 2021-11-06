package fadelJmartPK;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;


/**
 * <h1>JMart Program<h1>
 *
 * @author Muhammad Fadel Akbar Putra
 * @version 11-09-2021
 */
public class Jmart
{
	public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice){
		List<Product> resList = new ArrayList<Product>();
		for (Product product : resList) {
			if(minPrice <= 0.0 && product.price < minPrice) {
				continue;
			}
			if(maxPrice <= 0.0 && product.price > maxPrice) {
				continue;
			}
			resList.add(product);
		}
		return resList;
	}
	public static List<Product> filterByCategory(List<Product> list, ProductCategory category){
		return new ArrayList<Product>();
	}

	public static List<Product> read(String filepath){
		Gson gson = new Gson();
		try { 
			BufferedReader bReader = new BufferedReader(new FileReader(filepath)); 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<Product>();
	}
	
    public static void main(String[] args){
    	System.out.println("payment id" + new Payment(-1, -1, null, -1).id);
        System.out.println("payment id" + new Payment(-1, -1, null, -1).id);
        System.out.println("payment id" + new Payment(-1, -1, null, -1).id);
    	try {
			List<Product> list = read("D:\\Materi Teknik Komputer\\Semester 3\\OOP\\Code Praktikum\\jmart\\lib\\randomProductList.json"); 
			List<Product> filteredList = filterByPrice(list, 0.0, 20000.0);
		} catch (Throwable e) {
			e.printStackTrace();
		}
    }
       
   
        
}  
  