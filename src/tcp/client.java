package tcp;

import java.net.*;
import java.io.*;

public class client {
	public static void main(String[] args) throws Exception {
		// create client Socket
		Socket s = new Socket("localhost", 1534);
		// accept file name from keyboard
		BufferedReader k = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter file name:  ");
		String filename = k.readLine();
		// send file name to server using DataOutputStream
		DataOutputStream d = new DataOutputStream(s.getOutputStream());
		d.writeBytes(filename + "\n");
		// to read data sent from server
		BufferedReader i = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String st;
		// read first line from server into st
		st = i.readLine();
		// if file is found on server side, then send "Yes" else "No"
		if (st.equals("Yes")) {
			// read and display the file contents coming from Server
			while ((st = i.readLine()) != null)
				System.out.println(st);
			// close all connections
			i.close();
			d.close();
			k.close();
			s.close();
		} else
			System.out.println("File not found");
	}
}
