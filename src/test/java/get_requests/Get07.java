package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get07 extends JsonPlaceHolderBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking/11
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json"
        And
            Response body should be like;
                        {
                            "firstname": "John",
                            "lastname": "Smith",
                            "totalprice": 111,
                            "depositpaid": true,
                            "bookingdates": {
                                "checkin": "2018-01-01",
                                "checkout": "2019-01-01"
                            },
                            "additionalneeds": "Breakfast"
                        }

                        Task 1


     */

    @Test
    public void name() {

        spec.pathParams("first","booking","second,11");

       Response response = given(spec).when().get("{first}","{second}");
        response.prettyPrint();


        response.then().statusCode(200).contentType(ContentType.JSON).body()


    }
}
