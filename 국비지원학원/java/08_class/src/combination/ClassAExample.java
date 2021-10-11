package combination;


public class ClassAExample {

	public static void main(String[] args) {
		//----------------------------------declaration ---------------------------------------
		System.out.println("----------------declaration------------------------------------------");
		ClassA choiClass; //선언 // ClassA 클래스에 choiClass 객체라는 객체 선언 ! 
//		System.out.println(choiClass);// 불가능 지금 초기화가 안되있어서 쓰레기가 잔뜩 차있어
		choiClass = new ClassA(); //ClassA 클래스를 참조하여 	choiClass 객체 생성
		System.out.println("ClassA class 를 참조하여 choiClass 객체 생성" + choiClass);
		ClassA baekClass = new ClassA();
		System.out.println("ClassA class 를 참조하여 baekClass 객체 생성" + baekClass);
		//choiClass, baekClass에 생성된 주소값이 저장됨 
		GroupA firstGroup = null; // GroupA 클래스에서 firstGroup 이란 객체의  stack에 null값을 넣습니다
		firstGroup = new GroupA(); // 객체 firstGroup GroupA class 를 참조하여 firstGroup 객체 생성 
		System.out.println(firstGroup);
		System.out.println(choiClass == baekClass); // 이건 당연히 다르겟죠 다른반인데 ~  
		//---------------------------------------------------------------------------------------
		//-----------------------------------field-----------------------------------------------
		System.out.println("-----------------field-----------------------------------------------");
		ClassA kimClass = new ClassA(); // ClassA 클래스 에 kimClass 를 선언 함으로서 kimClass를 통해 ClassA 의 field 내부요소에  접근이 가능해짐
		System.out.println(kimClass.catchphrase);	  //기본값이 출력됨  
		System.out.println(kimClass.deskNum);	      //기본값이 출력됨
		System.out.println(kimClass.isOpen);		  //기본값이 출력됨
		System.out.println(kimClass.scoreAvrg);		  //기본값이 출력됨
		
		TeacherA choiTeacher = new TeacherA();  // choiTeacher 이라는 객체(인스턴스) 생성!
		choiTeacher.name = "최기근";				//TeacherA Class 의 필드에 선언 되어있음 ! 
		choiTeacher.height= 184;
		choiTeacher.weight= 70;
		choiTeacher.gender= '남';
		choiTeacher.isMarried= false;			// 선언된 모든항목을 다이용해서 객체 생성해도 되고
		
		TeacherA baekTeacher = new TeacherA();
		baekTeacher.name = "백인광";
		baekTeacher.height= 300;				// 선언된 일부 항목으로만 객체생성해도 됨
												// 그럼 baekTeacher.weight 에는 무슨값이 들어가있나?
												// 기본값이 들어가있습니다
		System.out.printf("이름은 : %s , 키는 %d",choiTeacher.name,choiTeacher.height);
		System.out.printf("\n이름은 : %s , 키는 %d\n",baekTeacher.name,baekTeacher.height);
		System.out.println(baekTeacher.weight); 	// 기본값 들어가있는거 확인 ~
		System.out.println(baekTeacher.gender); 	// 기본값 들어가있는거 확인 ~
		System.out.println(baekTeacher.isMarried);	// 기본값 들어가있는거 확인 ~
		//-----------------------------------method----------------------------------------------
		System.out.println("-----------------method----------------------------------------------");
		
	}

}
