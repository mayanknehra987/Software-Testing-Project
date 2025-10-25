package annotation;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TC02 {
	
	public static void main(String[] args) {
		try{
		TC01 obj = new TC01();
		obj.exceptionHandling();
		}
		catch(FileNotFoundException e){
			System.out.println("File not found");
			System.out.println("File");
		}		
		catch(IOException e){
			System.out.println("IO Exception");
		}
	}

}
