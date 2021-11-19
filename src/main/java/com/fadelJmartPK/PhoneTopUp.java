package com.fadelJmartPK;

public class PhoneTopUp extends Invoice{
	public String phoneNumber;
	public Status status;
	
	public PhoneTopUp(int buyerid, int productid, String phoneNumber, double getTotalPay) {
		super(buyerid, productid);
		this.phoneNumber = phoneNumber;
	}
	
	@Override
    public double getTotalPay(Product product) {
        return product.price * product.discount;
    }
}
