package a.basic;
@FunctionalInterface // @FunctionalInterface해당 어노테이션은 함수형인터페이스인지 검증해주는 역할
public interface MyInterface {
	void method(); // 이런걸 함수형인터페이스 라고합니다 인터페이스 가 곧 메소드다 ! 라는겁니다
//	void method2();// 하나 더 정의하면 @FunctionalInterface 어노테이션이 문법적으로 오류를 발생 시켜줍니다
}
