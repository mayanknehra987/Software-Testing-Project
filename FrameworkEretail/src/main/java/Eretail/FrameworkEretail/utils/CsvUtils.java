package Eretail.FrameworkEretail.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {
	public static Object[][] readCSVData(String filePath) throws IOException {
        List<Object[]> dataList = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;

        // Read and skip header
        br.readLine();

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",", -1); // -1 keeps empty strings
            dataList.add(data);
        }

        br.close();

        Object[][] dataArray = new Object[dataList.size()][];
        return dataList.toArray(dataArray);
    }

}
