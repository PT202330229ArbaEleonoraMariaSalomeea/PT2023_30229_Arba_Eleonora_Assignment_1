package gui;

import model.Operatii;
import model.Polynomial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfata1Polinom {
    private JTextField polinom;
    private JTextField rezultat;
    private JButton derivareButton;
    private JButton integrareButton;
    private JButton inapoiButton;
    private JPanel Interfata1Polinom;

    public Interfata1Polinom()
    {
        MainInterface.changePanel(Interfata1Polinom, "DerivationAndIntegrationPanel");
        inapoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                InterfacePolynomialCalculator interfacePolynomialCalculator = new InterfacePolynomialCalculator();

            }
        });
        derivareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial p1 = new Polynomial(polinom.getText());
                Polynomial p3 = Operatii.derivarePolinoame(p1);
                rezultat.setText(p3.toString());
            }
        });
        integrareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial p1 = new Polynomial(polinom.getText());
                Polynomial p3 = Operatii.integrarePolinoame(p1);
                rezultat.setText(p3.toString());
            }
        });
    }

}
