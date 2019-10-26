package com.company.Service;

public class NumberArrayService {
    public Integer[] numberToArrayOfDigits(int number, int discharge) {
        Integer[] Mass = new Integer[discharge];
        for (int j = discharge - 1; j >= 0; j--) {
            Mass[j] = number / (int) Math.pow(10, j) % 10;
        }
        return Mass;
    }
}
