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
import java.text.DecimalFormat;

public class FIP_Assignment3 {
    public static void main(String[] args) {

        try {
            FileInputStream inputFile = new FileInputStream("yoda.raw");
            int value;
            int k = 0;//count arr0
            int m = 1;//count total number of each value into array
            int count = 1;//count columns
            int count1 = 0;//count total number of a value
            int runSum1 = 0;//for increment use and get the last value of runSum(array)
            int[] arr0 = new int[inputFile.available()];
            int[] noOfPixel = new int[256];//num of pixels
            int[] runSum = new int[256];//run sum
            double[] normalized = new double[256];//normalized(run sum / 7626)
            double[] mul255 = new double[256];//multiply 7(double)
            int[] map = new int[256];//histogram-equalized value

            //store value into 1D array(int)
            while ((value = inputFile.read()) != -1) {
                arr0[k++] = value;
            }

            //store total number of each value into array
            for (int i = 0; i < noOfPixel.length; i++) {
                m = 1;
                for (int j = 0; j < arr0.length; j++) {
                    if (arr0[j] == i) {
                        noOfPixel[i] = m++;
                    }
                }
            }

            //run sum
            for (int i = 0; i < noOfPixel.length; i++) {
                runSum[i] = runSum1 += noOfPixel[i];
            }

            //normalized
            DecimalFormat df = new DecimalFormat("0.00");
            for (int i = 0; i < runSum.length; i++) {
                normalized[i] = runSum[i] / 1.0 / runSum1;
            }

            //multiply7
            DecimalFormat df1 = new DecimalFormat("0");
            for (int i = 0; i < normalized.length; i++) {
                mul255[i] = normalized[i] * 255.0;
                mul255[i] = Math.round(mul255[i]);
            }

            for (int j = 0; j < mul255.length; j++) {
                map[(int) (mul255[j])] += noOfPixel[j];
            }

            String t = "\t\t";
            System.out.print("");
            System.out.print("---------------------------------< Histogram-qualized values >---------------------------------");
            System.out.println("");
            System.out.println("Gray-level |\t\tNo of Pixel |\tRun Sum |\tNormalized |\t"
                    + "Multiply7 |\tMap");
            System.out.println("-----------------------------------------------------------------------------------------------");
            for (int i = 0; i < noOfPixel.length; i++) {
                System.out.printf("Gray-level%4d:", i);
                System.out.println(t + noOfPixel[i] + t + runSum[i] + t
                        + df.format(normalized[i]) + t + (int) (mul255[i])
                        + t + map[i]);
            }

            inputFile.close();
        } catch (IOException ex) {
            System.out.println("File error!");
        }
    }
}
