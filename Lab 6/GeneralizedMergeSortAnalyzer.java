public class GeneralizedMergeSortAnalyzer extends SortAnalyzer{

    @Override
    public Integer[] sort(Comparable[] arr) {
        Integer[] array = (Integer[]) arr;
        kWayMergeSort(array,0,array.length,array.length,k,array.length-1);
        return array;
    }

    public Integer[] kSort(Comparable[] arr, int k) {
        Integer[] array = (Integer[]) arr;
        kWayMergeSort(array,0,array.length,array.length,k,array.length-1);
        return array;
    }


    public  void kWayMergeSort(Integer arr[],int l, int r,int n, int k,int size) {
        if (compare(size, n) < 0 && compare(k, 2) >= 0){ // if (size<n && k>=2){ 
            for (int i = 0; i < k; i++) { 
                // Reduce size by n/k
                kWayMergeSort(arr,k*i,k*i+k,(int) Math.ceil(n/k),k,size); 
            }
            mergeSort(arr, l, r-1);
        }
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
            if (compare(lIndex, arr1.length) < 0 && compare(rIndex, arr2.length) < 0){ // if (lIndex < arr1.length && rIndex < arr2.length){
                if (compare(arr1[lIndex], arr2[rIndex]) < 0){// if (arr1[lIndex] < arr2[rIndex]){
                    arr[i] = arr1[lIndex];
                    lIndex++;
                } else {
                    arr[i] = arr2[rIndex];
                    rIndex++;
                }
            } else if (compare(lIndex, arr1.length) < 0){// } else if (lIndex < arr1.length){
                arr[i] = arr1[lIndex];
                lIndex++;
            } else if (compare(rIndex, arr2.length) < 0){// } else if (rIndex < arr2.length){
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

