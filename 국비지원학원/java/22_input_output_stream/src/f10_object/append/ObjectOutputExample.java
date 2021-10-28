package f10_object.append;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputExample {

	public static void main(String[] args) throws Exception{
		File file = new File("person.dat");
		ObjectOutputStream oos = new ObjectOutputStream(
						new FileOutputStream(file,true)
					);
		Player p = new Player();
		p.setpNum(1);
		p.setNick("신");
		p.setLevel(1);
		oos.writeObject(p);
		
		Player p1 = new Player();
		p1.setpNum(2);
		p1.setNick("포세이돈");
		p1.setLevel(25);
		oos.writeObject(p1);
		
		oos.flush();
		oos.close();
		System.out.println("작성완료");
	}

}




