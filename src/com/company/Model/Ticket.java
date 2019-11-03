package com.company.Model;

public class Ticket {
    private int number;
    private boolean itsHappyTicket;



    public Ticket(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isItsHappyTicket() {
        return itsHappyTicket;
    }

    public void setItsHappyTicket(boolean itsHappyTicket) {
        this.itsHappyTicket = itsHappyTicket;
    }
}
