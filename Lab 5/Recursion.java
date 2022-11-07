import java.util.ArrayList;
import java.util.Arrays;

public class Recursion {
    public static void main(String args[]){

        // Testing Question 1
        System.out.println("Testing Question 1:");
        // My testcases
        System.out.println(true == question1(12, 4, 3));
        System.out.println(true == question1(12, 5, 3));
        System.out.println(false == question1(12, 5, 2));
        // Provided testcases
        System.out.println(true == question1(29, 5, 10));
        System.out.println(false == question1(75, 25, 7));
        System.out.println(true == question1(74, 30, 16));
        System.out.println(false == question1(75, 25, 0));
        System.out.println(true == question1(75, 75, 0));

        // Testing Question 2
        System.out.println("\nTesting Question 2:");
        System.out.println(question2(new int[][] {{45, 50}, {10, 85}, {15, 45}, {20, 100}, {25, 6},{100, 100}}, 150));
        System.out.println(question2(new int[][] {{45, 50}, {10, 85}, {15, 45}, {20, 100}, {25, 6},{100, 100}}, 0));
        System.out.println(question2(new int[][] {{45, 50}, {10, 85}, {15, 45}, {20, 100}, {25, 6},{100, 100}}, 1000));
        System.out.println(question2(new int[][] {{60, 75}, {50, 85}, {200, 65}, {15, 100}, {40, 55}}, 50));
        System.out.println(question2(new int[][] {{60, 75}, {50, 85}, {200, 65}, {15, 100}, {40, 55}}, 115));

        // Testing Question 3
        System.out.println("\nTesting Question 3:");
        // My testcases
        System.out.println(2 == question3("exclamation", "excavation"));
        System.out.println(3 == question3("exclamation", "exclamatory"));
        System.out.println(2 == question3("exclamation", "excalamatioan"));
        System.out.println(2 == question3("exclamation", "excamtion"));
        System.out.println(2 == question3("exclamation", "exclaqatqon"));
        System.out.println(1 != question3("exclamation", "excavation"));
        // Provided testcases
        System.out.println(question3( "sunday", "saturday") == 3);
        System.out.println(question3( "exclamation", "excavation") == 2);
        System.out.println(question3( "inquire", "ensure") == 3);
        System.out.println(question3( "car", "race") == 3);
        System.out.println(question3( "man", "men") == 1);
        System.out.println(question3( "plane", "plane") == 0);
    }

    /**
     * Question 1
     */
    public static boolean question1(int n, int k, int a){
        return question1Helper(n, k, a, 0);
    }

    public static boolean question1Helper(int n, int k, int a, int call){
        if (call <= a){
            if (k == n && a == call){
                return true;
            }
            else{
                return question1Helper(n-2, k, a, call+1) || question1Helper(n-3, k, a, call+1);
            }
        }
        return false;
    }

    /**
     * Question 2
     */
    public static ArrayList<Integer> question2(int[][] arr, int N){  
        return question2Helper(arr, N, arr.length);
    }

    // Helper methods
    public static ArrayList<Integer> question2Helper(int[][] arr, int N, int n){  // arr[space][value]
        ArrayList<Integer> answer = new ArrayList<Integer>();
        // Base case 
        if (n == 0 || N == 0){
            return answer;
        }
        // Current game can't fit
        else if (arr[n-1][0] > N){
            return question2Helper(arr, N, n-1);
        }
        else{
            ArrayList<Integer> include = new ArrayList<Integer>(Arrays.asList(arr[n-1][1]));
            ArrayList<Integer> exclude = new ArrayList<Integer>();
            include.addAll(question2Helper(arr, N - arr[n-1][0], n-1));
            exclude.addAll(question2Helper(arr, N, n-1));
            // Get the maximum of both choices
            return arrayListMax(include, exclude);
        }
    }

    public static ArrayList<Integer> arrayListMax(ArrayList<Integer> a, ArrayList<Integer> b){
        int aSum = 0, bSum =0;
        for (int v : a){
            aSum += v;
        }
        for (int v : b){
            bSum += v;
        }
        if (aSum >= bSum){
            return a;
        }else{
            return b;
        }
    }

    /**
     * Question 3
     */
    public static int question3(String a, String b){
         // When one of the strings is empty the minimum operations required  are the length of the other string
        if (a.isEmpty()) return b.length();
        if (b.isEmpty()) return a.length();

        // Addition 
        int addition = question3(a, b.substring(1)) + 1;

        // Removal
        int removal =   question3(a.substring(1), b) + 1;

        // Substitution
        int substitution = question3(a.substring(1), b.substring(1));
        if (a.charAt(0) != b.charAt(0)) substitution += 1;

        // Return minimum of all procedures
        return Math.min(addition, Math.min(removal, substitution));
    }
}
