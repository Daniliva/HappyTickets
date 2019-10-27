package com.company.Controller;

import com.company.Service.HappyTicketsService;
import com.company.Service.OperationWithFile;

import java.util.Scanner;

public class Controller {

    private static String inputStr() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        return str;
    }

    public static void outputStr(String str) {
        System.out.println(str);
    }


    private String getReading(String way) {
        OperationWithFile operation = new OperationWithFile();
        try {
            return operation.readFromTxt(way);
        } catch (Exception e) {
            return getReading(inputStr());
        }
    }


    public Integer[] getNumbers() {
        try {
            outputStr("Enter way in file with have a numbers tickets:");
            return OperationWithFile.readFileTXTIntegerArea(inputStr());
        } catch (Exception e) {
            outputStr("error Enter");
            return getNumbers();
        }
    }

    public String getIdMethod() {
        outputStr("Enter way in file with have a id method:");
        return getReading(inputStr());
    }
    public int getDischarge() {
        outputStr("Enter discharge:");
        return  Integer.parseInt(inputStr());
    }

    public void countingHappyTickets() {
        HappyTicketsService happyTicketsService = new HappyTicketsService();
        String idMethod = getIdMethod();
        idMethod.replaceAll("\\s+","");
        int discharge =getDischarge();
        Integer[] numbers = getNumbers();
        int result = happyTicketsService.getCountHappyTickets(discharge, idMethod, numbers);
        outputStr("" + result);
    }


    public void run() {
        countingHappyTickets();
    }

}
