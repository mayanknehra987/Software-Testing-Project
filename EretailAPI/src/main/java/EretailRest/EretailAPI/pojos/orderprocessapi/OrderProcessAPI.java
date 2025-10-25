package EretailRest.EretailAPI.pojos.orderprocessapi;

import java.util.List;

public class OrderProcessAPI {
	private String externalOrderno;
	private String channelCode;
	private String whCode;
	private String status;
	private Integer weight;
	private Integer length;
	private Integer breadth;
	private Integer height;
	private Integer noofbox;
	private String transporterName;
	private String trackingno;
	private String externalInvoiceNo;
	private List<OrderProcessItem> items;

	public String getExternalOrderno() {
		return externalOrderno;
	}

	public void setExternalOrderno(String externalOrderno) {
		this.externalOrderno = externalOrderno;
	}

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public String getWhCode() {
		return whCode;
	}

	public void setWhCode(String whCode) {
		this.whCode = whCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getBreadth() {
		return breadth;
	}

	public void setBreadth(Integer breadth) {
		this.breadth = breadth;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getNoofbox() {
		return noofbox;
	}

	public void setNoofbox(Integer noofbox) {
		this.noofbox = noofbox;
	}

	public String getTransporterName() {
		return transporterName;
	}

	public void setTransporterName(String transporterName) {
		this.transporterName = transporterName;
	}

	public String getTrackingno() {
		return trackingno;
	}

	public void setTrackingno(String trackingno) {
		this.trackingno = trackingno;
	}

	public String getExternalInvoiceNo() {
		return externalInvoiceNo;
	}

	public void setExternalInvoiceNo(String externalInvoiceNo) {
		this.externalInvoiceNo = externalInvoiceNo;
	}

	public List<OrderProcessItem> getItems() {
		return items;
	}

	public void setItems(List<OrderProcessItem> items) {
		this.items = items;
	}
}
