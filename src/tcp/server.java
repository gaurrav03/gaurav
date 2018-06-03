package tcp;

import java.net.*;
import java.io.*;
public class server
{
       public static void main(String[] args) throws Exception {
              //create a server socket
              ServerSocket se=new ServerSocket(1534);
              //let the server wait until the connection is accepted by client
              Socket q=se.accept();
              System.out.println("Connection established successfully");
              //to receive file name from client
              BufferedReader v=new BufferedReader(new InputStreamReader(q.getInputStream()));
              //to transfer file contents to client
              DataOutputStream dr=new DataOutputStream(q.getOutputStream());
              //read file name from client
              String g=v.readLine();
              FileReader f=null;
              BufferedReader ff=null;
              //create file class object with file name
              File r=new File(g);
              //test if file exists or not
              if(r.exists()) {
            	  dr.writeBytes("Yes"+ "\n");
                  //attach file to fileReader to read data
                  f=new FileReader(g);
                  //attach FileReader to BufferedReader
                         ff=new BufferedReader(f);
                         String qq;
                  //read from BufferedReader and write to DataOutputStream
                         while((qq=ff.readLine())!=null)
                         {
                               dr.writeBytes(qq+"\n");
                         }
                         dr.close();
                         ff.close();
                         v.close();
                         se.close();
                         q.close();
                         f.close();
              }
            	  
              else
            	  dr.writeBytes("No"+"\n");
       }
}
