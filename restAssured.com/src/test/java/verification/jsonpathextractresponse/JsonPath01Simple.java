package verification.jsonpathextractresponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import static org.assertj.core.api.Assertions.assertThat;
//Note How api request is created [This is the 3 Step process of testing any API]
//1.Making the request (line no.24 to 43) and getting the response line no.(45)
//2. Extract the data from response by using the Json path line no. 48 to 51
//3. Assertion it mean verify the resposne.
// Here we verify the Each field of Response

//how to handle timeout in rest assured: 1. setConnectionRequestTime(), 2. setSocketTimeOut().
//how do you handle SSL in rest assured->RelaxedHTTPSValidation()
public class JsonPath01Simple {
    //  POST - Create -> Verify the Response
    RequestSpecification rs;
    ValidatableResponse vr;
    Response res;
    String token;
    Integer bookingId;
    @Test
    public void test_post() {

        String payload_POST = "{\n" +
                "    \"firstname\" : \"Arpit\",\n" +
                "    \"lastname\" : \"Mishra\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";
        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("/booking");
        rs.contentType(ContentType.JSON);
        rs.body(payload_POST).log().all();//this is used to log all the details(header,body, method etc.) in console for debuging

        res = rs.when().post();//this is used to send an HTTP POST request to a server.
        //The Response object holds the server's response after the POST request is sent.
        // This includes the status code, response body, headers, and more.

        System.out.println("Response is :-"+res.asString());// By using this you can print the response as Json string.
        // we will verify the response by using JsonPath

        //JsonPath
        JsonPath jsonPath = new JsonPath(res.asString());//this will provide the all keys
        //response.asString() converts the response body (which could be in JSON, XML, or another format) into a String
        //new JsonPath(...) creates a JsonPath object that allows you to read and extract data from a JSON response.
        // By using below code we can extract  the data
        String bookingId= jsonPath.getString("bookingid");
        String firstName = jsonPath.getString("booking.firstname");
        System.out.println("Booking id is :- "+bookingId);
        System.out.println("First Name is:- "+firstName);

        //Using AssertJ to verify the response
        //If you are using AssertJ to verify the response you need to import this (import static org.assertj.core.api.Assertions.assertThat;)
        assertThat(firstName).isEqualTo("Arpit").isNotNull().isNotBlank();
        assertThat(bookingId).isNotNull().isNotBlank().isNotEmpty();

    }
}
