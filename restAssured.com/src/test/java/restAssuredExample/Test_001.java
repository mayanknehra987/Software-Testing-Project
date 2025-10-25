package restAssuredExample;

import io.restassured.RestAssured;

public class Test_001 {
	public static void main(String[] args) {
        System.out.println("Rest Assured Test CASE");
        System.out.println("GET Request Demo");
// Basic's of RestAssured
        //RestAssured is a Java Library uses Domain specific language(DSL)for writing automates tests for Restful APIs.
        // This help to make HTTP request, Methods and verify the response.
        // RestAssured dsl also support the BDD gherkin syntax(without using cucumber)
        //it use Gherkin Synatax which is opensource
        // Gherkins Syntax
//        given() - url, headers, body or paylaod
//        when() - http methods - get, post, patch, put, delete
//        then() - verify the response - er == ar
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/1").log().all()
                .when()
                .get()
                .then().log().all()
                .statusCode(200); // <201> but was <200>.


    }

}
