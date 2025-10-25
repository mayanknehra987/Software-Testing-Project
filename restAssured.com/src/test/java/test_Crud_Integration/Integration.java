package test_Crud_Integration;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Integration {
	//Create A token
    //Create Nooking
    //Perform A put request
    //verify that put is getting suceed by Get request
    //Delete ID
    //Verify it doesn't exist get request
    //Note:- We can run test cases sequencely by using
    // 1.Priority,
    // 2.By nameing the test case alphabatically
    //3. By using dependson method and
    //4. you can also use <methods> <include name="method name" </include>..</methods> in testng.xml file

    RequestSpecification rs;
    ValidatableResponse vr;
    Response res;
    String token;
    String bookingid;
    @Test
    public String getToekn(){
    	String payload = "{\n" + "\"username\" : \"admin\",\n" + "\"password\" : \"password123\"\n" + "}";
    	rs= RestAssured.given();
    	rs.baseUri("https://restful-booker.herokuapp.com");
    	rs.basePath("/auth");
    	rs.contentType(ContentType.JSON).log().all();
    	rs.body(payload);
    	
    	res= rs.when().post();
    	
    	vr=res.then().log().all();
    	vr.statusCode(200);
    	//extract the token
    	token = res.jsonPath().getString("token");
    	System.out.println(token);
        return token;
    }
    public String getBookingID(){
    	String payloadPost= "{\n" +
                "    \"firstname\" : \"Pramod\",\n" +
                "    \"lastname\" : \"Dutta\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";
    	rs= RestAssured.given();
    	rs.baseUri("https://restful-booker.herokuapp.com/");
    	rs.basePath("/booking/");
    	rs.contentType(ContentType.JSON);
    	rs.body(payloadPost).log().all();
    	
    	res= rs.when().post();
    	
    	vr=res.then().log().all();
    	vr.statusCode(200);
    	
    	// Rest Assured Default - Hamcrest it is resassured library
        // import org.hamcrest.Matchers;
//        vr.body("booking.firstname", Matchers.equalTo("Pramod"));
//        vr.body("booking.lastname",Matchers.equalTo("Dutta"));
//        vr.body("booking.depositpaid",Matchers.equalTo(false));
//        vr.body("bookingid",Matchers.notNullValue());
    	bookingid = res.jsonPath().getString("bookingid");
    	System.out.println(bookingid);
        return bookingid;
    }
    @Test(priority = 1) //Priority wise sequencing
  //public void test_01_update_request_put(){//Alphabatically wise sequencing
    public void test_update_request_put(){
    	token=getToekn();
        bookingid=getBookingID();
        String payloadPUT= "{\n" +
                "    \"firstname\" : \"mayank\",\n" +
                "    \"lastname\" : \"nehra\",\n" +
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
        rs.basePath("/booking/"+bookingid);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);
        rs.body(payloadPUT).log().all();

        res = rs.when().put();
        // Get Validatable response to perform validation
        vr = res.then().log().all();
        vr.statusCode(200);
        System.out.println("Hello is this done");
    }
     @Test(dependsOnMethods = "test_update_request_put") // Dependons method using sequencing
   //  @Test(priority = 2)//Priority wise sequencing
     //public void test_02_update_request_get(){//AlphabaticaLLY wise sequencing
         public void test_update_request_get(){   //need to add code for operation
    	 rs = RestAssured.given();
         rs.baseUri("https://restful-booker.herokuapp.com");
         rs.basePath("/booking/"+bookingid);
         
         res = rs.when().get();
         // Get Validatable response to perform validation
         vr = res.then().log().all();
        // vr.statusCode(200);
    	  
    	 System.out.println(bookingid);

     }
     @Test(dependsOnMethods = "test_update_request_get")//Dependons method using sequencing
    // @Test(priority = 3) //Priority wise sequencing
     //public void test_03_delete_booking(){////AlphabaticaLLY wise sequencing
         public void test_delete_booking(){    //need to add code for operation
         System.out.println(bookingid);
         System.out.println(token);

     }
     @Test(dependsOnMethods = "test_delete_booking") //Dependons method using sequencing
     //@Test(priority = 4) //Priority wise sequencing
     //public void test_04_after_delete_booking(){////AlphabaticaLLY wise sequencing
         public void test_after_delete_booking(){
         System.out.println(bookingid);
    }
}
