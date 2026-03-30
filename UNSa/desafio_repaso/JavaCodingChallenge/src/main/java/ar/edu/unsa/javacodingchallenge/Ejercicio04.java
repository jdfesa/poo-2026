package ar.edu.unsa.javacodingchallenge;

import java.util.*;
import java.util.Scanner;
/*

 */
public class Ejercicio04 {
  public static void main(String[] args) {
    
    // Crea un objeto Scanner para leer la entrada del usuario
    Scanner teclado = new Scanner(System.in);
    
    // Inicializa las variables sp y si en 0
    int sp = 0, si = 0;
    
    // Declarar un arreglo de enteros v
    int v[];
    
    // Lee el número de elementos de la lista ingresado por el usuario y lo asigna a la variable n
    int n = teclado.nextInt();
    
    // Inicializa el arreglo v con el número de elementos ingresado por el usuario
    v = new int[n];
    
    // Lee cada número ingresado por el usuario y lo agrega al arreglo v
    for (int i = 0; i < n; i += 1) {
      v[i] = teclado.nextInt();
    }
    
    // Suma los números pares e impares en las variables sp y si, respectivamente
    for (int i = 0; i < n; i += 1) {
      if (v[i] % 2 == 0) {
        sp += v[i];
      } else {
        si += v[i];
      } 
    } 
    
    // Muestra la suma de los números impares y luego la suma de los números pares
    System.out.println(si);
    System.out.println(sp);
  }
}
