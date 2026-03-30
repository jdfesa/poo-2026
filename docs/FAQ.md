# Preguntas Frecuentes (FAQ) y Base de Conocimientos

Este documento centraliza dudas comunes y soluciones encontradas durante el desarrollo del proyecto, sirviendo como una referencia rápida.

---

## 1. ¿Qué significan las letras `U` y `M` al lado de los archivos en VSCode?

Cuando trabajas con Git en VSCode, los archivos pueden tener indicadores de estado a su lado:

*   **`U` (Untracked / Sin seguimiento):** Git ha detectado un **archivo nuevo** que acabas de crear, pero todavía no lo está "rastreando". Aún no forma parte del historial de Git.
*   **`M` (Modified / Modificado):** Se trata de un **archivo que Git ya rastreaba**, pero al que le has hecho cambios (agregar, borrar o modificar líneas de código) desde la última vez que guardaste un *commit*.

---

## 2. ¿Debo ir a la ubicación exacta del archivo en la terminal para hacer un `commit`?

**No.** No necesitas usar el comando `cd` para navegar hasta la carpeta profunda donde está el archivo modificado o nuevo. 

Puedes abrir la terminal integrada (que por defecto se ubica en la raíz del proyecto, ej. `poo-2026`) y ejecutar los comandos de Git desde allí. Git buscará en toda la estructura de carpetas automáticamente.

---

## 3. ¿Cuál es el flujo para guardar cambios de estos archivos (siguiendo Conventional Commits)?

Suponiendo que tienes un archivo nuevo (`U`) y uno modificado (`M`), y estás en la raíz del proyecto, debes seguir estos tres pasos:

**Paso 1: Preparar los archivos (Git Add)**
```bash
git add .
```
*(El punto `.` le indica a Git que incluya todos los cambios del directorio actual y todas sus subcarpetas. En VSCode verás que las letras cambian a `A` o a `M` pero bajo la categoría "Staged Changes").*

**Paso 2: Guardar los cambios (Git Commit)**
Siguiendo nuestra convención de **Conventional Commits** (como se documenta en el proyecto), debes usar prefijos como `feat`, `fix`, `docs`, etc.

Ejemplo:
```bash
git commit -m "feat(unsa): add Ejercicio01 and update JavaCodingChallenge"
```
*   **`feat`**: Indica que estás agregando una nueva característica o resolviendo un ejercicio nuevo.
*   **`(unsa)`**: Indica el contexto o área del proyecto donde se hizo el cambio (opcional, pero buena práctica en monorepos).
*   **Mensaje**: Una descripción clara en imperativo.

**Paso 3: Subir los cambios (Git Push)**
```bash
git push
```
*(Esto envía el historial local a tu repositorio en la nube).*