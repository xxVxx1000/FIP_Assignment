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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FIP_Assignment2_2 {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        File inputFile = new File("yoda.raw");
        FileInputStream fis = null;
        int x = 0;
        int y = 0;
        String ByteOrder = null, Version = null, Offset = null;
        String a, b = null;

        int[][] original = new int[62][123];
        int[][] d1result = new int[62][123];
        int[][] d2result = new int[62][123];
        int[][] d1 = {{0, 128},
        {192, 64}};
        int[][] d2
                = {{0, 128, 32, 160},
                {192, 64, 224, 96},
                {48, 176, 16, 144},
                {240, 112, 208, 80}};

        try {
            fis = new FileInputStream(inputFile);

            System.out.println("Total file size to read (in bytes) : " + fis.available());

            int value;
            while ((value = fis.read()) != -1) {
                if (y == 123) {
                    y = 0;
                    x++;
                }
                original[x][y] = value;
                y++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        for (int i = 0; i < 62; i++) {
            System.out.println("");
            for (int j = 0; j < 123; j++) {
                System.out.printf("%4s", original[i][j]);
            }
        }
        for (int i = 0; i < 62; i++) {
            for (int j = 0; j < 123; j++) {
                if (original[i][j] > d1[i % 2][j % 2]) {
                    d1result[i][j] = 255;
                } else {
                    d1result[i][j] = 0;
                }

                if (original[i][j] > d2[i % 4][j % 4]) {
                    d2result[i][j] = 255;
                } else {
                    d2result[i][j] = 0;
                }
            }
        }
        fis.close();

        FileOutputStream fout = new FileOutputStream("d1.raw");

        for (int i = 0; i < 62; i++) {
            System.out.println("");
            for (int j = 0; j < 123; j++) {
                System.out.printf("%4s", d1result[i][j]);
                fout.write(d1result[i][j]);

            }
        }
        fout.close();

        FileOutputStream fout2 = new FileOutputStream("d2.raw");

        for (int i = 0; i < 62; i++) {
            System.out.println("");
            for (int j = 0; j < 123; j++) {
                System.out.printf("%4s", d2result[i][j]);
                fout2.write(d2result[i][j]);
            }
        }
        fout2.close();
    }
}