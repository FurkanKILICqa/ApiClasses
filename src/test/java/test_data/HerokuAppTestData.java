package test_data;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HerokuAppTestData {



    public static Map<String,String> bookingMapper(String checkin){
        Map<String,String> bookingMap = new HashMap<>();
        bookingMap.put("checkin","2018-01-01");
        bookingMap.put("checkout","2019-01-01");
        System.out.println("bookingMap = " + bookingMap);


        return bookingMap;
    }



}
