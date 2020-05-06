/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author W.Quan
 */

import java.io.*;
public class FIP_Assignment2 {
    public static void main(String[] args) {
        try {
            FileInputStream inputFile = new FileInputStream("yoda.raw");
            int value;
            int k = 0;
            int l = 0;

           
            int height=62;
            int width=123;
            int[] arr0 = new int[inputFile.available()];
            int[][] arr = new int[height][width];
            int[][] arr1 = new int[height * 3][width * 3];

            while ((value = inputFile.read()) != -1) {
                arr0[k++] = value;
            }

            //store value into 2D array(int)
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = arr0[l++];
                }
            }

            for (int j = 0; j < arr.length; j++) {
                for (int i = 0; i < arr[j].length; i++) {
                    if (arr[j][i] >= 0 && arr[j][i] <= 25) {
                        arr1[j * 3 + 0][i * 3 + 0] = 0;
                        arr1[j * 3 + 0][i * 3 + 1] = 0;
                        arr1[j * 3 + 0][i * 3 + 2] = 0;
                        arr1[j * 3 + 1][i * 3 + 0] = 0;
                        arr1[j * 3 + 1][i * 3 + 1] = 0;
                        arr1[j * 3 + 1][i * 3 + 2] = 0;
                        arr1[j * 3 + 2][i * 3 + 0] = 0;
                        arr1[j * 3 + 2][i * 3 + 1] = 0;
                        arr1[j * 3 + 2][i * 3 + 2] = 0;
                    }
                    if (arr[j][i] >= 26 && arr[j][i] <= 50) {
                        arr1[j * 3 + 0][i * 3 + 0] = 0;
                        arr1[j * 3 + 0][i * 3 + 1] = 0;
                        arr1[j * 3 + 0][i * 3 + 2] = 0;
                        arr1[j * 3 + 1][i * 3 + 0] = 0;
                        arr1[j * 3 + 1][i * 3 + 1] = 0;
                        arr1[j * 3 + 1][i * 3 + 2] = 0;
                        arr1[j * 3 + 2][i * 3 + 0] = 0;
                        arr1[j * 3 + 2][i * 3 + 1] = 0;
                        arr1[j * 3 + 2][i * 3 + 2] = 255;
                    }
                    if (arr[j][i] >= 51 && arr[j][i] <= 75) {
                        arr1[j * 3 + 0][i * 3 + 0] = 255;
                        arr1[j * 3 + 0][i * 3 + 1] = 0;
                        arr1[j * 3 + 0][i * 3 + 2] = 0;
                        arr1[j * 3 + 1][i * 3 + 0] = 0;
                        arr1[j * 3 + 1][i * 3 + 1] = 0;
                        arr1[j * 3 + 1][i * 3 + 2] = 0;
                        arr1[j * 3 + 2][i * 3 + 0] = 0;
                        arr1[j * 3 + 2][i * 3 + 1] = 0;
                        arr1[j * 3 + 2][i * 3 + 2] = 255;
                    }
                    if (arr[j][i] >= 76 && arr[j][i] <= 100) {
                        arr1[j * 3 + 0][i * 3 + 0] = 255;
                        arr1[j * 3 + 0][i * 3 + 1] = 0;
                        arr1[j * 3 + 0][i * 3 + 2] = 255;
                        arr1[j * 3 + 1][i * 3 + 0] = 0;
                        arr1[j * 3 + 1][i * 3 + 1] = 0;
                        arr1[j * 3 + 1][i * 3 + 2] = 0;
                        arr1[j * 3 + 2][i * 3 + 0] = 0;
                        arr1[j * 3 + 2][i * 3 + 1] = 0;
                        arr1[j * 3 + 2][i * 3 + 2] = 255;
                    }
                    if (arr[j][i] >= 101 && arr[j][i] <= 125) {
                        arr1[j * 3 + 0][i * 3 + 0] = 255;
                        arr1[j * 3 + 0][i * 3 + 1] = 0;
                        arr1[j * 3 + 0][i * 3 + 2] = 255;
                        arr1[j * 3 + 1][i * 3 + 0] = 0;
                        arr1[j * 3 + 1][i * 3 + 1] = 0;
                        arr1[j * 3 + 1][i * 3 + 2] = 0;
                        arr1[j * 3 + 2][i * 3 + 0] = 255;
                        arr1[j * 3 + 2][i * 3 + 1] = 0;
                        arr1[j * 3 + 2][i * 3 + 2] = 255;
                    }
                    if (arr[j][i] >= 126 && arr[j][i] <= 150) {
                        arr1[j * 3 + 0][i * 3 + 0] = 255;
                        arr1[j * 3 + 0][i * 3 + 1] = 0;
                        arr1[j * 3 + 0][i * 3 + 2] = 255;
                        arr1[j * 3 + 1][i * 3 + 0] = 0;
                        arr1[j * 3 + 1][i * 3 + 1] = 0;
                        arr1[j * 3 + 1][i * 3 + 2] = 0;
                        arr1[j * 3 + 2][i * 3 + 0] = 255;
                        arr1[j * 3 + 2][i * 3 + 1] = 255;
                        arr1[j * 3 + 2][i * 3 + 2] = 255;
                    }
                    if (arr[j][i] >= 151 && arr[j][i] <= 175) {
                        arr1[j * 3 + 0][i * 3 + 0] = 255;
                        arr1[j * 3 + 0][i * 3 + 1] = 0;
                        arr1[j * 3 + 0][i * 3 + 2] = 255;
                        arr1[j * 3 + 1][i * 3 + 0] = 255;
                        arr1[j * 3 + 1][i * 3 + 1] = 0;
                        arr1[j * 3 + 1][i * 3 + 2] = 0;
                        arr1[j * 3 + 2][i * 3 + 0] = 255;
                        arr1[j * 3 + 2][i * 3 + 1] = 255;
                        arr1[j * 3 + 2][i * 3 + 2] = 255;
                    }
                    if (arr[j][i] >= 176 && arr[j][i] <= 200) {
                        arr1[j * 3 + 0][i * 3 + 0] = 255;
                        arr1[j * 3 + 0][i * 3 + 1] = 255;
                        arr1[j * 3 + 0][i * 3 + 2] = 255;
                        arr1[j * 3 + 1][i * 3 + 0] = 255;
                        arr1[j * 3 + 1][i * 3 + 1] = 0;
                        arr1[j * 3 + 1][i * 3 + 2] = 0;
                        arr1[j * 3 + 2][i * 3 + 0] = 255;
                        arr1[j * 3 + 2][i * 3 + 1] = 255;
                        arr1[j * 3 + 2][i * 3 + 2] = 255;
                    }
                    if (arr[j][i] >= 201 && arr[j][i] <= 225) {
                        arr1[j * 3 + 0][i * 3 + 0] = 255;
                        arr1[j * 3 + 0][i * 3 + 1] = 255;
                        arr1[j * 3 + 0][i * 3 + 2] = 255;
                        arr1[j * 3 + 1][i * 3 + 0] = 255;
                        arr1[j * 3 + 1][i * 3 + 1] = 0;
                        arr1[j * 3 + 1][i * 3 + 2] = 255;
                        arr1[j * 3 + 2][i * 3 + 0] = 255;
                        arr1[j * 3 + 2][i * 3 + 1] = 255;
                        arr1[j * 3 + 2][i * 3 + 2] = 255;
                    }
                    if (arr[j][i] >= 226 && arr[j][i] <= 255) {
                        arr1[j * 3 + 0][i * 3 + 0] = 255;
                        arr1[j * 3 + 0][i * 3 + 1] = 255;
                        arr1[j * 3 + 0][i * 3 + 2] = 255;
                        arr1[j * 3 + 1][i * 3 + 0] = 255;
                        arr1[j * 3 + 1][i * 3 + 1] = 255;
                        arr1[j * 3 + 1][i * 3 + 2] = 255;
                        arr1[j * 3 + 2][i * 3 + 0] = 255;
                        arr1[j * 3 + 2][i * 3 + 1] = 255;
                        arr1[j * 3 + 2][i * 3 + 2] = 255;
                    }
                }
            }
            int count1 = 0;
            int count2 = 0;

            for (int j = 0; j < arr.length; j++) {
                System.out.println("");
                for (int i = 0; i < arr[j].length; i++) {
                    System.out.printf("%4s", arr[j][i]);
                    count1++;
                }
            }
            System.out.println("\n\n");
            for (int j = 0; j < arr1.length; j++) {
                System.out.println("");
                for (int i = 0; i < arr1[j].length; i++) {
                    System.out.printf("%4s", arr1[j][i]);
                    count2++;
                FileOutputStream outFile = new FileOutputStream("result.raw");
                }
            }
            inputFile.close();
        } catch (IOException ex) {
            System.out.println("File error!");
        }
    }
}
