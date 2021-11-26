package com.fadelJmartPK.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fadelJmartPK.Account;
import com.fadelJmartPK.Invoice;
import com.fadelJmartPK.ObjectPoolThread;
import com.fadelJmartPK.Payment;
import com.fadelJmartPK.Product;
import com.fadelJmartPK.Shipment;
import com.fadelJmartPK.dbjson.JsonAutowired;
import com.fadelJmartPK.dbjson.JsonTable;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController {
    public static final long DELIVERED_LIMIT_MS = 100;
    public static final long ON_DELIVERY_LIMIT_MS = 100;
    public static final long ON_PROGRESS_LIMIT_MS = 100;
    public static final long WAITING_CONF_LIMIT_MS = 100;
    @JsonAutowired(value = Payment.class, filepath = "Payment.json")
    public static JsonTable<Payment> paymentTable;
    ObjectPoolThread<Payment> poolThread;

    
    @Override
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    @PostMapping("/create")
    @ResponseBody Payment create
            (
                    @RequestParam int buyerId,
                    @RequestParam int productId,
                    @RequestParam int productCount,
                    @RequestParam String shipmentAddress,
                    @RequestParam byte shipmnetPlan
            )
    {
    	 for (Account eachAccount : AccountController.accountTable){
             if (eachAccount.id == buyerId){
                 for(Product eachProduct : ProductController.productTable){
                     if(eachProduct.id == productId){
                         Payment payment = new Payment(buyerId, productId, productCount, new Shipment(shipmentAddress, 0,shipmnetPlan, null));
                         if(eachAccount.balance >= payment.getTotalPay(eachProduct)){
                             eachAccount.balance -= payment.getTotalPay(eachProduct);
                             paymentTable.add(payment);
                             return payment;
                         }
                     }
                 }
             }
         }
        return null;
    }

    @PostMapping(" /{id}/accept ")
    @ResponseBody boolean accept
            (
                    @RequestParam int id
            )
    {
    	 for(Payment each : paymentTable){
             if(each.id == id){
                 if(each.history.get(each.history.size()-1).status == Invoice.Status.WAITING_CONFIRMATION){
                     each.history.add(new Payment.Record(Invoice.Status.CANCELLED, null));
                     return true;
                 }
             }
         }
        return false;
    }

    @PostMapping(" /{id}/cancel ")
    @ResponseBody boolean cancel
            (
                    @RequestParam int id
            )
    {
    	for(Payment each : paymentTable){
            if(each.id == id){
                if(each.history.get(each.history.size()-1).status == Invoice.Status.WAITING_CONFIRMATION){
                    each.history.add(new Payment.Record(Invoice.Status.CANCELLED, null));
                    return true;
                }
            }
        }
        return false;
    }

    @PostMapping(" /{id}/submit ")
    @ResponseBody boolean submit
            (
                    @RequestParam int id,
                    @RequestParam String receipt
            )
    {
    	for(Payment each : paymentTable){
            if(each.id == id){
                if(each.history.get(each.history.size()-1).status == Invoice.Status.ON_PROGRESS){
                    if(!receipt.isBlank()){
                        each.shipment.receipt = receipt;
                        each.history.add(new Payment.Record(Invoice.Status.ON_DELIVERY, null));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @SuppressWarnings("unused")
	private static boolean timekeeper(Payment payment){
    	 Payment.Record record = payment.history.get(payment.history.size() - 1);
         long elapsed = System.currentTimeMillis() - record.date.getTime();
         if (record.status.equals(Invoice.Status.WAITING_CONFIRMATION) && (elapsed > WAITING_CONF_LIMIT_MS)) {
             record.status = Invoice.Status.FAILED;
             return true;
         } else if (record.status.equals(Invoice.Status.ON_PROGRESS) && (elapsed > ON_PROGRESS_LIMIT_MS)) {
             record.status = Invoice.Status.FAILED;
             return true;
         } else if (record.status.equals(Invoice.Status.ON_DELIVERY) && (elapsed > ON_PROGRESS_LIMIT_MS)) {
             record.status = Invoice.Status.FINISHED;
             return true;
         } else if (record.status.equals(Invoice.Status.FINISHED) && (elapsed > DELIVERED_LIMIT_MS)) {
             record.status = Invoice.Status.FINISHED;
             return true;
         } else {
             return false;
         }
    }
}