package csc5nz.com.github.codered;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageButton bt;
    SoundPool soundPool;
    int alarmID, ohnoID, stopID;
    Boolean loaded = false;
    Random rand;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt = (ImageButton)findViewById(R.id.imageButton);

        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                loaded = true;
            }
        });
        alarmID = soundPool.load(this, R.raw.alarm, 1 );
        ohnoID = soundPool.load(this, R.raw.ohno, 1 );
        stopID = soundPool.load(this, R.raw.stop, 1 );

        rand = new Random();
}

    public void buttonPressed(View view) {
        int randNumber = rand.nextInt(10);

        if(loaded){
            if(randNumber<3) {
                soundPool.play(ohnoID, 1.0f, 1.0f, 1, 0, 1f);
            }
            else if(randNumber==3) {
                soundPool.play(stopID, 1.0f, 1.0f, 1, 0, 1f);
            }
            else {
                soundPool.play(alarmID, 1.0f, 1.0f, 1, 0, 1f);
            }
        }

    }
}