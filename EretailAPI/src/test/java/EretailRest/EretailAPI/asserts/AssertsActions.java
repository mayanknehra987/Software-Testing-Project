package EretailRest.EretailAPI.asserts;

import static org.testng.Assert.assertEquals;

import io.restassured.response.Response;

public class AssertsActions {
//common assertion which will be re used
	
	public void verifyResponseBody(String actual, String expected){
		assertEquals(actual, expected);
	}
	public void verifyResponseBody(int actual, int expected){
		assertEquals(actual, expected);
	}
	public void verifyStatusCode(Response response, Integer expected){
		assertEquals(response, expected);
	}
}
