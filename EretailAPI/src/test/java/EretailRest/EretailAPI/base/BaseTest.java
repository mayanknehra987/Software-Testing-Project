package EretailRest.EretailAPI.base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import EretailRest.EretailAPI.asserts.AssertsActions;
import EretailRest.EretailAPI.endPoint.ApiConstrants;
import EretailRest.EretailAPI.modules.PayloadManager;
import EretailRest.EretailAPI.utils.PropertyReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseTest {
	// common to all testcases-n- single inheritance    and  <--what you want to do before the test after the test-->
	public RequestSpecification rs;
	public ResponseSpecification resp;
	public ValidatableResponse vr;
	public AssertsActions act;
	public Response response;
	public PayloadManager payloadmanager;
	public JsonPath jsonPath;
	
	@BeforeTest
	public void setUp() {
		payloadmanager = new PayloadManager();
		act = new AssertsActions();
	}
	public RequestSpecification createRequestSpecification(String contentType){
				return new RequestSpecBuilder()
				.setBaseUri(ApiConstrants.BASE_URL)
				.addHeader("Content-Type", contentType)
			    .addHeader("ApiOwner", getApiOwner())
			    .addHeader("ApiKey", getApiKey())
				.build().log().all();
		
	}
//		 rs = RestAssured.given();
//		 rs.baseUri(ApiConstrants.BASE_URL);
//		 rs.contentType("application/x-www-form-urlencoded").log().all();
	
	public RequestSpecification getRequestSpecificationForFormUrlEncoded() {
        return createRequestSpecification("application/x-www-form-urlencoded");
    }
	public RequestSpecification getRequestSpecificationForJson() {
        return createRequestSpecification("application/json");
    }
	
	public String getApiKey(){
		return PropertyReader.readKey("ApiKey");
	}
	public String getApiOwner(){
		return PropertyReader.readKey("ApiOwner");
	}

	@AfterTest
	public void tearDown() {

	}
}
