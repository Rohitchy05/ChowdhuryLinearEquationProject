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
        double numerator = slope();
        int denominator = 1;
        numerator *= 100;
        denominator *= 100;
        for (int i = 1; i <= numerator && i <= denominator; i++) {
            if (numerator % i == 0 && denominator % i == 0)
                numerator /= i;
                denominator /= i;
        }
        //String s = String.valueOf(slope());
        //int decimalDigit = s.length() - 1 - s.indexOf('.');
        //int denominator = 1;
        //for (int i = 0; i < decimalDigit; i++) {
            //double slope = slope();
            //slope *= 10;
            //denominator *= 10;
        //}
        //int numerator = (int) Math.round(slope());
        return "y =  " + numerator + "/" + (int) denominator + "x +  " + yIntercept();
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
