
package ar.edu.unsa.javacodingchallenge;

import java.util.Scanner;

/*
Remove first and last character from a string


Write a program to remove first and last character from a string. 
consider string is given as input to the program

Sample Input
Hello
Sample Output
ell
*/
public class Ejercicio11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String cadena = sc.nextLine();
        
        for (int i = 1; i < cadena.length()-1; i+= 1) {
            System.out.print(cadena.charAt(i));           
        }
    }
}
