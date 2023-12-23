package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
       Response response = given(spec).body(payLoad).contentType(ContentType.JSON).when().post("{first}");
       response.prettyPrint();


        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(201,response.statusCode());
        Assert.assertEquals(55, jsonPath.getInt("UserId"));
        Assert.assertEquals("Tidy your room",jsonPath.getString("title"));
        Assert.assertFalse(jsonPath.getBoolean("completed"));


    }

    @Test
    public void postMap() {

        //Url Olusturulacak
        spec.pathParams("first","todos");


        Map<String,Object> payload = new HashMap<>();
        payload.put("userId",555);
        payload.put("title","Tidy your room");
        payload.put("completed",false);

        //Requst Gönder Response al
        Response response = given(spec).body(payload).when().post("{first}");
        response.prettyPrint();
        /*  IllegalStateException Jackson (Databind), Gson, Johnzon, or Yasson in the classpath
        body(payLoad) içinde ki dataları dönüştüremediği için hata veriyorsa ;
        Serialization : Java objesini Json Objesine dönüştüme işlmeine denir
        */

        // Serialization: Java objesini Json Objesine dönüştürme işlemine denir
        // Serialization, Serializer denen JAckson Databind, Gson , Yasson gibi dependencyleri pom a yüklemek ile halledilir

    }
}
