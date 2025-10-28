package get;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBddStyle {
	static RequestSpecification rs = RestAssured.given();

	public static void main(String[] args) {
		rs.baseUri("https://api.zippopotam.us");
		test1();
		test2();
		// rs.basePath("/IN/560037").log().all();
		// rs.when().get();
		// rs.then().log().all().statusCode(200);
	}

	private static void test2() {
		rs.basePath("/IN/560037").log().all();
		rs.when().get();
		rs.then().log().all().statusCode(200);
	}

	private static void test1() {
		rs.basePath("/-1").log().all();
		rs.when().get();
		rs.then().log().all().statusCode(200);
		System.out.println("ghdnhfghb");

	}
}
