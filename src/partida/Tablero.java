package src.partida;
import src.Objetos.*;

public class Tablero {
    Cuadro tablero[][];
    ficha negros[];
    ficha blancos[];
     private static final String abc[] ={"A","B","C","D","E","F","G","H"};
     public static final String ANSI_RESET = "\u001B[0m";
     public static final String ANSI_GRIS = "\u001B[1;30m";
     public static final String ANSI_WHITE="\033[37m";
     public static final String ANSI_BLUE = "\u001B[34m";

    public Tablero(){
        //   Vertical[] Horizontal[]
        tablero = new Cuadro[8][8];
        negros = new ficha[12];
        blancos = new ficha[12];
    }
    public void crearTablero(){
        boolean anterior= true;
        boolean estado = true;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                anterior = estado;
                if (estado) {
                    tablero[i][j] = new Cuadro("     ",true,true);
                    estado = false;
                }else{
                    tablero[i][j] = new Cuadro("█████",false,false);
                    estado = true;
                }
            }
            estado = anterior;
        }
    }
    public void imprimirTablero(boolean estado){
        int fila=1;
        for (int i = 0; i < abc.length; i++) {
            System.out.print("  "+abc[i]+"  ");
        }
        System.out.print("\n");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
               if (estado) {
                tablero[i][j].imprimir();
               }else{
                tablero[7-i][j].imprimir();
               } 
            }
            if (estado) {
                System.out.print(" "+fila+" \n");    
            }else{
                System.out.print(" "+(9-fila)+" \n");
            }
            fila++;
        }
    }
    public void colocarPiezasInicial(boolean blanca){
        //System.out.print("ingreso \n");
        crearTablero();
        //System.out.print("ingreso \n");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {
                seleccionar(i, j, blanca);
            }
        }
        imprimirTablero(true);
        imprimirTablero(false);
    }
    public void seleccionar(int i, int j, boolean blanca){
                    
        if (tablero[7-i][j].getEstado()) {
            ficha Ficha = tipo(!blanca, i, j);
            tablero[7-i][j].setCuadro(Ficha.getNombre());
            tablero[7-i][j].setOcupado(false);
        }
        if (tablero[i][j].getEstado()) {
            ficha Ficha = tipo(blanca, i, j);
            tablero[i][j].setCuadro(Ficha.getNombre());
            tablero[i][j].setOcupado(false);
        }    
    }
    public ficha tipo(boolean estado, int y, int x){
        if (estado) {
            int p = posicion(blancos);
            blancos[p] = new ficha(x, y, estado);
            blancos[p].setNombre(tipoFicha(estado, p));
            return blancos[p];
        }
        int p = posicion(negros);
        negros[p] = new ficha(y,x, estado);
        negros[p].setNombre(tipoFicha(estado,p));
        return negros[p];
    }
    public String nombre(int n){
        if (n<10) {
            return "0"+n;
        }
        return n+"";
    }
    public int posicion(ficha pieza[]){
        for (int i = 0; i < pieza.length; i++) {
            if (pieza[i]==null) {
                return i;
            }
        }
        System.out.print("no se encontro la posición \n");
        return 0;
    }
    public String tipoFicha(boolean blanca,int n){
        if (blanca) {
            return ANSI_WHITE+" o"+nombre(n)+" "+ANSI_RESET;
        }else{
            return ANSI_BLUE+" o"+nombre(n)+" "+ANSI_RESET;
        }
    }
    public void imprimirPiezas(ficha fichas[]){
        for (int i = 0; i < fichas.length; i++) {
            fichas[i].getNombre();
        }
    }
    public void limpiar(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = null;
            }
        }
        for (int i = 0; i < negros.length; i++) {
            negros[i] = null;
        }
        for (int i = 0; i < blancos.length; i++) {
            blancos[i]= null;
        }
        System.out.println("se limpio el tablero");
    }

}
