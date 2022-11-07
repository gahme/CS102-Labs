public class MergeSortAnalyzer extends SortAnalyzer{

    @Override
    public Integer[] sort(Comparable[] arr) {
        Integer[] array = (Integer[]) arr;
        mergeSort(array, 0, array.length-1);
        return array;
    }

    public void mergeSort(Integer[] arr, int l, int r){
        if (r <= l) return;
        int m = (l+r)/2;
        mergeSort(arr, l, m);
        mergeSort(arr, m+1, r);
        merge(arr, l, m, r);
    }

    public void merge(Integer[] arr, int l, int m, int r){
        int arr1Length = m-l+1;
        int arr2Length = r-m;
        int[] arr1 = new int[arr1Length];
        int[] arr2 = new int[arr2Length];

        for (int i=0; i<arr1Length; i++){
            arr1[i] = arr[l+i];
        }
        for (int i=0; i<arr2Length; i++){
            arr2[i] = arr[m+1+i];
        }

        int lIndex = 0, rIndex = 0;
        for (int i=l; i<r+1; i++){
            // if (lIndex < arr1.length && rIndex < arr2.length){                
            if (compare(lIndex, arr1.length) < 0 && compare(rIndex, arr2.length) < 0){                
                // if (arr1[lIndex] < arr2[rIndex]){
                if (compare(arr1[lIndex], arr2[rIndex]) < 0){
                    arr[i] = arr1[lIndex];
                    lIndex++;
                } else {
                    arr[i] = arr2[rIndex];
                    rIndex++;
                }
            // } else if (lIndex < arr1.length){
            } else if (compare(lIndex, arr1.length) < 0){
                arr[i] = arr1[lIndex];
                lIndex++;
            // } else if (rIndex < arr2.length){
            } else if (compare(rIndex, arr2.length) < 0){
                arr[i] = arr2[rIndex];
                rIndex++;
            }
        }
    }

    public static void arrayPrint(Integer[] arr){
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
