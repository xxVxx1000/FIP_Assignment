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
public class FIP_Assignment5 {
    
    public static void main(String[] args) {

        try {
            FileInputStream inputFile = new FileInputStream("bedroom.raw");
            FileOutputStream outputFile = new FileOutputStream("result_low.raw");
            FileOutputStream outputFile1 = new FileOutputStream("result_high.raw");
            int value;
            int k = 0;
            int l = 0;
            int sum = 0;
            int sum1 = 0;
            int width = 600;
            int height = 600;

            int[][] kernel = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
            int[][] kernel1 = {{-1, -1, -1}, {-1, 8, -1}, {-1, -1, -1}};
            int[] arr0 = new int[inputFile.available()];
            int[][] arr1 = new int[height][width];
            int[][] arr2 = new int[height][width];
            int[][] arr3 = new int[height][width];

            while ((value = inputFile.read()) != -1) {
                arr0[k++] = value;
            }
            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr1[i].length; j++) {
                    arr1[i][j] = arr0[l++];
                }
            }
            for (int i = 0; i < arr2.length; i++) {
                for (int j = 0; j < arr2[i].length; j++) {
                    sum = 0;
                    sum1 = 0;
                    if (i + 1 >= 0 && i + 1 <= (height-1) && j + 1 >= 0 && j + 1 <= (width-1)) {
                        sum += kernel[0][0] * arr1[i + 1][j + 1];
                        sum1 += kernel1[0][0] * arr1[i + 1][j + 1];
                    }
                    if (i + 1 >= 0 && i + 1 <= (height-1) && j + 0 >= 0 && j + 0 <= (width-1)) {
                        sum += kernel[0][1] * arr1[i + 1][j + 0];
                        sum1 += kernel1[0][1] * arr1[i + 1][j + 0];
                    }
                    if (i + 1 >= 0 && i + 1 <= (height-1) && j - 1 >= 0 && j - 1 <= (width-1)) {
                        sum += kernel[0][2] * arr1[i + 1][j - 1];
                        sum1 += kernel1[0][2] * arr1[i + 1][j - 1];
                    }
                    if (i + 0 >= 0 && i + 0 <= (height-1) && j + 1 >= 0 && j + 1 <= (width-1)) {
                        sum += kernel[1][0] * arr1[i + 0][j + 1];
                        sum1 += kernel1[1][0] * arr1[i + 0][j + 1];
                    }
                    if (i + 0 >= 0 && i + 0 <= (height-1) && j + 0 >= 0 && j + 0 <= (width-1)) {
                        sum += kernel[1][1] * arr1[i + 0][j + 0];
                        sum1 += kernel1[1][1] * arr1[i + 0][j + 0];
                    }
                    if (i + 0 >= 0 && i + 0 <= (height-1) && j - 1 >= 0 && j - 1 <= (width-1)) {
                        sum += kernel[1][2] * arr1[i + 0][j - 1];
                        sum1 += kernel1[1][2] * arr1[i + 0][j - 1];
                    }
                    if (i - 1 >= 0 && i - 1 <= (height-1) && j + 1 >= 0 && j + 1 <= (width-1)) {
                        sum += kernel[2][0] * arr1[i - 1][j + 1];
                        sum1 += kernel1[2][0] * arr1[i - 1][j + 1];
                    }
                    if (i - 1 >= 0 && i - 1 <= (height-1) && j + 0 >= 0 && j + 0 <= (width-1)) {
                        sum += kernel[2][1] * arr1[i - 1][j + 0];
                        sum1 += kernel1[2][1] * arr1[i - 1][j + 0];
                    }
                    if (i - 1 >= 0 && i - 1 <= (height-1) && j - 1 >= 0 && j - 1 <= (width-1)) {
                        sum += kernel[2][2] * arr1[i - 1][j - 1];
                        sum1 += kernel1[2][2] * arr1[i - 1][j - 1];
                    }
                    sum /= 9;
                    if (sum < 0) {
                        sum = 0;
                    }
                    if (sum > 255) {
                        sum = 255;
                    }
                    if (sum1 < 0) {
                        sum1 = 0;
                    }
                    if (sum1 > 255) {
                        sum1 = 255;
                    }
                    arr2[i][j] = sum;
                    arr3[i][j] = sum1;
                }
            }

            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr1[i].length; j++) {
                    outputFile.write(arr2[i][j]);
                    outputFile1.write(arr3[i][j]);
                }
            }

            System.out.println("Low_Pass_Filtering.raw is created.");
            System.out.println("High_Pass_Filtering.raw is created.");
            outputFile.close();
            outputFile1.close();
            inputFile.close();
        } catch (IOException ex) {
            System.out.println("File error!");
        }
    }
}