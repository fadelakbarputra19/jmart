package com.fadelJmartPK.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fadelJmartPK.Algorithm;
import com.fadelJmartPK.dbjson.JsonTable;
import com.fadelJmartPK.dbjson.Serializable;

/**
 * BasicGetController is used as a universal get by id, get by page
 * @param <T> generic can be used with all type of data.
 * @author Muhammad Fadel Akbar Putra
 *
 */
@RestController
public interface BasicGetController <T extends Serializable> {
    @GetMapping("/{id}")
    public default T getById (@PathVariable int id){
        return Algorithm.<T>find(getJsonTable(),e -> e.id == id);
    }

    public abstract JsonTable<T> getJsonTable ();

    @GetMapping("/page")
    public default List<T> getPage(int page, int pageSize){
        final JsonTable<T> table = getJsonTable();
        return Algorithm.paginate(table,page,pageSize,o->true);
    }

}