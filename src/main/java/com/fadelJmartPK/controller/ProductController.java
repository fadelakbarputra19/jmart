package com.fadelJmartPK.controller;

import com.fadelJmartPK.Product;
import com.fadelJmartPK.ProductCategory;
import com.fadelJmartPK.dbjson.JsonTable;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

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
        return Algorithm.paginate(getJsonTable(), page, pageSize,pred->pred.accountId == id);
    }

    @PostMapping("/create")
    @ResponseBody
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
        for(Product each : productTable) {
            if (each.accountId == accountId){
                Product product =  new Product(accountId, accountId, name, weight, conditionUsed, price, discount, category, shipmentPlans);
                productTable.add(product);
                return product;
            }
        }
        return null;
    }

    @SuppressWarnings("null")
	@GetMapping("/getFiltered")
    @ResponseBody
    List<Product> getProductByFilter
            (
                    @RequestParam int page,
                    @RequestParam int pageSize,
                    @RequestParam int accountId,
                    @RequestParam String search,
                    @RequestParam int minPrice,
                    @RequestParam int maxPrice,
                    @RequestParam ProductCategory category
            )
    {
        List<Product> tempProduct = null;
        for (Product each : productTable) {
            if (each.accountId == accountId)
                if (each.name.contains(search))
                    if (minPrice <= each.price)
                        if (maxPrice >= each.price)
                            if (each.category == category)
                                tempProduct.add(each);
        }
        return tempProduct;
    }
}