package Assured.restAssuredFramework.pojos;
//we use this class beacuse response have one extra field(bookingid)
//at the time of request bookingid is not present
//now we are deserialized so we need this


public class BookingResponse {
    private Integer bookingid;//bookingid
    private Booking booking;//bookingclass
    private String token;// generatetoken
    private String firstname;
    private String lastname;

    public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
