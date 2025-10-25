package verification.handle_payload;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class pojo2 {
  
    @Test
    public void payloadpostbyusingHashMap(){
    	// In this we learn how to handle payload
        //1. String --> this is we are using uses when you have 100 TC 4%
        //2. HashMap --> uses when TC is b/w 100 to 500 2%
        //3. class --> uses when TC is greater then 500 95%
    }
}

