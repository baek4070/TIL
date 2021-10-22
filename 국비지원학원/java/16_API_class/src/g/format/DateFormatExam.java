package g.format;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatExam {

	public static void main(String[] args) {
		//1000/1초 단위의 밀리세컨으로
		//시간에대한정보를저장하고
		//문자열로 정보를 알려주는 객체
		//시간정보는 생성자의 매개변수
		//long type 의 시간정보로 결정
		long time =System.currentTimeMillis();
//		Date date = new Date(time);
		//long 타입을 넘겨받음 
		Date date = new Date(); //위의것과 동일함
		System.out.println(date);
		//이건 보기어려우니까 심플데이트포멧 을 알아보자
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//Date 타입의 Date를 전달받아서 지정패턴으로 변경
		String now= sdf.format(date);
		System.out.println(now);
		
		date = new Date(0); // 컴퓨터 기준 최초의 시간
		sdf = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분ss초");
		now = sdf.format(date);
		System.out.println(now);
		//최대~ 
		date = new Date(Long.MAX_VALUE);
		sdf = new SimpleDateFormat("yyyy-MM-dd E요일 HH:mm:ss");
		now = sdf.format(date);
		System.out.println(now);
		
		// 현재시간에 대한 정보를 제공하는 객체
		// Calendar는 new 연산자로 객체생성 불가
		// instance메소드를 이용하여 객체를 받아와서 사용가능
		Calendar cal = Calendar.getInstance();
		//Calendar 클래스의 경우 하나만 사용하게끔 생성자를 못만들게 막아놓음
		//싱글톤 // 즉 읽기전용 
//		new Calendar(); // 안만들어지는 거 확인 ! 
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		// 주중 날짜(요일)
		int day = cal.get(Calendar.DAY_OF_WEEK);
		// 월중 날짜
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		String strWeek = null;
		//Calendar.SUNDAY == 1
		//Calendar.MONDAY == 2
		//...
		switch (day) {
			case Calendar.MONDAY:
				strWeek = "월";
				break;
			case Calendar.TUESDAY:
				strWeek = "화";
				break;
			case Calendar.WEDNESDAY:
				strWeek = "수";
				break;
			case Calendar.THURSDAY:
				strWeek = "목";
				break;
			case Calendar.FRIDAY:
				strWeek = "금";
				break;
			case Calendar.SATURDAY:
				strWeek = "토";
				break;
			case Calendar.SUNDAY:
				strWeek = "일";
				break;
		}
		
		int amPm = cal.get(Calendar.AM_PM);
		String strAmPm = null;
		if(amPm == Calendar.AM) {
			strAmPm = "오전";
		}else {
			strAmPm = "오후";
		}
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE); // 월은 0~ 11까지 표현
		int seconds = cal.get(Calendar.SECOND);
		System.out.println(year+"년");
		System.out.println(month+"월");
		System.out.println(dayOfMonth+"일");
		System.out.println(strWeek+"요일");
		System.out.println(strAmPm+" ");
		System.out.println(hour+"시");
		System.out.println(minute+"분");
		System.out.println(seconds+"초");
	}

}
