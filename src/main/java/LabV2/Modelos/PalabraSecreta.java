package LabV2.Modelos;

import LabV2.BD.BDGanador;
import lombok.Data;

import java.util.HashSet;
import java.util.Random;

import static java.lang.Thread.sleep;

@Data
public class PalabraSecreta {
    private Boolean disponible = true;
    private String sPalabra;
    private char[] letras;
    String sLetras = "abcdefghijklmnopqrstuvwxyq";
    private HashSet<Character> letrasUsadas = new HashSet<>(); //Coleccion que almacena las letras jugadas para no repetirlas ...


        //Constructor ...
    public PalabraSecreta(String strPalabra) {
        this.sPalabra = strPalabra;
            //Obtengo un arreglo de la palabra transformado en guiones ...
        this.letras = new char[strPalabra.length()];
        this.letras = convertirArreglo(strPalabra);
    }


        //Devuelvo el String de la palabra actualizado ...
    public String getStrPalabra(){
        String palabraStr;

        palabraStr = String.copyValueOf(this.letras);

        return palabraStr;
    }


        //Convierto el String en un Array de guiones ...
    public static char[] convertirArreglo (String strPalabra) {
        int cantLetras = strPalabra.length();
        char[] letrasArray = new char[cantLetras];
        for (int i = 0; i < cantLetras; i++){
            letrasArray[i] = '_';
        }
        return letrasArray;
    }

        //Metodo por el que el jugador va a jugar una letra...
    public synchronized void JugarLetra (String nombreJ, String apellidoJ){
        if (this.getStrPalabra().equals(sPalabra)){
            Thread.currentThread().interrupt();
        }
        while (!disponible) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        disponible = false;
        Integer repeticiones = 0;
        char letra;
        letra = NuevaLetra();
        letrasUsadas.add(letra);
        for (Integer i = 0; i < sPalabra.length(); i++){
            if (sPalabra.charAt(i) == letra){
                repeticiones++;
                this.letras[i] = letra;
            }
        }
        if (repeticiones == 0) {
            letras[0] = Character.toUpperCase(letras[0]);
            System.out.println(this.getStrPalabra() + " : la letra " + letra + " NO aparece en la palabra \n");
            letras[0] = Character.toLowerCase(letras[0]);
        }
        else {
            letras[0] = Character.toUpperCase(letras[0]);
            System.out.println(this.getStrPalabra() + " : la letra " + letra + " esta repetida " + repeticiones.toString() + " veces \n");
            letras[0] = Character.toLowerCase(letras[0]);
        }
        if (this.getStrPalabra().equals(sPalabra)){
            System.out.println("********************************");
            System.out.println("********************************");
            System.out.println("GANADOR: " + nombreJ + " " + apellidoJ);
            System.out.println("********************************");
            System.out.println("********************************");
            letras[0] = Character.toUpperCase(letras[0]);
            BDGanador ganador = new BDGanador();
            ganador.setGanador(nombreJ, nombreJ, sPalabra);
            letras[0] = Character.toLowerCase(letras[0]);
            disponible = true;
            Thread.currentThread().interrupt();
            notifyAll();
        }else {
            disponible = true;
            notifyAll();
        }
    }

    private char NuevaLetra (){
        char letraNueva;
        do {    //Doy una letra que no se haya jugado...
            Random random = new Random();
            int index = random.nextInt(sLetras.length());
            letraNueva = sLetras.charAt(index);
            //letraNueva = (char) ('a' + Math.random() * ('z'-'a' + 1));
        } while (letrasUsadas.contains(letraNueva));
        return letraNueva;
    }
}
