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
		List<Product> returnList = new ArrayList<Product>();
        for (Product prod : list) {
            if (prod.category.equals(category)) {
                returnList.add(prod);
            }
        }
        return returnList;
	}

	public static List<Product> read(String filepath) throws FileNotFoundException{
		 Gson gson = new Gson();
	        Type userListType = new TypeToken<ArrayList<Product>>() {
	        }.getType();
	        BufferedReader br = new BufferedReader(new FileReader(filepath));
	        List<Product> returnList = gson.fromJson(br, userListType);
	        return returnList;
	}
	private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred){
		return list.stream().filter(temp -> pred.predicate(temp)).skip(page * pageSize).limit(pageSize).collect(Collectors.toList());
	}
	public static List<Product> filterByAccountId(List<Product> list, int accountId, int page, int pageSize){
		 Predicate<Product> predicate = temp -> (temp.accountId == accountId);
	        return paginate(list, page, pageSize, predicate);
	}
	public static List<Product> filterByName(List<Product> list, int accountId, int page, int pageSize, String search){
		Predicate<Product> predicate = tempName -> (tempName.name.toLowerCase().contains(search.toLowerCase()));
        return paginate(list, page, pageSize, predicate);
	}
    public static void main(String[] args){
    	System.out.println("payment id" + new Payment(-1, -1, null, -1).id);
        System.out.println("payment id" + new Payment(-1, -1, null, -1).id);
        System.out.println("payment id" + new Payment(-1, -1, null, -1).id);
    	try {
			List<Product> list = read("D:\\Materi Teknik Komputer\\Semester 3\\OOP\\Code Praktikum\\jmart\\lib\\randomProductList.json"); 
			List<Product> filteredList = filterByPrice(list, 0.0, 20000.0);
			filteredList.forEach(product -> System.out.println(product.price));
		} catch (Throwable e) {
			e.printStackTrace();
		}
    }
       
   
        
}  
  