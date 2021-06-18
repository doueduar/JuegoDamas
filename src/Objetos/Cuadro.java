package src.Objetos;

public class Cuadro {
    private String cuadro;
    private boolean estado;
    private boolean ocupado; 

    public Cuadro(String cuadro,boolean estado,boolean ocupado){
        this.cuadro = cuadro;
        this.estado = estado;
        this.ocupado = ocupado;
    }
    public void setCuadro(String cuadro){
        this.cuadro = cuadro;
    }
    public void setEstado(boolean estado){
        this.estado = estado;
    }
    public void setOcupado(boolean estado){
        this.ocupado = estado;
    }
    public String getCuadro(){
        return cuadro;
    }
    public boolean getEstado(){
        return estado;
    }
    public boolean getOcupado(){
        return ocupado;
    }
    public void imprimir(){
        System.out.print(cuadro);
    }

}
