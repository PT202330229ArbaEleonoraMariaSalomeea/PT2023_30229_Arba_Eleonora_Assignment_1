import model.Monomial;
import model.Polynomial;
import org.junit.Test;

import java.util.ArrayList;

import static model.Operatii.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Testare {

    @Test
    public void testAdunare() {

        Polynomial polinom1 = new Polynomial("x^3+2x^2+4x+1");
        Polynomial polinom2 = new Polynomial("2^3+x^2+3x+7");
        Polynomial rezultatAdunare = new Polynomial("3x^3+3x^2+7x+8");

        String rezultatAsteptat = rezultatAdunare.toString();
        String rezultatCalculat = adunarePolinoame(polinom1, polinom2).toString();

        System.out.println("Rezultat asteptat adunare: " + rezultatAsteptat);
        System.out.println("Rezultat calculat adunare: " + rezultatCalculat +"\n");


        assertTrue( rezultatAsteptat.equals(rezultatCalculat));
    }

    @Test
    public void testareScadere() {
        Polynomial polinom1 = new Polynomial("x^3+2x^2+4x+1");
        Polynomial polinom2 = new Polynomial("2^3+x^2+3x+7");
        Polynomial rezultatSCadere = new Polynomial();
        Monomial monom1 =new Monomial(3,1);
        Monomial monom2= new Monomial(2,-1);
        Monomial monom3 = new Monomial(1,-1);
        Monomial monom4 = new Monomial(0,6);

        rezultatSCadere.addMonom(monom1);
        rezultatSCadere.addMonom(monom2);
        rezultatSCadere.addMonom(monom3);
        rezultatSCadere.addMonom(monom4);

        String rezultatAsteptat = rezultatSCadere.toString();
        String rezultatCalculat = scaderePolinoame(polinom2, polinom1).toString();

        System.out.println("Rezultat asteptat scadere: " + rezultatAsteptat);
        System.out.println("Rezultat calculat scadere: " + rezultatCalculat+"\n");

        assertTrue( rezultatAsteptat.equals(rezultatCalculat));
    }

    @Test
    public void testInmultire() {
        Polynomial polinom1 = new Polynomial("2x^2+4x+1");
        Polynomial polinom2 = new Polynomial("3x+7");
        Polynomial rezultatInmultire = new Polynomial("6x^3+26x^2+31x+7");
        String rezultatAsteptat = rezultatInmultire.toString();
        String rezultatCalculat = inmultirePolinoame(polinom1, polinom2).toString();

        System.out.println("Rezultat asteptat inmultire: " + rezultatAsteptat);
        System.out.println("Rezultat calculat inmultire: " + rezultatCalculat+"\n");

        assertTrue( rezultatAsteptat.equals(rezultatCalculat));
    }


    @Test
    public void testDerivare() {
        Polynomial polinom1 = new Polynomial("2x^2+4x+1");
        Polynomial rezultatDerivare = new Polynomial("4x+4");

        String rezultatAsteptat = rezultatDerivare.toString();
        String rezultatCalculat = derivarePolinoame(polinom1).toString();

        System.out.println("Rezultat asteptat derivare: " + rezultatAsteptat);
        System.out.println("Rezultat calculat derivare: " + rezultatCalculat+"\n");

        assertTrue( rezultatAsteptat.equals(rezultatCalculat));

    }

    @Test
    public void testIntegare() {
        Polynomial polinom1 = new Polynomial("2x^3+4x+1");
        Polynomial rezultatIntegrare = new Polynomial("0.5x^4+2x^2+x");

        String rezultatAsteptat = rezultatIntegrare.toString();
        String rezultatCalculat = integrarePolinoame(polinom1).toString();

        System.out.println("Rezultat asteptat integrare: " + rezultatAsteptat);
        System.out.println("Rezultat calculat integrare: " + rezultatCalculat+"\n");

        assertTrue( rezultatAsteptat.equals(rezultatCalculat));

    }

    @Test
    public void testImpartire() {
        Polynomial polinom1 = new Polynomial("x^3-2x^2+6x-5");
        Polynomial polinom2 = new Polynomial("x^2-1");

        Polynomial catAsteptat = new Polynomial("x-2");
       String restAsteptat = new String("7.0x-7.0");

        ArrayList <Polynomial> impartire = impartirePolinoame(polinom1, polinom2);

        String catCalculat = impartire.get(0).toString();
        Polynomial restCalculat = impartire.get(1);

        //int putere = restCalculat.getPolinom().keySet();
        System.out.println("Cat asteptat impartire: " + catAsteptat.toString());
        System.out.println("Rest asteptat impartire: " + restAsteptat.toString());
        System.out.println("Cat calculat impartire: " + catCalculat);
        System.out.println("Rest calculat impartire: " + restCalculat+"\n");
        assertTrue( catAsteptat.toString().equals(catCalculat));
        assertTrue(restAsteptat.equals(restCalculat.toString()) );

    }
}
