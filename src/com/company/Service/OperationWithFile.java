package com.company.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

import static com.company.Controller.Controller.outputStr;

public class OperationWithFile {

    public static final String error = "Error 100100100";

    public static String readFromTxt(String way) throws Exception {
        FileReader fr;
        Scanner scan;
        String read = "";
        try {
            fr = new FileReader(way);
            scan = new Scanner(fr);
        } catch (FileNotFoundException e) {
            read = error;
            return read;
        }
        while (scan.hasNextLine())
            read += scan.nextLine();
        scan.close();
        fr.close();
        return read;
    }

    public static Integer[] readFileTXTIntegerArea(String way) throws Exception {
        String[] numbersInString =readFromTxt(way).split(",");
        Integer[] numbers = new Integer[numbersInString.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersInString[i].replaceAll("\\s+", ""));
        }
        return numbers;
    }

    public static void writeToTxt(String way, String strToWrite) {
        try (FileOutputStream fos = new FileOutputStream(way)) {
            byte[] buffer = strToWrite.getBytes();
            fos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            outputStr(ex.getMessage());
        }
        outputStr("The file has been written");
    }
}