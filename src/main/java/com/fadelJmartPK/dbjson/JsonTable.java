package com.fadelJmartPK.dbjson;

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
	private static final Gson gson = new Gson();
    public final String filepath;
    
    @SuppressWarnings("unchecked")
    public JsonTable(Class<T> clazz, String filepath) throws IOException
    {
        this.filepath = filepath;
        try
        {
        	Class<T[]> arrayType = (Class<T[]>) Array.newInstance(clazz, 0).getClass();
            T[] loaded = readJson(arrayType, filepath);
            if (loaded != null)
                Collections.addAll(this, loaded);
        }
        catch (FileNotFoundException e) {}
    }
    
    public void writeJson() throws IOException
    {
    	writeJson(this, this.filepath);
    }

    public static void writeJson(Object object, String filepath) throws IOException
    {
        File file = new File(filepath);
        if (!file.exists())
        {
            File parent = file.getParentFile();
            if (parent != null)
                parent.mkdirs();
            file.createNewFile();
        }
        final FileWriter writer = new FileWriter(filepath);
        writer.write(gson.toJson(object));
        writer.close();
    }

    public static <T> T readJson(Class<T> clazz, String filepath) throws FileNotFoundException
    {
        final JsonReader reader = new JsonReader(new FileReader(filepath));
        return gson.fromJson(reader, clazz);
    }
}
