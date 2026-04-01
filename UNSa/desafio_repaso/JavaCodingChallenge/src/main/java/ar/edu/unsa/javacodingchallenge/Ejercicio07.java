package ar.edu.unsa.javacodingchallenge;

import java.util.Scanner;

/*
Check if sum of two numbers is less than 100?

Consider two numbers are given as input to the program and print true 
if the sum of the two numbers is less than 100 else false.

Sample Input
79
36
Sample Output
false
*/
public class Ejercicio07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if((a+b) < 100){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}


/*
Otra version sin usar el if, podria ser la siguiente: 
// Imprime directamente el resultado booleano de la evaluación
        System.out.println((a + b) < 100);
*/