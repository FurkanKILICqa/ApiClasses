package put_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import org.junit.Test;

import java.util.Map;

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


    }
}
