package javaAccMod;

public class HoaKhanh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CamLe camle = new CamLe();
		camle.stateSize = "15000";
		System.out.println(camle.getstateSize());
		
		camle.stateZipcode = "";
		camle.getStateZipcode();
	}

}
