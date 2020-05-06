/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author W.Quan
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FIP_Assignment4 {

    public static void main(String[] args) throws IOException {
        File file = new File("yoda.raw");
        FileInputStream file1 = null;
        int x = 0;
        int y = 0;
        String ByteOrder = null, Version = null, Offset = null;
        String a, b = null;

        int[][] original = new int[62][123];
        int[][] at = new int[62][123];
        int[] sum = new int[9];
        int total = 0;
        int[][] kernel
                = {{-1, 0, 1},
                {-2, 0, 2},
                {-1, 0, 1}};
        try {
            file1 = new FileInputStream(file);

            System.out.println("Total file size to read (in bytes) : " + file1.available());

            int value;
            while ((value = file1.read()) != -1) {
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
                if (file1 != null) {
                    file1.close();
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
        file1.close();

        for (int i = 0; i < 62; i++) {
            for (int j = 0; j < 123; j++) {
                if (i + 1 < 62 && j + 1 < 123) {
                    sum[0] = 0;
                    sum[0] = kernel[0][0] * original[i + 1][j + 1];
                    if (sum[0] > 255) {
                        sum[0] = 255;
                    }
                    if (sum[0] < 0) {
                        sum[0] = 0;
                    }
                } else {
                    sum[0] = 0;
                }
                if (i < 62 && j + 1 < 123) {
                    sum[1] = 0;
                    sum[1] = kernel[1][0] * original[i][j + 1];
                    if (sum[1] > 255) {
                        sum[1] = 255;
                    }
                    if (sum[1] < 0) {
                        sum[1] = 0;
                    }
                } else {
                    sum[1] = 0;
                }
                if (i - 1 > 0 && j + 1 < 123) {
                    sum[2] = 0;
                    sum[2] = kernel[2][0] * original[i - 1][j + 1];
                    if (sum[2] > 255) {
                        sum[2] = 255;
                    }
                    if (sum[2] < 0) {
                        sum[2] = 0;
                    }
                } else {
                    sum[2] = 0;
                }
                if (i + 1 < 62 && j < 123) {
                    sum[3] = 0;
                    sum[3] = kernel[0][1] * original[i + 1][j];
                    if (sum[3] > 255) {
                        sum[3] = 255;
                    }
                    if (sum[3] < 0) {
                        sum[3] = 0;
                    }
                } else {
                    sum[3] = 0;
                }
                if (i < 62 && j < 123) {
                    sum[4] = 0;
                    sum[4] = kernel[1][1] * original[i][j];
                    if (sum[4] > 255) {
                        sum[4] = 255;
                    }
                    if (sum[4] < 0) {
                        sum[4] = 0;
                    }

                } else {
                    sum[4] = 0;
                }
                if (i - 1 > 0 && j < 123) {
                    sum[5] = 0;
                    sum[5] = kernel[2][1] * original[i - 1][j];
                    if (sum[5] > 255) {
                        sum[5] = 255;
                    }
                    if (sum[5] < 0) {
                        sum[5] = 0;
                    }
                } else {
                    sum[5] = 0;
                }
                if (i + 1 < 62 && j - 1 > 0) {
                    sum[6] = 0;
                    sum[6] = kernel[0][2] * original[i + 1][j - 1];
                    if (sum[6] > 255) {
                        sum[6] = 255;
                    }
                    if (sum[6] < 0) {
                        sum[6] = 0;
                    }
                } else {
                    sum[6] = 0;
                }
                if (i < 62 && j - 1 > 0) {
                    sum[7] = 0;
                    sum[7] = kernel[1][2] * original[i][j - 1];
                    if (sum[7] > 255) {
                        sum[7] = 255;
                    }
                    if (sum[7] < 0) {
                        sum[7] = 0;
                    }
                } else {
                    sum[7] = 0;
                }
                //                case 9
                if (i - 1 > 0 && j - 1 > 0) {
                    sum[8] = 0;
                    sum[8] = kernel[2][2] * original[i - 1][j - 1];
                    if (sum[8] > 255) {
                        sum[8] = 255;
                    }
                    if (sum[8] < 0) {
                        sum[8] = 0;
                    }
                } else {
                    sum[8] = 0;
                }

                for (int k = 0; k < sum.length; k++) {
                    total = total + sum[k];
                    sum[k] = 0;
                }
                at[i][j] = total;
                total = 0;
            }
        }

        FileOutputStream fout = new FileOutputStream("result_C.raw");

        for (int i = 0; i < 62; i++) {
            System.out.println("");
            for (int j = 0; j < 123; j++) {
                System.out.printf("%4s", at[i][j]);
                fout.write(at[i][j]);
            }
        }
        fout.close();
    }
}
