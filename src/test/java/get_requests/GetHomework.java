package get_requests;

import base_urls.TypiCodeBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetHomework extends TypiCodeBaseUrl {

    //Given URL:
    //https://jsonplaceholder.typicode.com/posts/5
    //
    //Test Scenario:
    //
    //The user sends a GET request to the above URL.
    //The HTTP status code should be 200.
    //The response should be in "application/json" format.
    //The value of the "title" field should be "nesciunt quas odio."
    //The value of the "userId" field should be 1.
    //The value of the "body" field should be "repudiandae veniam quaerat sunt sed."


    @Test
    public void name() {



            //  i)      Url kurulacak
            spec.pathParams("first", "posts", "second", 5);

            //  ii)     Beklenen data belirlenecek
            //  iii)    Request gönderilip Respons alınacak
            Response response = given(spec).when().get("{first}/{second}");

            //  iv)     Doğrulamalar yapılacak
            response
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .contentType(ContentType.JSON)
                    .body("title", equalTo("nesciunt quas odio"),
                            "userId", equalTo(1),
                            "body", containsString("repudiandae veniam quaerat sunt sed"));

            // 2. yol
            assertEquals(200, response.statusCode());
            assertEquals("application/json; charset=utf-8", response.contentType());
            assertTrue(response.asString().contains("nesciunt quas odio"));
            assertTrue(response.asString().contains("repudiandae veniam quaerat sunt sed"));


        }
    }
