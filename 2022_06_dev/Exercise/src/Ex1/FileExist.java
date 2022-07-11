package Ex1;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExist {
public static void main(String[] args) {
	File file = new File("D:/temp/file.txt");
	
	
	if(file.exists() == false) {file.mkdirs();}
	boolean isExistif = file.exists();
	System.out.println(isExistif);
	
	File temp = new File("D:/Temp");
	File[] contents = temp.listFiles();
	System.out.println("날짜                 시간        형태         크기       이름");
	System.out.println("------------------------------------");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
	for(File file1 : contents) {
		System.out.println(sdf.format(new Date(file.lastModified())));
		if(file.isDirectory()) {
			System.out.println("\t<file1>\t\t\t" + file.getName());
		}
		else {
			System.out.println("\t\t\t "+ file1.length() + "\t" +file.getName());
		}
	}
}
}
