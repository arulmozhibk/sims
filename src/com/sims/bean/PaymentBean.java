package com.sims.bean;

import java.util.Date;

public class PaymentBean {
	
	
	
private int payment_id;
private Date payment_date;
private int	user_id;
private double paid_amount;


public int getPayment_id() {
	return payment_id;
}
public void setPayment_id(int payment_id) {
	this.payment_id = payment_id;
}

public Date getPayment_date() {
	return payment_date;
}
public void setPayment_date(Date payment_date) {
	this.payment_date = payment_date;
}

public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}

public double getPaid_amount() {
	return paid_amount;
}
public void setPaid_amount(double paid_amount) {
	this.paid_amount = paid_amount;
}


}
