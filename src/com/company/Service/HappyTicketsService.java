package com.company.Service;


public class HappyTicketsService {
    NumberArrayService numberArrayService;

    public HappyTicketsService() {
        numberArrayService = new NumberArrayService();
    }

    public boolean getMoscowMethod(int number, int discharge) {
        Integer[] Mass = numberArrayService.numberToArrayOfDigits(number, discharge);
        int sum1 = 0, sum2 = 0;
        for (int j = 0; j < Mass.length / 2; j++) {
            sum1 += Mass[j + Mass.length / 2];
            sum2 += Mass[j];
        }
        if (sum1 == sum2) {
            return true;
        }
        return false;
    }

    public int getCountHappyTickets(int discharge,int id,Integer[] numbers) {
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (id == 1) {
                if (getMoscowMethod(numbers[i], discharge)) {
                    result++;
                }
            } else if (id == 2) {
                if (getPiterMethod(numbers[i], discharge)) {
                    result++;
                }
            }
        }
        return result;
    }

    public boolean getPiterMethod(int number, int discharge) {
        Integer[] Mass = numberArrayService.numberToArrayOfDigits(number, discharge);
        int sum1 = 0, sum2 = 0;
        for (int j = 0; j < Mass.length; j++) {
            if ((j + 1) % 2 == 0) {
                sum1 += Mass[j];
            } else {
                sum2 += Mass[j];
            }
        }
        if (sum1 == sum2) {
            return true;
        }
        return false;
    }


}
