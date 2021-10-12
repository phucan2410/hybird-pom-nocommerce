package javaOOP;

/**
 * Tính đa hình thái 1 hàm trùng tên nhưng khác tham số, dùng một tham số khác
 * Là một ngữ cảnh khác. NoteCùng tham số nhưng khác kiểu dữ liệu Note/Khác số
 * lượng tham số( không quan tâm kiểu dữ liệu
 * @author AN
 *
 */
public class Person {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person per_1 = new Person();
		Person per_2 = new Person();
		per_1.viewPerson("Nguyen Phuc An");
		per_2.viewPerson("0788876996");
	}

	public void viewPerson() {
		System.out.println();

	}

	public void viewPerson(String personName) {
		System.out.println(personName);

	}

	public void viewPerson(int personPhone) {
		System.out.println(personPhone);
	}

	public void viewPerson(String personName, int personPhone) {
		System.out.println(personPhone);
		System.out.println(personName);
	}
}
