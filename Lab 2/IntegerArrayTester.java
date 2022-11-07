import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class IntegerArrayTester {
    public static void main(String args[]){

        /*
        // Testing IntegerArray class
        */
        System.out.println("Testing IntegerArray class");
        System.out.println();
        IntegerArray test1 = new IntegerArray("0012345");
        IntegerArray test2 = new IntegerArray("789");
        
        System.out.println("Testing basic stuff");
        System.out.println(test1);
        System.out.println(test1.getDigit(0) == test1.LID());
        System.out.println(test1.getDigit(test1.numberOfDigits()-1) == test1.MID());
        System.out.println();


        System.out.println(test2);
        System.out.println(test2.getDigit(0) == test2.LID());
        System.out.println(test2.getDigit(test2.numberOfDigits()-1) == test2.MID());


        // Testing Addition
        IntegerArray testA = new IntegerArray("12312");
        IntegerArray testB = new IntegerArray("111");
        IntegerArray testA1 = testA.add(testB);
        IntegerArray testC = new IntegerArray("12312");
        IntegerArray testD = new IntegerArray("00711");
        IntegerArray testA2 = testC.add(testD);
        IntegerArray testE = new IntegerArray("12312");
        IntegerArray testF = new IntegerArray("08311");
        IntegerArray testA3 = testE.add(testF);
        IntegerArray testG = new IntegerArray("999");
        IntegerArray testH = new IntegerArray("2");
        IntegerArray testA4 = testG.add(testH);
        IntegerArray testI = new IntegerArray("00000");
        IntegerArray testJ = new IntegerArray("00100");
        IntegerArray testA5 = testI.add(testJ);
        System.out.println();
        System.out.println("Testing addition");
        System.out.println(testA1.equals(new IntegerArray("12423")));
        System.out.println(testA2.equals(new IntegerArray("13023")));
        System.out.println(testA3.equals(new IntegerArray("20623")));
        System.out.println(testA4.equals(new IntegerArray("1001")));
        System.out.println(testA5.equals(new IntegerArray("00100")));

        // Testing Subtraction
        IntegerArray testSA = new IntegerArray("12012");
        IntegerArray testSB = new IntegerArray("111");
        IntegerArray testS1 = testSA.subtract(testSB);
        IntegerArray testSC = new IntegerArray("12312");
        IntegerArray testSD = new IntegerArray("00711");
        IntegerArray testS2 = testSD.subtract(testSC);
        IntegerArray testSE = new IntegerArray("12312");
        IntegerArray testSF = new IntegerArray("08311");
        IntegerArray testS3 = testSE.subtract(testSF);
        IntegerArray testSG = new IntegerArray("102456");
        IntegerArray testSH = new IntegerArray("0005217");
        IntegerArray testS4 = testSG.subtract(testSH);
        IntegerArray testSI = new IntegerArray("1002456");
        IntegerArray testSJ = new IntegerArray("0005217");
        IntegerArray testS5 = testSI.subtract(testSJ);
        IntegerArray testSK = new IntegerArray("555");
        IntegerArray testSL = new IntegerArray("545");
        IntegerArray testS6 = testSK.subtract(testSL);
        System.out.println();
        System.out.println("Testing Subtraction");
        System.out.println(testS1.equals(new IntegerArray("11901")));
        System.out.println(testS2.equals(new IntegerArray("11601", false)));
        System.out.println(testS3.equals(new IntegerArray("4001")));
        System.out.println(testS4.equals(new IntegerArray("97239")));
        System.out.println(testS5.equals(new IntegerArray("997239")));
        System.out.println(testS6.equals(new IntegerArray("10")));

        // Testing Comparison
        IntegerArray testC1 = new IntegerArray("100");
        IntegerArray testC2 = new IntegerArray("101");
        IntegerArray testC3 = new IntegerArray("1000");
        IntegerArray testC4 = new IntegerArray("100", false);
        IntegerArray testC5 = new IntegerArray("101", false);
        IntegerArray testC6 = new IntegerArray("1000", false);

        System.out.println();
        System.out.println("Testing Comparison");
        System.out.println(testC2.compareTo(testC1) > 0);
        System.out.println(testC3.compareTo(testC2) > 0);
        System.out.println(testC3.compareTo(testC6) > 0);
        System.out.println(testC4.compareTo(testC5) > 0);
        System.out.println(testC5.compareTo(testC6) > 0);

        // Testing equals
        System.out.println();
        System.out.println("Testing equals");
        IntegerArray testE1 = new IntegerArray("12345");
        IntegerArray testE2 = new IntegerArray("12345");
        IntegerArray testE3 = new IntegerArray("12335");

        System.out.println(testE1.equals(testE2));
        System.out.println(!testE1.equals(testE3));


        /*
        // Testing IntegerArrayList class
        */
        System.out.println();
        System.out.println("Testing IntegerArrayList class");
        System.out.println();

        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.print("Please enter the filename(q to quit): ");
        String fileName = in.nextLine();
        while (!fileName.equals("q")){
            IntegerArrayList testIAL = readIntegerArraysFromFile(fileName);
            int startIndex = 0;
            int middleIndex = (testIAL.getSize()-1)/2;
            int endIndex = testIAL.getSize()-1;
            System.out.println("Output:");
            System.out.println("start index = " + startIndex);
            System.out.println("start index = " + middleIndex);
            System.out.println("start index = " + endIndex);
            System.out.println("Minimum of all the numbers: ");
            System.out.println(testIAL.min(startIndex, endIndex));
            System.out.println("Minimum of the first half");
            System.out.println(testIAL.min(startIndex, middleIndex));
            System.out.println("Minimum of the second half");
            System.out.println(testIAL.min(middleIndex+1, endIndex));
            System.out.println();
            System.out.print("Please enter the filename(q to quit): ");
            fileName = in.nextLine();
        }
        in.close();
    }

    public static IntegerArrayList readIntegerArraysFromFile(String fileName){
        ArrayList<String> data = new ArrayList<String>();
        try {
            File fileObj = new File(fileName);
            Scanner in = new Scanner(fileObj);
            while (in.hasNextLine()){
                String textLine = in.nextLine();
                if(!textLine.equals("")){
                    data.add(textLine);
                }
            }
            in.close();
        } catch (FileNotFoundException e){
            System.out.println("An error occured.");
            e.printStackTrace();
        }
        return new IntegerArrayList(data);
    }
}
