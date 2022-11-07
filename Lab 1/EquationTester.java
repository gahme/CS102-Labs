import java.util.Scanner;

public class EquationTester {
    public static void main(String args[]){

        Scanner in = new Scanner(System.in);

        Equation test1 = new Equation(2431, 102, 595);
        Equation test2 = new Equation(208, -368, 1276);
        Equation test3 = new Equation(-7038, 2646, 558);
        Equation test4 = new Equation(28, 3, 25);
        test1.reduceEquation();
        test2.reduceEquation();
        test3.reduceEquation();
        test4.reduceEquation();

        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);
        System.out.println(test4);

        // Testing addition
        System.out.print("Enter the value of a, b and c for first equation: ");
        int[] inputs_1 = new int[3];
        for (int i=0; i<3; i++){
            inputs_1[i] = in.nextInt();
        }
        Equation test11 = new Equation(inputs_1[0], inputs_1[1], inputs_1[2]);
        System.out.print("Enter the value of a, b and c for second equation: ");
        int[] inputs_2 = new int[3];
        for (int i=0; i<3; i++){
            inputs_2[i] = in.nextInt();
        }
        Equation test12 = new Equation(inputs_2[0], inputs_2[1], inputs_2[2]);

        System.out.println("Sum of the equaions: " + test11.add(test12));

        // Testing subtraction
        System.out.println();
        System.out.print("Enter the value of a, b and c for first equation: ");
        int[] inputs_3 = new int[3];
        for (int i=0; i<3; i++){
            inputs_3[i] = in.nextInt();
        }
        Equation test13 = new Equation(inputs_3[0], inputs_3[1], inputs_3[2]);
        System.out.print("Enter the value of a, b and c for second equation: ");
        int[] inputs_4 = new int[3];
        for (int i=0; i<3; i++){
            inputs_4[i] = in.nextInt();
        }
        Equation test14 = new Equation(inputs_4[0], inputs_4[1], inputs_4[2]);

        System.out.println("Subtraction of the equations: " + test13.subtract(test14));




        in.close();
    }
    
}
