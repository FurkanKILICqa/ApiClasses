package patch_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Patch01 extends JsonPlaceHolderBaseUrl {

    /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "title": "Wash the dishes gg hh hh kk jj ıı oo"
               }
        When
	 		I send PATCH Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 10,
									    "title": "Wash the dishes",
									    "completed": true,
									    "id": 198
									    }
     */
    @Test
    public void patch(){
        // Url Kurulacak:
        spec.pathParams("first","todos","second",198);

        // Beklenen data oluşturulur:
        Map<String,Object> payLoad =  JsonPlaceHolderTestData.jsonPlaceHolderMapper(null,"Wash the dishes",null);
        Map<String,Object> expectedData = JsonPlaceHolderTestData.jsonPlaceHolderMapper(10,"Wash the dishes",true);

        System.out.println("payLoad = " + payLoad);

        // Request ------ Response:
        Response response = given(spec).body(payLoad).when().patch("{first}/{second}");
        response.prettyPrint();

        // Doğrulamalar yapılır:
        Map<String,Object> actualData =  response.as(HashMap.class);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));


    }
}
