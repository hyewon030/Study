package di.constructor;

import di.tire.GoldTire;
import di.tire.SilverTire;

public class Person {
	public static void main(String[] args) {
		
		Car car1 = new Car( new GoldTire() );
		Car car2 = new Car( new SilverTire() );
	
		System.out.println( car1.getTire() );
		System.out.println( car2.getTire() );
		
	}
}












