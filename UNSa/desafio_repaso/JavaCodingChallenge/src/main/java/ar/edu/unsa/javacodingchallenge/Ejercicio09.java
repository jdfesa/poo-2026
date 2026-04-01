package ar.edu.unsa.javacodingchallenge;

import java.util.Scanner;

public class Ejercicio09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        
        int a = 0, b = 1, c;
        
        // Usamos print en lugar de println para que no salte de línea
        System.out.print(a + ", " + b); 
        
        // i empieza en 2 porque ya imprimimos los 2 primeros números
        // La condición ahora depende de 'i', por lo que el ciclo eventualmente se detendrá
        for (int i = 2; i < size; i++) {
            c = a + b;
            System.out.print(", " + c);
            a = b; 
            b = c;
        }
        
        System.out.println(); // Un salto de línea final por prolijidad en la consola
        sc.close();
    }
}