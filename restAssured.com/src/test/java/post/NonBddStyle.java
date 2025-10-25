package post;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class NonBddStyle {
	public static void main(String[] args) {
		String payload = "{\n" + "\"username\" : \"admin\",\n" + "\"password\" : \"password123\"\n" + "}";
		
		// Given - Request Spec(request preperation)
		RequestSpecification rs = RestAssured.given();
		rs.baseUri("https://restful-booker.herokuapp.com");
		rs.basePath("/auth").log().all();
		rs.contentType(ContentType.JSON).log().all();
		rs.body(payload);
		
		// When -     Response data  (request making)
		Response response = rs.when().post();

		// Then - ValidatableResponse Validation( request verification)
		ValidatableResponse vr = response.then().log().all();
		vr.statusCode(200);
	}

}
