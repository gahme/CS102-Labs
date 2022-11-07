public class DecreasingArrayGenerator implements ArrayGenerator{

    @Override
    public Integer[] generate(int n){
        Integer[] arr = new Integer[n];
        for (int i=8; i>0; i--){
            arr[n-i] = i;
        }
        return arr;
    }
    
}
