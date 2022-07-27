package rental.Controller;

import java.util.ArrayList;

import rental.Server.RentalServer;
import rental.vo.Rental;

public class RentalController {
RentalServer rServer;
	
	public ArrayList<Rental> allList() {
		ArrayList<Rental> rList = new ArrayList<Rental>();
		rServer = new RentalServer();
		rList = rServer.allList();
		
		return rList;
	}

	public ArrayList<Rental> serchId(String userid) {
		ArrayList<Rental> rList = new ArrayList<Rental>();
		rServer = new RentalServer();
		rList = rServer.serchId(userid);
		
		return rList;
	}

}
