package gui;

import model.Operatii;
import model.Polynomial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static model.Operatii.impartirePolinoame;

public class Interfara2Polinoame {
    private JButton scadereButton;
    private JButton inmultireButton;
    private JButton adunareButton1;
    private JButton impartireButton;
    private JTextField polinom1;
    private JTextField polinom2;
    private JTextField rezultat;
    private JButton inapoiButton;
    private JPanel Interfata2Polinoame;
    private JTextField restImpartire;

    public Interfara2Polinoame()
    {
        MainInterface.changePanel(Interfata2Polinoame, "AddAndSubstract");
        inapoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                InterfacePolynomialCalculator interfacePolynomialCalculator = new InterfacePolynomialCalculator();

            }
        });
        adunareButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Polynomial p1 = new Polynomial(polinom1.getText());
                Polynomial p2 = new Polynomial(polinom2.getText());
                Polynomial p3 = Operatii.adunarePolinoame(p1,p2);
                rezultat.setText(p3.toString());

            }
        });
        scadereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial p1 = new Polynomial(polinom1.getText());
                Polynomial p2 = new Polynomial(polinom2.getText());
                Polynomial p3 = Operatii.scaderePolinoame(p1,p2);
                rezultat.setText(p3.toString());
            }
        });
        inmultireButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial p1 = new Polynomial(polinom1.getText());
                Polynomial p2 = new Polynomial(polinom2.getText());
                Polynomial p3 = Operatii.inmultirePolinoame(p1,p2);
                rezultat.setText(p3.toString());
            }
        });
        impartireButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial p1 = new Polynomial(polinom1.getText());
                Polynomial p2 = new Polynomial(polinom2.getText());
                ArrayList<Polynomial> rezultatPolinoame=impartirePolinoame(p1,p2);

                rezultat.setText(rezultatPolinoame.get(0).toString());
                restImpartire.setText(rezultatPolinoame.get(1).toString());
            }
        });
    }
}
