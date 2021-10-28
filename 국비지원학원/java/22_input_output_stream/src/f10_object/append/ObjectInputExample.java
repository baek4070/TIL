package f10_object.append;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputExample {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("person.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			while(true) {
				try {
					Player p = (Player)ois.readObject();
					System.out.println(p);
				} catch (Exception e) {
					System.out.println("다 읽어옴"+e.getMessage());
					break;
				}
			}
			ois.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}










