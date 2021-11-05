package fadelKmartPK;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
    class Country
    {
    	public String name;
    	public int population;
    	public List<String> listOfStates;
    }
    
    
    /**
    * Main 
    */
    public static void main(String[] args)
    {   
   
        String filepath = "D:\\Materi Teknik Komputer\\Semester 3\\OOP\\Code Praktikum\\jmart\\lib\\city.json"; 
        Gson gson = new Gson();
        try {
        	BufferedReader br = new BufferedReader(new FileReader(filepath));
        	Country  input = gson.fromJson(br, Country.class);
        	System.out.println("name: " + input.name);
        	System.out.println("population: " + input.population);
        	System.out.println("states:");
        	input.listOfStates.forEach(State -> System.out.println(State));
        }
       catch (IOException e){
    	   e.printStackTrace();
       }
    }
}  
  