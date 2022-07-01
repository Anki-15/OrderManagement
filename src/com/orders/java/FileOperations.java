package com.orders.java;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileOperations 
{
	
	public void writeFile(List<Order>ordersList) throws IOException
	{
		File f1= new File("OrderManagement.txt");
		if(f1.exists())
			f1.delete();
		Files.write(Paths.get("OrderManagement.txt"), ("OrderId| Description  |DeliveryAddres | Order Date       | Amount   | Delivery Date   |Delivered \r\n").getBytes(), StandardOpenOption.CREATE);
		for (int i = 0; i< ordersList.size(); i++)
			{
			Files.write(Paths.get("OrderManagement.txt"), (ordersList.get(i).getOrderId()+"|"+ordersList.get(i).getDescription()+"|"+ordersList.get(i).getDeliveryAddress()+"|"+ordersList.get(i).getOrderDate()+"|"+ordersList.get(i).getAmount() +"|"+ordersList.get(i).getDeliveryDate()+"|"+ordersList.get(i).getDelivered()+"\n").getBytes(), StandardOpenOption.APPEND);
			}
		System.out.println("Successfully wrote to the file.");

	}
		
		public  List<Order> createFile(List<Order> ordersList)
		{
			try 
			{
				File tempFile = new File("OrderManagement.txt");
				boolean exists = tempFile.exists();
				if(exists==true)
				{
					ordersList=readFile();
					return ordersList;
				}
			 } 
			catch (Exception e)
				{
			      System.out.println("File Exists.");
			    }
			return ordersList;
		}
		public ArrayList<Order> readFile()
		{
			Stream<String> lines;
			try {
				lines = Files.lines(Paths.get("OrderManagement.txt"));
				List<String> result = lines.collect(Collectors.toList());
				ArrayList<Order> list = new ArrayList<Order>();
				Order O[] = new Order[result.size()-1];
				//System.out.println(result.size());
				for(int i=1;i<result.size();i++)
				{
					String s=result.get(i);
					O[i-1] = new Order();
					s = s.replace("|",",");
					String[] s2 = new String[7];
							s2=s.split(",",7);
							
						O[i-1].setOrderId(s2[0]);
						O[i-1].setDescription(s2[1]);
						O[i-1].setDeliveryAddress(s2[2]);
						O[i-1].setAmount(Double.parseDouble(s2[4]));
						O[i-1].setOrderDate(LocalDateTime.parse(s2[3]));
						if (!s2[5].contains("null")) {
							O[i-1].setDeliveryDate(LocalDateTime.parse(s2[5]));
							}
						O[i-1].setDelivered(s2[6]);
				}
				list.addAll(Arrays.asList(O));
				return list;				
				
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("File Read Failed. Please Verify");
				return null;
				
			}		
		}
		
	 }


