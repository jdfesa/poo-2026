---
title: "Desafío 0: Comenzando en Java"
type: assign
academic_status: completed # pending | in_progress | delayed | completed
due_date: 2026-03-30
tags: [academics/tup/poo, assign]
export_target: pdf
---

# Desafío 0: Comenzando en Java

> [!note]
>Universidad Nacional de Salta, Facultad Orán
> Tecnicatura Universitaria en Programación
> 
> Materia: Programación Orientada a Objetos
> Profesor: Prof. CU Blas Lopez
> Alumno: Sandoval, José David Fernando 
> Fecha de entrega: 2026-03-30

---

## 📝 Descripción
Resolución de un conjunto de 15 ejercicios básicos de lógica de programación utilizando el lenguaje Java. Los ejercicios abarcan desde manipulación de arreglos y cadenas hasta cálculos matemáticos y algoritmos clásicos como Fibonacci y Factorial.

## 🚀 Desarrollo

### Ejercicio 01: Orden Alfabético
Escribir un programa para ordenar los elementos de un arreglo en orden alfabético.

```java
package ar.edu.unsa.javacodingchallenge;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int size = sc.nextInt();
        sc.nextLine();
        
        String arr[] = new String[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextLine();
        }
        Arrays.sort(arr);
        
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
```

---

### Ejercicio 02: Suma de Dígitos
Escribir un programa que imprima la suma de los dígitos de un número dado.

```java
package ar.edu.unsa.javacodingchallenge;
import java.util.Scanner;

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
```

---

### Ejercicio 03: Incrementar Dígitos
Escribir un programa para incrementar en 1 cada dígito de un número dado.

```java
package ar.edu.unsa.javacodingchallenge;
import java.util.*;

public class Ejercicio03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long numeroActual;
        long multiplicador = 1;
        long resultadoAcumulado = 0;
        
        numeroActual = sc.nextLong();
        
        while(numeroActual > 0){
            long digitoIncrementado = (numeroActual % 10) + 1;
            resultadoAcumulado = (digitoIncrementado * multiplicador) + resultadoAcumulado;
            
            if(digitoIncrementado == 10){
                multiplicador = multiplicador * 100;
            } else {
                multiplicador = multiplicador * 10;
            }
            numeroActual = numeroActual / 10;
        }
        System.out.println(resultadoAcumulado);
    }
}
```

---

### Ejercicio 04: Suma de Pares e Impares
Calcular la suma de los números pares e impares de un arreglo de enteros.

```java
package ar.edu.unsa.javacodingchallenge;
import java.util.*;

public class Ejercicio04 {
  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
    int sp = 0, si = 0;
    int v[];
    int n = teclado.nextInt();
    v = new int[n];
    
    for (int i = 0; i < n; i += 1) {
      v[i] = teclado.nextInt();
    }
    
    for (int i = 0; i < n; i += 1) {
      if (v[i] % 2 == 0) {
        sp += v[i];
      } else {
        si += v[i];
      } 
    } 
    System.out.println(si);
    System.out.println(sp);
  }
}
```

---

### Ejercicio 05: Perímetro de un Rectángulo
Calcular el perímetro de un rectángulo dadas su longitud y su anchura.

```java
package ar.edu.unsa.javacodingchallenge;
import java.util.Scanner;

public class Ejercicio05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int w = sc.nextInt();
        System.out.println(2*(l+w));
    }
}
```

---

### Ejercicio 06: Edad a Días
Convertir la edad en años a número de días (ignorando años bisiestos).

```java
package ar.edu.unsa.javacodingchallenge;
import java.util.Scanner;

public class Ejercicio06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        int days = age * 365;
        System.out.println(days);
    }
}
```

---

### Ejercicio 07: Suma menor a 100
Verificar si la suma de dos números es menor a 100.

```java
package ar.edu.unsa.javacodingchallenge;
import java.util.Scanner;

public class Ejercicio07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if((a+b) < 100){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
```

---

