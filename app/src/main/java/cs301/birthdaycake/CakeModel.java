package cs301.birthdaycake;

public class CakeModel {

    public boolean candlesLit = true;
    public int candleCount = 2;
    public boolean frosting = true;
    public boolean hasCandles = true;
    public boolean balloonDraw = false;
    public int balloonX;
    public int balloonY;

    public void setCandlesLit(boolean input) {
        candlesLit = input;
    }

    public void setHasCandles(boolean input) {
        hasCandles = input;
    }

    public boolean getHasCandles(){
        return hasCandles;
    }

    public void setCandleCount(int input) {
        candleCount = input;
    }

    public int getCandleCount(){
        return candleCount;
    }

    public boolean drawBalloonConfirmed() { return balloonDraw;}
}
