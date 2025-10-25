package Assured.restAssuredFramework.Tests.Integration;

import static org.testng.Assert.assertTrue;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import Assured.restAssuredFramework.Base.BaseTest;
import Assured.restAssuredFramework.Listeners.RetryAnalyser;
import Assured.restAssuredFramework.Utils.propertyReader;
import Assured.restAssuredFramework.endpoint.ApiConstrants;
import Assured.restAssuredFramework.modules.Payloadmanager;
import Assured.restAssuredFramework.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import static org.assertj.core.api.Assertions.*;

@Test(retryAnalyzer= RetryAnalyser.class)
public class TCIntegrationFlowDoSelf extends BaseTest{
	 String bookingid;
	 String token;
	 String firstname;
	 String lastname;
	
	@Owner("Mayank Nehra")
	@Description("Verify that the Token is created")
	@Test(priority=1)
	public void createToken(ITestContext iTextContext){
	//	iTextContext.setAttribute("token", BookingResponse.getToken());
		rs.basePath(ApiConstrants.Auth_URL);
		res = RestAssured.given(rs).when().body(Payloadmanager.createTokenAsString()).post();
		vs = res.then().log().all();
		vs.statusCode(200);
		
		BookingResponse bookinngresponse = Payloadmanager.bookingResponseJava(res.asString());
		assertThat(bookinngresponse.getToken()).isNotNull();
		token= res.jsonPath().getString("token");
		System.out.println(token);
		//return token;
	//	iTextContext.setAttribute("bookingid", BookingResponse.getBookingid());
	}
	@Owner("Mayank Nehra")
	@Description("Verify that the Booking is created")
	@Test(priority=2)
	public void testCreateBooking(ITestContext iTextContext){
		
		rs.basePath(ApiConstrants.Create_Update_Booking_URL);
		res = RestAssured.given(rs).when().body(Payloadmanager.createPayloadBookingAsString()).post();
		vs = res.then().log().all();
		vs.statusCode(200);
		
		vs.body("booking.firstname", Matchers.equalTo("mayank"));
		Assert.assertTrue(true);
		BookingResponse bookinngresponse = Payloadmanager.bookingResponseJava(res.asString());
		assertThat(bookinngresponse.getBookingid()).isNotNull();
		bookingid= res.jsonPath().getString("bookingid");
		System.out.println(bookingid);
		//return bookingid;
	//	iTextContext.setAttribute("bookingid", BookingResponse.getBookingid());
	}
	@Owner("Mayank Nehra")
	@Description("Verify that the Booking by Id")
	@Test(groups="integration", priority=3)
	public void testVerifyBookingId(ITestContext iTextContext){
	//	iTextContext.setAttribute("token", BookingResponse.getBookingid());
	//	Integer bookingid = (Integer) iTextContext.getAttribute("bookingid");
		//String basePathGet = ApiConstrants.Create_Update_Booking_URL + "/" + bookingid; 
		rs.basePath(ApiConstrants.Create_Update_Booking_URL + "/" + bookingid);
		res = RestAssured.given(rs).when().body(Payloadmanager.createPayloadBookingAsString()).get();
		vs = res.then().log().all();
		vs.statusCode(200);
		BookingResponse bookingresponse = Payloadmanager.bookingResponseJava(res.asString());
		assertThat(bookingresponse.getFirstname()).isNotNull().isNotEmpty();
		//assertThat(bookingresponse.getLastname()).isEqualTo(propertyReader.readKey("booking.post.firstname"));
		firstname = res.jsonPath().getString("firstname");
		System.out.println(firstname);
		assertThat(bookingresponse.getLastname()).isEqualTo("nehra1");
		lastname = res.jsonPath().getString("lastname");
		System.out.println(lastname);
	}
	@Owner("Mayank Nehra")
	@Description("Verify that update Booking by Id")
	@Test(groups="integration", priority=4)
	public void testUpdateBookingById(){
		rs.basePath(ApiConstrants.Create_Update_Booking_URL + "/" + bookingid);
		res = RestAssured.given(rs).cookie("Token", token).when().body(Payloadmanager.fullUploadPayloadAsString()).put();
		vs = res.then().log().all();
		vs.statusCode(200);
		BookingResponse bookingresponse = Payloadmanager.bookingResponseJava(res.asString());
		assertThat(bookingresponse.getFirstname()).isNotNull().isNotEmpty();
		firstname = res.jsonPath().getString("firstname");
		System.out.println(firstname);
		assertThat(bookingresponse.getLastname()).isEqualTo("nehra1");
		lastname = res.jsonPath().getString("lastname");
		System.out.println(lastname);
		Assert.assertTrue(true);
	}
	@Owner("Mayank Nehra")
	@Description("Verify that delete Booking by Id")
	@Test(groups="integration", priority=5)
	public void testDeleteBookingbyId(){
		rs.basePath(ApiConstrants.Create_Update_Booking_URL + "/" + bookingid);
		res = RestAssured.given(rs).cookie("Token", token).when().delete();
		vs = res.then().log().all();
		vs.statusCode(200);
		Assert.assertTrue(true);
	}

}
