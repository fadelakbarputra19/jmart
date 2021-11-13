package fadelJmartPK;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

@SuppressWarnings({ "serial", "rawtypes" })
public class JsonTable<T> extends Vector{
	 public final String filepath;
	 private static final Gson gson = new Gson();
	 
	 @SuppressWarnings("unchecked")
	public JsonTable(Class<T> clazz, String filepath)throws IOException{
		 this.filepath = filepath;
		 try {
			 Class<T[]> arrayType = (Class <T[]>) Array.newInstance(clazz, 0).getClass();
			 T[] loaded = JsonTable.readJson(arrayType, filepath);
			 if(loaded != null) {
				 Collections.addAll(this, loaded); 
			 }
		} catch (Exception e) {
			File file = new File(filepath);
		}
		 
	 }
	public static <T> T readJson(Class <T> clazz, String filepath)throws FileNotFoundException {
		final JsonReader bacaJsonReader = new JsonReader(new FileReader(filepath));
		return gson.fromJson(bacaJsonReader, clazz);
	}
	public void writeJson()throws IOException{
		writeJson(this, this.filepath);
	}
	public static void writeJson(Object object, String filepath)throws IOException {
		final FileWriter writer = new FileWriter(filepath);
		writer.write(gson.toJson(object));
		writer.close();
	}
}
