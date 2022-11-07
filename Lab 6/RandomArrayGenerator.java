import java.util.Random;

public class RandomArrayGenerator implements ArrayGenerator{

    @Override
    public Integer[] generate(int n){
        Random rnd = new Random();
        Integer[] arr = new Integer[n];
        for (int i=0; i<arr.length; i++){
            arr[i] = rnd.nextInt(1, n+1);
        }
        return arr;
    }

    
}
