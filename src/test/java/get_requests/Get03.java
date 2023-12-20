package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class Get03 {

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


        Response response = given().
                when().
                get(url);

        response.prettyPrint();

        response.
                then().
                statusCode(200).//HTTP Status Code should be 200
                statusLine("HTTP/1.1 200 OK")
                .body(containsString("Not Found"))
                .body(not(containsString("TechProEd"))).
                body("title",is("et itaque necessitatibus maxime molestiae qui quas velit"));









    }
}
