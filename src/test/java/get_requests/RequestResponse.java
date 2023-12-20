package day02_RequestRespons;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class C01_RequestResrpons {

    /*
     1) Manuel testler için Postman kulllanacağız
    2) Otomasyon testleri için Rest Assured Library kulllanacağız
    3) Test caseler yazılırken şu adımları takip edelim:
        i) Önkoşullar iyi anlaşılmalı
        ii) Test case yazılırken Gherkin dili kullanılır:
            Given : Önkoşullar -----> url , body, ....
            When: Aksiyon -----> get(), post() .....
            Then: Doğrulamalar
            And: Çoklu durumları birbirine bağlamakta kullanılır

    4) Otomasyon testi yazarken aşağıdaki adımları izleyebiliriz:
        i) Url kurulacak
        ii) Beklenen data belirlenecek
        iii) Request gönderilip Response alınacak
        iv) Doğrulamalar yapılacak
    */

    public static void main(String[] args) {

        //i) Url kurulacak
        String url = "https://petstore.swagger.io/v2/pet/1996";

         //Base url : https://petstore.swagger.io/v2
         //1.path parametresi : /pet
         //2. path parametresi :/5

        //ii) Beklenen data belirlenecek
        //iii) Request gönderilip Response alınacak
       Response response = given().when().get(url);
        response.prettyPrint();

        //Status code a nasıl ulaşılır / yazdılılır



    }




}
