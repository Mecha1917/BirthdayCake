package cs301.birthdaycake;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;

public class CakeView extends SurfaceView {

    /* These are the paints we'll use to draw the birthday cake below */
    Paint cakePaint = new Paint();
    Paint frostingPaint = new Paint();
    Paint candlePaint = new Paint();
    Paint outerFlamePaint = new Paint();
    Paint innerFlamePaint = new Paint();
    Paint wickPaint = new Paint();
    Paint balloonLine = new Paint();
    //Paint var for textPaint
    Paint textPaint = new Paint();

    Paint checkerPaint1 = new Paint();
    Paint checkerPaint2 = new Paint();

    /* These constants define the dimensions of the cake.  While defining constants for things
        like this is good practice, we could be calculating these better by detecting
        and adapting to different tablets' screen sizes and resolutions.  I've deliberately
        stuck with hard-coded values here to ease the introduction for CS371 students.
     */
    public static final float cakeTop = 400.0f;
    public static final float cakeLeft = 100.0f;
    public static final float cakeWidth = 1200.0f;
    public static final float layerHeight = 200.0f;
    public static final float frostHeight = 50.0f;
    public static final float candleHeight = 300.0f;
    public static final float candleWidth = 60.0f;
    public static final float wickHeight = 30.0f;
    public static final float wickWidth = 6.0f;
    public static final float outerFlameRadius = 30.0f;
    public static final float innerFlameRadius = 15.0f;
    public static final float balloonHeight = 140.0f;
    public static final float balloonWidth = 100.0f;

    public static final float checkerSize = 60.0f;

    private CakeModel cakeModel;

    public CakeModel getCake() {
        return cakeModel;
    }

    /**
     * ctor must be overridden here as per standard Java inheritance practice.  We need it
     * anyway to initialize the member variables
     */
    public CakeView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //This is essential or your onDraw method won't get called
        setWillNotDraw(false);

        //Setup our palette
        cakePaint.setColor(0xFF32CD32);  //violet-red
        cakePaint.setStyle(Paint.Style.FILL);
        frostingPaint.setColor(0xFFFFFACD);  //pale yellow
        frostingPaint.setStyle(Paint.Style.FILL);
        candlePaint.setColor(0xFF32CD32);  //lime green
        candlePaint.setStyle(Paint.Style.FILL);
        outerFlamePaint.setColor(0xFFFFD700);  //gold yellow
        outerFlamePaint.setStyle(Paint.Style.FILL);
        innerFlamePaint.setColor(0xFFFFA500);  //orange
        innerFlamePaint.setStyle(Paint.Style.FILL);
        wickPaint.setColor(Color.BLACK);
        wickPaint.setStyle(Paint.Style.FILL);
        //Set textPaint
        textPaint.setColor(Color.RED);
        textPaint.setTextSize(150);
        checkerPaint1.setColor(Color.GREEN);
        checkerPaint1.setStyle(Paint.Style.FILL);
        checkerPaint2.setColor(Color.RED);
        checkerPaint2.setStyle(Paint.Style.FILL);


        setBackgroundColor(Color.WHITE);  //better than black default

        cakeModel = new CakeModel();

    }

    public void drawChecker(Canvas c, float x, float y) {
        c.drawRect(x-checkerSize, y-checkerSize,x+checkerSize,y+checkerSize, checkerPaint1);
        c.drawRect(x-checkerSize, y-checkerSize,x,y, checkerPaint2);
        c.drawRect(x, y,x+checkerSize,y+checkerSize, checkerPaint2);
    }

    /**
     * draws a candle at a specified position.  Important:  the left, bottom coordinates specify
     * the position of the bottom left corner of the candle
     */


    public void drawCandle(Canvas canvas, float left, float bottom) {
        if (cakeModel.hasCandles == true) {
            canvas.drawRect(left, bottom - candleHeight, left + candleWidth, bottom, candlePaint);

            if (cakeModel.candlesLit == true) {
                //draw the outer flame
                float flameCenterX = left + candleWidth / 2;
                float flameCenterY = bottom - wickHeight - candleHeight - outerFlameRadius / 3;
                canvas.drawCircle(flameCenterX, flameCenterY, outerFlameRadius, outerFlamePaint);

                //draw the inner flame
                flameCenterY += outerFlameRadius / 3;
                canvas.drawCircle(flameCenterX, flameCenterY, innerFlameRadius, innerFlamePaint);
            }

            //draw the wick
            float wickLeft = left + candleWidth/2 - wickWidth/2;
            float wickTop = bottom - wickHeight - candleHeight;
            canvas.drawRect(wickLeft, wickTop, wickLeft + wickWidth, wickTop + wickHeight, wickPaint);
        }
    }

    /**
     * onDraw is like "paint" in a regular Java program.  While a Canvas is
     * conceptually similar to a Graphics in javax.swing, the implementation has
     * many subtle differences.  Show care and read the documentation.
     *
     * This method will draw a birthday cake
     */
    @Override
    public void onDraw(Canvas canvas)
    {
        //top and bottom are used to keep a running tally as we progress down the cake layers
        float top = cakeTop;
        float bottom = cakeTop + frostHeight;

        //Frosting on top
        canvas.drawRect(cakeLeft, top, cakeLeft + cakeWidth, bottom, frostingPaint);
        top += frostHeight;
        bottom += layerHeight;

        //Then a cake layer
        canvas.drawRect(cakeLeft, top, cakeLeft + cakeWidth, bottom, cakePaint);
        top += layerHeight;
        bottom += frostHeight;

        //Then a second frosting layer
        canvas.drawRect(cakeLeft, top, cakeLeft + cakeWidth, bottom, frostingPaint);
        top += frostHeight;
        bottom += layerHeight;

        //Then a second cake layer
        canvas.drawRect(cakeLeft, top, cakeLeft + cakeWidth, bottom, cakePaint);

        //Now a candle in the center
        for(int i = 1; i <= cakeModel.candleCount; i++){
            drawCandle(canvas, cakeLeft + (i * cakeWidth / (cakeModel.candleCount+1)) - (candleWidth / 2), cakeTop);
        }
        //Drawing Red Text
        canvas.drawText("" + cakeModel.getX_cord() + ", " + cakeModel.getY_cord(), 700, 500, textPaint);

        //draw checker board
        if (cakeModel.getShowChecker()) {
            drawChecker(canvas, cakeModel.getCheckerX(), cakeModel.getCheckerY());
        }

        //Calls drawBalloon
        if (cakeModel.balloonDraw == true){
            drawBalloon(canvas, cakeModel.balloonX, cakeModel.balloonY);
        }
    }//onDraw

    public void drawBalloon(Canvas canvas, int x, int y)
    {
        //Sets color to blue
        balloonLine.setColor(Color.BLUE);
        //draws the balloon itself
        canvas.drawOval(x - balloonWidth/2, y - balloonHeight/2, x+balloonWidth/2, y+balloonHeight/2, balloonLine);
        //Sets color to black
        balloonLine.setColor(Color.BLACK);
        //Draws the balloon string
        canvas.drawLine(x,y+balloonHeight/2, x, y+balloonHeight/2+100, balloonLine);
    }

}//class CakeView

