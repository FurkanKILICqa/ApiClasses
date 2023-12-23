package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Post02 extends JsonPlaceHolderBaseUrl {
    @Test
    public void name() {

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

        //Doğrular yapılır
        Map<String,Object> actualData = response.as(HashMap.class);//HashMap rasgele sıralar map gibi değildir
        System.out.println(actualData);

        Assert.assertEquals(201,response.statusCode());
        Assert.assertEquals(payload.get("userId"), actualData.get("userId"));
        Assert.assertEquals(payload.get("title"),actualData.get("title"));
        Assert.assertEquals(payload.get("completed"),actualData.get("completed"));
    }
}
