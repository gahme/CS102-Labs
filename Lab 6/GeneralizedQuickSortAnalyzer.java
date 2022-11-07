/**
* @author Ghulam Ahmed
*/

public class GeneralizedQuickSortAnalyzer extends SortAnalyzer{

    @Override
    public Comparable[] sort(Comparable[] arr) {
        Integer[] array = (Integer[]) arr;
        quickSort(array, 0, arr.length-1, k);
        return array;
    }

    public Comparable[] kSort(Comparable[] arr, int k) {
        Integer[] array = (Integer[]) arr;
        quickSort(array, 0, arr.length-1, k);
        return array;
    }

    public void quickSort(Integer[] arr, int low, int high, int k){
        if (compare(low, high) < 0){// if (low < high){
            if (k % 2 == 0){
                int pivot = twoPartition(arr, low, high);
                quickSort(arr, low, pivot - 1, k-2);
                quickSort(arr, pivot + 1, high, k-2);
            } else if (k % 3 == 0){
                int[] pivots = threePartition(arr, low, high);
                quickSort(arr, low, pivots[1], k-3);
                quickSort(arr, pivots[0], high, k-3);
            } else{
                int[] pivots = threePartition(arr, low, high);
                quickSort(arr, low, pivots[1], k-1);
                quickSort(arr, pivots[0], high, k-1);
            }

        }
    }
    
    public int twoPartition(Integer[] arr, int low, int high){
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

    public int[] threePartition(Integer a[], int l, int r){
        int[] output = new int[2];
        int i = l - 1, j = r;
        int p = l - 1, q = r;
        int v = a[r];
    
        while (true){
            while (compare(a[++i], v) < 0)// while (a[++i] < v)
                ;
            
            while (compare(v, a[--j]) < 0){// while (v < a[--j]){
                if (j == l) break;
            }
    
            if (i >= j) break;
    
            // Swap a[i] and a[j]
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
    
            if (compare(a[i], v) == 0){// if (a[i] == v) {
                p++;
                // Swap a[i] and a[p]
                temp = a[i];
                a[i] = a[p];
                a[p] = temp;
            }
    
            if (compare(a[j], v) == 0){// if (a[j] == v) {
                q--;
            // Swap a[q] and a[j]
                temp = a[q];
                a[q] = a[j];
                a[j] = temp;
            }
        }
    
        // Bring pivot element back to it's index by swapping a[i] and a[r]
        int temp = a[i];
        a[i] = a[r];
        a[r] = temp;
    
        j = i-1;
        for (int k = l; k<p; k++, j--){
            // Swap a[k] and a[j]
            temp = a[k];
            a[k] = a[j];
            a[j] = temp;
        }
    
        i = i+1;
        for (int k = r - 1; k > q; k--, i++){
            // Swap a[i] and a[k]
            temp = a[i];
            a[i] = a[k];
            a[k] = temp;
        }

        output[0] = i;
        output[1] = j;
        return output;
    }
}
