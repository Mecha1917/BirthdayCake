package cs301.birthdaycake;

public class CakeModel {

    public boolean candlesLit = true;
    public int candleCount = 2;
    public boolean frosting = true;
    public boolean hasCandles = true;
    public boolean balloonDraw = false;
    public int balloonX;
    public int balloonY;



    //Cordinates for RedText cordinates with getters and setters
    public int X_cord;
    public int Y_cord;

    public int getY_cord() {
        return Y_cord;
    }
    public int getX_cord() {
        return X_cord;
    }

    public void setX_cord(int x_cord) {
        X_cord = x_cord;
    }
    public void setY_cord(int y_cord) {
        Y_cord = y_cord;
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

    public boolean drawBalloonConfirmed() { return balloonDraw;}
}
