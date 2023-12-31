package com.cinemamanage.model;

import javax.validation.constraints.NotEmpty;

public class PaymentMethodBean {
	private String paymentMethodID;
	@NotEmpty(message="")
	private String paymentMethodName;
	@NotEmpty(message="")
	private String paymentMethodPhone;
	

	public String getPaymentMethodName() {
		return paymentMethodName;
	}
	public void setPaymentMethodName(String paymentMethodName) {
		this.paymentMethodName = paymentMethodName;
	}
	public String getPaymentMethodPhone() {
		return paymentMethodPhone;
	}
	public void setPaymentMethodPhone(String paymentMethodPhone) {
		this.paymentMethodPhone = paymentMethodPhone;
	}
	public String getPaymentMethodID() {
		return paymentMethodID;
	}
	public void setPaymentMethodID(String paymentMethodID) {
		this.paymentMethodID = paymentMethodID;
	}
}
