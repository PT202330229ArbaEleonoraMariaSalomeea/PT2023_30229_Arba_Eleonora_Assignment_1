package model;

public class Monomial {
   private int putere;
   private double coeficient;

    public Monomial(int putere, double coeficient) {
        this.putere = putere;
        this.coeficient = coeficient;
    }

    public Monomial() {

    }

    public double getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }

    public int getPutere() {
        return putere;
    }

    public void setPutere(int putere) {

        this.putere = putere;
    }

    @Override
    public String toString() {
        return "Monomial{" +
                "putere=" + putere +
                ", coeficient=" + coeficient +
                '}';
    }
}
