package it.aulab.model;

public class Mask {
    private String colore;

    public Mask(String colore) {
        System.out.println("Create mask");
        this.colore = colore;
    }

    public Mask() {
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }
}
