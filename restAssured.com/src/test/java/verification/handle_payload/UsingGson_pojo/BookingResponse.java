package verification.handle_payload.UsingGson_pojo;
//we use this class beacuse response have one extra field(bookingid)
//at the time of request bookingid is not present
//now we are deserialized so we need this


public class BookingResponse {
    private Integer bookingid;//bookingid
    private Booking booking;//bookingclass

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
