package verification.handle_payload;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UsingHashmap {
	RequestSpecification rs;
    ValidatableResponse vr;
    Response res;
    String token;
    String bookingId;

    // Has Map Payload
	@Test
	public void payloadpostbyusingHashMap(){
    // Restassured not support any kind of Map. If you run this program you will get an error.
    //if you want to use HashMap you need to add 3rd party library
    //We have two library <--1. GSON API
    //                      <--2. JASKSON API
    // These library convert Hshmap to inputstream

    //This is normal json payload we convert into HashMap payload
    // {
    //    "firstname" : "sally",
    //    "lastname" : "brown",
    //    "totalprice" : 111,
    //    "depositpaid" : true,
    //    "bookingdates" : {
    //        "checkin" : "2018-01-01",
    //        "checkout" : "2019-01-01"
    //    },
    //    "additionalneeds" : "Breakfast"
    //}

    // Hashmap ->
    // {} - map--> two map is present one is parent{complete payload} and other is child{bookingdates}

    //Below is HashMap Payload
        //First HashMap
	
    Map<String, Object> jsonBodyUsingMap = new LinkedHashMap<String, Object>();
    jsonBodyUsingMap.put("firstname", "sally");
    jsonBodyUsingMap.put("lastname", "brown");
    jsonBodyUsingMap.put("totalprice", 111);
    jsonBodyUsingMap.put("depositpaid", true);

        //Second HashMap
    Map<String, Object> bookingDatesMap = new LinkedHashMap<String, Object>();
    bookingDatesMap.put("checkin", "2018-01-01");
    bookingDatesMap.put("checkout", "2019-01-01");

    jsonBodyUsingMap.put("bookingdates", bookingDatesMap);
    jsonBodyUsingMap.put("additionalneeds", "Breakfast");
        System.out.println(jsonBodyUsingMap);

        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("/booking");
        rs.contentType(ContentType.JSON);
        rs.body(jsonBodyUsingMap).log().all();

        res = rs.when().post();

//    JsonPath jsonPath=new JsonPath(response.asString());
//    String firstName = jsonPath.getString("booking.firstname");
        // Get Validatable response to perform validation
        vr = res.then().log().all();
        vr.statusCode(200);
//       assertThat(firstName).isEqualTo("sally");
//    System.out.println(firstName);

      bookingId = res.jsonPath().getString("bookingid");
        System.out.println(bookingId);
    }


}
