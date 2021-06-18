package src.partida;
import java.util.Scanner;

public class Inicio {
    public Inicio(){
        int estado = 0;
        Tablero tablero = new Tablero();
        while (estado==0) {
            imprimir("\n------------------Juego de damas-----------------------------\n");
            imprimir("1. Ingrese jugadores  2.Estadistica 3.Partida 4.Ver tablero 5.salir");
            switch (ingresarEntero("ingrese la opcion: ")) {
                case 1:

                    break;
                case 2:
                
                    break;
                case 3:
                
                    break;
                case 4:
                    imprimir("-----------------Tablero inicial--------------------\n");
                    tablero.colocarPiezasInicial();
                    break;
                case 5:
                    estado = 1;
                    break;
                default:
                    imprimir("ingresa otra opción dato invalido");
                    break;
            }
        }

    }

    Scanner scanner = new  Scanner(System.in);

    public void imprimir(String text){
        System.out.println(text);
    }
    public String ingresarTexto(String text){
        System.out.print(text);
        String texto = scanner.next(); 
        return texto;
    }
    public int ingresarEntero(String text){
        System.out.print(text);
        int num = scanner.nextInt(); 
        return num;
    }
}
