package model;
import java.util.*;

public class Operatii {

    public static Polynomial adunarePolinoame( Polynomial polinom1, Polynomial polinom2){
       HashMap <Integer, Double> rezultat = new HashMap<>();

        Polynomial rezPolinomial= new Polynomial();

        for (Map.Entry<Integer, Double>  set1 : polinom1.getPolinom().entrySet()) {
            if(!polinom2.getPolinom().containsKey(set1.getKey())){
                rezultat.put(set1.getKey(), set1.getValue());
            }
        }

        for (Map.Entry<Integer, Double>  set2 : polinom2.getPolinom().entrySet()) {
            if(!polinom1.getPolinom().containsKey(set2.getKey())){
                rezultat.put(set2.getKey(), set2.getValue());
            }
        }

        for (Map.Entry<Integer, Double>  set1 : polinom1.getPolinom().entrySet()){
            for (Map.Entry<Integer, Double>  set2 : polinom2.getPolinom().entrySet()){
                if(set1.getKey() == set2.getKey()) {
                    rezultat.put(set1.getKey(), set1.getValue() + set2.getValue());

                }
            }

        }
     rezPolinomial.setPolinom(rezultat);

    return rezPolinomial;
    }


    public static Polynomial scaderePolinoame( Polynomial polinom1, Polynomial polinom2){
        HashMap <Integer, Double> rezultat = new HashMap<>();

        Polynomial rezPolinomial= new Polynomial();

        for (Map.Entry<Integer, Double>  set1 : polinom1.getPolinom().entrySet()) {
            if(!polinom2.getPolinom().containsKey(set1.getKey())){
                rezultat.put(set1.getKey(), set1.getValue());
            }
        }

        for (Map.Entry<Integer, Double>  set2 : polinom2.getPolinom().entrySet()) {
            if(!polinom1.getPolinom().containsKey(set2.getKey())){
                rezultat.put(set2.getKey(), (-set2.getValue()));
            }
        }

        for (Map.Entry<Integer, Double>  set1 : polinom1.getPolinom().entrySet()){
            for (Map.Entry<Integer, Double>  set2 : polinom2.getPolinom().entrySet()){
                if(set1.getKey() == set2.getKey()) {
                    if(set1.getValue() - set2.getValue() != 0)
                        rezultat.put(set1.getKey(), (set1.getValue() - set2.getValue()));
                }
            }
        }
        rezPolinomial.setPolinom(rezultat);

        return rezPolinomial;
    }

    public static Polynomial inmultirePolinoame( Polynomial polinom1, Polynomial polinom2){
        HashMap <Integer, Double> rezultat = new HashMap<>();

        Polynomial rezPolinomial= new Polynomial();

        for (Map.Entry<Integer, Double>  set1 : polinom1.getPolinom().entrySet()){
            for (Map.Entry<Integer, Double>  set2 : polinom2.getPolinom().entrySet()){

                if(rezultat.containsKey(set1.getKey() + set2.getKey())){
                    rezultat.replace(set1.getKey() + set2.getKey(), rezultat.get(set1.getKey() + set2.getKey()) + set1.getValue() * set2.getValue());
                }
                else
                    rezultat.put(set1.getKey()+set2.getKey(), set1.getValue() * set2.getValue());

            }

        }
        rezPolinomial.setPolinom(rezultat);

        return rezPolinomial;
    }

    public static Polynomial ordonareDescrescatoare(Polynomial polinomToSort){

        ArrayList <Integer> listaPolinom = new ArrayList<>(polinomToSort.getPolinom().keySet());

        Collections.sort(listaPolinom);
        Collections.reverse(listaPolinom);

        Monomial monom = new Monomial();
        LinkedHashMap<Integer,Double> newMap = new LinkedHashMap<>();

        for (Integer i: listaPolinom){
            newMap.put(i,polinomToSort.getPolinom().get(i));
        }


        return new Polynomial(newMap);
    }
    public static ArrayList<Polynomial> impartirePolinoame( Polynomial polinom1, Polynomial polinom2) {
        polinom1=ordonareDescrescatoare(polinom1);
        polinom2=ordonareDescrescatoare(polinom2);
        Polynomial cat = new Polynomial();
        Polynomial rest = new Polynomial();
        ArrayList <Integer> keySet1 = new ArrayList<>(polinom1.getPolinom().keySet());
        ArrayList <Integer> keySet2 = new ArrayList<>(polinom2.getPolinom().keySet());

        if(keySet1.get(0) >= keySet2.get(0)){
            while(keySet1.get(0)>= keySet2.get(0)) {
                Monomial monomCat = new Monomial(keySet1.get(0) - keySet2.get(0), polinom1.getPolinom().get(keySet1.get(0)) / polinom2.getPolinom().get(keySet2.get(0)));
                cat.addMonom(monomCat);

                Polynomial inmultireCatP2 = inmultirePolinoame(polinom2, cat);
                rest = scaderePolinoame(polinom1, inmultireCatP2);
                rest = ordonareDescrescatoare(rest);
                keySet1= new ArrayList<>(rest.getPolinom().keySet());
            }
        }
        else{
            while(keySet2.get(0)>= keySet1.get(0)) {
                Monomial monomCat = new Monomial(keySet2.get(0) - keySet1.get(0), polinom2.getPolinom().get(keySet2.get(0)) / polinom1.getPolinom().get(keySet1.get(0)));
                cat.addMonom(monomCat);

                Polynomial inmultireCatP2 = inmultirePolinoame(polinom1, cat);
                rest = scaderePolinoame(polinom2, inmultireCatP2);
                rest = ordonareDescrescatoare(rest);
                keySet2= new ArrayList<>(rest.getPolinom().keySet());
            }
        }

        ArrayList<Polynomial> listaRezultat = new ArrayList<>();
        listaRezultat.add(cat);
        listaRezultat.add(rest);

        return listaRezultat;

    }

    public static Polynomial derivarePolinoame (Polynomial polinom){
        Polynomial rezultatPolinomial = new Polynomial();
        HashMap <Integer, Double> rezultat = new HashMap<>();

        for (Map.Entry<Integer, Double>  set : polinom.getPolinom().entrySet()) {
            if(set.getKey()==0){
                rezultat.put(0,0.0);
            }
            else
            rezultat.put(set.getKey()-1, set.getValue() * set.getKey());
        }

        rezultatPolinomial.setPolinom(rezultat);
        return rezultatPolinomial;
    }

    public static Polynomial integrarePolinoame (Polynomial polinom){
        Polynomial rezultatPolinomial = new Polynomial();
        HashMap <Integer, Double> rezultat = new HashMap<>();

        for (Map.Entry<Integer, Double>  set : polinom.getPolinom().entrySet()) {
            rezultat.put(set.getKey()+1, set.getValue()/ (set.getKey() + 1 ));
        }

        rezultatPolinomial.setPolinom(rezultat);
        return rezultatPolinomial;
    }


}
