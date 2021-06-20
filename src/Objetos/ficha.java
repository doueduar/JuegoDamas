package src.Objetos;

public class ficha {
    // si el estado es true=blanca false=negro
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GRIS = "\u001B[1;30m";
    public static final String ANSI_WHITE="\033[37m";
    public static final String ANSI_BLUE = "\u001B[34m";
    private String nombre;
    private boolean estado;
    private boolean viva;
    private int x;
    private int y;

    public ficha(int x,int y,boolean blanca){
        this.estado = blanca;
        this.x = x;
        this.y = y;
        this.viva = true;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setEstado(boolean estado){
        this.estado= estado;
    }
    public void setVida(boolean vida){
        this.viva = vida;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public String getNombre(){
        return nombre;
    }
    public boolean getEstado(){
        return estado;
    }
    public boolean getVidad(){
        return viva;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
