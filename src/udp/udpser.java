package udp;

import java.net.*;
import java.util.Scanner;

public class udpser {
	public static void main(String[] args) {
		DatagramSocket skt = null;
		Scanner sc = new Scanner(System.in);
		try {
			skt = new DatagramSocket(6794);
			byte[] buffer = new byte[1000];
			System.out.println("enter server message");
			while (true) {

				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				skt.receive(request);
				String message;
				message = sc.next();
				byte[] sendMsg = message.getBytes();
				DatagramPacket reply = new DatagramPacket(sendMsg, sendMsg.length, request.getAddress(),request.getPort());
				skt.send(reply);
			}
		} catch (Exception ex) {
		}
	}
}
