package LabV2;

import LabV2.BD.BDGanador;
import lombok.Data;

@Data
public class Jugador extends Thread{
    private String nombre;
    private String apellido;
    private PalabraSecreta palabraSecreta;

    public Jugador(String nombre, String apellido, PalabraSecreta palabraSecreta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.palabraSecreta = palabraSecreta;
    }

    @Override
    public void run (){
        while (!palabraSecreta.getStrPalabra().equals(palabraSecreta.getSPalabra())) {
            System.out.println("********************************\n");
            System.out.println("Turno del Jugador: " + nombre + " " + apellido);
            palabraSecreta.JugarLetra(nombre, apellido);
            if(!palabraSecreta.getStrPalabra().equals(palabraSecreta.getSPalabra())) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        Thread.currentThread().interrupt();
    }
}
