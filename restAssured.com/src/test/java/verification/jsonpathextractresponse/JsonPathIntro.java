package verification.jsonpathextractresponse;

import io.restassured.response.Response;

public class JsonPathIntro {
    public JsonPathIntro(String string) {
    }
    // How to verify the Resposne Body
    //1. We get the response in JSON String
    //1.1 Make a Request --> POST --> Request Body or Payload in JSON String
    //1.2 Response also you get in JSON String
    //2 After loging the response (response.then().log().all();)
    //2.1 Extract the reposne from the responses String and verify by using the Assert J, TestNg Assertion, Default RA

    //JsonPath
    //Json path is a query language for Json
    // It enables you to extract the specific element from JSON document/JSON String
    //It uses dot(.)anotation

    //Note How api request is created [This is the 3 Step process of testing any API] check all this in JsonPath01 class
//1.Making the request (line no.24 to 43) and getting the response line no.(43)
//2. Extract the data from response by using the Json path line no. 48 to 51
//3. Assertion it mean verify the resposne.
// Here we verify the Each field of Response

    //<---Response response = requestSpecification.when().post();--->

    // this is used to send an HTTP POST request to a server.
    //The Response object holds the server's response after the POST request is sent.
    //This includes the status code, response body, headers, and more.
    //requestSpecification
    //this is an object that holds all the request details such as headers, parameters, request body, etc.
    // You usually build the requestSpecification using methods like given(), header(), body(), contentType(), etc.
    //when() is the point where the request is executed.
    //post():
    //This sends an HTTP POST request to the server.
    // POST requests are typically used to send data (e.g., JSON or form data) to the server to create or update a resource.

    //<---requestSpecification.body(payload_POST).log().all();--->

    //requestSpecification:
    //This is an object of the RequestSpecification class that holds all the details about the HTTP request.
    // It could contain information like headers, query parameters, request body, authentication, etc.
    //.body(payload_POST):
    //This method is used to set the body of the HTTP request.
    //The payload_POST is the variable or object that contains the data you want to send in the body of the request.
    // This is commonly used for POST or PUT requests where you are sending data (like JSON, XML, or form data) to the server.

    //<---validatableResponse = response.then().log().all();--->

    //response: This is what you get back after making a request.
    //then(): Prepares the response for checking.
    //log().all(): Prints everything from the response (like status, headers, and data).
    //validatableResponse: Saves the response so you can check it later.
    //It’s just showing the response and getting ready to check it.



}
