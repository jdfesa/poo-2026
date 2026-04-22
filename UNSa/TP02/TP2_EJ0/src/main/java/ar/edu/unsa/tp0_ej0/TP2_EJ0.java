

package ar.edu.unsa.tp0_ej0;

/**
 *
 * @author jd
 */
public class TP2_EJ0 {

    public static void main(String[] args) {
        // --- 1. CREACIÓN DE OBJETOS (Testeando Constructores) ---
        // Usa el constructor vacío (gnc=false por defecto)
        Auto a1 = new Auto(); 
        // a1.arrancar();
        // a1.frenar();
        
        // Usa el constructor con parámetros
        Auto a2 = new Auto("EYU722", 5);
        
        // Crea un auto distinto en memoria, pero con los MISMOS datos que a2
        Auto a3 = new Auto("EYU722", 5); 
        
        // a4 no es un auto nuevo, apunta exactamente al mismo espacio de memoria que a1
        Auto a4 = a1; 
        
        // Casos límite para probar si el programa explota
        Auto a5 = null; 
        String a6 = "Auto 6"; 
        
        
        // --- 2. MOSTRAR DATOS (Testeando el @Override toString) ---
        // Al imprimir el objeto, Java llama automáticamente al método toString()
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        
        
        // --- 3. COMPARACIONES (Testeando el @Override equals) ---
        // Debería dar IGUALES: a4 y a1 son exactamente la misma referencia en memoria.
        System.out.println(a4.equals(a1) ? "Son iguales" : "Son distintos");
        
        // Debería dar DISTINTOS: Prueba contra un nulo (atajado por 'if (obj == null)')
        System.out.println(a1.equals(a5) ? "Son iguales" : "Son distintos");
        
        // Debería dar DISTINTOS: Prueba contra un String (atajado por 'if (getClass() != obj.getClass())')
        System.out.println(a1.equals(a6) ? "Son iguales" : "Son distintos");
        
        // Debería dar IGUALES: Son objetos distintos en memoria, pero tienen la misma patente, puertas y gnc.
        System.out.println(a3.equals(a2) ? "Son iguales" : "Son distintos");
        
        
        // --- 4. MÉTODOS ESTÁTICOS (Modificar y comparar estados) ---
        // Llama al método de la Clase para modificar el objeto a2
        Auto.ponerGnc(a2);
        System.out.println(a2); // Vuelve a imprimir para verificar que gnc ahora es true
        
        // Llama al método estático de comparación usando la velocidad (que por ahora inicializa en 0.0)
        if (Auto.compararVelocidadMaxima(a1, a2) == 0)
            System.out.println("Tienen la misma velocidad maxima.");
        else if (Auto.compararVelocidadMaxima(a1, a2) > 0)
            System.out.println(a1 + " es mas rapido que " + a2);
        else
            System.out.println(a2 + " es mas rapido que " + a1);
    }
}
