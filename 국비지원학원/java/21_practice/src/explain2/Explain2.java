package explain2;

import java.util.ArrayList;
import java.util.Scanner;

public class Explain2 {

	private ArrayList<Nation> store = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);
	
	public Explain2() {
		store.add(new Nation("한국", "서울"));
		store.add(new Nation("프랑스", "파리"));
		store.add(new Nation("그리스", "아테네"));
		store.add(new Nation("중국", "베이징"));
		store.add(new Nation("스페인", "마드리드"));
		store.add(new Nation("영국", "런던"));
		store.add(new Nation("독일", "베를린"));
		store.add(new Nation("러시아", "모스크바"));
	}
	
	public void run() {
		System.out.println("** 수도 맞추기 게임을 시작합니다 ***");
		while (true) {
			System.out.println("입력:1, 퀴즈:2, 종료:3");
			int menu = sc.nextInt();
			switch (menu) {
			case 1 :
				input();
				break;
			case 2 :
				quiz();
				break;
			case 3 :
				System.out.println("게임을 종료합니다.");
				return;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	}
	
	public void input() {
		int n = store.size();
		System.out.println("현재"+n+"개의 나라와 수도가 입력되어 있습니다.");
		a: while (true) {
			System.out.printf("국가 입력(현재 : %d 번째 국가 등록 / q는 종료) ",store.size()+1);
			String country = sc.next();
			if(country.equals("q")) {
				System.out.println("입력을 종료합니다.");
				break;
			}
			System.out.println("수도 입력>>");
			String capital = sc.next();
			Nation nation = new Nation(country, capital);
			boolean isCheck =false;
			if(store.contains(nation)) {
				System.out.println(country+"는 이미 존재합니다.");
				continue;
			}
			/*
			for (int i = 0; i < store.size(); i++) {
				Nation na = store.get(i);
				if (na.getCountry().equals(nation.getCountry())) {
					System.out.println(country+"는 이미 존재합니다.");
					continue a;
				}
			}
			*/
			store.add(nation);
		}
	}
	
	public void quiz() {
		//문제를 낼 나라를 선택
		
		int index = (int)(Math.random()*store.size());
		
		Nation nation = store.get(index);
		String question = nation.getCountry();
		String answer = nation.getCapital();
		System.out.print(question+"의 수도는? ");
		
		//사용자 에게 수도 이름을 입력받음
		String capitalFromUser = sc.next();
		if(answer.equals(capitalFromUser)) {
			System.out.println("정답");
		}else {
			System.out.printf("아닙니다 !! %s의 수도는 %s 입니다 %n",question,answer);
		}
	}
	public static void main(String[] args) {
		new Explain2().run();
	}

}
