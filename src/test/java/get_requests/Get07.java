package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

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

        //  i)  Url belirlenir
        spec.pathParams("first","booking"
                ,"second",11);

        //  ii) Beklenen data belirlenir
        //  iii) Request gönderilip Response alınır
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        //  iv)) Doğrulamalar yapılır
        response
                .then()
                .statusCode(404)
                .contentType(ContentType.JSON)
                .body("firstname",equalTo("Josh")
                        ,"lastname",equalTo("Allen")
                        ,"totalprice",equalTo(111)
                        ,"depositpaid",equalTo(true)
                        ,"bookingdates.checkin",equalTo("2018-01-01")
                        ,"bookingdates.checkout",equalTo("2019-01-01")
                        ,"additionalneeds",equalTo("midnight snack"));

        // JsonPath :  Response data çeşitini Javada tanımlanan bir data çeşidine çevirip, body içerisindeki istenilen dataya
        //             ulaşabilmemizi sağlar(o datayı kaydedip kullanabilmeyi de sağlar)

        JsonPath json = response.jsonPath();
        assertEquals(200,response.statusCode());
        assertEquals("application/json; charset=utf-8",response.contentType());
        assertEquals("Josh",json.getString("firstname"));
        assertEquals("Allen",json.getString("lastname"));
        assertEquals(111,json.getInt("totalprice"));
        assertEquals(true,json.getBoolean("depositpaid"));
        assertEquals("2018-01-01",json.getString("bookingdates.checkin"));
        assertEquals("2019-01-01",json.getString("bookingdates.checkout"));
        assertEquals("midnight snack",json.getString("additionalneeds"));





    }
}
