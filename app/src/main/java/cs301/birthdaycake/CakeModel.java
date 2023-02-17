package cs301.birthdaycake;

public class CakeModel {

    public boolean candlesLit = true;
    public int candleCount = 2;
    public boolean frosting = true;
    public boolean hasCandles = true;

    private float checkerXPos;
    private float checkerYPos;
    private boolean showChecker = false;

    public void setCheckerPos(float x, float y) {
        this.checkerXPos = x;
        this.checkerYPos = y;
    }

    public float getCheckerX() {
        return checkerXPos;
    }
    public float getCheckerY() {
        return checkerYPos;
    }

    public void setShowChecker(boolean b) {
        this.showChecker = b;
    }

    public boolean getShowChecker() {
        return showChecker;
    }

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
}
