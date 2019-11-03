package com.company.Service;


import com.company.Model.Ticket;

public class HappyTicketsService {

    private NumberArrayService numberArrayService;

    public HappyTicketsService() {
        numberArrayService = new NumberArrayService();
    }

    private boolean getMoscowMethod(int number, int discharge) {
        Integer[] Mass = numberArrayService.numberToArrayOfDigits(number, discharge);
        int sum1 = 0, sum2 = 0;
        for (int j = 0; j < Mass.length / 2; j++) {
            sum1 += Mass[j + Mass.length / 2];
            sum2 += Mass[j];
        }
        return sum1 == sum2;
    }

    public int getCountHappyTickets(int discharge, String id, Ticket[] numbers) {
        int result = 0;
        for (Ticket number : numbers) {
            if (id.equals("Moskow")) {
                if (getMoscowMethod(number.getNumber(), discharge)) {
                    result++;
                    number.setItsHappyTicket(true);
                }
            } else if (id.equals("Piter")) {
                if (getPiterMethod(number.getNumber(), discharge)) {
                    result++;
                    number.setItsHappyTicket(true);
                }
            }
        }
        return result;
    }

    private boolean getPiterMethod(int number, int discharge) {
        Integer[] Mass = numberArrayService.numberToArrayOfDigits(number, discharge);
        int sum1 = 0, sum2 = 0;
        for (int j = 0; j < Mass.length; j++) {
            if ((j + 1) % 2 == 0) {
                sum1 += Mass[j];
            } else {
                sum2 += Mass[j];
            }
        }
        return sum1 == sum2;
    }


}
