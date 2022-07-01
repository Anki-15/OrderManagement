package com.orders.java;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;

public class OrderManagementImpl extends Thread implements OrderManagement
	{
	Scanner sc= new Scanner(System.in);
	String orderId;
	String description;
	String deliveryAddress;
	LocalDateTime orderDate;
	double amount;
	LocalDateTime deliveryDate;
	String delivered;
	List<Order>ordersList=new ArrayList<Order>();
	
	
	@Override
	public List<Order> addOrder(List<Order> ordersList)
		{
		Order order=new Order();
		System.out.println("enter Order Id");
		orderId=sc.next();
		for(int i=0;i<ordersList.size();i++)
		{
			if(ordersList.get(i).getOrderId().contains(orderId))
			{
				System.out.println("enter unique Order Id");
				System.out.println("enter OrderId");
				orderId=sc.next();
			}
		}
		System.out.println("enter Description");
		description=sc.next();
		System.out.println("enter Delivery Address");
		deliveryAddress=sc.next();
		System.out.println("enter Amount");
		amount=sc.nextDouble();
		orderDate= LocalDateTime.now();
		deliveryDate=null;
		delivered="no";
		order.setOrderId(orderId);
		order.setDescription(description);
		order.setDeliveryAddress(deliveryAddress);
		order.setOrderDate(orderDate);
		order.setAmount(amount);
		order.setDeliveryDate(deliveryDate);
		order.setDelivered(delivered);
		
		ordersList.add(order);
		return ordersList;
	}
	
	@Override
		public List<Order> viewOrder(List<Order> ordersList)
		{
			System.out.println("OrderId| Description  |DeliveryAddres | Order Date       | Amount   | Delivery Date   |Delivered ");
				for(int i=0;i<ordersList.size();i++)
				{
				System.out.println(ordersList.get(i).getOrderId()+"       | "+ordersList.get(i).getDescription()+" | "+ordersList.get(i).getDeliveryAddress()+" | "+ ordersList.get(i).getOrderDate()+" | "+ordersList.get(i).getAmount()+" | "+ordersList.get(i).getDeliveryDate() +" | "+ordersList.get(i).getDelivered());
				}
		return ordersList;
		}
	
	
		public void viewOrder(List<Order> ordersList,String id)
		{
			for(int i=0;i<ordersList.size();i++)
				{
					if (ordersList.get(i).getOrderId().compareToIgnoreCase(orderId)==0)
					{
					System.out.println("OrderId : "+ordersList.get(i).getOrderId());
					System.out.println("Description : "+ordersList.get(i).getDescription());
					System.out.println("Delivery Address : "+ordersList.get(i).getDeliveryAddress());
					System.out.println("Order Date : "+ordersList.get(i).getOrderDate());
					System.out.println("Amount : "+ordersList.get(i).getAmount());
					System.out.println("Delivery date : "+ordersList.get(i).getDeliveryDate());
					System.out.println("Delivered : "+ordersList.get(i).getDelivered());
					}
				}
	}
	
	@Override
	public void sortOrder(List<Order> ordersList, int ch,int option)
		{
		switch(ch)
			{
			case 1:
				ordersList.sort((o1,o2) -> o1.getOrderId().compareTo(o2.getOrderId())*option);
				for(Order obj : ordersList)
				{
				System.out.println(obj.getOrderId() + " | " + obj.getDescription() + " | " + obj.getDeliveryAddress()  + " | " + obj.getOrderDate() + " | " +obj.getAmount() + " | " + obj.getDeliveryDate());
				}
			break;
			case 2:
				ordersList.sort((o1,o2) -> o1.getDescription().compareTo(o2.getDescription())*option);
				for(Order obj : ordersList)
				{
				System.out.println(obj.getOrderId() + " | " + obj.getDescription() + " | " + obj.getDeliveryAddress()  + " | " + obj.getOrderDate() + " | " +obj.getAmount() + " | " + obj.getDeliveryDate());
				}
			break;
			case 3:
				ordersList.sort((o1,o2) -> o1.getDeliveryAddress().compareTo(o2.getDeliveryAddress())*option);
				for(Order obj : ordersList)
				{
				System.out.println(obj.getOrderId() + " | " + obj.getDescription() + " | " + obj.getDeliveryAddress()  + " | " + obj.getOrderDate() + " | " +obj.getAmount() + " | " + obj.getDeliveryDate());
				}
			break;
			case 4:
				ordersList.sort((o1,o2) -> o1.getOrderDate().compareTo(o2.getOrderDate())*option);
				for(Order obj : ordersList)
				{
				System.out.println(obj.getOrderId() + " | " + obj.getDescription() + " | " + obj.getDeliveryAddress()  + " | " + obj.getOrderDate() + " | " +obj.getAmount() + " | " + obj.getDeliveryDate());
				}
			break;
			case 5:
				Collections.sort(ordersList, new Comparator<Order>() {;
				@Override
				public int compare(Order o1, Order o2) {
				return Double.compare(o1.getAmount(),o2.getAmount())*option;
				}
				});
			break;
			}
	}
	
	@Override
	public List<Order> deleteOrder(List<Order> ordersList, String value)
		{
			for(int i=0;i<ordersList.size();i++)
			{
					if(ordersList.get(i).getOrderId().contains(value))
						{
						ordersList.remove(i);
						System.out.println("deleted successfully");
						}
					
				
			}
			
			
			
			
		return ordersList;
	}
	
	@Override
	public List<Order> markAsDelivered(List<Order> ordersList, String value)
		{
			
		for(int i=0;i<ordersList.size();i++)
				{
					if(ordersList.get(i).getOrderId().contains(value))
					{
						if(ordersList.get(i).getDelivered().equals("no"))
						{
						delivered="yes";
						ordersList.get(i).setDeliveryDate(LocalDateTime.now());
						ordersList.get(i).setDelivered(delivered);
						System.out.println("successfully marked as delivered");
						}
						else
						System.out.println("already delivered on "+ordersList.get(i).getDeliveryDate());
					}
				}
		return ordersList;
	}
	
	@Override
	public void generateReport(List<Order> ordersList)
		{
			OrderManagementImpl order1= new OrderManagementImpl();
			List<Order>newList= new ArrayList<>();
			newList=ordersList.stream().filter(i -> i.getDelivered().equals("yes")).collect(Collectors.toList());
			ThreadDummy d1= new ThreadDummy();
			try {
				d1.writeFile(newList);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);

		    ReaderThread reader = new ReaderThread(queue);
		    WriterThread writer = new WriterThread(queue);

		    new Thread(reader).start();
		    new Thread(writer).start();
		    
		    System.out.println("written");
			
		}


}

