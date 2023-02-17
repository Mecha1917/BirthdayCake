package cs301.birthdaycake;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener{

    private CakeModel cakeModel;
    private CakeView cakeView;

    public CakeController(CakeView cakeView) {
        this.cakeView = cakeView;
        this.cakeModel = cakeView.getCake();
    }

    @Override
    public void onClick(View view) {
        Log.i("Event", "Event Triggered");
        cakeModel.setCandlesLit(false);
        cakeView.invalidate();
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        Log.i("Event", "Candles Toggle Alert");
        cakeModel.setHasCandles(b);
        if (cakeModel.getHasCandles() == true) {
            cakeView.invalidate();
            Log.i("Event", "Candles Toggle Set to True");
        }
        else {
            cakeView.invalidate();
            Log.i("Event", "Candles Toggle Set to False");
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        Log.i("Event", "Seekbar has been Adjusted");
        cakeModel.setCandleCount(i);
        cakeView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        Log.i("Event", "Progress has been Made");
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Log.i("Event", "Progress has been Made");
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Log.i("Event", "Touch Alert");
        cakeModel.balloonX = (int) motionEvent.getX();
        cakeModel.balloonY = (int) motionEvent.getY();
        cakeModel.balloonDraw = true;
        cakeView.invalidate();
        return true;
    }
}
