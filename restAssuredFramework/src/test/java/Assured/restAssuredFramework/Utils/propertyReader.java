package Assured.restAssuredFramework.Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class propertyReader {
	//responsibility of the class is to give teh value of the key
	
	public static String readKey(String key){
		//properties is a class which is part of collection it is a legacy 1.2- jdk
		Properties property = new Properties();
		try{
			//read the property.properties and give the key value
			FileInputStream inputStream = new FileInputStream("/restAssuredFramework/src/test/java/resources/property.properties");
			property.load(inputStream);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return property.getProperty(key);
	}
	

}
