package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Polynomial {
    private HashMap<Integer, Double> polinom;

    public Polynomial() {
        this.polinom = new HashMap<Integer, Double>();
    }
    public Polynomial(HashMap<Integer,Double> map) {

        this.polinom = map;
    }

    public Polynomial(String polinomString){
        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");//stackOverflow
        Matcher matcher = pattern.matcher(polinomString);
        HashMap<Integer, Double> poli = new HashMap<>();

        int x=0;
        while (matcher.find()) {
            x=x+1;
            String[] firstSplit = matcher.group(1).split("[?^]");

            if(firstSplit.length == 2){
                if(Objects.equals(firstSplit[0], "x") || Objects.equals(firstSplit[0], "+x") || Objects.equals(firstSplit[0], "-x")){

                    poli.put(Integer.valueOf(firstSplit[1]),1.0);
                }
                else {
                    String[] keyString = firstSplit[0].split("[x]");
                    double value =  Double.valueOf(keyString[0]);
                    int key = Integer.valueOf(firstSplit[1]);

                    poli.put(key, value);
                }
            }
            else {
                if(Objects.equals(firstSplit[0], "x") || Objects.equals(firstSplit[0], "+x") || Objects.equals(firstSplit[0], "-x")){

                    poli.put(1,1.0);
                }
                else {
                    if (firstSplit[0].contains("x")) {
                        String[] keyS = firstSplit[0].split("x");
                        if (keyS[0] != null) {
                            double value = Integer.valueOf(keyS[0]);
                            poli.put(1, value);
                        } else {
                            poli.put(1, 1.0);
                        }
                    } else {
                        double value = Integer.valueOf(firstSplit[0]);
                        poli.put(0, value);
                    }
                }
            }

        }
        this.polinom = poli;
    }

    public void addMonom (Monomial monomToAdd){

        if(monomToAdd.getCoeficient() !=0){
            if(polinom.containsKey(monomToAdd.getPutere())) {
                for (Map.Entry<Integer, Double>  set : this.getPolinom().entrySet()) {
                    if (set.getKey() == monomToAdd.getPutere()){
                         this.polinom.replace(monomToAdd.getPutere(), set.getValue() +monomToAdd.getCoeficient() );
                }
            }
            }
            else {
            this.polinom.put(monomToAdd.getPutere(), monomToAdd.getCoeficient());
                }
        }

    }

    @Override
    public String toString() {

        int firstKey=0;
        String stringAfisare = new String();

        for(Integer i : this.getPolinom().keySet()) {
             firstKey = i;
            break;
        }

        for(Integer i : this.getPolinom().keySet()){
            if(this.getPolinom().get(i) != 0) {
                if (i == 0) {
                    if (this.getPolinom().get(i) > 0)
                        stringAfisare = stringAfisare.concat("" +this.getPolinom().get(i));
                    else
                        stringAfisare = stringAfisare.concat("" + String.valueOf(this.getPolinom().get(i)));
                }
                if (i==1){
                    if(this.getPolinom().get(i) == 1)
                    {
                        if(i!=firstKey)
                            stringAfisare = stringAfisare.concat("+"  + "x");
                        else
                            stringAfisare = stringAfisare.concat("x");
                    }
                    else if (this.getPolinom().get(i) > 0 && i!= firstKey)
                        stringAfisare = stringAfisare.concat("+" + this.getPolinom().get(i) + "x");
                    else
                        stringAfisare = stringAfisare.concat("" + this.getPolinom().get(i) + "x");

                }
                if(i>1) {
                    if (this.getPolinom().get(i) > 0 && i!= firstKey ) {
                        if (this.getPolinom().get(i) == 1)
                            stringAfisare = stringAfisare.concat("+" + "x^" + i);
                        else
                            stringAfisare = stringAfisare.concat("+" + this.getPolinom().get(i) + "x^" + i);
                    }
                    else {
                        if (this.getPolinom().get(i) == 1)
                            stringAfisare = stringAfisare.concat("x^" + i);
                        else
                            stringAfisare = stringAfisare.concat("" + this.getPolinom().get(i) + "x^" + i);
                    }
                }
            }
        }

        return stringAfisare;

    }

    public HashMap<Integer, Double> getPolinom() {
        return polinom;
    }

    public void setPolinom(HashMap<Integer, Double> polinom) {
        this.polinom = polinom;
    }


}
