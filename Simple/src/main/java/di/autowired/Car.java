package di.autowired;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import di.tire.Tire;

public class Car {

//	@Autowired
//	@Resource
	@Inject
	
//	@Qualifier("sTire")
	@Qualifier("gTire")
	private Tire tire;
	
	public String getInfo() {
		return tire.getProduct() + "장착!";
	}
	
	public Tire getTire() {
		return tire;
	}

	public void setTire(Tire tire) {
		this.tire = tire;
	}
	
}






