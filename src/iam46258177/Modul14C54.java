package iam46258177;

import javax.swing.*;
import java.awt.*;

public class Modul14C54 {

    private boolean estaEnOrbita = false;
//Variable compartida entre SS27, els 3 fils MIRV i el fil ControlDeVolDelSS27.
//Quan valgui true es quan el missil estarà en posició per a llançar les MIRVs //contra els seus objectius.

    private boolean[] impacteMIRV = {false, false, false};
//Variable compartida entre SS27, els 3 fils MIRV i el fil ControlDeVolDelSS27.
//Es posaran a true segons les MIRV fassin impacte contra els seus objectius.
//Una vegada que hagin fet impacte, el missil caurà a terra.

    private boolean impacteControlDeVolDelSS27 = false;
//Variable compartida entre SS27 i el fil ControlDeVolDelSS27.
//Es posarà a true quan el missil, després de que les MIRV hagin fet impacte, //caigui a terra.

    private String img = "fi_del_mon.png";
    private Image image;

    public Modul14C54(){
        image = new ImageIcon(Modul14C54.class.getResource(img)).getImage();
    }

    public boolean isEstaEnOrbita() {
        return estaEnOrbita;
    }

    public synchronized void setEstaEnOrbita(boolean estaEnOrbita) {
        this.estaEnOrbita = estaEnOrbita;
    }

    public synchronized boolean[] getImpacteMIRV() {
        return impacteMIRV;
    }

    public synchronized void setImpacteMIRV(boolean[] impacteMIRV) {
        this.impacteMIRV = impacteMIRV;
    }

    public synchronized  boolean isImpacteControlDeVolDelSS27() {
        return impacteControlDeVolDelSS27;
    }

    public synchronized void setImpacteControlDeVolDelSS27(boolean impacteControlDeVolDelSS27) {
        this.impacteControlDeVolDelSS27 = impacteControlDeVolDelSS27;
    }

    public synchronized String getImg() {
        return img;
    }

    public synchronized void setImg(String img) {
        this.img = img;
    }

    public synchronized Image getImage() {
        return image;
    }

    public synchronized void setImage(Image image) {
        this.image = image;
    }

    public void pinta (Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(this.image, 0, 0, null);
    }

}
