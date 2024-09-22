package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;

public class Priebeh extends UniverzalnyAdapter{
    public static final String PLUS="Plus";
    public static final String USECKA="Usecka";
    public static final String ZELENA="Zelena";
    public static final String CERVENA="Cervena";
    public static final String MODRA="Modra";
    public static final String ZMENA_FARBY="Zmenit farbu";
    private JLabel aktualnaFarba;
    private Plocha plocha;
    private Point zaciatokSuradnice;
    private Point koniecSuradnice;


    public Priebeh(Plocha plocha, JLabel zvolenaFarba) {
        this.plocha=plocha;
        this.aktualnaFarba=zvolenaFarba;
        plocha.setFarba(Color.GREEN);
        koniecSuradnice =new Point();
    }

    private void zmenFarbu(Color farba){
        aktualnaFarba.setBackground(farba);
        plocha.setFarba(farba);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getItem().equals(ZELENA)){
            zmenFarbu(Color.GREEN);
        }
        else if(e.getItem().equals(MODRA)){
            zmenFarbu(Color.BLUE);
        }
        else if(e.getItem().equals(CERVENA)){
            zmenFarbu(Color.RED);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(plocha.getMod().equals(Mod.FARBA)){
            plocha.setUtvar(plocha.dajUtvar(e));
            if(plocha.getUtvar()!=null){
                plocha.getUtvar().setFarba(plocha.getFarba());
            }
        }
        else{
            zaciatokSuradnice=e.getPoint();
            koniecSuradnice =e.getPoint();
            plocha.pridajUtvar(e,this);
        }
        plocha.repaint();

    }
    @Override
    public void mouseDragged(MouseEvent e){
        koniecSuradnice = e.getPoint();
        if(plocha.getMod().equals(Mod.PLUS)){
            plocha.getUtvar().setX(Math.min(zaciatokSuradnice.x,koniecSuradnice.x));
            plocha.getUtvar().setY(Math.min(koniecSuradnice.y,zaciatokSuradnice.y));
            plocha.getUtvar().setSirka(Math.abs(koniecSuradnice.x-zaciatokSuradnice.x));
            plocha.getUtvar().setVyska(Math.abs(koniecSuradnice.y-zaciatokSuradnice.y));

        }
        else if(plocha.getMod().equals(Mod.USECKA)){
            plocha.getUtvar().setXK(e.getX());
            plocha.getUtvar().setYK(e.getY());
        }
        plocha.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(PLUS)){
            plocha.setMod(Mod.PLUS);
        }
        else if(e.getActionCommand().equals(USECKA)){
            plocha.setMod(Mod.USECKA);
        }
        else if(e.getActionCommand().equals(ZMENA_FARBY)){
            plocha.setMod(Mod.FARBA);
        }
    }
    @Override
    public void mouseReleased(MouseEvent e){
        koniecSuradnice=new Point();
        zaciatokSuradnice=new Point();
    }



}
