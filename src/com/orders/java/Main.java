package com.orders.java;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException
		{
		System.out.println("1.Add Order");
		System.out.println("2.View Order List");
		System.out.println("3.View By Order Id");
		System.out.println("4.Sort Order");
		System.out.println("5.Delete Order by Id");
		System.out.println("6.Mark as Delivered.");
		System.out.println("7.Generate Report");
		System.out.println("8.Exit");
		
		OrderManagementImpl order= new OrderManagementImpl();
		List<Order>ordersList=new ArrayList<Order>();
		Scanner sc= new Scanner(System.in);
		System.out.println("enter choice");
		FileOperations f2= new FileOperations();
		ordersList= f2.createFile(ordersList);
		int choice=sc.nextInt();
	
		while(choice!=9)
		{
			switch(choice)
			{
				case 1:
				    String input="y";
				    while(input.compareToIgnoreCase("y")==0)
				    {
				    ordersList=order.addOrder(ordersList);
				    System.out.println("Do you want to enter more order details(Y/N)\r\n"
				    + "If Y: Enter another order.\r\n"
				    + "If N: Show the menu.\r\n"
				    );
				    
				    input=sc.next();
				    }
			    break;
			    case 2:
			    	order.viewOrder(ordersList);
			       break;
			    case 3:
				    System.out.println("enter the orderId");
				    String or=sc.next();
				    order.viewOrder(ordersList, or);
			    break;
			    case 4:
				    System.out.println("Enter the property based on which you want to sort");
				    System.out.println("1.Order Id");
				    System.out.println("2.Description");
				    System.out.println("3.Delivery Address");
				    System.out.println("4.Order Date");
				    System.out.println("5.Amount");
				    int ch=sc.nextInt();
				    int option;
				    System.out.println("enter the order you want to sort in :"
				    + "A for Ascending"
				    + "D for DEscending");
				    String property = sc.next();
				    if(property.compareToIgnoreCase("A")==0)
				    option=1;
				    else
				    option=-1;
				    order.sortOrder(ordersList, ch, option);
			    break;
			    case 5:
				    String input2="y";
				    while(input2.compareToIgnoreCase("y")==0)
				    {
				    System.out.println("enter the order id that needs to be deleted");
				    String id=sc.next();
				    ordersList=order.deleteOrder(ordersList,id);
				    System.out.println("Do you want to enter more order details(Y/N)\r\n"
				    + "If Y: Enter another order.\r\n"
				    + "If N: Show the menu.\r\n"
				    );
				    input2=sc.next();
				    }
				    break;
			    case 6:
				    String input3="y";
				    while(input3.compareToIgnoreCase("y")==0)
				    {
				    System.out.println("enter the order id that needs to be marked as delivered");
				    String id=sc.next();
				    ordersList=order.markAsDelivered(ordersList, id);
				    System.out.println("Do you want to enter more order details(Y/N)\r\n"
				    + "If Y: Enter another order.\r\n"
				    + "If N: Show the menu.\r\n"
				    );
				    input3=sc.next();
				    }
			    break;
			    case 7:
			    	order.generateReport(ordersList);
			   
			    break;
			    case 8:
					try
					{
					f2.writeFile(ordersList);
					}
					catch (Exception e)
					{
					e.printStackTrace();
					}
					System.exit(0);
				break;
	}
	System.out.println("enter choice");
	choice=sc.nextInt();
	}
	
	
	}

}