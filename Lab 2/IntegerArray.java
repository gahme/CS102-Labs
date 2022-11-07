public class IntegerArray implements Comparable<IntegerArray>{
    private int[] digits;
    private boolean isPositive;


    // Constructors
    public IntegerArray(String n){
        // Assuming the number is positive
        isPositive = true;

        // Get rid of zeros in the beginning
        n = n.replaceFirst("^0+(?!$)", "");

        // Get size of input string inorder to initialize digits array
        digits = new int[n.length()];

        // Enter digits in array
        for (int i=0; i<n.length(); i++){
            digits[i] = Character.getNumericValue(n.charAt(i));
        }
    }

    public IntegerArray(String n, boolean Positive){
        // Assign the sign
        isPositive = Positive;

        // Get rid of zeros in the beginning
        n = n.replaceFirst("^0+(?!$)", "");

        // Get size of input string inorder to initialize digits array
        digits = new int[n.length()];

        // Enter digits in array
        for (int i=0; i<n.length(); i++){
            digits[i] = Character.getNumericValue(n.charAt(i));
        }
    }
    
    // Getters & Setters
    public int[] getDigits(){
        return digits;
    }


    // Utilities
    public int numberOfDigits(){
        return digits.length;
    }

    public int MID(){
        return digits[0];
    }

    public int LID(){
        return digits[digits.length-1];
    }

    public int getDigit(int index){
        // Returns the digit from the right
        return digits[numberOfDigits() - 1 - index];
    }

    public IntegerArray add(IntegerArray b){

        // Local variables
        String addString = "";
        int[] bigDigits, smallDigits;
        int carry = 0, digitSum = 0;

        // Differentiate between the bigger integer
        if (numberOfDigits() <= b.numberOfDigits()){
            bigDigits = b.getDigits();
            smallDigits = digits; 
        }
        else{
            bigDigits = digits;
            smallDigits = b.getDigits();
        }
        int lengthDiff = bigDigits.length - smallDigits.length;

        // Carry out the addition 

        // Add till smaller number
        for (int i=smallDigits.length-1 ; i>= 0; i--){
            digitSum = smallDigits[i] + bigDigits[i+lengthDiff] + carry;
            carry = digitSum / 10;
            digitSum %= 10;

            addString = Integer.toString(digitSum) + addString;
        }

        // Add remaining numbers
        for (int i=lengthDiff-1; i>=0; i--){ 
            digitSum = bigDigits[i] + carry;
            carry = digitSum / 10;
            digitSum %= 10;

            addString = Integer.toString(digitSum) + addString;
        }
        
        if (carry == 1){
            addString = Integer.toString(1) + addString;
        }

        return new IntegerArray(addString);
    }

    public IntegerArray subtract(IntegerArray b){

        // Switch numbers and sign if subtracting a bigger number from a smaller number
        if (this.compareTo(b) < 0){
            IntegerArray result = b.subtract(this);
            return new IntegerArray(result.toString(), false);
        }

        // Local Variables
        String subtractString = "";
        int[] bigDigits = getDigits();
        int[] smallDigits = b.getDigits();
        int lengthDiff = numberOfDigits() - b.numberOfDigits();


        // Carry out subtraction

        // Subract till smaller number
        for (int i=smallDigits.length-1; i>=0; i--){
            if (bigDigits[i+lengthDiff] < smallDigits[i]){
                do{
                    boolean foundNonZero = false;
                    int digitsback = 1;
                    while (!foundNonZero){
                        if (bigDigits[i-digitsback+lengthDiff] > 0){
                            foundNonZero = true;
                            bigDigits[i+lengthDiff-digitsback+1] += 10;
                            bigDigits[i-digitsback+lengthDiff] --;
                        }
                        else{
                            digitsback ++;
                        }
                    }
                } while (bigDigits[i+lengthDiff] < smallDigits[i]);
            }
            subtractString = Integer.toString(bigDigits[i+lengthDiff] - smallDigits[i]) + subtractString;
        }
        
        // Subtract remaining numbers
        for (int i=lengthDiff-1; i>= 0; i--){
            subtractString = Integer.toString(bigDigits[i]) + subtractString;
        }

        return new IntegerArray(subtractString);
    }

    // Helper methods

    public boolean isPositive(){
        return isPositive;
    }

    public int compareTo(IntegerArray b){
        /*
        // Compare current integer (a) with passed integer (b)
        */
       if (isPositive() && !b.isPositive()){ // a is positive and b is negative
           return 1;
       } 
       else if (!isPositive() && b.isPositive()){ // a is negative and b is positive
           return -1;
       }
       else if (!isPositive){  // both are negative
            if (numberOfDigits() < b.numberOfDigits()){ // a has less digits so it's bigger
                return 1;
            }
            else if (numberOfDigits() > b.numberOfDigits()){ // a has more digits so it's smaller
                return -1;
            }
            else{ // both have same digits so need to check every digit
                for (int i=numberOfDigits()-1; i>=0; i--){
                    if (getDigit(i) < b.getDigit(i)){
                        return 1;
                    }
                    else if (getDigit(i) > b.getDigit(i)){
                        return -1;
                    }
                }
                return 0; // They're the same integer
            }
       }
       else{ // both are positive
            if (numberOfDigits() > b.numberOfDigits()){ // a has more digits so it's bigger
                return 1;
            }
            else if (numberOfDigits() < b.numberOfDigits()){ // a has less digits so it's smaller
                return -1;
            }
            else{ // both have same digits so need to check every digit
                for (int i=numberOfDigits()-1; i>=0; i--){
                    if (getDigit(i) < b.getDigit(i)){
                        return -1;
                    }
                    else if (getDigit(i) > b.getDigit(i)){
                        return 1;
                    }
                }
                return 0; // They're the same integer
            }
       }
    }

    @Override
    public boolean equals(Object b){
        IntegerArray bArray = (IntegerArray) b;
        return this.toString().equals(bArray.toString());
    }

    public String toString(){
        String result = "";
        for (int i=0; i<digits.length; i++){
            result += digits[i];
        }
        return result;
    }
}