package di.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Person {
	public static void main(String[] args) {
		
		//스프링 컨텍스트 객체
		ApplicationContext context = null;
		context = new FileSystemXmlApplicationContext("/src/main/java/di/autowired/di.xml");
		//--------------------------------------------------
		
		Car car = (Car) context.getBean("car");
		System.out.println("car : " + car);
		System.out.println("info : " + car.getInfo());
		
	}
}















