package it.unisalento.sonoff;

import android.content.Context;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.StringRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

public class RestService {
    public RestService(Context context) {
        AndroidNetworking.initialize(context);
    }

    String address = "http://192.168.1.67:3000";

    public void getStatus(Switch switcher){
        AndroidNetworking.get(address+"/getStatus")
                .setPriority(Priority.LOW)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.w("Rest (getStatus()):", "stato corrente " + response);
                        switcher.setChecked(response.equals("ON"));
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e("Rest (getStatus()):", anError.toString());
                    }
                });
    }

    public void changeStatus(CompoundButton switcher, String status) {
        AndroidNetworking.post(address+"/changeStatus")
                .addBodyParameter("status", status)
                .setPriority(Priority.LOW)
                .build()
                .getAsString(new StringRequestListener() {

                    @Override
                    public void onResponse(String response) {
                        Log.w("Rest (changeStatus()):", "stato corrente " + response);
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e("Rest (changeStatus()):", anError.toString());
                        switcher.setChecked(!status.equals("ON"));
                    }
                });


    }
}
