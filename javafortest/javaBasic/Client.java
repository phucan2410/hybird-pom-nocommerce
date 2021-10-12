package javaBasic;


public class Client extends Car implements ICar, Icomputer{
	
public static void main(String[] args) {
Car car = new Car();
car.setCarColor("Red");
System.out.println(car.getCarColor());
}
}