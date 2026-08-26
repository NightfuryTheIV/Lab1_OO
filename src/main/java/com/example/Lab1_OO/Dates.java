package com.example.Lab1_OO;

public class Dates {
    private String begin;
    private String end;

    public Dates(String begin, String end) {
        this.begin = begin;
        this.end = end;
    }

    public Dates() {
        begin = "";
        end = "";
    }

    public String getBegin() {
        return begin;
    }
    public String getEnd() {
        return end;
    }
    public void setBegin(String begin) {
        this.begin = begin;
    }
    public void setEnd(String end) {
        this.end = end;
    }

    public void resetDates() {
        this.begin = "";
        this.end = "";
    }
}
