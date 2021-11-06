package it.unisalento.sonoff;

import android.content.Context;
import android.widget.CompoundButton;

public class Listener implements CompoundButton.OnCheckedChangeListener {

    RestService restService;
    public Listener(Context applicationContext) {
        restService = new RestService(applicationContext);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        String status = "";
        if(compoundButton.isPressed()){
            if(compoundButton.isChecked())
                restService.changeStatusON(compoundButton, status);
            else if (!compoundButton.isChecked())
                restService.changeStatusOFF(compoundButton, status);

        }

    }
}
