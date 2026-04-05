
package ar.edu.unsa.javacodingchallenge;

import java.util.Scanner;

/*
    Calculate area of a triangle


    Write a program to calculate area of a triangle.
    Consider base and height of the triangle are given as input to the program.

    Sample Input
    7
    4
    Sample Output
    14
*/
public class Ejercicio14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int base = sc.nextInt();
        int height = sc.nextInt();
        
        System.out.println((base * height) / 2);
    }
}
