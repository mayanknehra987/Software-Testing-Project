package notepad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.text.Document;

public class Readdata {
	public static void main(String[] args) throws IOException {
		
		File f = new File("D:/read.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String s = br.readLine();
		
		 // int x = fr.read(); while(x!=-1) { System.out.print((char)x); x = fr.read(); }
		 
		while(s!=null) {
			System.out.println(s);
			s = br.readLine();
		}
		br.close();
	}
}