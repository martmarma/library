package uk.co.martmarma.library.domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Fine {

    private final Loan loan;
    //private LocalDate today = LocalDate.now();

    public Fine(final Loan loan){
        this.loan = loan;
    }

    public Loan getLoan() {
        return loan;
    }


    public long getAmount(){
        long poundsToPay = 0;
        LocalDate returnDate = this.loan.getReturnDate();

        if (loan.isOverdue() == true) {
            poundsToPay = ChronoUnit.DAYS.between(returnDate, LocalDate.now());
        }

        return poundsToPay;
    }

}


