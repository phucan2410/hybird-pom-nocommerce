package javaBasic;

public class Car {

	private String color;

	/**
	 * Set value for Car
	 * @author AN
	 * @return void
	 * @param color
	 */
	public void setCarColor(String color) {
		this.color = color;
	}

	/**
	 * Get Car color
	 * @author AN
	 * @param
	 * @return color
	 */
	public String getCarColor() {
		return this.color;
	}
	 public synchronized void setCarColor1(String color) {
		 this.color = color;
	 }
}
