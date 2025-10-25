package verification.handle_payload.UsingGson_pojo;

import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Deserialization {
    RequestSpecification r = RestAssured
            .given();

    Response response;

    ValidatableResponse validatableResponse;

    @Description("TC#1 - Verify that create booking is working with valid payload")
    @Test
    public void testNonBDDStylePOSTPositive() {
        //New POJO Payload
        Booking booking = new Booking();
        booking.setFirstname("Arpit");
        booking.setLastname("Mishra");
        booking.setTotalprice(2000);
        booking.setDepositpaid(true);

        booking.setAdditionalneeds("Breakfast");

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2024-05-09");
        bookingDates.setCheckout("2024-05-09");
        booking.setBookingdates(bookingDates);

        System.out.println(booking);//if you run this without using gson converter you will get only object in reponse
        // Java Object -> JSON String (byteStream) - Serlization
        //to perform above line we use below code
        Gson gson = new Gson();
        String jsonStringpayload = gson.toJson(booking);
        // String jsonStringpayload2 = gson.toJson(bookingDates);
        System.out.println(jsonStringpayload);
        //System.out.println(jsonStringpayload2);




        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";

        r.baseUri(BASE_URL);
        r.basePath(BASE_PATH);
        r.contentType(ContentType.JSON).log().all();
        r.body(jsonStringpayload);

        response = r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);


        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        //Parse Deserialized
        BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
        System.out.println(bookingResponse.getBookingid());
        //System.out.println(bookingResponse.getBooking().getFirstname());
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Arpit");

    }
}
