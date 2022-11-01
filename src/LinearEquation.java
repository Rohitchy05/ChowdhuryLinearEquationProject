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
        return Math.sqrt((roundedToHundredth(y2 - y1) * roundedToHundredth((y2 - y1))) + (roundedToHundredth(x2 - x1) * (roundedToHundredth(x2 - x1))));
    }

    public double yIntercept() {
        return slope() * x1 - y1;
    }

    public double slope() {
        return ((roundedToHundredth(y2 - y1)) / (roundedToHundredth(x2 - x1)));
    }

    public String equation() {
        return "y =  " + slope() + "x +  " + yIntercept();
    }

    public String coordinateForX(double xValue) {
        return "(" + roundedToHundredth(xValue) + ", " + (roundedToHundredth(((xValue * slope() + yIntercept())))) + ")";
    }

    public double roundedToHundredth(double toRound) {
        return Math.round(toRound);
    }

    public String lineInfo() {
        return "The original points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n" + "The equation of the line between these points is: " + equation() + "\n" + "The slope of this line is: " + slope() + "\n" + "The y-intercept of the line is: " + yIntercept() + "\n" + "The distance between the two points is: " + distance();
    }
}
