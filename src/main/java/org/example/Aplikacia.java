package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Aplikacia {

    public Aplikacia(){
        JFrame aplikacia=new JFrame("Plus a usecka");
        aplikacia.setResizable(false);
        aplikacia.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        aplikacia.setSize(700,700);

        Plocha plocha=new Plocha();

        JLabel zvolenaFarba=new JLabel("Farba");
        zvolenaFarba.setBackground(Color.GREEN);
        zvolenaFarba.setOpaque(true);

        Choice vyberFarby=new Choice();
        naplnChoice(vyberFarby);
        JButton plus=new JButton("Plus");
        JButton usecka=new JButton("Usecka");
        JButton zmenaFarby=new JButton("Zmenit farbu");
        JPanel menu=new JPanel();
        menu.setLayout(new GridLayout(1,5));
        menu.add(vyberFarby);
        menu.add(plus);
        menu.add(usecka);
        menu.add(zvolenaFarba);
        menu.add(zmenaFarby);

        Priebeh priebeh=new Priebeh(plocha,zvolenaFarba);

        aplikacia.add(plocha, BorderLayout.CENTER);
        aplikacia.add(menu,BorderLayout.SOUTH);

        vyberFarby.addItemListener(priebeh);
        plus.addActionListener(priebeh);
        usecka.addActionListener(priebeh);
        zmenaFarby.addActionListener(priebeh);
        plocha.addMouseMotionListener(priebeh);
        plocha.addMouseListener(priebeh);

        aplikacia.setVisible(true);
    }
    private void naplnChoice(Choice komponent){
        komponent.addItem("Zelena");
        komponent.addItem("Modra");
        komponent.addItem("Cervena");
    }
}
