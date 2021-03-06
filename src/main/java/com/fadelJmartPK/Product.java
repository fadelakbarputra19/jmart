package com.fadelJmartPK;

import com.fadelJmartPK.dbjson.Serializable;

/**
 * Class Product menyediakan detail data untuk tiap product
 *
 * @author Muhammad Fadel Akbar Putra
 * @version 1.0
 */
public class Product extends Serializable
{
    public int accountId;
    public ProductCategory category;
    public boolean conditionUsed;
    public double discount;
    public String name;
    public double price;
    public byte shipmentPlans;
    public int weight;
   
    public Product(int accountId, String name, int weight, boolean conditionUsed, double price, double discount, ProductCategory category, byte shipmentPlans)
    {
        this.accountId = accountId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.shipmentPlans = shipmentPlans;
    }
   public String toString(){ 
        return "name: " + this.name + "\nweight: " + this.weight + "\nconditionUsed: " + this.conditionUsed + "\nprice: " + this.price + "\ndiscount: " + this.discount + "\naccountId: " + this.accountId + "\nshipmentPlans: " + this.shipmentPlans;
    }
}

