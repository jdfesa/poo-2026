package ar.edu.unsa.javacodingchallenge;

import java.util.Scanner;

/*
Print Hi UserName, Welcome to companyName from email-id

Consider your input is an email address in the format userName@companyName.com. 
Write a program to print Hi UserName, Welcome to companyName.

Note: Output should have first letter of userName and companyName 
as a capital letter and both the username and companyName should be of characters

Sample Input
sara@alphabet.com
Sample Output
Hi Sara, Welcome to Alphabet


*/
public class Ejercicio08 {
    public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);
      
      String cadena = keyboard.nextLine();
      String copy0 = "";
      String copy1 = "";
      
      int i = 0;
      
      while(cadena.charAt(i) != '@'){
        copy0 += cadena.charAt(i);
        i += 1;
      }
      
      
      while(cadena.charAt(i) != '.'){
        copy1 += cadena.charAt(i);
        i += 1;
      }
      
      System.out.println("Hi " + Character.toUpperCase(copy0.charAt(0)) + copy0.substring(1) + ", Welcome to " + Character.toUpperCase(copy1.charAt(1)) + copy1.substring(2) );

      //System.out.println("Hi " + copy0.toUpperCase.charAt(0));
      
  }
}
