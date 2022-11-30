package pojo;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

/**
 * Created by infoobjects on 11-07-2017.
 */
public class RestData {
    public Response GET(String path, String username, String pwd) {
        System.out.print("GET        : " + path);
        long start = System.currentTimeMillis();
        Response response = (Response) RestAssured.given().auth().preemptive().basic(username, pwd).header("Accept", "application/json", new Object[0]).header("Content-Type", "application/json", new Object[0]).get(path, new Object[0]);
        long end = System.currentTimeMillis() - start;
        System.out.print("Status     : " + response.getStatusLine());
        System.out.print("Time Taken : " + end + " ms");
        String contentLength = response.getHeader("Content-Length");
        if(contentLength != null && Integer.parseInt(contentLength) <= 500) {
            System.out.print("Response   : " + response.asString());
        }

        return response;
    }
}
