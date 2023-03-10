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
        Log.d("TEST","Hello I touched");
        int y = (int)motionEvent.getY();
        int x = (int)motionEvent.getX();
        //Set x and y in cakeModel
        cakeModel.setX_cord((int)motionEvent.getX());
        cakeModel.setY_cord((int)motionEvent.getY());
        //Display x and y in console
        Log.d("VAR", Integer.toString(x));
        Log.d("VAR", Integer.toString(y));
        cakeModel.balloonX = (int) motionEvent.getX();
        cakeModel.balloonY = (int) motionEvent.getY();
        cakeModel.balloonDraw = true;
        float xPos = motionEvent.getX();
        float yPos = motionEvent.getY();
        cakeModel.setCheckerPos(xPos,yPos);
        cakeModel.setShowChecker(true);
        cakeView.invalidate();
        return false;
    }
}
