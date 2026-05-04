# Relaciones entre Clases en UML

Esta guía explica los distintos tipos de relaciones que pueden existir entre clases en un diagrama UML.
Están ordenadas de la **más débil** a la **más fuerte**.

---

## 1. Dependencia (la más débil)

**Símbolo en UML:** Flecha punteada `- - - ->`  
**Se lee como:** *"Usa a"* o *"Necesita momentáneamente a"*

### ¿Qué es?
Una clase **usa** a otra de forma temporal. No la guarda como atributo permanente, sino que la necesita un ratito: como parámetro de un método, como variable local, o porque usa una de sus constantes.

### Ejemplo de la vida real
Vos vas a un cajero automático. Usás la máquina 2 minutos y te vas. No sos dueño del cajero, no lo llevás a tu casa. Solo lo **usaste** un momento.

### Ejemplo en Java
```java
public class Medico {
    // El médico NO guarda una lista de especialidades,
    // simplemente USA el enum para definir la suya
    private Especialidad especialidad; // usa el tipo Especialidad
}

// O también cuando aparece como parámetro:
public class Impresora {
    public void imprimir(Documento doc) {
        // Usa a Documento solo dentro de este método
        // No lo guarda como atributo
        System.out.println(doc.getTexto());
    }
}
```

### Símbolo en PlantUML
```
ClaseA ..> ClaseB : usa
```

---

## 2. Asociación

**Símbolo en UML:** Flecha normal `────────>`  
**Se lee como:** *"Conoce a"* o *"Tiene una referencia a"*

### ¿Qué es?
Una clase **conoce** a otra y guarda una referencia a ella como atributo. Es una relación **estructural y duradera**. Ambas clases existen de forma independiente, pero una sabe de la existencia de la otra.

### Ejemplo de la vida real
Un alumno tiene un profesor asignado. El alumno **conoce** a su profesor (sabe quién es), pero ninguno de los dos "pertenece" al otro. Si el alumno deja la materia, el profesor sigue existiendo y viceversa.

### Ejemplo en Java
```java
public class Historia {
    private Medico medicoAsignado; // La historia CONOCE a su médico
    
    public Medico getMedicoAsignado() {
        return medicoAsignado;
    }
}
```
La `Historia` guarda una referencia al `Medico` que la atendió. Si la historia se elimina, el médico sigue existiendo. Si el médico se jubila, la historia sigue existiendo en el archivo.

### Símbolo en PlantUML
```
Historia --> Medico : es atendido por
```

---

## 3. Agregación (relación "Todo-Parte" débil)

**Símbolo en UML:** Flecha con rombo **vacío** `◇────────>`  
**Se lee como:** *"Tiene"* o *"Agrupa a"*

### ¿Qué es?
Es un tipo especial de asociación. Indica que una clase (el **todo**) agrupa o contiene a otras (las **partes**), pero las partes **pueden existir sin el todo**. Si destruís el todo, las partes siguen viviendo.

### Ejemplo de la vida real
Un equipo de fútbol **tiene** jugadores. Si el equipo se disuelve, los jugadores no desaparecen: se van a otro equipo o siguen con su vida.

### Ejemplo en Java
```java
public class CuadroMedico {
    // El cuadro médico AGRUPA médicos
    // Pero si eliminamos el cuadro, los médicos siguen existiendo
    private List<Medico> medicos;
    
    public void insertarMedico(Medico m) {
        medicos.add(m);  // agrega un médico que ya existía antes
    }
    
    public void eliminarMedico(Medico m) {
        medicos.remove(m); // lo saca de la lista, pero no lo destruye
    }
}
```
**Clave:** El `CuadroMedico` no **crea** a los médicos. Los recibe desde afuera. Si el cuadro se elimina, los médicos siguen existiendo en la memoria del programa.

### Símbolo en PlantUML
```
CuadroMedico o--> "0..*" Medico : agrupa
```

---

## 4. Composición (relación "Todo-Parte" fuerte)

**Símbolo en UML:** Flecha con rombo **relleno/negro** `◆────────>`  
**Se lee como:** *"Está compuesto por"* o *"Posee y controla la vida de"*

### ¿Qué es?
Es la relación más fuerte entre objetos. Igual que la agregación, indica que una clase contiene a otras. **Pero aquí las partes NO pueden existir sin el todo.** Si destruís el todo, las partes se destruyen también. El todo es el **dueño absoluto** de las partes.

### Ejemplo de la vida real
Una casa **está compuesta** por habitaciones. Si demolés la casa, las habitaciones desaparecen con ella. No tiene sentido que una habitación exista flotando sin una casa.

