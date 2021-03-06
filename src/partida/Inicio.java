package src.partida;
import java.util.Scanner;

public class Inicio {
    public Inicio(){
        int estado = 0;
        Tablero tablero = new Tablero();
        Cjugador cJugador = new Cjugador(tablero, this);
        while (estado==0) {
            imprimir("\n------------------Juego de damas-----------------------------\n");
            imprimir("1. Modificar nombre Jugador 2.Estadistica 3.Jugar 4.Ver tablero 5.salir");
            switch (ingresarEntero("ingrese la opcion: ")) {
                case 1:
                    imprimir("--------------------Modificar Jugador--------------------------------");
                    int posicion;
                    do {
                        cJugador.mostrarJugadores();
                        posicion = ingresarEntero("ingrese la posicion del jugador: ");    
                    } while (!cJugador.verificar(posicion));
                    cJugador.modificarNombre(posicion, ingresarTexto("ingrese el nuevo nombre: "));
                    break;
                case 2:
                    int estadoI = 0;
                    while (estadoI !=1) {
                        imprimir("\n-----------Estadistica-------------------");
                        imprimir("1.ordenar Ganados 2.ordenar por perdidos 3.Salir");
                        switch (ingresarEntero("ingrese la opcion: ")) {
                            case 1:
                                cJugador.ordenar(true);
                                cJugador.mostrarJugadores();
                                break;
                            case 2:
                                cJugador.ordenar(false);
                                cJugador.mostrarJugadores();
                                break;
                            case 3:
                                estadoI = 1;
                                break;
                            default:
                                imprimir("orden no encontrada");
                                break;
                        }
                    }
                    break;
                case 3:
                    cJugador.seleccionarJugadores();
                    break;
                case 4:
                    imprimir("-----------------Tablero inicial--------------------\n");
                    tablero.colocarPiezasInicial(true);
                    tablero.imprimirTablero(true);
                    tablero.limpiar();
                    break;
                case 5:
                    estado = 1;
                    break;
                default:
                    imprimir("ingresa otra opci??n dato invalido");
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
