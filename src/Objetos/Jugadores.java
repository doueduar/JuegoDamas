package src.Objetos;

public class Jugadores {
    private String nombre;
    private int ganadas;
    private int perdidas;

    public Jugadores(String nombre, int ganadas, int perdidas){
        this.nombre = nombre;
        this.ganadas = ganadas;
        this.perdidas = perdidas;
    }
    public String getNombre(){
        return nombre;
    }
    public int getGanadas(){
        return ganadas;
    }
    public int getPerdidas(){
        return perdidas;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setGanadas(int ganadas){
        this.ganadas = ganadas;
    }
    public void setPerdidas(int perdidas){
        this.perdidas = perdidas;
    }
}    
