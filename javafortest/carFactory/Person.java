package carFactory;

public class Person {

	public static void main(String[] args) {
		CarFactory carFac = new CarFactory();
		
		//view HonDa
		carFac.viewCarByType("Honda");
		carFac.viewCarByType("Kia");
		carFac.viewCarByType("Toyota");

	}

}
