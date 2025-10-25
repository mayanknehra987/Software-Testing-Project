package Assured.restAssuredFramework.Tests.DDT;

import org.testng.annotations.Test;

import Assured.restAssuredFramework.Utils.UtilsExcel;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class VwoDDtTest {
	
	RequestSpecification rs;
	ValidatableResponse vs;
	Response res;
	Integer ir;
	@Test(dataProvider = "getData", dataProviderClass = UtilsExcel.class)
	public void testVwpLogin(String email, String password){
		System.out.println("Login Api");
		System.out.println(email);
		System.out.println(password);
	}

}
