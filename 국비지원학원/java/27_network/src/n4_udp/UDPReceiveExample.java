package n4_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiveExample {
	public static void main(String[] args) throws Exception {
		DatagramSocket datagramSocket = new DatagramSocket(5001);
		
		Thread t = new Thread() {
			@Override
			public void run() {
				System.out.println("[수신 시작]");
				try {
					while(true) {
						DatagramPacket packet 
							= new DatagramPacket(new byte[100],100);
						datagramSocket.receive(packet);
						String data = new String(packet.getData(),0,packet.getLength());
						System.out.println("[ 받은 내용 : " + packet.getSocketAddress()+"]"+data);
					}
				} catch (Exception e) {
					System.out.println("수신종료");
				}
			}
		};
		t.start();
		Thread.sleep(30000);
		datagramSocket.close();
	}
}





