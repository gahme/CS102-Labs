public abstract class SortAnalyzer {
    private int numberOfComparisons;
    protected int k = 2;

    protected int compare(Comparable o1, Comparable o2){
        Integer i1 =  (Integer) o1;
        Integer i2 =  (Integer) o2;
        numberOfComparisons ++;
        if (i1 > i2){
            return 1;
        } else if (i1 < i2){
            return -1;
        } else {
            return 0;
        }
    }

    public boolean isSorted(Comparable[] arr){
        Integer[] intArr = (Integer[]) arr;
        if (intArr == null || intArr.length <= 1) return true;
        for (int i=0; i<intArr.length-1; i++){
            if (intArr[i] > intArr[i+1]) return false;
        }
        return true;
    }

    public abstract Comparable[] sort(Comparable[] arr);

    public int getComparison(){
        return numberOfComparisons;
    }
}
