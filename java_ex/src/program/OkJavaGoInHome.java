package program;

import org.opentutorials.iot.Elevator;
import org.opentutorials.iot.Lighting;
import org.opentutorials.iot.Security;
public class OkJavaGoInHome {

	public OkJavaGoInHome() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	
		String id = "JAVA APT 507";
		//Elevater call
		Elevator myElevater = new Elevator(id);
		myElevater.callForUp(1);
		
		//Security off
		Security mysecurity=new Security(id);
		mysecurity.off();
		
		//Light on
		Lighting hallLamp=new Lighting(id+" / Hall Lamp");
		hallLamp.on();
		
		Lighting floorLamp=new Lighting(id+" / floor Lamp");
		floorLamp.on();
	}

}