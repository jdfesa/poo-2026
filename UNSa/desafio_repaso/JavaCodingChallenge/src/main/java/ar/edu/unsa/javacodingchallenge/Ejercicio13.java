package ar.edu.unsa.javacodingchallenge;

import java.util.Scanner;

/*
   Convert Minutes into Seconds
   Max Score: 2 | Difficulty: Not Specified

   Write a program to convert Minutes into Seconds.

   Sample Input
   5
   Sample Output
   300
 */
public class Ejercicio13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       int minute = sc.nextInt();
       int seconds = minute * 60;
       
        System.out.println(seconds);
    }
}
