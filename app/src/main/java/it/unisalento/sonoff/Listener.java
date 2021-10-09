package it.unisalento.sonoff;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;

public class Listener implements CompoundButton.OnCheckedChangeListener {

    MQTTHelper mqttHelper;
    public Listener(MQTTHelper mqttHelper) {
        this.mqttHelper = mqttHelper;
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if(isChecked && compoundButton.isPressed())
            mqttHelper.publish("cmnd/tasmota_8231A8/POWER1", "ON");
        else if( !isChecked && compoundButton.isPressed())
            mqttHelper.publish("cmnd/tasmota_8231A8/POWER1", "OFF");

    }
}
