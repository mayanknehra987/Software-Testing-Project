package EretailRest.EretailAPI.pojos.orderprocessapi;

public class OrderProcessItem {
	
	private Integer lineno;
	private String extLineno;
	private String sku;
	private Integer qty;
	
	public Integer getLineno() {
		return lineno;
	}
	public void setLineno(Integer lineno) {
		this.lineno = lineno;
	}
	public String getExtLineno() {
		return extLineno;
	}
	public void setExtLineno(String extLineno) {
		this.extLineno = extLineno;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
}
