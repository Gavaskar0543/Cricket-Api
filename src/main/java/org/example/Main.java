package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import java.util.Map;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        Fetch fetch = new Fetch();
        String response = fetch.run("https://api.restful-api.dev/objects");
      //  System.out.println(response);

          JsonConverter converter = new JsonConverter(response);

        try {
            List<Map<String, Object>> jsonList = converter.convert();
            Object[] arr = jsonList.toArray();
            for(int i = 0;i<arr.length;i++){
               Object item =(Object) arr[i];
               System.out.println();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}