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
        int posicion;
        boolean estado;
        while ((hayPiezas(tablero.blancos)) && (hayPiezas(tablero.negros))) {
            if (primero) {
                do{
                    tablero.imprimirTablero(primero);
                    do {
                        estado = false;
                        posicion = incio.ingresarEntero("ingrese el numero de la ficha: ");
                        if ((posicion<0) || (tablero.blancos.length-1<posicion)) {
                            estado = true;
                        }else{
                            if(!existe(tablero.blancos,tablero.blancos[posicion]))
                                estado = true;
                        } 
                    } while (estado);
                }while(moverPieza(tablero.blancos, tablero.blancos[posicion], incio.ingresarEntero("ingrese la fila a mover: "), incio.ingresarEntero("ingrese la columna a mover: ")));
                primero = false;
            }else{
                do{
                    tablero.imprimirTablero(primero);
                    do {
                        estado = false;
                        posicion = incio.ingresarEntero("ingrese el numero de la ficha: ");
                        if ((posicion<0) || (tablero.negros.length-1<posicion)) {
                            estado = true;
                        }else{
                            if(!existe(tablero.negros,tablero.negros[posicion]))
                                estado = true;
                        } 
                    } while (estado);
                }while(moverPieza(tablero.negros, tablero.negros[posicion], incio.ingresarEntero("ingrese la fila a mover: "), incio.ingresarEntero("ingrese la columna a mover: ")));
                primero = true;
            }
        }
    }
    public boolean moverPieza(ficha fichas[], ficha ficha, int x, int y){
        tablero.imprimirPiezas(fichas);
        if ((x<0)||(8<x)) {
            incio.imprimir("No esta permitido esta fila");
            return true;
        }
        if ((y<0)||(8<y)) {
            incio.imprimir("No esta permitido esta fila");
            return true;
        }
        if (existe(fichas, ficha)) {
            if (!tablero.tablero[y][x].getOcupado()) {
                if (tablero.tablero[y][x].getEstado()) {
                    for (int i = 0; i < fichas.length; i++) {
                        if (fichas[i]!=null) {
                            if(fichas[i].getX()==x) {
                                if (fichas[i].getY()==y) {
                                    incio.imprimir("NO se puede mover a esa posición hay un ficha mia");
                                    return true;
                                }
                            }
                        }
                    }
                    if (fichas.equals(tablero.blancos)) {
                        eliminarPieza(tablero.negros,tablero.negros[posicionFicha(tablero.negros, x, y)]);
                        cambio(fichas,ficha,x,y);
                        return false;
                    }
                    if (fichas.equals(tablero.negros)) {
                        eliminarPieza(tablero.blancos,tablero.blancos[posicionFicha(tablero.blancos, x, y)]);
                        cambio(fichas,ficha,x,y);
                        return false;
                    }
         
                }
                incio.imprimir("NO se puede mover ahi es cuadro blanco");
                return true;
            }else{
                cambio(fichas,ficha,x,y);
                return false;
            }
        }
        incio.imprimir("No se encontro");
        return true;
    }
    public void cambio(ficha fichas[],ficha ficha,int x,int y){
        estado(fichas, ficha,true, "     ");
        ficha.setX(x);
        ficha.setY(y);
        tablero.tablero[x][y].setCuadro(ficha.getNombre());
        tablero.tablero[x][y].setOcupado(false);
    }
    public int posicionFicha(ficha fichas[],int x, int y){
        for (int i = 0; i < fichas.length; i++) {
            if (fichas[i]!=null) {
                if (fichas[i].getX()==x) {
                    if (fichas[i].getY()==y) {
                        return i;      
                    }
                }   
            }
        }
        incio.imprimir("No se encontro posicionFicha");
        return 0;
    }
    public void estado(ficha fichas[],ficha ficha, boolean estado,String cuadro){
        tablero.tablero[fichas[posicion(fichas, ficha)].getX()][fichas[posicion(fichas, ficha)].getY()].setCuadro(cuadro);
        tablero.tablero[fichas[posicion(fichas, ficha)].getX()][fichas[posicion(fichas, ficha)].getY()].setOcupado(estado);
            
    }
    public void eliminarPieza(ficha fichas[],ficha ficha){
        if (existe(fichas, ficha)) {
            estado(fichas, ficha, true,"     ");
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
            if (fichas != null) {
                if (fichas[i]==ficha) {
                    return true;
                }   
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
