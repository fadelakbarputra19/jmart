package com.fadelJmartPK.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fadelJmartPK.Algorithm;
import com.fadelJmartPK.Coupon;
import com.fadelJmartPK.Product;
import com.fadelJmartPK.dbjson.JsonTable;

public class CouponController implements BasicGetController<Coupon>{

	public static JsonTable<Coupon> couponTable;
	@Override
	public JsonTable<Coupon> getJsonTable() {
		// TODO Auto-generated method stub
		return couponTable;
	}
	
	 @GetMapping("/{id}/canApply")
	 @ResponseBody
	 boolean canApply
	            (
	                    @RequestParam int id,
	                    @RequestParam double price,
	                    @RequestParam double discount
	            )
	    {
		 for (Coupon coupon : couponTable) {
	            if (coupon.id == id) {
	                return coupon.canApply(price, discount);
	            }
	        }
	        return false;
	    }
	 @GetMapping("/{id}/getAvailable")
	 @ResponseBody
	 List<Coupon> getAvailable
	            (
	                    @RequestParam int page,
	                    @RequestParam int pageSize
	            )
	    {
		return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> pred.isUsed() == false);
	    }
	 @GetMapping("/{id}/isUsed")
	 @ResponseBody
	 boolean isUsed
	            (
	                    @RequestParam int id
	            )
	    {
	        for(Coupon each : couponTable)
	        {
	            if (each.id == id) {
	                return each.isUsed();
	            }
	        }
	        return false;
	    }
}
