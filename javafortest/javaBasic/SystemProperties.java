package javaBasic;

import java.io.File;

public class SystemProperties {
	static String projectPath = System.getProperty("user.dir");
	static String osName = System.getProperty("os.name");
	static String fileName = "IOS.png";
	static String filePath;

	public static void main(String[] args) {

		filePath = projectPath + File.separator + "uploabFiles" + fileName;
		System.out.print(filePath);
	}

	public static String getDirSlash(String folderName) {
		if (osName.toLowerCase().startsWith("window")) {
			folderName = "\\" + folderName + "\\";
		} else if (osName.toLowerCase().startsWith("mac")) {
			folderName = "/" + folderName + "/";
		}
		return folderName;
	}
}
