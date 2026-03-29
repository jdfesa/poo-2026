# ADR 0002: Estrategia de .gitignore Multinivel

**Fecha:** 2026-03-29
**Estado:** Aceptado

## Contexto
En un monorepo que gestiona entregas mediante `git subtree` (ver [ADR 0001](./0001-estrategia-monorepo.md)), surge el desafío técnico de cómo manejar la exclusión de archivos (archivos temporales, binarios compilados, configuraciones de IDE).

Si se utiliza un único archivo `.gitignore` en la raíz del repositorio (`/poo-2026/.gitignore`), este archivo se encargará correctamente de ignorar todos los archivos indeseados en el entorno local del desarrollador. Sin embargo, al ejecutar `git subtree push --prefix UNSa/TP01 ...`, Git aísla *únicamente* el historial de esa subcarpeta, excluyendo cualquier archivo que esté fuera de ella, incluyendo el `.gitignore` raíz.

Esto significa que el repositorio remoto del profesor recibiría el código fuente correctamente, pero sin un archivo `.gitignore`. Si el profesor clona el repositorio, compila el código y ejecuta un comando de Git, su entorno se llenará de archivos temporales (ej. `.class` en Java o `__pycache__` en Python), demostrando una aparente falta de buenas prácticas por parte del estudiante.

## Decisión
Se decidió implementar una estrategia de **`.gitignore` multinivel** (en cascada):

1. **Un `.gitignore` Global (Raíz del monorepo):** 
   Gestiona exclusivamente ignorancias transversales, específicas del entorno de trabajo del desarrollador (Sistema Operativo y editores).
   - *Ejemplos:* `.DS_Store` (Mac/Hackintosh), `.vscode/`, `.idea/`.

2. **Múltiples `.gitignore` Locales (Raíz de cada Trabajo Práctico):**
   Gestionan exclusivamente las ignorancias específicas del lenguaje de programación y entorno de ejecución de ese proyecto en particular.
   - *Ejemplo Python (IES6023/TP01/.gitignore):* `__pycache__/`, `venv/`, `*.pyc`.
   - *Ejemplo Java (UNSa/TP01/.gitignore):* `*.class`, `bin/`, `out/`, `target/`.

## Consecuencias

### Positivas
- **Entregas impecables:** Al usar `git subtree` para enviar la carpeta de un TP específico, el `.gitignore` local de esa carpeta viaja junto con el código al repositorio destino. El profesor recibe un proyecto con las reglas de exclusión correctas para su ecosistema (Java o Python).
- **Separación de responsabilidades:** Las configuraciones del IDE personal (`.vscode`) no se filtran ni "ensucian" el repositorio del profesor, ya que están contenidas en el `.gitignore` raíz que no viaja mediante el subtree.
- **Demostración de conocimientos avanzados:** Refuerza la imagen de un ingeniero de software que comprende profundamente el funcionamiento de Git, la arquitectura de repositorios y las buenas prácticas de despliegue/entrega.

### Negativas
- **Ligero incremento en la carga de configuración inicial:** Requiere crear manualmente un archivo `.gitignore` para cada nuevo directorio de TP que se inicie, en lugar de depender de una única regla global. (Se considera un coste trivial frente a los beneficios).