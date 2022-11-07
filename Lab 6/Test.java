public class Test {
    public static void main(String args[]){

        /**
         * Decreasing array
         */
        System.out.println("\n\n|Decreasing Array|");
        // merge sort
        System.out.println("\n=>Merge sort");
        DecreasingArrayGenerator decreasing = new DecreasingArrayGenerator();
        Integer[] decreasing8 = decreasing.generate(8);
        arrayPrint(decreasing8);
        MergeSortAnalyzer decreasingMergeSort = new MergeSortAnalyzer();
        System.out.println("Is sorted: " + decreasingMergeSort.isSorted(decreasing8));
        System.out.println("Comparisons made: " + decreasingMergeSort.getComparison());
        System.out.println("sorting...");
        decreasingMergeSort.sort(decreasing8);
        System.out.println("Is sorted: " + decreasingMergeSort.isSorted(decreasing8));
        System.out.println("Comparisons made: " + decreasingMergeSort.getComparison());

        //  quick sort
        System.out.println("\n=>Quick sort");
        Integer[] decreasing8_1 = decreasing.generate(8);
        arrayPrint(decreasing8_1);
        QuickSortAnalyzer qsaDecreasing = new QuickSortAnalyzer();
        System.out.println("sorting...");
        qsaDecreasing.sort(decreasing8_1);
        arrayPrint(decreasing8_1);
        System.out.println("Is sorted: " + qsaDecreasing.isSorted(decreasing8_1));
        System.out.println("Comparisons made: " + qsaDecreasing.getComparison());

        /**
         * Increasing array
         */
        System.out.println("\n\n|Increasing Array|");
        // merge sort
        System.out.println("\n=> Merge sort");
        IncreasingArrayGenerator increasing = new IncreasingArrayGenerator();
        Integer[] increasing8 = increasing.generate(8);
        arrayPrint(increasing8);
        MergeSortAnalyzer increasingMergeSort = new MergeSortAnalyzer();
        System.out.println("Is sorted: " + increasingMergeSort.isSorted(increasing8));
        System.out.println("Comparisons made: " + increasingMergeSort.getComparison());
        System.out.println("sorting...");
        increasingMergeSort.sort(increasing8);
        System.out.println("Is sorted: " + increasingMergeSort.isSorted(increasing8));
        System.out.println("Comparisons made: " + increasingMergeSort.getComparison());

        //  quick sort
        System.out.println("\n=> Quick sort");
        Integer[] increasing8_1 = increasing.generate(8);
        arrayPrint(increasing8_1);
        QuickSortAnalyzer qsaIncreasing = new QuickSortAnalyzer();
        System.out.println("sorting...");
        qsaIncreasing.sort(increasing8_1);
        arrayPrint(increasing8_1);
        System.out.println("Is sorted: " + qsaIncreasing.isSorted(increasing8_1));
        System.out.println("Comparisons made: " + qsaIncreasing.getComparison());

        /**
         * Random Array
         */
        System.out.println("\n\n|Increasing Array|");

        // Normal merge sort
        System.out.println("\n => Normal merge sort");
        RandomArrayGenerator random = new RandomArrayGenerator();
        Integer[] random8 = random.generate(8);
        arrayPrint(random8);
        MergeSortAnalyzer randomMergeSort = new MergeSortAnalyzer();
        System.out.println("Is sorted: " + randomMergeSort.isSorted(random8));
        System.out.println("Comparisons made: " + randomMergeSort.getComparison());
        System.out.println("sorting...");
        randomMergeSort.sort(random8);
        System.out.println("Is sorted: " + randomMergeSort.isSorted(random8));
        System.out.println("Comparisons made: " + randomMergeSort.getComparison());

        //  K way merge sort
        System.out.println("\n => K-way merge sort");
        Integer[] random8_2 = random.generate(8);

        for (int i=2; i<10; i++){
            GeneralizedMergeSortAnalyzer gmsa = new GeneralizedMergeSortAnalyzer();
            System.out.println("Testing k-way mergesort with k = " + i);
            Integer[] testArray = random8_2.clone();
            System.out.println("Comparisons made: " + gmsa.getComparison());
            arrayPrint(testArray);
            System.out.println("Is sorted: " + gmsa.isSorted(testArray));
            gmsa.kSort(testArray, i);
            arrayPrint(testArray);
            System.out.println("Is sorted: " + gmsa.isSorted(testArray));
            System.out.println("Comparisons made: " + gmsa.getComparison());
            System.out.println();
        }

        //  quick sort
        System.out.println("\n => Normal quick sort");
        Integer[] random8_3 = random.generate(8);
        arrayPrint(random8_3);
        QuickSortAnalyzer qsa = new QuickSortAnalyzer();
        System.out.println("sorting...");
        qsa.sort(random8_3);
        arrayPrint(random8_3);
        System.out.println("Is sorted: " + qsa.isSorted(random8_3));
        System.out.println("Comparisons made: " + qsa.getComparison());

        //  k-way quick sort
        System.out.println("\n => K-way quick sort");
        Integer[] random8_4 = random.generate(8);
        arrayPrint(random8_4);
        GeneralizedQuickSortAnalyzer gqsa = new GeneralizedQuickSortAnalyzer();
        System.out.println("sorting...");
        gqsa.kSort(random8_4, 6);
        arrayPrint(random8_4);
        System.out.println("Is sorted: " + gqsa.isSorted(random8_4));
        System.out.println("Comparisons made: " + gqsa.getComparison());

        Integer[] randomarrs = random.generate(8);

        System.out.println("\n => K-way quick sort");
        for (int i=2; i<10; i++){
            GeneralizedQuickSortAnalyzer gqsa2 = new GeneralizedQuickSortAnalyzer();
            System.out.println("Testing k-way quicksort with k = " + i);
            Integer[] testArray = randomarrs.clone();
            System.out.println("Comparisons made: " + gqsa2.getComparison());
            arrayPrint(testArray);
            System.out.println("Is sorted: " + gqsa2.isSorted(testArray));
            gqsa2.kSort(testArray, i);
            arrayPrint(testArray);
            System.out.println("Is sorted: " + gqsa2.isSorted(testArray));
            System.out.println("Comparisons made: " + gqsa2.getComparison());
            System.out.println();
        }

    }

    public static void arrayPrint(Integer[] arr){
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
