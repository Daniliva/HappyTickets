package com.company.Service;

import java.util.ArrayList;
import java.util.List;

public class NumberTickets {
    public List<Integer> generatedNumber(int discharge) {
        List<Integer> numberTickets = new ArrayList<Integer>();
        double maxSize = Math.pow(10, discharge);
        for (int i = 0; i < maxSize; i++) {
            numberTickets.add(i);
        }
        return numberTickets;
    }

    public void writeNumbersTickets(String way) {
        List<Integer> integers = generatedNumber(6);
        OperationWithFile.writeToTxt(way, integers.toString());
    }
}
