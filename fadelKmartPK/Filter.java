package fadelKmartPK;

import java.util.ArrayList;

public class Filter {
    public static ArrayList<PriceTag> filterPriceTag(PriceTag[] list, double value, boolean less){
        ArrayList<PriceTag> x = new ArrayList<>();
        for(PriceTag i : list){
            if(less && i.getAdjustedPrice() < value){
                x.add(i);
                
            }
            else{
                x.add(null);
                
            }
        }
        return x;
    }
    public static void filterProductRating(ArrayList<ProductRating> list, double value, boolean less){
        for (int i = 0; i < list.size(); ++i) 
        {
            final ProductRating x = list.get(i);
            if (less && x.getAverage() < value || !less && x.getAverage() >= value)
            {
                list.remove(i);
            }
        }
        
    }
}
