public class LinearEquation {
    private double x1;
    private double x2;
    private int y1;
    private int y2;

    public LinearEquation(int x1 ,int x2, int y1, int y2) {
        if (x1 == x2) {
            System.out.println("x1 and x2 cannot be the same value!");
        }
    }

}
