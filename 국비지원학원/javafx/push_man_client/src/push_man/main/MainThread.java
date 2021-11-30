package push_man.main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import push_man.member.MemberController;
import push_man.vo.MemberVO;

public class MainThread extends Thread {
	
	public MemberController memberController;
	

	// Server에서 발신한 내용을 Receive
	@Override
	public void run() {
		ObjectInputStream ois = null;
		try {
			while(true) {
				if(isInterrupted()) {break;}
				Object obj =null;
				ois = new ObjectInputStream(
						ClientMain.socket.getInputStream()
					);
				if((obj = ois.readObject()) != null) {
					System.out.println(obj);
					if(obj instanceof MemberVO) {
						// 회원관련 요청 처리 결과
						memberController.receiveData((MemberVO)obj);
					}
				}
			}
		} catch (Exception e) {
			
		}
	}
	
	public void sendData(Object o) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(
					ClientMain.socket.getOutputStream()
				);
			oos.writeObject(o);
			oos.flush();
		} catch (IOException e) {
			
		}
	}
	
}





