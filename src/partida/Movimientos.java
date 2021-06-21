package src.partida;
import src.Objetos.*;
import src.partida.*;

public class Movimientos {
    Tablero tablero;
    Jugadores jugador[];
    int j1, j2;
    boolean turno;
    Inicio incio;

    public Movimientos(Inicio inicio, Tablero tablero,Jugadores jugador[], int j1, int j2,boolean turno){
        this.jugador = jugador;
        this.tablero = tablero;
        this.j1 = j1;
        this.j2 = j2;
        this.turno = turno;
        this.incio = inicio;
        movimientos(turno);
    }
    public void movimientos(boolean primero){
        while ((hayPiezas(tablero.blancos))||(hayPiezas(tablero.negros))) {
            
        }
    }
    public void eliminarPieza(ficha fichas[],ficha ficha){
        if (existe(fichas, ficha)) {
            tablero.tablero[fichas[posicion(fichas, ficha)].getX()][fichas[posicion(fichas, ficha)].getY()].setCuadro("     ");
            tablero.tablero[fichas[posicion(fichas, ficha)].getX()][fichas[posicion(fichas, ficha)].getY()].setOcupado(true);
            fichas[posicion(fichas, ficha)] = null;
        } else {
            System.out.println("no existe esa ficha");   
        }
    }
    public int posicion(ficha fichas[],ficha ficha){
        for (int i = 0; i < fichas.length; i++) {
            if (fichas[i]==ficha) {
                return i;
            }
        }
        return 0;
    }
    public boolean existe(ficha fichas[],ficha ficha){
        for (int i = 0; i < fichas.length; i++) {
            if (fichas[i]==ficha) {
                return true;
            }
        }
        return false;
    }
    public boolean hayPiezas(ficha fichas[]){
        for (int i = 0; i < fichas.length; i++) {
            if (fichas[i]!=null) {
                return true;
            }
        }
        return false;
    }
}
