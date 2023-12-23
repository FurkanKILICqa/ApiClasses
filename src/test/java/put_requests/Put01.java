package put_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static test_data.JsonPlaceHolderTestData.jsonPlaceHolderMapper;

public class Put01 extends JsonPlaceHolderBaseUrl {

    /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "userId": 55,
                 "title": "Wash the dishes",
                 "completed": false
               }
        When
	 		I send PUT Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 55,
									    "title": "Wash the dishes",
									    "completed": false
									   }
     */

    @Test
    public void put() {
        //Url Kurulacak
        spec.pathParams("first","todos","second",198);


        Map<String,Object> payLoad = jsonPlaceHolderMapper(55,"Wash the dishes",false);

        // Request Göderip Response alınacak:
        Response response = given(spec).body(payLoad).when().put("{first}/{second}");
        response.prettyPrint();
        // Serialization: Java objesini Json Objesine dönüştürme işlemine denir
        // Serialization, Serializer denen JAckson Databind, Gson , Yasson gibi dependencyleri pom a yüklemek ile halledilir

        // Doğrulamalar Yapılır
        Map<String,Object> actualData =  response.as(HashMap.class);

        assertEquals(200,response.statusCode());
        assertEquals(payLoad.get("userId"),actualData.get("userId"));
        assertEquals(payLoad.get("title"),actualData.get("title"));
        assertEquals(payLoad.get("completed"),actualData.get("completed"));


    }
}
