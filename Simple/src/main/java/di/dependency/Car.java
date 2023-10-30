package di.dependency;

import di.tire.SilverTire;
import di.tire.Tire;

public class Car {

	private Tire tire;

	public Car() {
		
		//의존성이 발생한다
//		this.tire = new GoldTire();
		this.tire = new SilverTire();

	}
	
	public String getTire() {
		return tire.getProduct() + "장착함!";
	}
	
}













