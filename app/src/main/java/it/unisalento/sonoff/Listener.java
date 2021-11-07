package it.unisalento.sonoff;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

public class Listener implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    RestService restService;
    public Listener(Context applicationContext) {
        restService = new RestService(applicationContext);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if(compoundButton.isPressed()){
            if(compoundButton.isChecked())
                restService.changeStatusON(compoundButton);
            else if (!compoundButton.isChecked())
                restService.changeStatusOFF(compoundButton);

        }

    }

    @Override
    public void onClick(View view) {
        restService.getStatus((TextView) view.findViewById(R.id.textView));
    }
}
