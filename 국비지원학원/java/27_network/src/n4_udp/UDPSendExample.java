package n4_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPSendExample {
	public static void main(String[] args) {
		try {
			// 전달할 데이터 정보와 전달될 위치 정보를 가지고
			// data를 전송 하는 역할
			DatagramSocket datagramSocket = new DatagramSocket();
			for(int i=0; i<3; i++) {
				String message = "message - " + i;
				byte[] bytes = message.getBytes();
				DatagramPacket packet = new DatagramPacket(
							bytes,			// 전달될 데이터
							bytes.length,	// 데이터의 크기
											// 전달될 위치
							new InetSocketAddress("192.168.1.113",5001)
						);
				datagramSocket.send(packet);
				System.out.println("[보낸 바이트 수 ] : " + bytes.length+"bytes");
			} //end for
			System.out.println("[발신 완료]");
			datagramSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}






