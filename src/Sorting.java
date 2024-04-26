import java.util.Scanner;
public class Sorting {
    public int[] getArray() {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter integers:");
            array[i] = scanner.nextInt();
        }

        return array;
    }

    public int[] sortArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array;
    }
}

