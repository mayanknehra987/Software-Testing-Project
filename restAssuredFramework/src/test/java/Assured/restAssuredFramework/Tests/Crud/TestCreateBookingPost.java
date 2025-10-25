package Assured.restAssuredFramework.Tests.Crud;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import Assured.restAssuredFramework.Base.BaseTest;
import Assured.restAssuredFramework.Utils.propertyReader;
import Assured.restAssuredFramework.endpoint.ApiConstrants;
import Assured.restAssuredFramework.modules.Payloadmanager;
import Assured.restAssuredFramework.pojos.Booking;
import Assured.restAssuredFramework.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import static org.assertj.core.api.Assertions.*;

public class TestCreateBookingPost extends BaseTest{
	@Link(name="API", url="")
	@Issue("Jira ID")
	@Owner("Mayank Nehra")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify that POST request is working fine")
	@Test
	public void testVerifyCreateBookingPostTC01(){
		
		rs.basePath(ApiConstrants.Create_Update_Booking_URL);
		res = RestAssured.given(rs).when().body(Payloadmanager.createPayloadBookingAsString()).post();
		vs = res.then().log().all();
		//vs.statusCode(Integer.parseInt(propertyReader.readKey("booking.post.statuscode.success")));
		vs.statusCode(200);
		//default restassured
		vs.body("booking.firstname", Matchers.equalTo("mayank"));
		//assertJ assertion
		BookingResponse bookingResponse = Payloadmanager.bookingResponseJava(res.asString());
		assertThat(bookingResponse.getBookingid()).isNotNull();
		assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isNotEmpty();
		assertThat(bookingResponse.getBooking().getLastname()).isEqualTo("nehra");
		
		// read value for property file to validate
		//assertThat(bookingResponse.getBooking().getLastname()).isEqualTo(propertyReader.readKey("booking.post.firstname=abc"));
		//testng assertion
	
		Assert.assertEquals(true, true);
	}

}
