public class Main {
    public static void main(String[] args) {
        Sorting sorting = new Sorting();

        int[] unsortedArray = sorting.getArray();

        System.out.println("Unsorted array:");
        for (int num : unsortedArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] sortedArray = sorting.sortArray(unsortedArray);

        System.out.println("Sorted array:");
        for (int num : sortedArray) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