### Ejercicio 08: Formateo de Email
Extraer nombre de usuario y empresa de un email y dar un mensaje de bienvenida con formato.

```java
package ar.edu.unsa.javacodingchallenge;
import java.util.Scanner;

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
      i += 1; // Saltar el '@'
      
      while(i < cadena.length() && cadena.charAt(i) != '.'){
        copy1 += cadena.charAt(i);
        i += 1;
      }
      
      System.out.println("Hi " + Character.toUpperCase(copy0.charAt(0)) + copy0.substring(1) + ", Welcome to " + Character.toUpperCase(copy1.charAt(1)) + copy1.substring(2) );
    }
}
```

---

### Ejercicio 09: Serie de Fibonacci
Imprimir la serie de Fibonacci hasta una cantidad dada de elementos.

```java
package ar.edu.unsa.javacodingchallenge;
import java.util.Scanner;

public class Ejercicio09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int a = 0, b = 1, c;
        
        System.out.print(a + ", " + b); 
        
        for (int i = 2; i < size; i++) {
            c = a + b;
            System.out.print(", " + c);
            a = b; 
            b = c;
        }
        System.out.println();
        sc.close();
    }
}
```

---

### Ejercicio 10: Factorial de un número
Calcular el factorial de un número entero dado.

```java
package ar.edu.unsa.javacodingchallenge;
import java.util.Scanner;

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
```

---

### Ejercicio 11: Remover Primer y Último Carácter
Eliminar el primer y el último carácter de una cadena de texto.

```java
package ar.edu.unsa.javacodingchallenge;
import java.util.Scanner;

public class Ejercicio11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine();
        
        for (int i = 1; i < cadena.length()-1; i+= 1) {
            System.out.print(cadena.charAt(i));           
        }
    }
}
```

---

### Ejercicio 12: Caracteres Repetidos
Contar las ocurrencias de caracteres que se repiten en una cadena.

```java
package ar.edu.unsa.javacodingchallenge;
import java.util.*;

public class Ejercicio12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextLine()) {
            String s = sc.nextLine().trim();
            if (s.isEmpty()) return;

            Map<Character, Integer> counts = new LinkedHashMap<>();
            for (char c : s.toCharArray()) {
                if (c == ' ') continue; 
                counts.put(c, counts.getOrDefault(c, 0) + 1);
            }

            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
                if (entry.getValue() > 1) {
                    if (!first) {
                        sb.append(", ");
                    }
                    sb.append(entry.getKey()).append(":").append(entry.getValue());
                    first = false;
                }
            }
            if (sb.length() > 0) {
                System.out.print(sb.toString());
            }
        }
    }
}
```

---

### Ejercicio 13: Minutos a Segundos
Convertir una cantidad de minutos a segundos.

```java
package ar.edu.unsa.javacodingchallenge;
import java.util.Scanner;

public class Ejercicio13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int minute = sc.nextInt();
        int seconds = minute * 60;
        System.out.println(seconds);
    }
}
```

---

### Ejercicio 14: Área de un Triángulo
Calcular el área de un triángulo dada su base y su altura.

```java
package ar.edu.unsa.javacodingchallenge;
import java.util.Scanner;

public class Ejercicio14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt();
        int height = sc.nextInt();
        System.out.println((base * height) / 2);
    }
}
```

---

### Ejercicio 15: Número Palíndromo
Verificar si un número dado es palíndromo (se lee igual al derecho y al revés).

```java
package ar.edu.unsa.javacodingchallenge;
import java.util.Scanner;

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
```

---

## 📌 Conclusión o Reflexión
Este desafío inicial permitió afianzar conceptos básicos de programación en Java, tales como el uso de la clase `Scanner` para la entrada de datos, estructuras de control (`if`, `while`, `for`), manipulación de cadenas (`String`, `StringBuilder`) y estructuras de datos básicas (`Arrays`, `Map`). La resolución de problemas variados ayuda a desarrollar un pensamiento lógico sólido antes de profundizar en temas avanzados de Programación Orientada a Objetos.
