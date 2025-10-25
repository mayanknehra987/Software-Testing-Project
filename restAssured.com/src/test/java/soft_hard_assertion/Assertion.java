package soft_hard_assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.assertj.core.api.Assertions.*;

public class Assertion {
		RequestSpecification rs;
	    ValidatableResponse vr;
	    Response res;
	    String token;
	    Integer bookingId;

	    @Test
	    public void test_post(){
	        String payload_POST= "{\n" +
	                "    \"firstname\" : \"Pramod\",\n" +
	                "    \"lastname\" : \"Dutta\",\n" +
	                "    \"totalprice\" : 111,\n" +
	                "    \"depositpaid\" : false,\n" +
	                "    \"bookingdates\" : {\n" +
	                "        \"checkin\" : \"2024-01-01\",\n" +
	                "        \"checkout\" : \"2024-01-01\"\n" +
	                "    },\n" +
	                "    \"additionalneeds\" : \"Lunch\"\n" +
	                "}";


	        rs = RestAssured.given();
	        rs.baseUri("https://restful-booker.herokuapp.com/");
	        rs.basePath("/booking");
	        rs.contentType(ContentType.JSON);
	        rs.body(payload_POST).log().all();

	        res = rs.when().post();

	        // Get Validatable response to perform validation
	        vr = res.then().log().all();
	        vr.statusCode(200);

	        // Rest Assured Default - Hamcrest it is resassured library
	        // import org.hamcrest.Matchers;
//	        vr.body("booking.firstname", Matchers.equalTo("Pramod"));
//	        vr.body("booking.lastname",Matchers.equalTo("Dutta"));
//	        vr.body("booking.depositpaid",Matchers.equalTo(false));
//	        vr.body("bookingid",Matchers.notNullValue());



	        // TestNG Assertion
	        // 1.SoftAssert vs
	        // 2.HardAssert - This means that if any assertion fails, the remaining statements in that test method will not be executed.

	        Integer bookingId = res.then().extract().path("bookingid");
	        String firstname = res.then().extract().path("booking.firstname");

	        Assert.assertNotNull(bookingId);
	        Assert.assertEquals(firstname,"Pramod");

	        SoftAssert SF = new SoftAssert();
	        SF.assertTrue(false);
	        SF.assertEquals("firstnam", "dfghj");

	        // AssertJ Assertion

	        assertThat(bookingId).isNotNull().isNotZero().isPositive();
	        assertThat(firstname).isEqualTo("Pramod").isNotEmpty().isNotBlank();
	        String s = ""; //Empty
	        String s2 = " "; //Blank
	        SF.assertAll();// to capture all the soft assertion
	        ;




//	        bookingId = response.jsonPath().getString("bookingid");







	    }

}
