package ArchitectureofSelenium.SeleniumFramework.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	// Read the browser- chrome from propertie file -> give to drivermanager

	public PropertyReader() {

	}

	public static String readKey(String Key) {
		FileInputStream fileinputstream = null;
		Properties p = null;
		try {
			fileinputstream = new FileInputStream(
					System.getProperty("user.dir") + "/resources/data.properties");
			p = new Properties();
			p.load(fileinputstream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return p.getProperty(Key);

	}

}
