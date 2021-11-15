package n1_inetaddress_url;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;

public class URLExample {

	public static void main(String[] args) {
		// web 환경 또는 local 환경에서의 특정 자원(resource)의
		// 위치 정보를 저장하는 class
		try {
			URL url = new URL("http://www.naver.com:80/index/index.html?name=java");
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			System.out.println(url.getPort());
			System.out.println(url.getPath());
			System.out.println(url.getQuery());
			System.out.println(url.getFile());
			url = new URL("https://www.naver.com");
			
			try {
				InputStream is = url.openStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				File file = new File("naver.html");
				FileWriter os = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(os);
				
				
				String isLine = "";
				while ((isLine = br.readLine()) != null) { //문자열 형태의 출력되는 데이터를 한줄씩 읽어옴
//					System.out.println(isLine);
					bw.write(isLine);
					bw.newLine(); // 줄바꿈
				}
				bw.flush();
				bw.close();
				os.close();
				
				br.close();
				is.close();
				isr.close();
				
				System.out.println("출력완료");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		} catch (MalformedURLException e) {
			// 해석할 수 없는 Protocol을 매개변수로 전달
			e.printStackTrace();
		}
	}

}
