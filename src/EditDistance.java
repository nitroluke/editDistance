
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nitroluke
 */
public class EditDistance {

    private final Scanner in;

    EditDistance(String inputFile) throws FileNotFoundException {
        in = new Scanner(new File(inputFile));
    }

    public void initialize() {
        String string1;
        String string2;
        char str1Arr[];
        char str2Arr[];
        int str1Length = 0;
        int str2Length = 0;
        int editDistance[][] = new int[0][0];

        while (in.hasNext()) {
            string1 = in.next();
            string2 = in.next();
            str1Length = string1.length();
            str2Length = string2.length();
            str1Arr = string1.toCharArray();
            str2Arr = string2.toCharArray();

            System.out.println("String 1 = " + string1 + ", String 2 = " + string2);
            //  System.out.println("string1.compare(string2) = " + string1.compareTo(string2));
            editDistance = new int[str1Length + 1][str2Length + 1];

            for (int i = 0; i <= str1Length; i++) {
                editDistance[i][0] = i;
            }
            for (int j = 0; j <= str2Length; j++) {
                editDistance[0][j] = j;
            }

            for (int i = 1; i <= str1Length; i++) {
                char char1 = str1Arr[i-1];
                for (int j = 1; j <= str2Length; j++) {
                    char char2 = str2Arr[j-1];

                    if (char1 == char2) {
                        editDistance[i][j] = editDistance[i-1][j-1];
                    } else {
                        int replace = editDistance[i-1][j-1] + 1;
                        int insert = editDistance[i-1][j] + 1;
                        int delete = editDistance[i][j-1] + 1;

                        int min = replace > insert ? insert : replace;
                        min = delete > min ? min : delete;
                        editDistance[i][j] = min;
                    }

                }
            }

//            System.out.print("String 1 = ");
//            for (int i = 0; i < str1Arr.length; i++) {
//                System.out.println(str1Arr[i]);
//            }
//                System.out.print("String 2 = ");
//            for (int j = 0; j < str2Arr.length; j++) {
//                System.out.println(str2Arr.length);
//            }
        }
        printArray(editDistance);

    }

    public void printArray(int ed[][]) {
        for (int i = 0; i < ed.length; i++) {
            for (int j = 0; j < ed[0].length; j++) {
                System.out.print(ed[i][j]);
            }
            System.out.println("");
        }
    }

    public void solveProblems() {

    }
}
