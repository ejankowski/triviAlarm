package org.b14.trivialarm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;

public class AlertActivity extends AppCompatActivity {

    private Button submitAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null) {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        final Ringtone ringtone = RingtoneManager.getRingtone(this, alarmUri);
        final Card card = Deck.getCard();

        //submitAnswer = (Button) findViewById(R.id.submitAnswer);

        submitAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answerCheck(card)) {
                    ringtone.stop();
                }
            }
        });

        while (true) {
            ringtone.play();
        }

    }

    public boolean answerCheck(Card card) {
        return true;
    }


}
