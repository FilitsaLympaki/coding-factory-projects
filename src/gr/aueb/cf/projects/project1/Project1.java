package gr.aueb.cf.projects.project1;

import java.io.*;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Project1 {

    public static void main(String[] args) {
        String parentDirectory = new File("").getAbsolutePath() + "\\src\\gr\\aueb\\cf\\projects\\project1";
        String inputFilePath = parentDirectory + "\\numbers.txt";
        createFileWithNumbers(inputFilePath);

        int[] arrayOfNumbers = getNumbersArrayFromFile(inputFilePath);
        Arrays.sort(arrayOfNumbers);

        ArrayList<int[]> result = getCombinationsOfSixNumbers(arrayOfNumbers);
        String outputFilePath = parentDirectory + "\\combinations.txt";
        createFileWithNumberCombinationsOfSix(result, outputFilePath);

    }

    public static void createFileWithNumbers(String filePath) {
        File numbersFile = new File(filePath);

        try (PrintWriter printWriter = new PrintWriter(numbersFile, StandardCharsets.UTF_8)) {
            for (int i = 49; i >= 1; i--) {
                printWriter.println(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] getNumbersArrayFromFile(String filePath) {
        ArrayList<Integer> listOfNumbers = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                listOfNumbers.add(number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // convert ArrayList to array of integers
        int[] arrayOfNumbers = new int[listOfNumbers.size()];
        for (int i = 0; i < listOfNumbers.size(); i++) {
            arrayOfNumbers[i] = listOfNumbers.get(i);
        }
        return arrayOfNumbers;
    }

    public static ArrayList<int[]> getCombinationsOfSixNumbers(int[] array) {
        int n = array.length;
        int m = 6;
        ArrayList<int[]> result = new ArrayList<>();

        for (int i = 0; i <= n - m; i++) {
            for (int j = i + 1; j <= n + 1 - m; j++) {
                for (int k = j + 1; k <= n + 2 - m; k++) {
                    for (int l = k + 1; l <= n + 3 - m; l++) {
                        for (int x = l + 1; x <= n + 4 - m; x++) {
                            for (int y = x + 1; y <= n + 5 - m; y++) {
                                int[] combination = new int[m];
                                combination[0] = array[i];
                                combination[1] = array[j];
                                combination[2] = array[k];
                                combination[3] = array[l];
                                combination[4] = array[x];
                                combination[5] = array[y];

                                if (isEven(combination) && isOdd(combination) && isContiguous(combination) && isSameTen(combination) && isSameEnding(combination)) {
                                    result.add(combination);
                                }
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    public static boolean isEven(int[] array) {
        if (array == null) {
            return false;
        }
        int count = 0;
        for (int num : array) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count <= 4;
    }

    public static boolean isOdd(int[] array) {
        if (array == null) {
            return false;
        }
        int count = 0;
        for (int num : array) {
            if (num % 2 != 0) {
                count++;
            }
        }
        return count <= 4;
    }

    public static boolean isContiguous(int[] array) {
        if (array == null) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if ((array[i] == array[i + 1] - 1)) {
                count++;
            }
        }
        return count <= 2;
    }

    public static boolean isSameEnding(int[] array) {
        if (array == null) {
            return false;
        }
        int[] endings = new int[10];

        for (int i = 0; i < array.length; i++) {
            endings[array[i] % 10]++;
        }
        for (int i = 0; i < endings.length; i++) {
            if (endings[i] > 3) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSameTen(int[] array) {
        if (array == null) {
            return false;
        }
        int[] tens = new int[5];

        for (int i = 0; i < array.length; i++) {
            tens[array[i] / 10]++;
        }
        for (int i = 0; i < tens.length; i++) {
            if (tens[i] > 3) {
                return false;
            }
        }
        return true;
    }

    public static void createFileWithNumberCombinationsOfSix(ArrayList<int[]> arrayList, String filePath) {
        File combinationNumbersFile = new File(filePath);

        try (PrintWriter printWriter = new PrintWriter(combinationNumbersFile, StandardCharsets.UTF_8)) {
            for (int[] array : arrayList) {
                printWriter.println(Arrays.toString(array));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
