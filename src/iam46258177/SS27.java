/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iam46258177;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author gines
 */
class SS27 extends JPanel implements Runnable {
    private int numNaus=3;
    Thread[] filsNau;
    MIRV[] arrayMIRVs;
    Modul14C54 modul14C54Obj;
    ControlDeVolDelSS27 controlDeVolDelSS27;
    Thread filControlDeVolDelSS27;
    int posX, posY;
    String controlDeVolDelSS27Id;
    String MIRVId;

    //ControlDeVolDelSS27[] controlDeVolDelSS27;


    public SS27(){
        filsNau = new Thread[numNaus]; //Creo dos hilos
        //controlDeVolDelSS27 = new ControlDeVolDelSS27[numNaus];

        modul14C54Obj = new Modul14C54();
        controlDeVolDelSS27 = new ControlDeVolDelSS27(1, 840, 1, 1, 30, modul14C54Obj);
        filControlDeVolDelSS27 = new Thread(this);


        for (int i = 0; i < filsNau.length; i++){
            filsNau[i] = new Thread(this);
            filsNau[i].setName("Fil Nau-"+ i);

            Random rand = new Random();
            //int velocitat = rand.nextInt(50);
            int velocitat = 10;
            //int posX = rand.nextInt(100) + 30;
            //int posY = rand.nextInt(100) + 30;
            int posX = rand.nextInt(400) + 30;
            int posY = rand.nextInt(400) + 30;
            //int dX = rand.nextInt(3) + 1;
            //int dY = rand.nextInt(3) + 1;
            int dX = 1;
            int dY = 1;
            controlDeVolDelSS27[i] = new ControlDeVolDelSS27(posX, posY, dX, dY, velocitat);
        }

        for (int i = 0; i < filsNau.length; ++i) {

            posX = 430;
            switch (i) {
                case 0:
                    posY = 25;
                    break;
                case 1:
                    posY = 50;
                    break;
                case 2:
                    posY = 75;
                    break;
                default:
                    posY = 0;
            }


            int dX = 1;
            int dY = 1;

            arrayMIRVs[i] = new MIRV(posX, posY, dX, dY, 10, i, modul14C54Obj);

            filsNau[i].start();
        }
    }


    public void run(){

        while (Thread.currentThread().getId() = )
        for (int i = 0; i < filsNau.length; ++i){
            while (filsNau[i].currentThread() == filsNau[i]) {
                try {
                    filsNau[i].sleep(controlDeVolDelSS27[i].velocitat()); //
                    controlDeVolDelSS27[i].moure();
                }catch (InterruptedException e) { }
                repaint();

            }
        }
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(int i = 0; i < controlDeVolDelSS27.length; ++i)
            controlDeVolDelSS27[i].pinta(g);
    }
}
