package javaClassObject;

public class Student extends Person {
public void showStudentName() {
	getPersonName();
	setPersoneName("Nguyen khanh linh");
}

	public static void main(String[] args) {
		// Sử dụng thông qua 1 đối tượng (Object)
		Person per = new Person();
		setPersonAddres();
	}
	
	

}
