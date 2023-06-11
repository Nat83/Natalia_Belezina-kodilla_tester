package com.kodilla.jacoco;

public class Year {
    int checkedYear;

    public Year(int year) {
        this.checkedYear = year;
    }

    public boolean isLeap() {
        if (this.checkedYear % 4 == 0) {
            if (this.checkedYear % 100 == 0) {
                if (this.checkedYear % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}