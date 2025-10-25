package Assured.restAssuredFramework.Base;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.BeforeTest;

import Assured.restAssuredFramework.Asserts.AssertsActions;
import Assured.restAssuredFramework.endpoint.ApiConstrants;
import Assured.restAssuredFramework.modules.Payloadmanager;
import Assured.restAssuredFramework.pojos.BookingResponse;
import Assured.restAssuredFramework.pojos.tokenResponse;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

//Common to all testcases(parents)
public class BaseTest {
	
	public static RequestSpecification rs;
	public static Response res;
	public static ValidatableResponse vs;
	public static AssertsActions as;
	public static Payloadmanager pm;
	public static JsonPath jp;
	
	//TC- common Headers
	@BeforeTest
	public void setUp(){
		pm = new Payloadmanager();
		as = new AssertsActions();
		rs = new RequestSpecBuilder().setBaseUri(ApiConstrants.Base_URL).addHeader("Content-Type", "application/json")
				.build().log().all();
		
//		 Given - Request Spec(request preperation) choose any one from both
//				RequestSpecification rs = RestAssured.given();  
//				rs.baseUri("https://restful-booker.herokuapp.com");
//				rs.basePath("/auth").log().all();
//				rs.contentType(ContentType.JSON).log().all();
	}
//	public static String createToken(){
//		rs.basePath(ApiConstrants.Auth_URL);
//		res = RestAssured.given(rs).when().body(Payloadmanager.createTokenAsString()).post();
//		vs = res.then().log().all();
//		vs.statusCode(200);
//		
//		String tokenResponse2 = Payloadmanager.getTokenFronJson(res.asString());
//		return tokenResponse2;
//	}

}
