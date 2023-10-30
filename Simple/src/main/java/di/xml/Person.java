package di.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import di.tire.Tire;

public class Person {

	public static void main(String[] args) {
		
		//스프링 컨텍스트 객체
		ApplicationContext context = null;
		
		//Bean Configuration XMl 파일을 읽어들여 Spring Context를 구성한다
		context = new FileSystemXmlApplicationContext("/src/main/java/di/xml/di.xml");
		//----------------------------------------------------------------
		
		// Spring Context에 등록된 "car"라는 이름의 스프링 빈을 이용하여
		//Car객체로 사용한다
		Car car = (Car) context.getBean("car");
		car.setTire( (Tire) context.getBean("gTire") );
		
		System.out.println( car );
		System.out.println( car.getInfo() );
		//----------------------------------------------------------------
		System.out.println("---------------");
		
		Car car1 = (Car) context.getBean("car");
		car1.setTire( (Tire) context.getBean("sTire") );
		
		System.out.println("car1 : " + car1);
		System.out.println("car1 info : " + car1.getInfo());
		
		//----------------------------------------------------------------
		System.out.println("---------------");
		
		Car car2 = (Car) context.getBean("car");
		car2.setTire( (Tire) context.getBean("gTire") );
		
		System.out.println("car2 : " + car2);
		System.out.println("car2 info : " + car2.getInfo());
		
		//----------------------------------------------------------------
		System.out.println("---------------");
		
		Car c2 = (Car) context.getBean("car2");
		Car c3 = (Car) context.getBean("car3");

		System.out.println("c2 : " + c2);
		System.out.println("c2 info : " + c2.getInfo());
		System.out.println("c3 : " + c3);
		System.out.println("c3 info : " + c3.getInfo());
	}
	
}













