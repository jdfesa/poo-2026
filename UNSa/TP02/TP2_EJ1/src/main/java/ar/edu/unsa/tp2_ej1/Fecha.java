package ar.edu.unsa.tp2_ej1;

/**
 *
 * @author jd
 */
public class Fecha {
    private int dia;
    private int mes;
    private int anio;
    
    public Fecha(){
        dia = 1;
        mes = 1;
        anio = 1990;
    }
    
    public Fecha(int dia, int mes, int anio){
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
    
    public int getDia(){
        return dia;
    }
    
    public void setDia(int d){
        this.dia = d;
    }
    
    public int getMes(){
        return mes;
    }
    
    public void setMes(int m){
        this.mes = m;
    }
    
    public int getAnio(){
        return anio;
    }
    
    public void setAnio(int a){
        this.anio = a;
    }
    
    
    
}

