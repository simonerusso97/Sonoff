package it.unisalento.sonoff;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Switch lockSwitch;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lockSwitch = findViewById(R.id.lockSwitch);
        button = findViewById(R.id.button);

        RestService restService = new RestService(getApplicationContext());
        restService.getStatus(this.lockSwitch);

        Listener listener = new Listener(getApplicationContext());

        lockSwitch.setOnCheckedChangeListener(listener);
        button.setOnClickListener(listener);

    }

}