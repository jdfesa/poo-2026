
package ar.edu.unsa.javacodingchallenge;

import java.util.Scanner;

/*
    Check if a given number is palindrome or not
    

    Write a program to check if a given number is palindrome or not. Print TRUE if 
    its a palindrome number else FALSE.

    Note: A number is a palindrome if the reverse of that number 
    is equal to the original number.

    Sample Input
    10001
    
    Sample Output
    TRUE
 */
public class Ejercicio15 {
   public static boolean palindromo(int x){
      int inv = 0;
      int aux = x;
      int digit = 0;
      while (x != 0){
        digit = x % 10;
        x = x / 10;
        
        inv = inv * 10 + digit;
      }
       return inv == aux;
      
    }
    
    public static void main(String[] args) {
      
      Scanner sc = new Scanner(System.in);
      
      int number;
      number = sc.nextInt();
      
      if(palindromo(number)){
        System.out.println("TRUE");
      }else{
        System.out.println("FALSE");
      }
  }
}
