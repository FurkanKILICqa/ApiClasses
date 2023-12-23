package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static test_data.JsonPlaceHolderTestData.jsonPlaceHolderMapper;

public class Get10 extends JsonPlaceHolderBaseUrl {

    /*
    Given
    https://jsonplaceholder.typicode.com/todos/2
    When
        I send GET Request to the URL
    Then
        Status code is 200
    And
        "completed" is false
    And
        "userId" is 1
    And     "title" is "quis ut nam facilis et officia qui"
    And     header "Via" is "1.1 vegur"
    And     header "Server" is "cloudflare"
    And     body is like
        {
        "userId": 1,
        "id": 2,
        "title": "quis ut nam facilis et officia qui",
        "completed": false
        }
    */

    @Test
    public void name() {


        spec.pathParams("first","todos"
                ,"second",2);


        Map<String,Object> expectedData=jsonPlaceHolderMapper(1,"quis ut nam facilis et officia qui",false);


        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();


        //Doğrulamalar yapilir:






    }
}
