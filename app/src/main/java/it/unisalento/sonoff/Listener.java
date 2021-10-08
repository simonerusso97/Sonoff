package it.unisalento.sonoff;

import android.content.Context;
import android.view.View;

public class Listener implements View.OnClickListener {

    public Listener(MQTTHelper mqttHelper) {
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.lockSwitch) {

        }
    }
}
