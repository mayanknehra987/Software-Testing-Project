package put;

import org.testng.annotations.Test;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class NonBddStyle {
	@Severity(SeverityLevel.BLOCKER)
	@Description("verify the true!== true")
	@Test
	public void TC_001(){
		String token  = "0d5c10c0a1064ce";
        String bookingid = "3159";

        String payloadPUT= "{\n" +
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
        RequestSpecification rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("/booking/"+bookingid);
        rs.body(payloadPUT).log().all();
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);
        
        Response response = rs.when().put();


        // Get Validatable response to perform validation
        ValidatableResponse vr = response.then().log().all();
        vr.statusCode(200);
		
	}

}
