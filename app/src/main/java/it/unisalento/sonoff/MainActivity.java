package it.unisalento.sonoff;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Switch lockSwitch;
    TextView statusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lockSwitch = findViewById(R.id.lockSwitch);
        statusTextView = findViewById(R.id.statusTextView);

        RestService restService = new RestService(getApplicationContext());
        restService.getStatus(this.lockSwitch);

        Listener listener = new Listener(getApplicationContext());

        lockSwitch.setOnCheckedChangeListener(listener);

    }

}