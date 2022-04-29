package program;

import javax.swing.JOptionPane;

import org.opentutorials.iot.DimmingLights;
import org.opentutorials.iot.Elevator;
import org.opentutorials.iot.Lighting;
import org.opentutorials.iot.Security;
public class OkJavaGoInHomeInput {

	public OkJavaGoInHomeInput() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	
		String id = args[0];
		String bright= args[1];
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
		
		DimmingLights moodLamp = new DimmingLights(id+" moolamp");
		moodLamp.setBright(Double.parseDouble(bright));
		moodLamp.on();
	}

}