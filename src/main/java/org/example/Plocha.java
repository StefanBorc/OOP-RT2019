package org.example;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;


import java.util.ArrayList;

public class Plocha extends JPanel  {
    @Setter@Getter
    private Color farba;
    @Setter
    @Getter
    private Mod mod;
    private ArrayList<Utvar> utvary;
    @Getter@Setter
    private Utvar utvar;

    public Plocha() {
        utvary = new ArrayList<>();
        mod = Mod.PLUS;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Utvar utvar : utvary) {
            utvar.nakresliUtvar(g);
        }
    }

    protected void pridajUtvar(MouseEvent e, Priebeh priebeh) {
        utvar = new Utvar(e, mod, farba, priebeh);
        utvary.add(utvar);
        utvar.addMouseListener(priebeh);
    }

    protected Utvar dajUtvar(MouseEvent e){
        for(Utvar utvar : utvary){
            if(utvar.jeUtvar(e.getX(),e.getY())){
                return utvar;
            }
        }
        return null;
    }

}
