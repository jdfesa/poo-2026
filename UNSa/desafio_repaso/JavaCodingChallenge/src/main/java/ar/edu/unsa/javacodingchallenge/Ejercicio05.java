package ar.edu.unsa.javacodingchallenge;

import java.util.Scanner;

/*
Calculate perimeter of a Rectangle

Write a program to calculate the perimeter of a rectangle. 
In rectangle opposite sides have equal length and both 
the diagonals of a rectangle have equal length. 
Consider the length and breadth of the rectangle are given as input.

Note: The Perimeter of rectangle is 2*(l + w).
*/
public class Ejercicio05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int l = sc.nextInt();
        int w = sc.nextInt();
        
        System.out.println(2*(l+w));
    }
}
