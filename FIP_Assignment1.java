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
public class FIP_Assignment1 {

    public static void main(String[] args) {
        int value;
        int count = 1; 
        int k = 0;

        try {

            FileInputStream inputFile = new FileInputStream("yoda.tif");
            String[] arr = new String[inputFile.available()];

            while ((value = inputFile.read()) != -1) {
                arr[k++] = Integer.toHexString(value);
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length() == 1) {
                    arr[i] = 0 + arr[i];
                }
            }
            System.out.println("File name       :yoda.tif\n");
            String order = arr[1] + arr[0];
            String version = arr[3] + arr[2];
            String offset = arr[7] + arr[6] + arr[5] + arr[4];

            System.out.println("-----------------------------< Header Info >-----------------------------");
            System.out.println("Byte order      : " + order);
            System.out.println("Version         :" + version.replaceFirst("^0+(?!$)", " "));
            System.out.println("Offset          :" + offset.replaceFirst("^0+(?!$)", " "));
            System.out.println("");

            String m = arr[9] + arr[8];
            int m1 = Integer.parseInt(m, 16);
            int totalDE = m1 * 12;
            int sizeIFD = totalDE + 2;
            int offset1 = Integer.parseInt(arr[8 + sizeIFD + 6 - 1] + arr[8 + sizeIFD + 5 - 1]);

            System.out.println("-----------------------------< IFD Data >-------------------------------");
            System.out.println("Total DE                :" + totalDE);
            System.out.println("Size of IFD             :" + sizeIFD);
            System.out.println("Consecutive Offset IFD  :" + offset1);
            System.out.println("");

            String[] arrDE = new String[totalDE];
            int u = 0;

            for (int i = 10; i < totalDE + 10; i++) {
                arrDE[u++] = arr[i];
            }
            String[] arrTag = new String[m1];
            String[] arrType = new String[m1];
            String[] arrLength = new String[m1];
            String[] arrValue = new String[m1];
            String type = "";
            String tag = "";
            int indexStripOffsets = 0;

            for (int i = 0; i < m1; i++) {
                arrTag[i] = arrDE[1 + 12 * i] + arrDE[0 + 12 * i];
                arrType[i] = arrDE[3 + 12 * i] + arrDE[2 + 12 * i];
                arrLength[i] = arrDE[7 + 12 * i] + arrDE[6 + 12 * i] + arrDE[5 + 12 * i] + arrDE[4 + 12 * i];
                arrValue[i] = arrDE[11 + 12 * i] + arrDE[10 + 12 * i] + arrDE[9 + 12 * i] + arrDE[8 + 12 * i];
            }

            for (int i = 0; i < m1; i++) {
                if (Integer.parseInt(arrTag[i], 16) == 273) {
                    indexStripOffsets = i;
                }
            }

            System.out.println("-----------------------------< Data Entry >-------------------------------");
            System.out.println("| Tag                            |      Type     |   Count  |  Value");
            System.out.println("-------------------------------------------------------------------------");

            for (int i = 0; i < arrTag.length; i++) {
                switch (Integer.parseInt(arrTag[i], 16)) {
                    case 254:
                        tag = " (New sub file type)\t\t\t";
                        break;
                    case 256:
                        tag = " (Image width)\t\t\t";
                        break;
                    case 257:
                        tag = " (Image height)\t\t\t";
                        break;
                    case 258:
                        tag = " (Bits per sample)\t\t\t";
                        break;
                    case 259:
                        tag = " (Compression)\t\t\t";
                        break;
                    case 262:
                        tag = " (Photometric interpretation)\t";
                        break;
                    case 273:
                        tag = " (Strip offsets)\t\t\t";
                        break;
                    case 277:
                        tag = " (Samples per pixel)\t\t\t";
                        break;
                    case 278:
                        tag = " (Rows per strip)\t\t\t";
                        break;
                    case 279:
                        tag = " (Strip byte counts)\t\t\t";
                        break;
                    case 282:
                        tag = " (X resolution)\t\t\t";
                        break;
                    case 283:
                        tag = " (Y resolution)\t\t\t";
                        break;
                    case 296:
                        tag = " (Resolution unit)\t\t\t";
                        break;
                    default:
                        tag = " (unknown)\t\t\t\t";
                        break;
                }
                switch (Integer.parseInt(arrType[i], 16)) {
                    case 3:
                        type = "(SHORT)\t";
                        break;
                    case 4:
                        type = "(LONG)\t\t";
                        break;
                    case 5:
                        type = "(RATIONAL)\t";
                        break;
                }
                System.out.println(arrTag[i].replaceFirst("^0+(?!$)", "")
                        + tag + arrType[i].replaceFirst("^0+(?!$)", "") + type
                        + arrLength[i].replaceFirst("^0+(?!$)", "") + "\t"
                        + Integer.parseInt(arrValue[i].replaceFirst("^0+(?!$)", ""), 16));
            }

            System.out.println("-----------------------------< Image  Data >-----------------------------");
            for (int i = Integer.parseInt(arrValue[indexStripOffsets], 16); i < arr.length; i++) {
                System.out.printf("%3s", arr[i]);
                if (count % 8 == 0) {
                    System.out.print(" ");
                }
                if (count % 16 == 0) {
                    System.out.println(" ");
                }
                count++;
            }
            inputFile.close();

        } catch (IOException ex) {
            System.out.println("File error!");
        }

    }
}
