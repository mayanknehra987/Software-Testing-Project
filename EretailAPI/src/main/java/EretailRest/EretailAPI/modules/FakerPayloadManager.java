package EretailRest.EretailAPI.modules;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.google.gson.Gson;

import EretailRest.EretailAPI.pojos.orderprocessapi.OrderProcessAPI;
import EretailRest.EretailAPI.pojos.orderprocessapi.OrderProcessItem;
import io.qameta.allure.Description;

public class FakerPayloadManager {
	//serialiazation and deserialiazation
		private Gson gson;
		
		public FakerPayloadManager(){
			this.gson=new Gson();
		}
		@Description("Verify that create payload is working")
	  //  @Test
		public String orderProcessRequest(){
		Faker faker = new Faker();
		OrderProcessAPI orderprocessapi = new OrderProcessAPI();
		orderprocessapi.setExternalOrderno(faker.name().firstName());
		orderprocessapi.setChannelCode("che");
		orderprocessapi.setWhCode("che");
		orderprocessapi.setStatus("pack");
		orderprocessapi.setWeight(faker.random().nextInt(12));
		orderprocessapi.setLength(faker.random().nextInt(2));
		orderprocessapi.setBreadth(1);
		orderprocessapi.setHeight(1);
		orderprocessapi.setNoofbox(1);
		orderprocessapi.setTransporterName("Delhivery-1");
		orderprocessapi.setTrackingno("w092maya");
		orderprocessapi.setExternalInvoiceNo("w09263ju");
		orderprocessapi.setItems(new ArrayList<OrderProcessItem>());

		OrderProcessItem orderprocessitem = new OrderProcessItem();
		orderprocessitem.setLineno(1);
		orderprocessitem.setExtLineno("");
		orderprocessitem.setSku("yad1");
		orderprocessitem.setQty(1);
		orderprocessapi.getItems().add(orderprocessitem);
		System.out.println(orderprocessapi);
		
		String jsonRequestBody = gson.toJson(orderprocessapi);
	    System.out.println("Generated RequestBody: " + jsonRequestBody);
	    return jsonRequestBody;
		
	}
//		public Map<String, String> getCompletePayload(String apiKey, String apiOwner) {
//	        Map<String, String> payload = new HashMap();
//	        payload.put("ApiOwner", apiOwner);
//	        payload.put("ApiKey", apiKey);
//	        payload.put("RequestBody", orderProcessRequest ());
//	       // payload.put("RequestBody", updateOrders());
	//
//	        return payload;
//	    }

}