### Ejemplo en Java
```java
public class Factura {
    private List<LineaFactura> lineas;
    
    public Factura() {
        // La factura CREA sus propias líneas internamente
        this.lineas = new ArrayList<>();
    }
    
    public void agregarProducto(String nombre, double precio) {
        // Crea la línea dentro de la factura. La línea no existe fuera.
        lineas.add(new LineaFactura(nombre, precio));
    }
}

public class LineaFactura {
    private String producto;
    private double precio;
    // Una LineaFactura no tiene sentido sin su Factura
}
```
**Clave:** La `Factura` **crea** las `LineaFactura` internamente. Las líneas nacen y mueren con la factura. Si borrás la factura, las líneas se van con ella.

### Símbolo en PlantUML
```
Factura *--> "1..*" LineaFactura : contiene
```

---

## 5. Herencia (Generalización)

**Símbolo en UML:** Flecha con triángulo vacío `────────▷`  
**Se lee como:** *"Es un tipo de"* o *"Hereda de"*

### ¿Qué es?
Una clase hija **hereda** todos los atributos y métodos de una clase padre, y puede agregar los suyos propios o modificar (sobreescribir) los del padre. Es la relación que modela la jerarquía "es un tipo de".

### Ejemplo de la vida real
Un perro **es un tipo de** animal. Todo lo que puede hacer un animal (respirar, moverse), un perro también puede hacerlo. Pero además el perro agrega comportamientos propios (ladrar).

### Ejemplo en Java
```java
public class Animal {
    protected String nombre;
    
    public void respirar() {
        System.out.println(nombre + " está respirando");
    }
}

public class Perro extends Animal {
    // Hereda nombre y respirar() automáticamente
    
    public void ladrar() {
        System.out.println(nombre + " dice: ¡Guau!");
    }
}
```

### Símbolo en PlantUML
```
Animal <|-- Perro
```
*(Se lee: Perro hereda de Animal)*

---

## 6. Realización / Implementación de Interfaz

**Símbolo en UML:** Flecha punteada con triángulo vacío `- - - -▷`  
**Se lee como:** *"Implementa"* o *"Cumple el contrato de"*

### ¿Qué es?
Una clase se compromete a implementar todos los métodos definidos en una interfaz. Una interfaz es como un **contrato**: dice QUÉ se debe hacer, pero no CÓMO. La clase que la implementa define el CÓMO.

### Ejemplo de la vida real
Un contrato de trabajo dice "debes cumplir 8 horas". El contrato no dice CÓMO trabajar. Cada empleado (programador, diseñador, contador) cumple esas 8 horas a su manera.

### Ejemplo en Java
```java
public interface Imprimible {
    void imprimir();  // Solo define QUÉ, no CÓMO
}

public class Historia implements Imprimible {
    @Override
    public void imprimir() {
        // Define CÓMO se imprime una historia
        System.out.println("Historia #" + id + " - Paciente: " + codigoPaciente);
    }
}

public class Factura implements Imprimible {
    @Override
    public void imprimir() {
        // Define CÓMO se imprime una factura (diferente a la historia)
        System.out.println("Factura #" + numero + " - Total: $" + total);
    }
}
```

### Símbolo en PlantUML
```
interface Imprimible
Imprimible <|.. Historia
Imprimible <|.. Factura
```

---

## Resumen Visual - De más débil a más fuerte

| Relación | Flecha UML | Se lee como | ¿Las partes viven sin el todo? |
|---|---|---|---|
| **Dependencia** | `..>` punteada | "Usa a" | No aplica (es momentánea) |
| **Asociación** | `-->` normal | "Conoce a" | Sí, son independientes |
| **Agregación** | `o-->` rombo vacío | "Agrupa a" | Sí, las partes sobreviven |
| **Composición** | `*-->` rombo lleno | "Se compone de" | No, las partes mueren con el todo |
| **Herencia** | `<\|--` triángulo vacío | "Es un tipo de" | No aplica (es jerarquía) |
| **Realización** | `<\|..` triángulo punteado | "Implementa" | No aplica (es contrato) |

---

## Truco para no confundir Agregación y Composición

Hacete esta pregunta: **¿Tiene sentido que la parte exista sola, sin el todo?**

- **Sí** → Es **Agregación** (rombo vacío). Ejemplo: Un médico puede existir sin el cuadro médico.
- **No** → Es **Composición** (rombo lleno). Ejemplo: Una habitación no tiene sentido sin la casa.

Otra forma de verlo: **¿Quién crea a la parte?**

- Si la parte **ya existía antes** y el todo solo la recibe → **Agregación**.
- Si el todo **crea la parte internamente** → **Composición**.
