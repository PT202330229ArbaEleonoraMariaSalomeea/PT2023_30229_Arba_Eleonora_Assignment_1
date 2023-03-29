package gui;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfacePolynomialCalculator {
    private JButton adunare_Scadere_Inmultire_ImpartireButton;
    private JButton derivare_IntegrareButton;
    private JPanel InterfacePolynomialCalculator;

    public InterfacePolynomialCalculator()
    {
        MainInterface.changePanel(InterfacePolynomialCalculator,"MainPanel");
        adunare_Scadere_Inmultire_ImpartireButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Interfara2Polinoame interfara2Polinoame = new Interfara2Polinoame();
            }
        });
        derivare_IntegrareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Interfata1Polinom interfata1Polinom = new Interfata1Polinom();

            }
        });
    }

}
