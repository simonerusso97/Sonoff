package it.unisalento.sonoff;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;

public class Listener implements CompoundButton.OnCheckedChangeListener {

    public Listener() {
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if(isChecked && compoundButton.isPressed()){

        }
        else if( !isChecked && compoundButton.isPressed()){

        }

    }
}
