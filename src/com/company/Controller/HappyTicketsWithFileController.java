package com.company.Controller;

import com.company.Model.Ticket;
import com.company.Service.HappyTicketsService;
import com.company.Service.OperationWithFile;

import java.util.ArrayList;
import java.util.List;

import static com.company.Controller.EnterOutController.*;

public class HappyTicketsWithFileController extends HappyTickets {

    private Integer[] getNumbers() {
        try {
            outputStr("Enter way in file with have a numbers tickets:");
            return OperationWithFile.readFileTXTIntegerArea(inputStr());
        } catch (Exception e) {
            outputStr("error Enter");
            return getNumbers();
        }
    }


    private void happyTicketsWithFile() {
        HappyTicketsService happyTicketsService = new HappyTicketsService();
        String idMethod = getIdMethod();
        idMethod = idMethod.replaceAll("\\s+", "");
        int discharge = getDischarge();
        Integer[] numbers = getNumbers();
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            tickets.add(new Ticket(numbers[i]));
        }
        int result = happyTicketsService.getCountHappyTickets(discharge, idMethod, (Ticket[]) tickets.toArray());
        outputStr("" + result);
    }

    public void run() {
        happyTicketsWithFile();
    }
}
