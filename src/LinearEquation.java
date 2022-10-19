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
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }

    public double yIntercept() {
        return slope() * 0 + y1;
    }

    public double slope() {
        return (y2 - y1) / (x2 - x1);
    }

    public String equation() {
        return "y =  " + slope() + "x +  " + yIntercept();
    }
}
