package EretailRest.EretailAPI.pojos.orderprocessapi;

public class OrderProcessResponse {
	
	private int responseCode;
    private String responseMessage;
    private OrderProcessResponse1 requeststatus;
    
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public OrderProcessResponse1 getRequeststatus() {
		return requeststatus;
	}
	public void setRequeststatus(OrderProcessResponse1 requeststatus) {
		this.requeststatus = requeststatus;
	}
	

	

}
