package test_data;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HerokuAppTestData {



    public static Map<String,String> bookingMapper (String checkin, String checkout){
        Map<String,String> map = new HashMap<>();
        map.put("checkin",checkin);
        map.put("checkout",checkout);
        return map;
    }

    public static Map<String,Object> herokuAppMapper( String firstname,String lastname,
                                                      Integer totalprice,Boolean depositpaid,Map<String,String> bookingdates
            ,String additionalneeds){
        Map<String,Object> map = new HashMap<>();
        map.put("firstname",firstname);
        map.put("lastname",lastname);
        map.put("totalprice",totalprice);
        map.put("depositpaid",depositpaid);
        map.put("bookingdates",bookingdates);
        map.put("additionalneeds",additionalneeds);
        return map;
    }

    /*

     */


    }



