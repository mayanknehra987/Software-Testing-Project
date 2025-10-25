package Assured.restAssuredFramework.Asserts;

import static org.testng.Assert.assertEquals;

import org.asynchttpclient.Response;

//common assertion which we will re-used
public class AssertsActions {
	
	public void verifyResponseBody(String actual, String expected, String description){
		assertEquals(actual, expected, description);
	}
	
	public void verifyResponseBody(int actual, int expected, String description){
		assertEquals(actual, expected, description);
	}
	
	public void verifyStatusCode(Response response, Integer expected){
		//assertEquals(response.getStatusCode(), expected);
	}

}
