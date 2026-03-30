package ar.edu.unsa.javacodingchallenge;
import java.util.*;
/*
Increment the digits of a number by 1

Write a program to increment the digits of a 
given number by 1

Sample Input
568
Sample Output
679
 */
public class Ejercicio03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long numeroActual;
        long multiplicador = 1;
        long resultadoAcumulado = 0;
        
        numeroActual = sc.nextLong();
        
        while(numeroActual > 0){
            // Extraemos el último dígito y lo incrementamos en 1
            long digitoIncrementado = (numeroActual % 10) + 1;
            
            // Posicionamos el dígito y lo sumamos al total
            resultadoAcumulado = (digitoIncrementado * multiplicador) + resultadoAcumulado;
            
            // Ajustamos el multiplicador dinámicamente
            if(digitoIncrementado == 10){
                // Si se formó un 10, este ocupa dos lugares físicos (ej: decenas y unidades).
                // Por lo tanto, el próximo dígito a procesar debe saltar dos posiciones a la izquierda.
                multiplicador = multiplicador * 100;
            } else {
                // Si es un dígito normal (1 al 9), ocupa un solo lugar.
                // El próximo dígito a procesar da un salto normal de una posición.
                multiplicador = multiplicador * 10;
            }
            
            // 4. Descartamos el último dígito
            numeroActual = numeroActual / 10;
        }
        
        System.out.println(resultadoAcumulado);
    }
}