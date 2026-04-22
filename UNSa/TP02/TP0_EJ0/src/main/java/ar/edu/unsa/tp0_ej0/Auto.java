/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.unsa.tp0_ej0;

import java.util.Objects;

/**
 *
 * @author jd
 */
public class Auto {
    private String patente;
    private int puertas;
    private boolean gnc;
    private float velocidadMax;
    
    public Auto(){
        System.out.println("Obj creado");
        this.gnc = false;
    }
    
    public Auto (String patente, int puertas){
        this.patente = patente;
        this.puertas = puertas;
        this.gnc = false;
        System.out.println("Obj" + this.patente + "creado.");
    }
    
    public String getPatente(){
        return patente;
    }
    
    public int getPuertas(){
        return puertas;
    }
    
    public boolean isGnc(){
        return gnc;
    }
    
    public static void ponerGNC(Auto a) {
        System.out.println("Instalando equipo GNC.-");
        a.gnc = true;
    }
    
    public static int compararVelocidadMaxima(Auto a1, Auto a2){
        if(a1.velocidadMax == a2.velocidadMax)
            return 0;
        else if (a1.velocidadMax>a2.velocidadMax)
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        return "Auto{" + "patente=" + patente + ", puertas=" + puertas + ", gnc=" + gnc + ", velocidadMax=" + velocidadMax + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.patente);
        hash = 37 * hash + this.puertas;
        hash = 37 * hash + (this.gnc ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Auto other = (Auto) obj;
        if (this.puertas != other.puertas) {
            return false;
        }
        if (this.gnc != other.gnc) {
            return false;
        }
        return Objects.equals(this.patente, other.patente);
    }
    
    public void arrancar(){
        System.out.println("PRRRRRRRNNNNNN");
    }
    
    public void frenar(){
        System.out.println("GRIIIIIIIIII");
    }
    
   

  
}
