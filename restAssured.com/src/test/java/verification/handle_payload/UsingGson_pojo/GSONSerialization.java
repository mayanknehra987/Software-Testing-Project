package verification.handle_payload.UsingGson_pojo;

import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GSONSerialization {
    //String--> already done
    //HashMap--> already done
    //Class --> POJO
    //Create class for the Payload- POJO
    // PUT Request
    // token, booking id this will be harcoded

//    {
//                "firstname" : "Jim",
//                        "lastname" : "Brown",
//                    "totalprice" : 111,
//                    "depositpaid" : true,
//                    "bookingdates" : {
//                "checkin" : "2018-01-01",
//                        "checkout" : "2019-01-01"
//            },
//                "additionalneeds" : "Breakfast"
//            }

    RequestSpecification r = RestAssured
            .given();

    Response response;

    ValidatableResponse validatableResponse;

    @Description("TC#1 - Verify that create booking is working with valid payload")
    @Test
    public void testNonBDDStylePOSTPositive() {
        //Here the question is how we convert this payload to  class
        //{} this sign mean is one class
        //{} this have same meaning
        //Kisi bhi payload main jitne curly braces({}) hoge us payload main utni hi class hogi
        //In given above payload two {} are given it mean this payload have two class one is booking and
        //anothe one is bookingdates.
        //So to make the payload we will create the two class one is Booking and other is bookingadates
        //In calss we only pass the keys like for booking keys are {firstname, lastname etc.}
        //after making the class create the object of the class.
        //Manually creating the pojo is very difficult to make it easy we use tool that convert json to pojo class.
        //https://www.jsonschema2pojo.org/ use this to convert json schema to pojo class


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

    }
}
