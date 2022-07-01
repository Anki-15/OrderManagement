package com.orders.java;

import java.util.List;

public interface OrderManagement
{
List<Order> addOrder(List<Order> ordersList);
List<Order> viewOrder(List<Order> ordersList);
void sortOrder(List<Order> ordersList,int value,int option);
List<Order> deleteOrder(List<Order> ordersList,String value);
List<Order> markAsDelivered(List<Order> ordersList,String value);
void generateReport(List<Order> ordersList);
}
