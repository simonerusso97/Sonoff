package it.unisalento.sonoff;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MainActivity extends AppCompatActivity {

    Switch lockSwitch;
    TextView statusTextView;

    boolean creatingView=true;

    MQTTHelper mqttHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lockSwitch = (Switch) findViewById(R.id.lockSwitch);
        statusTextView = (TextView) findViewById(R.id.statusTextView);


        startMqtt();

        Listener listener = new Listener(mqttHelper);

        lockSwitch.setOnCheckedChangeListener(listener);

    }

    private void startMqtt(){
        mqttHelper = new MQTTHelper(getApplicationContext(),  "stat/tasmota_8231A8/POWER1");
        mqttHelper.setCallback(new MqttCallbackExtended() {
            @Override
            public void connectComplete(boolean b, String s) {
            }

            @Override
            public void connectionLost(Throwable throwable) {

            }

            @Override
            public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
                Log.w("messageArrived", "stato: " + mqttMessage);
                    if(mqttMessage.toString().equals("ON"))
                        lockSwitch.setChecked(true);
                    else
                        lockSwitch.setChecked(false);

            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
                Log.w("messageDelivered", "stato cambiato " + iMqttDeliveryToken);

            }
        });

    }
}