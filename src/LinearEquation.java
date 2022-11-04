import java.util.*;
public class LinearEquation { //Instance variables
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public LinearEquation(int x1 ,int x2, int y1, int y2) { //Assigns values
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public double distance() {
        return roundedToHundredth(Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1))); //Measures the distance between two points
    }

    public double yIntercept() {
        return roundedToHundredth((y1 - slope() * x1));  //Measures the y-intercept
    }

    public double slope() { //Measures the slope
        if (x2 - x1 != 0)
            return roundedToHundredth(((roundedToHundredth(y2 - y1)) / (roundedToHundredth(x2 - x1))));
        return 0;
    }

    public String equation() {
        String slope = ""; //Converts slope and y-Int to string for easy changing
        String yInt;
        int differenceOfX = x2 - x1;
        int differenceOfY = y2 - y1;
        if (slope() * 10 % 10 == 0) { //Finds slope
            if (slope() == 1.0) {
                slope += "";
            } else if(slope() == -1.0) {
                slope += "-";
            } else {
                slope += (int) (slope());
            }
        } else {
            if (differenceOfX > 0 && differenceOfY > 0) {
                slope += differenceOfY + "/" + differenceOfX;
            } else if (differenceOfX < 0 && differenceOfY > 0) {
                slope += "-" + differenceOfY + "/" + Math.abs(differenceOfX);
            } else if (differenceOfX > 0 && differenceOfY < 0) {
                slope += differenceOfY + "/" + differenceOfX;
            } else if (differenceOfX < 0 && differenceOfY < 0) {
                slope += Math.abs(differenceOfY) + "/" + Math.abs(differenceOfX);
            } else {
                return "";
            }
        }
        if (yIntercept() > 0) { //Finds y-Int
            yInt = "+ " + Math.abs(yIntercept());
        } else if (yIntercept() < 0) {
            yInt = "- " + Math.abs(yIntercept());
        } else {
            yInt = "";
        }
        if (slope() == 0 || slope() == Integer.MAX_VALUE || slope() == Integer.MIN_VALUE) { //If the y-Int is 0 then a different statement returns
            if (yInt == "") {
                return "y = 0";
            } else {
                if (yIntercept() * 10 % 10 == 0) {
                    return "y = " + (int) (yIntercept());
                } else {
                    return "y = " + yIntercept();
                }
            }
        } else {
            return "y = " + slope + "x " + yInt; //Regular return statement
        }
    }
    public String coordinateForX(double xValue) { //Takes user input and calculates corresponding y-value
        return "(" + roundedToHundredth(xValue) + ", " + (roundedToHundredth(((xValue * slope() + yIntercept())))) + ")";
    }

    public double roundedToHundredth(double toRound) { //Used to round values for other methods
        return Math.round(toRound * 100.0) / 100.0;
    }

    public String lineInfo() { //Prints the final value
        return "The original points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n" + "The equation of the line between these points is: " + equation() + "\n" + "The slope of this line is: " + slope() + "\n" + "The y-intercept of the line is: " + yIntercept() + "\n" + "The distance between the two points is: " + distance();
    }
}
