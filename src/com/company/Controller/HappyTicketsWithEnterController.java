package com.company.Controller;

import com.company.Model.Ticket;
import com.company.Service.HappyTicketsService;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static com.company.Controller.EnterOutController.*;

public class HappyTicketsWithEnterController extends HappyTickets {
    private boolean answerForContinue() {
        String s2 = "Y";
        String s1 = "yes";
        outputStr("Will you continue?:\n");
        String answer = inputStr();
        if (Pattern.compile(Pattern.quote(s1), Pattern.CASE_INSENSITIVE).matcher(answer).find()) {
            return true;
        } else return Pattern.compile(Pattern.quote(s2), Pattern.CASE_INSENSITIVE).matcher(answer).find();
    }

    private void happyTicketsWithEnter() {
        int discharge = getDischarge();
        String idMethod = getIdMethod();
        List<Ticket> numbers = new ArrayList<>();
        while (answerForContinue()) {
            Ticket ticket = new Ticket(inputInt());
            numbers.add(ticket);
        }
        HappyTicketsService happyTicketsService = new HappyTicketsService();
        int result = happyTicketsService.getCountHappyTickets(discharge, idMethod, (Ticket[]) numbers.toArray());
        outputStr("" + result);
    }

    public void run() {
        happyTicketsWithEnter();
    }
}
