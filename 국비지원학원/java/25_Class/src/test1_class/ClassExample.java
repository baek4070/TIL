package test1_class;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassExample {

	public static void main(String[] args) throws ClassNotFoundException {
		// Object가 가지고 있는 정적멤버 class 변수
		// 객체 설계 정보를 가지고 옴
		Class<? extends Person> pClass1 = Person.class;
		// class의 이름 정보 (package를 포함하는 class 이름이 전체 이름)
		System.out.println(pClass1.getName());
		
		Person person =new Person("a");
		System.out.println(person);
		
		Class<? extends Person> pClass2 = person.getClass();
		System.out.println(pClass2.getName());
		//class 파일이 위치한 정보를 가지고
		//class 설계 정보를 반환
		
		Class<?> pClass3 = Class.forName("test1_class.Person");
		
		System.out.println(pClass3.getName());
		System.out.println(pClass3.getSimpleName());
		System.out.println(pClass3.getPackage().getName());
		
		//class에 정의된 Field(전역변수) 정보 제공
		// java.lang.reflact
		Field[] fields = pClass3.getDeclaredFields();
		System.out.println("Fields ==========================");
		for (Field f : fields) {
			System.out.print(f.getModifiers()+"\t"); // 필드의 접근 제한자 //상수값으로 반환
			System.out.print(Modifier.toString(f.getModifiers())+"\t"); // 필드의 접근 제한자 
			System.out.print(f.getType().getSimpleName()+"\t");// 필드의 타입
			System.out.println(f.getName()); // 필드의 이름
		}
		System.out.println();
		
		//class에 정의된 생성자 정보 제공
		System.out.println("Constructors ====================================");
		// import java.lang.reflect.Constructor
		Constructor<?>[] cons = pClass3.getDeclaredConstructors();
		for (Constructor<?> c : cons) {
			System.out.print(c.getName()+"(");
			Class<?>[] param = c.getParameterTypes();
			for (int i = 0; i < param.length; i++) {
				System.out.print(param[i].getName()+" ");
			}
			System.out.println(")");
		}
		
		System.out.println();
		System.out.println("Methods =========================================");
		// java.lang.reflect.Method
		Method[] methods = pClass3.getDeclaredMethods();
		// 접근제한자   반환타입    패키지.클래스.메소드
		System.out.println(methods[0]);
		for (Method m : methods) {
			System.out.println(m);
			System.out.print(Modifier.toString(m.getModifiers()));
			System.out.print("\t"+m.getReturnType()+"\t"+m.getName());
			System.out.print("(");
			Class<?>[] param = m.getParameterTypes();
			for (int i = 0; i < param.length; i++) {
				System.out.print(param[i].getName()+" ");
			}
			System.out.println(")");
		}
		
		System.out.println("instance 생성===========");
		
		try {
			Person p 
				= (Person)Class.forName("test1_class.Person").newInstance();
			p.setName("우리집");
			p.setAge(20);
			System.out.println(p);
			Person p1 = (Person)pClass3.getConstructor(String.class).newInstance("우리집");
			System.out.println(p1);
			Person p2 = (Person)pClass3.getConstructor(String.class, int.class).newInstance("남의집",30);
			System.out.println(p2);
		} catch (InstantiationException e) {
			// 객체 설계 정보는 있으나 객체 생성이 불가능 할때 발생하는 오류
			// 추상클래스, 인터페이스 이러한 설계정보를 가진 class는
			// 자체만으로 객체 생성이 불가하니 생성 할 수없다고 발생하는 예외
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// class정보도 존재하고 일반 클래스이지만
			// 객체를 생성하기위해서 생성자를 호출 할 수 없다.
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// 해당 되는 패키지에 해당되는 class이름을 가진 설계도를 찾지 못함.
			e.printStackTrace();
		} catch(IllegalArgumentException e) {
			//동일한 타입의 인자값이 전달 되지 않았을떄
			e.printStackTrace();
		} catch(InvocationTargetException e) {
			//설계 정보가 잘못되었을때 - 발생하는 오류
		} catch(NoSuchMethodException e) {
			// 동일한 매개변수를 가진 생성자를 찾지 못했을떄
		}
		
	}

}
