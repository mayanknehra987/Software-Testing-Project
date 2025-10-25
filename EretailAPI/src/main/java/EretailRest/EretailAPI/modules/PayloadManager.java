package EretailRest.EretailAPI.modules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.google.gson.Gson;

import EretailRest.EretailAPI.pojos.orderprocessapi.OrderProcessAPI;
import EretailRest.EretailAPI.pojos.orderprocessapi.OrderProcessItem;
import EretailRest.EretailAPI.pojos.orderprocessapi.OrderProcessResponse;
import EretailRest.EretailAPI.pojos.orderprocessapi.OrderProcessResponse1;
import io.qameta.allure.Description;

public class PayloadManager {
	//serialiazation and deserialiazation
	static Gson gson;
	
//	public PayloadManager(){
//		this.gson=new Gson();
//	}
//	@Description("Verify that create payload is working")
//    @Test
//	public String orderProcessRequest(){
//	OrderProcessAPI orderprocessapi = new OrderProcessAPI();
//	orderprocessapi.setExternalOrderno("CHE110752");
//	orderprocessapi.setChannelCode("che");
//	orderprocessapi.setWhCode("che");
//	orderprocessapi.setStatus("pack");
//	orderprocessapi.setWeight(12);
//	orderprocessapi.setLength(2);
//	orderprocessapi.setBreadth(1);
//	orderprocessapi.setHeight(1);
//	orderprocessapi.setNoofbox(1);
//	orderprocessapi.setTransporterName("BlueDart APIGEE");
//	orderprocessapi.setTrackingno("w092yy66maya");
//	orderprocessapi.setExternalInvoiceNo("w09263ju");
//	orderprocessapi.setItems(new ArrayList<OrderProcessItem>());
//
//	OrderProcessItem orderprocessitem = new OrderProcessItem();
//	orderprocessitem.setLineno(1);
//	orderprocessitem.setExtLineno("");
//	orderprocessitem.setSku("yad1");
//	orderprocessitem.setQty(1);
//	orderprocessapi.getItems().add(orderprocessitem);
//	System.out.println(orderprocessapi);
//	gson = new Gson();
//	String jsonRequestBody = gson.toJson(orderprocessapi);
//    //System.out.println("Generated RequestBody: " + jsonRequestBody);
//    return jsonRequestBody;
	@Description("Verify that create payload is working")
    @Test
	public String orderProcessRequest(String externalorderno, String channelcode, String whcode, String status,
			Integer weight, Integer length, Integer breadht, Integer height, Integer noofbox, String trans,
			String trackingno, String extinvno, String items ,String extlineno , String sku, Integer lineno , Integer qty) {
	OrderProcessAPI orderprocessapi = new OrderProcessAPI();
	orderprocessapi.setExternalOrderno(externalorderno);
	orderprocessapi.setChannelCode(channelcode);
	orderprocessapi.setWhCode(whcode);
	orderprocessapi.setStatus(status);
	orderprocessapi.setWeight(weight);
	orderprocessapi.setLength(length);
	orderprocessapi.setBreadth(breadht);
	orderprocessapi.setHeight(height);
	orderprocessapi.setNoofbox(noofbox);
	orderprocessapi.setTransporterName(trans);
	orderprocessapi.setTrackingno(trackingno);
	orderprocessapi.setExternalInvoiceNo(items);
	orderprocessapi.setItems(new ArrayList<OrderProcessItem>());

	OrderProcessItem orderprocessitem = new OrderProcessItem();
	orderprocessitem.setLineno(lineno);
	orderprocessitem.setExtLineno(extlineno);
	orderprocessitem.setSku(sku);
	orderprocessitem.setQty(qty);
	orderprocessapi.getItems().add(orderprocessitem);
	System.out.println(orderprocessapi);
	gson = new Gson();
	String jsonRequestBody = gson.toJson(orderprocessapi);
    //System.out.println("Generated RequestBody: " + jsonRequestBody);
    return jsonRequestBody;
}
	 public static OrderProcessResponse OrderProcessResponseDeserilize(String responseString){
		 	gson = new Gson();
			OrderProcessResponse bookingResponse = gson.fromJson(responseString, OrderProcessResponse.class);
			return bookingResponse;
			
		}
	 public static OrderProcessResponse1 OrderProcessResponse1Deserilize(String responseString){
		 	gson = new Gson();
			OrderProcessResponse1 bookingResponse1 = gson.fromJson(responseString, OrderProcessResponse1.class);
			return bookingResponse1;
			
		}
	public Map<String, String> getCompletePayload(String apiKey, String apiOwner) {
        Map<String, String> payload = new HashMap();
        payload.put("ApiOwner", apiOwner);
        payload.put("ApiKey", apiKey);
        //payload.put("RequestBody", orderProcessRequest ());
		payload.put("RequestBody", orderProcessRequest("CHE110752", "che", "che", "pack", 1, 2, 1, 2, 1,
				"BlueDart APIGEE", "jhgtyrurffg", "rfety6y", "INV123", "", "yad1", 1, 1));
        
        return payload;
    }
}
