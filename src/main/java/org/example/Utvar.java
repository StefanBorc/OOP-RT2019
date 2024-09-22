package org.example;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@Setter
public class Utvar extends JPanel {
    @Getter
    private int x;
    @Getter
    private int y;
    private int sirka;
    private int vyska;
    private int xK;
    private int yK;
    private Color farba;
    private Mod mod;
    public Utvar(MouseEvent e,Mod mod,Color farba,Priebeh priebeh) {
        x=e.getX();
        y=e.getY();
        xK=e.getX();
        yK=e.getY();
        sirka=0;
        vyska=0;
        this.mod=mod;
        this.farba=farba;
    }
    protected void nakresliUtvar(Graphics g){
        Graphics2D g2d=(Graphics2D)g;
        g.setColor(farba);
        if(mod.equals(Mod.PLUS)){
            g.fillRect(x,y+vyska/3,sirka,vyska/3);
            g.fillRect(x+sirka/3,y,sirka/3,vyska);
        }
        else if(mod.equals(Mod.USECKA)){
            g2d.setStroke(new BasicStroke(3));
            g2d.drawLine(x,y,xK,yK);

        }
    }
    protected boolean jeUtvar(int x , int y){
        return x>this.x &&
                x<this.x+sirka &&
                y>this.y &&
                y<this.y+vyska;
    }

}
