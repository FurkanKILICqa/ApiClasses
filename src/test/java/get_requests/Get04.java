package get_requests;

import org.junit.Test;
import base_urls.JsonPlaceHolderBaseUrl;

import static io.restassured.RestAssured.given;

public class Get04 extends JsonPlaceHolderBaseUrl {

    /*
        Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
		And
		    Response format should be "application/json"
		And
		    "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
		And
		    "completed" is false
		And
		    "userId" is 2
    */

    @Test
    public void name() {


        // i) Url kurulacak
        spec.pathParams("first","todos","second",23);
        // ii) Beklenen data belirlenecek
        // iii) Request gönderilip Response alınacak

        given(spec).when().get().prettyPrint();
        // iv) Doğrulamalar yapılacak




    }
}
