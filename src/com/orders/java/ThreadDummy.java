package com.orders.java;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ThreadDummy 
{
	public void writeFile(List<Order>newsList) throws IOException
	{
		File f1= new File("Dummy.txt");
		if(f1.exists())
			f1.delete();
		Files.write(Paths.get("Dummy.txt"), ("OrderId| Description  |DeliveryAddres | Order Date       | Amount   | Delivery Date   |Delivered \r\n").getBytes(), StandardOpenOption.CREATE);
		for (int i = 0; i< newsList.size(); i++)
			{
			Files.write(Paths.get("Dummy.txt"), (newsList.get(i).getOrderId()+"|"+newsList.get(i).getDescription()+"|"+newsList.get(i).getDeliveryAddress()+"|"+newsList.get(i).getOrderDate()+"|"+newsList.get(i).getAmount() +"|"+newsList.get(i).getDeliveryDate()+"|"+newsList.get(i).getDelivered()+"\n").getBytes(), StandardOpenOption.APPEND);
			}
		//System.out.println("Successfully wrote to the file.");
	}
}
