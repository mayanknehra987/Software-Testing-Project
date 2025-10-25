package get;

import io.restassured.RestAssured;

public class BddStyle {
	
	public static void main(String[] args) {
		RestAssured.given()
						.baseUri("https://api.zippopotam.us")
						.basePath("/IN/110010").log().all()
					.when()
						.get()
					.then().log().all()
						.statusCode(200);
	}

}
