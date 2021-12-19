package com.fadelJmartPK.controller;

import com.fadelJmartPK.Product;
import com.fadelJmartPK.ProductCategory;
import com.fadelJmartPK.dbjson.JsonTable;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fadelJmartPK.Account;
import com.fadelJmartPK.Algorithm;
import com.fadelJmartPK.Store;
import com.fadelJmartPK.dbjson.JsonAutowired;
import com.fadelJmartPK.dbjson.JsonTable;
/**
 * Product Controller is used to handle product class
 * @author Muhammad Fadel Akbar Putra
 */
@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product>
{
    @JsonAutowired(value = Product.class,filepath = "Product.json")
    public static JsonTable<Product> productTable;

    @Override
    public JsonTable<Product> getJsonTable() {
        return productTable;
    }

    @GetMapping("/{id}/store")
    @ResponseBody
    List<Product> getProductByStore
            (
                    @RequestParam int id,
                    @RequestParam int page,
                    @RequestParam int pageSize
            )
    {
        return Algorithm.paginate(productTable, page, pageSize,pred->pred.accountId == id);
    }

    @PostMapping("/create")
    Product create
            (
                    @RequestParam int accountId,
                    @RequestParam String name,
                    @RequestParam int weight,
                    @RequestParam boolean conditionUsed,
                    @RequestParam double price,
                    @RequestParam double discount,
                    @RequestParam ProductCategory category,
                    @RequestParam byte shipmentPlans
            )
    {
        for(Account each : AccountController.accountTable) {
            if (each.id == accountId && each.store != null){
                Product product =  new Product(accountId, name, weight, conditionUsed, price, discount, category, shipmentPlans);
                productTable.add(product);
                return product;
            }
        }
        return null;
    }

    @GetMapping("/getFiltered")
    @ResponseBody
    List<Product> getProductByFilter(@RequestParam int page, @RequestParam int pageSize, @RequestParam String search,
                                     @RequestParam int minPrice, @RequestParam int maxPrice, @RequestParam ProductCategory category,
                                     @RequestParam boolean conditionUsed) {
        List<Product> tempProduct = new ArrayList<Product>();
        for (Product iterate : productTable) {
            if (iterate.name.contains(search))
                if (minPrice <= iterate.price)
                    if (maxPrice >= iterate.price)
                        if (iterate.category == category)
                            if (iterate.conditionUsed == conditionUsed)
                                tempProduct.add(iterate);
        }
        return Algorithm.paginate(tempProduct, page, pageSize, pred -> pred.weight != 0);
    }
}