package com.company.Controller;

import java.util.regex.Pattern;


import static com.company.Controller.EnterOutController.*;

public class Controller {

    private boolean answerForContinue() {
        String s2 = "Y";
        String s1 = "yes";
        outputStr("Will you continue?:\n");
        String answer = inputStr();
        if (Pattern.compile(Pattern.quote(s1), Pattern.CASE_INSENSITIVE).matcher(answer).find()) {
            return true;
        } else return Pattern.compile(Pattern.quote(s2), Pattern.CASE_INSENSITIVE).matcher(answer).find();
    }

    private void countingHappyTickets() {
        while (answerForContinue()) {
            runController();
        }
    }

    private void runController() {
        HappyTicketsWithFileController HTWFC = new HappyTicketsWithFileController();
        HappyTicketsWithEnterController HTWFE = new HappyTicketsWithEnterController();
        outputStr("Enter 1, if you wont to coast happy tickets with file\n" +
                "or 2, if you wont to coast happy tickets with your enter\"");
        int answer = inputInt();
        if (answer == 1) {
            HTWFC.run();
        } else if (answer == 2) {
            HTWFE.run();
        } else {
            outputStr("You enter not 1 or 2");
        }
    }


    public void run() {
        countingHappyTickets();
    }

}
