import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("Enter coordinate 1: ");
        String coordinate1 = scan.nextLine();
        System.out.println("Enter coordinate 2: ");
        String coordinate2 = scan.nextLine();
        if (coordinate1.contains("(")) { //Removes brackets from user inputs
            coordinate1 = coordinate1.replace("(", "").replace(")", "").replace(",","");
        }
        if (coordinate2.contains("(")) {
            coordinate2 = coordinate2.replace("(", "").replace(")", "").replace(",","");
        }

        int x1 = Integer.parseInt(coordinate1.substring(0, coordinate1.indexOf(" "))); //Converts string to int
        int y1 = Integer.parseInt(coordinate1.substring(coordinate1.indexOf(" ")+ 1));
        int x2 = Integer.parseInt(coordinate2.substring(0, coordinate2.indexOf(" ")));
        int y2 = Integer.parseInt(coordinate2.substring(coordinate2.indexOf(" ") + 1));

        LinearEquation rc = new LinearEquation(x1, x2, y1, y2); //Object
        System.out.println(rc.lineInfo());
        System.out.println("Enter a value for x: ");
        Double xCoordinate = scan.nextDouble();
        System.out.println(rc.coordinateForX(xCoordinate));
    }
}
