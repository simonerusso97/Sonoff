package it.unisalento.sonoff;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Switch lockSwitch;
    TextView statusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lockSwitch = (Switch) findViewById(R.id.lockSwitch);
        statusTextView = (TextView) findViewById(R.id.statusTextView);

        Listener listener = new Listener();

        lockSwitch.setOnCheckedChangeListener(listener);

    }

}