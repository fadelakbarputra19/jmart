package fadelKmartPK;

import java.util.ArrayList;

public class Filter {
    public static ArrayList<PriceTag> filterPriceTag(PriceTag[] list, double value, boolean less){
        ArrayList<PriceTag> x = new ArrayList<>();
        for(PriceTag i : list){
            if(less && i.getAdjustedPrice() < value){
                x.add(i);
            }
        }
        return null;
    }
    public void filterProductRating(ArrayList<ProductRating> list, double value, boolean less){
      
    }
}
