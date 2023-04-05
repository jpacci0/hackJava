package it.aulab.model;

public class Batmobile {
    private String colore;

    public Batmobile(String colore) {
        System.out.println("Create batmobile");
        this.colore = colore;
    }

    public Batmobile() {
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }
}
