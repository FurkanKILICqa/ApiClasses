package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Post01 extends JsonPlaceHolderBaseUrl {


/*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2)  {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
              }
        When
            I send POST Request to the Url

        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void post() {

        //Url Hazirliyor
        spec.pathParams("first","todos");

        //Beklenen Datayı Olustur
        String payLoad = "{\n" +
                "                 \"userId\": 55,\n" +
                "                 \"title\": \"Tidy your room\",\n" +
                "                 \"completed\": false\n" +
                "              }";

        System.out.println(payLoad);


        //Request Gönder Response Alınır
       Response response = given(spec).when().post("{first}");




    }
}
