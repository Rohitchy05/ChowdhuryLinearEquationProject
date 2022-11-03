import java.util.*;
public class LinearEquation {
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public LinearEquation(int x1 ,int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public double distance() {
        return roundedToHundredth(Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1)));
    }

    public double yIntercept() {
        return y1 - slope() * x1;
    }

    public double slope() {
        return ((roundedToHundredth(y2 - y1)) / (roundedToHundredth(x2 - x1)));
    }

    public String equation() {
        String wholeNum = Double.toString(Math.abs(slope()));
        int integerNum = wholeNum.indexOf('.');
        int decimalNum = wholeNum.length() - integerNum - 1;
        if (wholeNum.length() == 3 && wholeNum.charAt(wholeNum.length() - 1) == 0) {
            decimalNum = 0;
        } else {
            double converted_slope = slope() * Math.pow(10, decimalNum);
            int divisor = GCD((int) converted_slope, (int) Math.pow(10, decimalNum));
            return "y =  " + converted_slope / divisor + "/" + ((Math.pow(10, decimalNum)) / divisor) + "x +  " + yIntercept();
        }
    }

    public static int GCD(int numer, int denom) {
        if (denom == 0) {
            return numer;
        } else {
            return GCD(denom, numer % denom);
        }
    }

    public String coordinateForX(double xValue) {
        return "(" + roundedToHundredth(xValue) + ", " + (roundedToHundredth(((xValue * slope() + yIntercept())))) + ")";
    }

    public double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100.0) / 100.0;
    }

    public String lineInfo() {
        return "The original points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n" + "The equation of the line between these points is: " + equation() + "\n" + "The slope of this line is: " + slope() + "\n" + "The y-intercept of the line is: " + yIntercept() + "\n" + "The distance between the two points is: " + distance();
    }
}
