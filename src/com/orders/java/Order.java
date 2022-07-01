package com.orders.java;

import java.time.LocalDateTime;

public class Order
{
  private String orderId;
  private String description;
  private String deliveryAddress;
  private LocalDateTime orderDate;
  private double amount;
  private LocalDateTime deliveryDate;
  String delivered;
	@Override
	public String toString() {
	return orderId + "| " + description + "| " + deliveryAddress
	+ "| " + orderDate + "| " + amount + "|" + deliveryDate + "| "
	+ delivered ;
	}
	public String getDelivered() {
	return delivered;
	}
	public void setDelivered(String delivered) {
	this.delivered = delivered;
	}
	public String getOrderId() {
	return orderId;
	}
	public void setOrderId(String orderId) {
	this.orderId = orderId;
	}
	public String getDescription() {
	return description;
	}
	public void setDescription(String description) {
	this.description = description;
	}
	public String getDeliveryAddress() {
	return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
	this.deliveryAddress = deliveryAddress;
	}
	public LocalDateTime getOrderDate() {
	return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
	this.orderDate = orderDate;
	}
	public double getAmount() {
	return amount;
	}
	public void setAmount(double amount) {
	this.amount = amount;
	}
	public LocalDateTime getDeliveryDate() {
	return deliveryDate;
	}
	public void setDeliveryDate(LocalDateTime deliveryDate) {
	this.deliveryDate = deliveryDate;
	}
}