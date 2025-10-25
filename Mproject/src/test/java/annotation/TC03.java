package annotation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TC03 {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		int count = 0;
		File f = new File("D:\\writedata1.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String x = br.readLine();
		while (x != null) {
			count = count + x.length() -x.replace("a", "").length();
			x = br.readLine();
		}
		System.out.println(count);
		fr.close();
	}
}
