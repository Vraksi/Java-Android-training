package com.example.customizedlist;

public class Computer {
    String overSkrift;
    String besskrivelse;
    int billedNr;

    public Computer() {

    }

    public Computer(String overSkrift, String besskrivelse, int billedNr) {
        this.overSkrift = overSkrift;
        this.besskrivelse = besskrivelse;
        this.billedNr = billedNr;
    }

    public String getOverSkrift() {
        return overSkrift;
    }

    public void setOverSkrift(String overSkrift) {
        this.overSkrift = overSkrift;
    }

    public String getBesskrivelse() {
        return besskrivelse;
    }

    public void setBesskrivelse(String besskrivelse) {
        this.besskrivelse = besskrivelse;
    }

    public int getBilledNr() {
        return billedNr;
    }

    public void setBilledNr(int billedNr) {
        this.billedNr = billedNr;
    }
}
