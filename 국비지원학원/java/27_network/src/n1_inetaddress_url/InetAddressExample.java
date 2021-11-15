package n1_inetaddress_url;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class InetAddressExample {

	public static void main(String[] args) {
		// InetAddress
		// 연결이나 지정된 위치의 IP또는 port정보를 저장하는 class
		
		// Local / 내컴퓨터 정보 확인
		// java.net.*
		try {
			InetAddress address = InetAddress.getLocalHost();
			// 내컴퓨터 이름
			System.out.println(address.getCanonicalHostName());
			// 내컴퓨터 아이디 주소
			System.out.println(address.getHostAddress());
			// 내컴퓨터 이름/ 아이피 주소
			System.out.println(address);
			
			// naver 아이피 주소 확인
			InetAddress[] iar 
				= InetAddress.getAllByName("www.naver.com");
			for(InetAddress remote : iar) {
				System.out.println("www.naver.com IP 주소 : "+remote.getHostAddress());
			}
			
			InetSocketAddress isa = new InetSocketAddress(
						"192.168.1.113", 80
					);
			System.out.println(isa.getAddress());
			System.out.println(isa.getPort());
			
			
			
			
			
			
			
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}
}






