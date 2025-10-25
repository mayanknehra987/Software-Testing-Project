package post;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class BddStyle {
	// POST Request
    // URL - https://restful-booker.herokuapp.com/auth
    // BODY - PAYLOAD - JSON
    // {
    //    "username" : "admin",
    //    "password" : "password123"
    //}
    // HEADER - Content Type -> application/json
	public static void main(String[] args) {
	//  Payload can be given as - String(1%), Hashmap(4%), Classes( 95%)
		String payload = "{\n"+ 
							"\"username\" : \"admin\",\n" +
							"\"password\" : \"password123\"\n" +"}";
		RestAssured.given()
						.baseUri("https://restful-booker.herokuapp.com")
						.basePath("/auth").log().all()
						.contentType(ContentType.JSON).log().all()
						.body(payload)
					.when()
						.post()
					.then().log().all().statusCode(200);
	}
	

}
