package ar.edu.unsa.javacodingchallenge;
import java.util.Arrays;
import java.util.Scanner;
/**
Sort names in an alphabetical Order

Write a program to sort the array elements in alphabetical order, 
Consider no duplicates are present and you will be taking 
the array size and the elements of an array as input to the program.

Sample Input
3
foo
bar
chris

Sample Output
bar
chris
foo

*/

public class Ejercicio01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int size = sc.nextInt();
        sc.nextLine();
        
        String arr[] = new String[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextLine();
        }
        Arrays.sort(arr);
        
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
/*
 ACLARACIÓN IMPORTANTE: 
   La línea 'keyboard.nextLine();' después de 'nextInt()' es necesaria para "limpiar" 
   el salto de línea (Enter) que queda en el sistema. 
   
   Si se quita: El primer espacio del arreglo se llenará con un texto vacío ("") 
   automáticamente, lo que desplazará los demás datos y causará que el último 
   valor ingresado (como "chris") quede fuera del arreglo y se pierda.
*/
