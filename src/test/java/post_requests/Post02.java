package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static test_data.JsonPlaceHolderTestData.jsonPlaceHolderMapper;

public class Post02 extends JsonPlaceHolderBaseUrl {
    @Test
    public void name() {

        //Url Olusturulacak
        spec.pathParams("first","todos");

        Map<String,Object> payLoad = jsonPlaceHolderMapper(55,"Tidy your room",false);


        Map<String,Object> payload = new HashMap<>();
        payload.put("userId",555);
        payload.put("title","Tidy your room");
        payload.put("completed",false);

        //Requst Gönder Response al
        Response response = given(spec).body(payload).when().post("{first}");
        response.prettyPrint();
        /*  IllegalStateException Jackson (Databind), Gson, Johnzon, or Yasson in the classpath
        body(payLoad) içinde ki dataları dönüştüremediği için hata veriyorsa ;
        Serialization : Java objesini Json Objesine dönüştüme işlmeine denirsdsf
        */

        // Serialization: Java objesini Json Objesine dönüştürme işlemine denirasfasf
        // Serialization, Serializer denen JAckson Databind, Gson , Yasson gibi dependencyleri pom a yüklemek ile halledilir

        //Doğrular yapılır
        Map<String,Object> actualData = response.as(HashMap.class);//HashMap rasgele sıralar map gibi değildir
        System.out.println(actualData);

        assertEquals(201,response.statusCode());
        assertEquals(payload.get("userId"), actualData.get("userId"));
        assertEquals(payload.get("title"),actualData.get("title"));
        assertEquals(payload.get("completed"),actualData.get("completed"));
    }

    // Post01 deki task map oluşturmayı metod içinde hallederek geliştirildi
    @Test
    public void postMap(){
        // Url Oluşturulacak
        spec.pathParam("first","todos");

        // Beklenen Datayı oluştur
        Map<String,Object> payLoad = jsonPlaceHolderMapper(55,"Tidy your room",false);


        // Request Gönder Response al
        Response response = given(spec).body(payLoad).when().post("{first}");
        // Serialization: Java objesini Json Objesine dönüştürme işlemine denir
        response.prettyPrint();
        // Serialization, Serializer denen JAckson Databind, Gson , Yasson gibi dependencyleri pom a yüklemek ile halledilir

        // Doğrulamalar yapılır:
        Map<String,Object> actualData = response.as(HashMap.class);
        System.out.println(actualData);

        assertEquals(201,response.statusCode());
        assertEquals(payLoad.get("userId"),actualData.get("userId"));
        assertEquals(payLoad.get("title"),actualData.get("title"));
        assertEquals(payLoad.get("completed"),actualData.get("completed"));


    }
}
