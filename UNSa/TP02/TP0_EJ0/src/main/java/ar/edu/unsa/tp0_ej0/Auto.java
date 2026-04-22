package ar.edu.unsa.tp0_ej0;

import java.util.Objects;

/**
 *
 * @author jd
 */
public class Auto {

    // --- 1. ATRIBUTOS (Estado o características del objeto) ---
    // Son 'private' por seguridad (encapsulamiento), nadie desde afuera puede cambiarlos directamente.
    private String patente;
    private int puertas;
    private boolean gnc;
    private float velocidadMax;
    
    // --- 2. CONSTRUCTORES (Cómo "nace" el objeto al usar 'new') ---
    
    // Constructor vacío: inicializa un auto por defecto.
    public Auto(){
        System.out.println("Obj creado");
        this.gnc = false;
    }
    
    // Constructor con parámetros: te obliga a pasarle patente y puertas al crearlo.
    public Auto (String patente, int puertas){
        this.patente = patente;
        this.puertas = puertas;
        this.gnc = false;
        System.out.println("Obj" + this.patente + "creado.");
    }
    
    // --- 3. GETTERS (Métodos para poder leer los atributos privados) ---
    
    public String getPatente(){
        return patente;
    }
    
    public int getPuertas(){
        return puertas;
    }
    
    // Los getters de los booleanos se suelen llamar 'is' (es/está) en lugar de 'get'.
    public boolean isGnc(){
        return gnc;
    }
    
    // --- 4. MÉTODOS ESTÁTICOS (Le pertenecen a la Clase, no a un auto en particular) ---
    
    // Recibe un auto cualquiera y le modifica su estado interno de GNC.
    public static void ponerGnc(Auto a) {
        System.out.println("Instalando equipo GNC.-");
        a.gnc = true; // Como está dentro de la misma clase, puede acceder al private directamente.
    }
    
    // Recibe dos autos y compara un atributo específico (velocidadMax) devolviendo 0, 1 o -1.
    public static int compararVelocidadMaxima(Auto a1, Auto a2){
        if(a1.velocidadMax == a2.velocidadMax)
            return 0;
        else if (a1.velocidadMax>a2.velocidadMax)
            return 1;
        else
            return -1;
    }

    // --- 5. MÉTODOS SOBRESCRITOS HEREDADOS DE 'OBJECT' (@Override) ---

    // Transforma el objeto en una cadena de texto legible para la consola.
    @Override
    public String toString() {
        return "Auto{" + "patente=" + patente + ", puertas=" + puertas + ", gnc=" + gnc + ", velocidadMax=" + velocidadMax + '}';
    }

    // Genera un número de identificación matemático único basado en los datos del auto. 
    // Siempre va de la mano con el equals().
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.patente);
        hash = 37 * hash + this.puertas;
        hash = 37 * hash + (this.gnc ? 1 : 0);
        return hash;
    }

    // Define las reglas exactas para considerar si dos autos son "iguales".
    @Override
    public boolean equals(Object obj) {
        if (this == obj) { // Si apuntan al mismo espacio de memoria, son iguales.
            return true;
        }
        if (obj == null) { // Si lo que me pasas no existe (es nulo), no son iguales.
            return false;
        }
        if (getClass() != obj.getClass()) { // Si comparo un Auto con un Texto (u otra cosa), no son iguales.
            return false;
        }
        
        // Casteo: Ahora que sé que es un Auto, lo trato como tal para comparar sus datos internos.
        final Auto other = (Auto) obj;
        if (this.puertas != other.puertas) {
            return false;
        }
        if (this.gnc != other.gnc) {
            return false;
        }
        // Finalmente compara la patente (como es un String, usa Objects.equals).
        return Objects.equals(this.patente, other.patente);
    }
    
    // --- 6. MÉTODOS DE ACCIÓN (Comportamiento del objeto) ---
    
    public void arrancar(){
        System.out.println("PRRRRRRRNNNNNN");
    }
    
    public void frenar(){
        System.out.println("GRIIIIIIIIII");
    }
  
}