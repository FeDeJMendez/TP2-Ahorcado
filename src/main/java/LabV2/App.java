package LabV2;

import LabV2.BD.BDPalabra;

import java.util.HashSet;

public class App
{
    public static void main( String[] args ) {
            // Obtengo la palabra en un string y en minusculas...
        BDPalabra palabra = new BDPalabra();
        String sPalabra = palabra.getPalabra().toLowerCase();

            //Creo el objeto con la palabra ya en forma secreta para el jugador ...
        PalabraSecreta palabraSecreta = new PalabraSecreta(sPalabra);

        System.out.println(sPalabra);
        System.out.println(palabraSecreta.getStrPalabra() + "\n");

        Jugador j1 = new Jugador ("Nicolas","Gonzalez", palabraSecreta);
        Jugador j2 = new Jugador ("Carlos","Martinez", palabraSecreta);
        //Jugador j3 = new Jugador ("Pablo","Hernandez", palabraSecreta);

        j1.start();
        j2.start();
        //j3.start();
    }
}
