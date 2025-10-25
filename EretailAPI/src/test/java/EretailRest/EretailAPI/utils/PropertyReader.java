package EretailRest.EretailAPI.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	public static String readKey(String key) {
		FileInputStream fileInputStream = null;
		Properties p = null;
		try {
			 fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/resources/property.properties");
			p = new Properties();
			p.load(fileInputStream);
		}

		catch (IOException e) {
			throw new RuntimeException(e);
		}
		return p.getProperty(key);
	}
}
