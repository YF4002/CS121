import java.util.Scanner;
import java.util.Random;

public class TestScores {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Random random = new Random();


        int size = (int) (Math.random() * 8) + 3;

        int[] testScores = new int[size];

        char[] letterGrades = new char[size];

        System.out.println("Enter your " + size + " test scores");

        for (int i = 0; i < size; i++) {
            System.out.printf("Enter test " + (i + 1) + " score:");
            testScores[i] = scnr.nextInt();

        }
        System.out.println("----");
        for (int i = 0; i < size; i++) {
            letterGrades[i] = getLetterGrades(testScores[i]);
        }
        printGrades(testScores, letterGrades);
        printHighestScore(testScores);
        printLowestScore(testScores);
        averageScore(testScores);

    }

    public static char getLetterGrades(int testScore) {
        char letterGrade;
        if (testScore >= 90 && testScore <= 100) {
            letterGrade = 'A';
        } else if (testScore >= 80 && testScore <= 89) {
            letterGrade = 'B';
        } else if (testScore >= 70 && testScore <= 79) {
            letterGrade = 'C';
        } else if (testScore >= 60 && testScore <= 69) {
            letterGrade = 'D';
        }//else ifif (testScore <= 59)
        else {
            letterGrade = 'F';
        }
        return letterGrade;

    }

    public static void printGrades(int[] testScores, char[] letterGrades) {
        System.out.println("\nScore   Grade");
        System.out.println("-------------");
        for (int t = 0; t < testScores.length; t++) {
            System.out.printf("%-7d   %-1c%n", testScores[t], letterGrades[t]);
        }
    }

    public static void printHighestScore(int[] testScore) {
        int highScore = testScore[0];
        for (int i = 0; i < testScore.length; i++) {
            if (testScore[i] > highScore) {
                highScore = testScore[i];
            }
        }
        System.out.println("\n Highest Score: " + highScore);
    }

    public static void printLowestScore(int[] testScore) {
        int lowestScore = testScore[0];
        for (int i = 0; i < testScore.length; i++) {
            if (testScore[i] < lowestScore) {
                lowestScore = testScore[i];
            }
        }
        System.out.println("\n Lowest Score: " + lowestScore);
    }

    public static void averageScore(int[] testScore) {
        int sum = 0;
        int i;
        for (i = 0; i < testScore.length; i++) {
            sum += testScore[i];
        }

        double average = (double) sum / testScore.length;
        System.out.printf("Average Score: %.2f", average);
    }
}

