package combination;
//클래스 밖에는 package 와 import, subClass 말고는 정의가 안된다
//main method 가 존재하는 실행 class

	   // (ClassA = ClassA.java) 파일 이름이랑 일치!! 
public class ClassA { // 자 여기가 클래스 선언부입니다
	//-----------------------------------Field----------------------------------------------
    //여기부터 ~~~~~~~~ 					// Field를 지칭하는 말이 여러가지 짬뽕입니다 잘알아들으세요
	int deskNum; //class의 책상수			// Field, attribute, property
	double scoreAvrg;//class의 평균성적		// 전역 변수
	boolean isOpen;//class 개방여부		// 객체(인스턴스)의 멤버 변수 
	String catchphrase; //class 의 대표문구
	//---------------------------------------------------------------------------------------
	
}
class GroupA{ // 클래스 GroupA 하나더 만들어 보것습니다
	int badStudentNum;
	int goodStudentNum;
	int smartStudentNum;
	double goodBadBalance;
}

class TeacherA{ // 클래스 TeacherA 하나더 만들어 보것습니다
	
	String name;		//이름
	int height;			//키
	double weight;		//몸무게
	char gender;		//성별
	boolean isMarried;	//결혼 여부 
	
}
