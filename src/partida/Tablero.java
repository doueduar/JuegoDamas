package src.partida;
import src.Objetos.*;

public class Tablero {
     private Cuadro tablero[];
     private static final String abc[] ={"A","B","C","D","E","F","G","H"};
     public static final String ANSI_RESET = "\u001B[0m";
     public static final String ANSI_GRIS = "\u001B[1;30m";
     public static final String ANSI_WHITE="\033[37m";

    public Tablero(){
        tablero = new Cuadro[64];
        crearTablero();
    }
    public void crearTablero(){
        boolean anterior= true;
        boolean estado = true;
        for (int i = 0; i < tablero.length; i++) {
            int multiplo = i % 8;
            if ((1<i)&&(multiplo==0)) {
                estado = anterior;
            }
            anterior = estado;
            if (estado) {
                tablero[i] = new Cuadro("   ",true,true);
                estado = false;
            }else{
                tablero[i] = new Cuadro("███",false,false);
                estado = true;
            }
        }
    }
    public void imprimirTablero(){
        int contador=0;
        int fila=1;
        for (int i = 0; i < abc.length; i++) {
            System.out.print(" "+abc[i]+" ");
        }
        System.out.print("\n");
        for (int i = 0; i < tablero.length; i++) {
            tablero[i].imprimir();
            contador++;
            if (7 < contador) {
                System.out.print(" "+fila+" \n");
                contador = 0;
                fila++;
            }
        }
    }
    public void colocarPiezasInicial(){
        int contador = 0;
        for (int i = 0; i < 16; i++) {

            if (tablero[63-i].getEstado()) {
                tablero[63-i].setCuadro(ANSI_GRIS+" o "+ANSI_RESET);
                tablero[63-i].setOcupado(false);
            }
            if (tablero[i].getEstado()) {
                tablero[i].setCuadro(ANSI_WHITE+" o "+ANSI_RESET);
                tablero[i].setOcupado(false);
                contador++;
            }
        }
        imprimirTablero();
    }
    
}
