package gr.aueb.cf.projects.project3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Project3 {

    public static void main(String[] args) {
        String parentDirectory = new File("").getAbsolutePath() + "\\src\\gr\\aueb\\cf\\projects\\project3";
        String inputFilePath = parentDirectory + "\\characters.txt";

        File characters = new File(inputFilePath);
        String[][] array = getCharacterFrequencies(characters);
        printStats(array);
    }

    public static String[][] getCharacterFrequencies(File characters) {
        String[][] array = new String[128][2];
        try (Scanner scanner = new Scanner(characters)) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                for (int i = 0; i < word.length(); i++) {
                    char currentChar = word.charAt(i);
                    int asciiValue = currentChar;
                    if (String.valueOf(currentChar).equals(array[asciiValue][0])) {
                        int num = Integer.parseInt(array[asciiValue][1]);
                        num++;
                        array[asciiValue][1] = String.valueOf(num);
                        break;
                    }
                    if (array[asciiValue][0] == null) {
                        array[asciiValue][0] = String.valueOf(currentChar);
                        array[asciiValue][1] = "1";
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }


    //VERSION B

//    public static String[][] getCharacterFrequencies(File characters) {
//        String[][] array = new String[128][2];
//        try (Scanner scanner = new Scanner(characters)) {
//            while (scanner.hasNext()) {
//                String word = scanner.next();
//                for (int i = 0; i < word.length(); i++) {
//                    for (int j = 0; j < array.length; j++) {
//                        if (String.valueOf(word.charAt(i)).equals(array[j][0])) {
//                            int num = Integer.parseInt(array[j][1]);
//                            num++;
//                            array[j][1] = String.valueOf(num);
//                            break;
//                        }
//                        if (array[j][0] == null) {
//                            array[j][0] = String.valueOf(word.charAt(i));
//                            array[j][1] = "1";
//                            break;
//                        }
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return array;
//    }


    public static void printStats(String[][] array) {
        for (String[] row : array) {
            if (row[0] != null && row[1] != null) {
                System.out.printf("%s: %s\n", row[0], row[1]);
            }
        }
    }


}
