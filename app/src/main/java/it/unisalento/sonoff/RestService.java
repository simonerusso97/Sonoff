package it.unisalento.sonoff;

import android.content.Context;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;

public class RestService {
    public RestService(Context context) {
        AndroidNetworking.initialize(context);
    }

    public void getStatus(Switch switcher){
        AndroidNetworking.get("http://192.168.1.100:8080/getStatus")
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
                        Log.w("Rest (getStatus()):", anError);
                    }
                });
    }

    public void changeStatus(CompoundButton switcher, String status) {
        AndroidNetworking.get("http://192.168.1.100:8080/changeStatus/{status}")
                .addPathParameter("status", status)
                .setPriority(Priority.LOW)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.w("Rest (changeStatus()):", "stato corrente " + status);
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.w("Rest (changeStatus()):", anError);
                        switcher.setChecked(!status.equals("ON"));
                    }
                });
    }
}
