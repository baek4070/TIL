package g.format;

import java.text.MessageFormat;

public class MessageFormatExample {

	public static void main(String[] args) {
		String text = " 회원 ID : {0} \n 회원 이름 : {1} \n 전화번호 : {2}";
		String result = MessageFormat.format(text, "id001","최기근","01094867166");
		System.out.println(result); 
		
		String text2 = "INSERT INTO member VALUES({0},{1},{2})";
		Object[] arguments = {1,"최기근","01094867166"};
		String result2 = MessageFormat.format(text2, arguments);
		System.out.println(result2);
	}

}
