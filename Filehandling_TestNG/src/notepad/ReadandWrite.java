package notepad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadandWrite {
	public static void main(String[] args) throws IOException {
		File f = new File("D:/read.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String x = br.readLine();
		while(x!=null) {
			File f1 = new File("D:/readwrite.txt");
			FileWriter fw = new FileWriter(f1,true);				// true for dont overwrite
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(x);
			bw.newLine(); 					// for new line
			bw.flush();
			bw.close();
			x = br.readLine();
		}
		br.close();
		
	}

}
