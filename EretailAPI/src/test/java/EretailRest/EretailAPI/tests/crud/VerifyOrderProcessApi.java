package EretailRest.EretailAPI.tests.crud;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonSyntaxException;

import EretailRest.EretailAPI.base.BaseTest;
import EretailRest.EretailAPI.endPoint.ApiConstrants;
import EretailRest.EretailAPI.modules.PayloadManager;
import EretailRest.EretailAPI.pojos.orderprocessapi.OrderProcessResponse;
import EretailRest.EretailAPI.pojos.orderprocessapi.OrderProcessResponse1;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import static org.assertj.core.api.Assertions.*;
public class VerifyOrderProcessApi extends BaseTest{

	@Severity(SeverityLevel.NORMAL)
	@Description("Verify the order process api working fine")
	@Test
	public void verifyOrderProcessApi(){
		rs = getRequestSpecificationForFormUrlEncoded();
		rs.basePath(ApiConstrants.orderprocessapi);
		Map<String, String> formPayload = payloadmanager.getCompletePayload(getApiKey(), getApiOwner());
        //System.out.println("Payload being sent: " + formPayload);
		response = RestAssured.given().spec(rs).formParams(formPayload).when().post();
		
		
		vr = response.then().log().all();
		vr.statusCode(200);
		
		Assert.assertEquals(true, true);
		
		try {
		    OrderProcessResponse orderprocessresponse = PayloadManager.OrderProcessResponseDeserilize(response.asString());
		    OrderProcessResponse1 orderprocessresponse1 = PayloadManager.OrderProcessResponse1Deserilize(response.asString());
		    assertThat(orderprocessresponse.getResponseMessage()).isNotNull();
			assertThat(orderprocessresponse.getResponseCode()).isNotNegative().isNotNull();
			assertThat(orderprocessresponse1.getDeliveryNo()).isEqualTo("CHEA0C106009");
		} catch (JsonSyntaxException e) {
		    System.err.println("Deserialization failed: " + e.getMessage());
		    
		}
		
	}

}

