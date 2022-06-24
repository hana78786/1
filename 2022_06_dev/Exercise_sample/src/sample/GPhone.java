package sample;

public class GPhone extends Phone {
	private String os = "Android";

	public GPhone() {
	}

	public GPhone(String model, String number) {
		super(model,number);
	}
	
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
}
