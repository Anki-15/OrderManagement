package com.orders.java;
import java.io.File;
import java.util.ArrayList;
import java.io.*;

public class ThreadManager extends Thread 
{

    public void run() 
    {
        try 
        {
            BufferedReader br = null;
            String line;
            String fileNme = "Dummy.txt";
            ArrayList<String> fileLines = new ArrayList<>();
            int numLine = 0;

            File outFile = new File("$$$$$$$$.tmp");

            // input
            FileInputStream fis = null;
            PrintWriter out = null;

   //From here is a critical section

                fis = new FileInputStream(fileNme);


            // output
                FileOutputStream fos = new FileOutputStream(outFile);
                out = new PrintWriter(fos);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
        

            try 
            {
                while ((line = in.readLine()) != null) 
                {
                    fileLines.add(line);
                }
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        
            if (!fileLines.isEmpty()) {
                int middleLine = (int) Math.round(fileLines.size() / 2);
                fileLines.add(middleLine, Thread.currentThread().getName());

                for (int i = 0; i < fileLines.size(); i++) {
                    out.println(fileLines.get(i));
                }

                out.flush();
                out.close();
                try {
                    in.close();
                    new File(fileNme).delete();
                    outFile.renameTo(new File(fileNme));
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
    }
}
          

//end critical section
      
        
