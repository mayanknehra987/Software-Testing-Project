package notepad;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writedata {
	public static void main(String[] args) throws IOException {

		File f = new File("D:/write.csv");
		FileWriter fw = new FileWriter(f,true);
//		fw.write("my");
//		fw.close();
		
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("Write Something");				// write in temp sapce
		bw.newLine();
		bw.write("Write Something1");
		bw.flush();						// internaly code define for save and 
		bw.close();
		

	}

}
