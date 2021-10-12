package javaOOP;

public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Honda honda = new Honda();
		honda.setCarName("Honda CRV");
		System.out.println(honda.getCarName());

		Toyota toyota = new Toyota();
		toyota.setCarName("Toyota Camry");
		System.out.println(toyota.getCarName());

	}
}
