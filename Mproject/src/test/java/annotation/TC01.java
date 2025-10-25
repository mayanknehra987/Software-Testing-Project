package annotation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class TC01 {

	
	public void exceptionHandling() throws IOException {
		//try{
		File f = new File("D:\\writedata1.txt");
		FileWriter fw = new FileWriter(f,true);
		fw.write("world");
		fw.flush();
		fw.close();
	//	}
//		catch (IOException e) {
//		System.out.println("File not found");
//			
//		}
//		catch (Exception e) {
//			System.out.println("File not not found");
//		}
		
	}
}
