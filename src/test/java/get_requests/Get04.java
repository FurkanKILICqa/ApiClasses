package get_requests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get04 {

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

        String url = "https://jsonplaceholder.typicode.com/todos/23";

        RequestSpecBuilder spec = (RequestSpecBuilder) new RequestSpecBuilder().
                setBaseUri(url).
                setContentType(ContentType.JSON).build();




    }
}
