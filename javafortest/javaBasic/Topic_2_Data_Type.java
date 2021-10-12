package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_2_Data_Type {
// Primitive type / value type : Kiểu nguyên thủy
	
byte bNumber = 6;
short sNumber = 1500;
int iNumber = 15000;
long lNumber = 65000;
float fNumber = 15.98f;
double dNumber = 15.98;
char  cChar = '1';
boolean bStatus =  false; 

//Reference type : Tham chiếu
//String

String address = "Ho Chi Minh";
//Array
String[] studentAddress = {address, "SG", "DN"};
Integer[] studenNumber = {15, 20, 30};

//Class
Topic_2_Data_Type topic; //topic là biến đại diện cho topic_2...


//Interface
WebDriver driver;
//Object

Object aObject; // CÓ thể convert qua các kiểu dữ liệu khác

//Collection
List<WebElement> homepageLinks = driver.findElements(By.tagName("a"));
Set<String> allWindows = driver.getWindowHandles();
List<String> productName = new ArrayList<String>();

public void clicktoElement() {
 address.trim();
 studentAddress.clone();
 driver.getCurrentUrl();
 aObject.toString();
 homepageLinks.size();
 allWindows.clear();
 Topic_2_Data_Type topic = new Topic_2_Data_Type();
 topic.address = "Ha Noi";
}
public static void main (String[] args) {
	
}
}
