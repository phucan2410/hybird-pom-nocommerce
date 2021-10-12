package javaBasic;

import org.testng.Assert;

public class Topic_04_Operator {

	public static void main(String[] args) {
		int number = 10;
		number += 5;
		System.out.println(number);
		System.out.println(number / 5);

		System.out.println(number % 7);
		System.out.println(number++);
		//in number ra truoc 
		// ++ tang number len 1
		System.out.println(++number);
		// Cộng trước 
		
		for(int i =0; i < 3; i++) {
			System.out.println(i);
			
		}
		
		Assert.assertTrue(5 < 6);
		
		String address = "Ho CHi Minh";
		if (address != "Ha Noi" && address != "Da nang") {
			System.out.println("Addresss is the same");
			
			
		}
		// Biểu thức tam nguyên = ? : 
		boolean status = (address == "Ha noi") ? true : false;
		System.out.println(status);
		
	}

}
