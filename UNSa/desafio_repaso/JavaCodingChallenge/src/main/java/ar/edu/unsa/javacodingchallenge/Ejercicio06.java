package ar.edu.unsa.javacodingchallenge;

import java.util.Scanner;

/*
Convert age into number of days
Write a program to convert age into number of days. 
Consider age is given as input

Note: Ignore leap years and input must be a positive integer

Sample Input
20
Sample Output
7300
 */
public class Ejercicio06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        int days = age * 365;
        
        System.out.println(days);
    }
}
