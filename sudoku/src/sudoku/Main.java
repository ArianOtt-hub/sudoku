package sudoku;

import processing.core.PApplet;

public class Main extends PApplet {
/*TODO main problems not fixed, we need to add: 1. all lower part is broken

*  */
    int breite = 50;
    int zeilen = 9;
    int spalten = 9;
    int spieler = 1;
    int[][] spielFlaeche = new int[zeilen][spalten];
    int[][] zahlen = {
            {1,2,3,4,5,6,7,8,9},
            {7,8,9,1,2,3,4,5,6},
            {4,5,6,7,8,9,1,2,3},
            {9,1,2,3,4,5,6,7,8},
            {6,7,8,9,1,2,3,4,5},
            {3,4,5,6,7,8,9,1,2},
            {8,9,1,2,3,4,5,6,7},
            {5,6,7,8,9,1,2,3,4}};


    public static void main(String[] args) {
        PApplet.main("sudoku.Main");
    }

    public void settings(){
        size(800, 700);
    }

    public void setup() {
        rectMode(CORNER);
        ellipseMode(CORNER);
        zahlenEinsetzen();
        ausgabe2DArray(zahlen);
    }

    public void draw() {
        for (int y = 0; y < zeilen; y++) {
            for (int x = 0; x < spalten; x++) {
                fill(255);
                rect(x * breite, y * breite, breite, breite);
                }
            }
        }

    public void zahlenEinsetzen(){
        fill(0);
        textSize(32);
        textAlign(CENTER, CENTER);

        for(int i = 0; i <zeilen; i++){
            for (int j = 0; j <spalten; j++){
                text(spielFlaeche[i][j], j+breite+25, i*breite+25);
            }
        }
    }


    public void mousePressed() {
        int zeile = mouseY / breite;
        int spalte = mouseX / breite;

        if(spielFlaeche[zeile][spalte] == 0) {
            spielFlaeche[zeile][spalte] = spieler;
        }
    }

    public boolean ueberpruefeZeilen(){
        boolean gewonnen = false;
        for (int i = 0; i < zeilen; i++) {
            if(spielFlaeche[i][0] != 0 && spielFlaeche[i][0] == spielFlaeche[i][1] &&
                    spielFlaeche[i][0] == spielFlaeche[i][2]){
                gewonnen = true;
            }
        }
        return gewonnen;
    }

    public void ausgabe2DArray(int[][] a){
        for (int zeile = 0; zeile < a.length; zeile++) {
            for (int spalte = 0; spalte < a[0].length; spalte++) {
                print(a[zeile][spalte] + ", "); //print() --> Gibt an, dass ein Array ausgegeben werden soll
                text(a[zeile][spalte],0, zeile * 30); //Gibt Array aus !!!
            }
            println();
        }
        println();
    }

}
