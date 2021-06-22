package src.partida;

import src.Objetos.*;
import src.partida.*;

public class Cjugador {
    private Jugadores jugador[];
    private Tablero tablero;
    private Inicio inicio;
    public Cjugador(Tablero tablero, Inicio inicio){
        this.tablero = tablero;
        this.inicio = inicio;
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
        if ((0<=posicion)&&(posicion <= jugador.length)) {
            return true;
        }
        return false;
    }
    public void seleccionarJugadores(){
        int j1,j2;
        do {
            mostrarJugadores();
            j1 = inicio.ingresarEntero("Selecciona el primer Jugador: ");
            mostrarJugadores();
            j2 = inicio.ingresarEntero("Selecciona el segundo Jugador: ");
            if (verificar(j1, j2)) {
                inicio.imprimir("Jugadores invalidos ingrese otros Jugadores");
            }    
        } while (verificar(j1, j2));
        jugar(j1, j2);
    }
    public boolean verificar(int j1,int j2){
        if (j1==j2) {
            return true;
        }
        if ((jugador.length<j1)&&(jugador.length<j2)) {
            return true;
        }
        if ((j1<0)&&(j2<0)) {
            return true;
        }
        return false;
    }
    public void jugar(int j1, int j2){
        boolean estado = turno(j1, j2);
        tablero.colocarPiezasInicial(estado);
        Movimientos mover = new Movimientos(inicio, tablero, jugador, j1, j2,estado);
        tablero.limpiar();
    }
    public boolean turno(int j1,int j2){
        inicio.imprimir("<<<<<<<<<<<<Juego de piedra, papel o tijera>>>>>>>>>>>>");
        int eleccion, eleccion2;
        do {
            eleccion = (int)(Math.random()*3+1);
            inicio.imprimir(jugador[j1].getNombre()+" eligio: "+eleccion(eleccion));
            eleccion2 = (int)(Math.random()*3+1);
            inicio.imprimir(jugador[j2].getNombre()+" eligio: "+eleccion(eleccion2));
            if (eleccion == eleccion2) {
                inicio.imprimir("Misma elección \n");
            }
        } while (eleccion == eleccion2);
        if (eleccion(eleccion, eleccion2)) {
            inicio.imprimir("GANO "+jugador[j1].getNombre());
        } else {
            inicio.imprimir("GANO "+jugador[j2].getNombre());
        }
        return eleccion(eleccion,eleccion2);
    }

    public boolean eleccion(int j1,int j2){
        if((j1==1)&&(j2==2))
            return false;
        if((j1==1)&&(j2==3))
            return true;
        if((j1==2)&&(j2==1))
            return true;
        if((j1==2)&&(j2==3))
            return false;
        if((j1==3)&&(j2==1))
            return false;
        if((j1==3)&&(j2==2))
            return true;
        inicio.imprimir("ninguno");
        return false;
    }

    public String eleccion(int i){
        if(i==1)
            return "Piedra";
        if(i==2)
            return "Papel";
        if(i==3)
            return "tijera";

        return "ninguno";
    }
    public void ordenar(boolean estado){
        Jugadores auxJugador;
        for (int i = 0; i < jugador.length; i++) {
            for (int j = 0; j < 9; j++) {
                if ((jugador[j]!=null)&&(jugador[j+1]!=null)) {
                    if (estado) {
                        if (jugador[j+1].getGanadas()>jugador[j].getGanadas()) {
                            auxJugador = jugador[j];
                            jugador[j] = jugador[j+1];
                            jugador[j+1]=auxJugador;
                        }
                    }else{
                        if (jugador[j+1].getPerdidas()>jugador[j].getPerdidas()) {
                            auxJugador = jugador[j];
                            jugador[j] = jugador[j+1];
                            jugador[j+1]=auxJugador;
                        }
                    }
                }
            }
        }
    }

}
