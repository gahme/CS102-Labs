public class QuickSortAnalyzer extends SortAnalyzer{

    @Override
    public Comparable[] sort(Comparable[] arr) {
        Integer[] array = (Integer[]) arr;
        quickSort(array, 0, arr.length-1);
        return array;
    }

    public void quickSort(Integer[] arr, int low, int high){
        if (compare(low, high) < 0){// if (low < high){
            int partitioningIndex = partition(arr, low, high);
            quickSort(arr, low, partitioningIndex - 1);
            quickSort(arr, partitioningIndex + 1, high);
        }
    }
    
    public int partition(Integer[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;
    
        for(int j = low; j <= high - 1; j++){
            if (compare(arr[j], pivot) < 0){// if (arr[j] < pivot){
                i++;
                // Swap arr[i] & arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap arr[i] & arr[j]
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
