package com.company.Controller;

import com.company.Service.OperationWithFile;

import static com.company.Controller.EnterOutController.*;

import java.util.Scanner;

public abstract class HappyTickets {

    protected String getIdMethod() {

        outputStr("Enter 1, if you wont enter with file,\n" +
                "or 2, if you wont enter:");
        int answer = inputInt();
        if (answer == 1) {
            return getIdMethodWithFile();
        } else if (answer == 2) {
            return getIdMethodWithEnter();
        } else {
            outputStr("error,please try again:");
            return getIdMethod();
        }

    }

    String getReading(String way) {
        try {
            return OperationWithFile.readFromTxt(way);
        } catch (Exception e) {
            return getReading(inputStr());
        }
    }

    private String getIdMethodWithFile() {
        outputStr("Enter way in file with have a id method:");
        try {
            return getReading(inputStr());

        } catch (NumberFormatException e) {
            outputStr("error,please try again:");
            return getIdMethod();
        }
    }

    private String getIdMethodWithEnter() {
        outputStr("Enter 1, if you wont use \"Moskow\" or 2, if you wont to use \"Piter\" method:");
        int answer = inputInt();
        if (answer == 1) {
            return "Moskow";
        } else if (answer == 2) {
            return "Piter";
        } else {
            outputStr("error,please try again:");
            return getIdMethod();
        }

    }


    int getDischarge() {
        outputStr("Enter discharge:");
        return Integer.parseInt(inputStr());
    }
}
