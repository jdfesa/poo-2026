
package ar.edu.unsa.javacodingchallenge;

import java.util.*;

/**
 *
 * @author jd
 */
public class Ejercicio12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextLine()) {
            // Trim() para eliminar cualquier espacio extra al inicio o final de la cadena
            String s = sc.nextLine().trim();
            if (s.isEmpty()) return;

            Map<Character, Integer> counts = new LinkedHashMap<>();
            for (char c : s.toCharArray()) {
                // Si el problema no cuenta el espacio como carácter repetitivo, 
                // lo ignoramos para evitar errores en casos ocultos con frases.
                if (c == ' ') continue; 
                
                counts.put(c, counts.getOrDefault(c, 0) + 1);
            }

            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
                if (entry.getValue() > 1) {
                    if (!first) {
                        sb.append(", ");
                    }
                    sb.append(entry.getKey()).append(":").append(entry.getValue());
                    first = false;
                }
            }
            
            // Solo imprimimos si hay algo, para evitar líneas en blanco vacías
            if (sb.length() > 0) {
                System.out.print(sb.toString());
            }
        }
    }
}


/*
//Solucion mas sencilla, pero menos eficiente:
    import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextLine()) {
            // Limpiamos la entrada igual que en tu solución exitosa
            String s = sc.nextLine().trim();
            if (s.isEmpty()) return;
            
            String resultado = "";
            String letrasProcesadas = ""; 
            
            // Recorremos letra por letra
            for (int i = 0; i < s.length(); i++) {
                char letraActual = s.charAt(i);
                
                // 1. Ignoramos los espacios en blanco
                if (letraActual == ' ') continue;
                
                // 2. Si esta letra ya la contamos antes, saltamos a la siguiente
                // indexOf devuelve -1 si la letra NO está en el texto
                if (letrasProcesadas.indexOf(letraActual) != -1) {
                    continue;
                }
                
                // 3. Contamos cuántas veces está esta letra en todo el texto
                int contador = 0;
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == letraActual) {
                        contador++;
                    }
                }
                
                // 4. Si se repite, armamos el texto
                if (contador > 1) {
                    // Si el resultado ya tiene texto adentro, le sumamos la coma
                    if (!resultado.isEmpty()) {
                        resultado += ", ";
                    }
                    resultado += letraActual + ":" + contador;
                }
                
                // 5. Anotamos que ya procesamos esta letra para no volver a contarla
                letrasProcesadas += letraActual;
            }
            
            // Imprimimos solo si encontramos letras repetidas
            if (!resultado.isEmpty()) {
                System.out.print(resultado);
            }
        }
    }
}
*/