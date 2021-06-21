package src.partida;
import src.Objetos.*;
import src.partida.*;

public class Movimientos {
    Tablero tablero;
    Jugadores jugador[];
    int j1, j2;
    boolean turno;

    public Movimientos(Tablero tablero,Jugadores jugador[], int j1, int j2,boolean turno){
        this.jugador = jugador;
        this.tablero = tablero;
        this.j1 = j1;
        this.j2 = j2;
        this.turno = turno;
    }
    public void movimientos(){
        
    }
}
