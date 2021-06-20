package src.partida;

import src.Objetos.*;
import src.partida.*;

public class Cjugador {
    private Jugadores jugador[];

    public Cjugador(){
        jugador = new Jugadores[10];
        jugador[0] = new Jugadores("Marconi", 0, 0);
        jugador[1] = new Jugadores("Macos", 0, 0);
        jugador[2] = new Jugadores("Maria", 0, 0);
        jugador[3] = new Jugadores("Tara", 0, 0);
        jugador[4] = new Jugadores("Matilda", 0, 0);
        jugador[5] = new Jugadores("Jorge", 0, 0);
        jugador[6] = new Jugadores("Mariano", 0, 0);
        jugador[7] = new Jugadores("Oconer", 0, 0);
        jugador[8] = new Jugadores("XD", 0, 0);
        jugador[9] = new Jugadores("F", 0, 0);
        
    }
    public void modificarNombre(int posicion, String nombre){
        if (verificar(posicion)) {
            jugador[posicion].setNombre(nombre);
            System.out.print(posicion+". nombre: "+jugador[posicion].getNombre());
        }
    }
    public void mostrarJugadores(){
        for (int i = 0; i < jugador.length; i++) {
            System.out.println(i+". Nombre: "+jugador[i].getNombre()+" Ganadas: "+jugador[i].getGanadas()+" Perdidas: "+jugador[i].getPerdidas());
        }
    }
    public boolean verificar(int posicion){
        if (posicion <= jugador.length) {
            return true;
        }
        return false;
    }


}
