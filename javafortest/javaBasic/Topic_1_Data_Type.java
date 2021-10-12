package javaBasic;


public class Topic_1_Data_Type{
	
	// Hàm khởi tạo trùng tên với class
	public Topic_1_Data_Type() {
		String studentName;
	}
	
//	Biến static phạm vi thuộc class Topic_1_Datatype
	static int studentNumber;
	static boolean statusValue;
	
	static final String browser_Name = "Chrome"; // thằng này không được thay đổi
	static int studentPrice;
	
	String studentName = "Automation";
	

	public static void main(String[] args) {
		//Cái này chỉ dùng trong hàm này thôi
		int studentPrice = 5;
		System.out.println(studentPrice);
		
		System.out.println(studentNumber);
		System.out.println(browser_Name);
		System.out.println(statusValue);
		
		Topic_1_Data_Type topic_1 = new Topic_1_Data_Type();
		Topic_1_Data_Type topic_2 = new Topic_1_Data_Type();
		Topic_1_Data_Type topic_3 = new Topic_1_Data_Type();
		
		
		System.out.println(topic_1.studentName);
		System.out.println(topic_2.studentName);
		System.out.println(topic_3.studentName);
		
		
		
	}
}
