package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import org.junit.Test;

public class Get05 extends JsonPlaceHolderBaseUrl {

    /*
        Given
            https://jsonplaceholder.typicode.com/todos
        And
	        Accept type is "application/json"
        When
	 	    I send a GET request to the Url
	    Then
	        HTTP Status Code should be 200
	    And
	        Response format should be "application/json"
	    And
	        There should be 200 todos
	    And
	        "quis eius est sint explicabo" should be one of the todos title
	    And
	        2, 7, and 9 should be among the userIds
     */

    @Test
    public void name() {

        spec.pathParams("first","todos");





    }
}
