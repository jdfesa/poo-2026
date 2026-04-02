package ar.edu.unsa.javacodingchallenge;

import java.util.Scanner;

/*
 Write a program to print the factorial of a given number.

The factorial of a number is the product of all the integers from 1 to that given integer.
For example, the factorial of 5 is 12345 is 120. 
Consider whole numbers are given as input to the program

Sample Input
6
Sample Output
720

*/

public class Ejercicio10 {
    public static int factorial(int number){
        if(number == 0) return 1;
        else return number * factorial(number - 1);
  }
    public static void main(String[] args) {
      
      Scanner teclado = new Scanner(System.in);
      int a = teclado.nextInt();
      System.out.println(factorial(a));
      
  }
}
