package it.unisalento.sonoff;

import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestAPI {

    public RestAPI() {
    }

    public void changeStatus(String status){
        try {
            URL url = new URL("http://192.168.1.100:8080/changeStatus/"+status);
            // Create connection
            HttpURLConnection myConnection = (HttpURLConnection) url.openConnection();
            if (myConnection.getResponseCode() == 200) {
                Log.w("REST", String.valueOf(myConnection.getResponseCode()));
            } else {
                // Error handling code goes here
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
