package cs301.birthdaycake;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        CakeView theCake = findViewById(R.id.cakeview);
        CakeController newCake = new CakeController(theCake);
        Button blowOutButton = findViewById(R.id.button2);
        blowOutButton.setOnClickListener(newCake);
        Switch candlesSwitch = findViewById(R.id.switch2);
        candlesSwitch.setOnCheckedChangeListener(newCake);
        SeekBar candlesCount = findViewById(R.id.seekBar2);
        candlesCount.setOnSeekBarChangeListener(newCake);
        theCake.setOnTouchListener(newCake);
    }

    public void goodbye(View button) {
        Log.i("button", "goodbye");
    }
}
