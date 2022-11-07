import java.util.ArrayList;

public class IntegerArrayList {
    // Variables
    private ArrayList<IntegerArray> numbers = new ArrayList<IntegerArray>();

    // Constructor
    public IntegerArrayList(ArrayList<String> input){
        for (String integerString: input){
            numbers.add(new IntegerArray(integerString));
        }
    }

    // Utilities
    public int getSize(){
        return numbers.size();
    }

    public IntegerArray getIntegerArray(int index){
        return numbers.get(index);
    }

    public void setIntegerArrayAt(int index, IntegerArray intArr){
        numbers.add(index, intArr);
    }

    public void addIntegerArray(String number){
        numbers.add(new IntegerArray(number));
    }

    public void removeIntegerArray(int index){
        numbers.remove(index);
    }

    public void removeIntegerArray(IntegerArray intArr){
        numbers.remove(intArr);
    }

    public IntegerArray min(int start, int end){
        IntegerArray minimum = numbers.get(start);
        for (int i=start; i<=end; i++){
            if (numbers.get(i).compareTo(minimum) < 0){
                minimum = numbers.get(i);
            }
        }
        return minimum;
    }
}
