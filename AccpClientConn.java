package StMarys.AdvComm.AcceptConn;

import java.net.*;
import java.io.*;
import java.net.InetAddress;

public class AccpClientConn
{
 public static void acceptConn() throws Exception
 {
     // Returns the instance of InetAddress containing
     // local host name and address
     InetAddress localhost = InetAddress.getLocalHost();
     System.out.println(" \n\n\t\tMy System IP Address : " +
                   (localhost.getHostAddress()).trim());

     // Find public IP address
     String systemipaddress = "";
     try
     {
         URL url_name = new URL("http://127.0.0.1:8080/");

         BufferedReader sc =
         new BufferedReader(new InputStreamReader(url_name.openStream()));
         
         // reads system IPAddress
         systemipaddress = sc.readLine().trim();
     }
     catch (Exception e)
     {
         systemipaddress = "Cannot Execute Properly";
     }
     System.out.println("\t\tMy Public IP Address: " + systemipaddress +"\n");
 }
}