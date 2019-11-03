package com.company.Controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EnterOutController {

    public static boolean answerForContinue(String question) {
        String s2 = "Y";
        String s1 = "yes";
        outputStr(question + "(if you answer yes\n enter 'yes' or 'y'\n if you answer -no enter any char ):\n");//  outputStr("Will you continue?:\n");
        String answer = inputStr();
        if (Pattern.compile(Pattern.quote(s1), Pattern.CASE_INSENSITIVE).matcher(answer).find()) {
            return true;
        } else return Pattern.compile(Pattern.quote(s2), Pattern.CASE_INSENSITIVE).matcher(answer).find();
    }

    public static  String inputStr() {
        String str;
        Scanner in = new Scanner(System.in);
        str = in.nextLine();
        return str;
    }

    public static  void outputStr(String str) {
        System.out.println(str);
    }

    public static  double inputDouble() {
        Scanner in = new Scanner(System.in);
        double str = 0;
        try {
            str = in.nextDouble();
        } catch (InputMismatchException e) {
            outputStr("it is not number");
            if (answerForContinue("Do you wont continue?\n")) {
                return inputDouble();
            }
        }
        return str;
    }
    public static int inputInt() {
        Scanner in = new Scanner(System.in);
        int result = in.nextInt();
        if (result != 0) {
            return result;
        } else {
            outputStr("Error enter try again");
            return inputInt();
        }
    }
}
