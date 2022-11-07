public class IncreasingArrayGenerator implements ArrayGenerator{

    @Override
    public Integer[] generate(int n){
        Integer[] arr = new Integer[8];
        for (int i=0; i<n; i++){
            arr[i] = i+1;
        }
        return arr;
    }
    
}
