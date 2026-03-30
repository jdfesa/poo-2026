package ar.edu.unsa.javacodingchallenge;


import java.util.Scanner;

/*
Print the sum of the digits of a given number

Write a program to print the sum of the digits of a given number.

Sample Input
234

Sample Output
9
 */
public class Ejercicio02 {
    public static void main(String[] args) {
            Scanner sc = new Scanner (System.in);
    int num = sc.nextInt();
    int acu = 0, digito;
    
        while(num != 0){
            digito = num % 10;
            num = num / 10;
            acu = acu + digito;
        }
        System.out.println(acu);
    }
    
}