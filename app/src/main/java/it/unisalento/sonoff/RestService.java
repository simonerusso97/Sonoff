package it.unisalento.sonoff;

import android.content.Context;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.StringRequestListener;

import org.json.JSONArray;


public class RestService {
    public RestService(Context context) {
        AndroidNetworking.initialize(context);
    }

    String address = "http://192.168.1.67:8082";

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
    public void getStatus(TextView textView){
        AndroidNetworking.get(address+"/getStatus")
                .setPriority(Priority.LOW)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.w("Rest (getStatus()):", "stato corrente " + response);
                        if(response.equals("ON"))
                            textView.setText("Accesso consentito");
                        else
                            textView.setText("Accesso non consentito");
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e("Rest (getStatus()):", anError.toString());
                    }
                });
    }


    public void changeStatusON(CompoundButton switcher) {
        AndroidNetworking.get(address+"/changeStatusON")
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
                        switcher.setChecked(false);
                    }
                });
    }

    public void changeStatusOFF(CompoundButton switcher) {
        AndroidNetworking.get(address+"/changeStatusOFF")
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
                        switcher.setChecked(true);
                    }
                });


    }

    public void saveToken(String token) {
        AndroidNetworking.post(address+"/saveToken")
                .addBodyParameter("token", token)
                .addBodyParameter(token)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                    }
                    @Override
                    public void onError(ANError error) {
                    }
                });
    }
}
