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

---

## 4. ¿Cuál es la diferencia entre `git add .` y `git add <archivo>` cuando solo he modificado un archivo?

Si **únicamente** has modificado o creado un solo archivo (ej. `Ejercicio02.java`) en todo el proyecto, **el resultado de ambos comandos será exactamente el mismo.**

*   **`git add .`**: Le indica a Git que busque en todas las carpetas y subcarpetas desde tu ubicación actual y prepare todo lo que tenga cambios (archivos `U` y `M`). Si solo cambió un archivo, solo preparará ese. Es la opción más rápida y cómoda.
*   **`git add <ruta-del-archivo>`**: Prepara únicamente ese archivo específico. Sin embargo, si estás en la raíz del proyecto, tendrías que escribir la ruta completa (ej: `git add UNSa/desafio_repaso/.../Ejercicio02.java`), lo cual es menos práctico.

**¿Cuándo SÍ importa la diferencia?**
Es fundamental elegir bien cuando tienes **varios archivos modificados al mismo tiempo**, pero quieres separarlos en *commits* diferentes para mantener el orden (una regla clave de **Conventional Commits**).

*   **Ejemplo:** Imagina que creaste `Ejercicio02.java`, arreglaste un error en `Ejercicio01.java` y actualizaste el `README.md`.
*   Si haces `git add .`, incluirás los **tres** cambios en un solo commit, mezclando un `feat`, un `fix` y un `docs`.
*   En este escenario, lo correcto es usar `git add <ruta-del-README.md>` y hacer su commit de `docs: ...`. Luego preparar el siguiente archivo de forma individual y hacer su respectivo commit, y así sucesivamente.

---

## 5. Si el profesor dice "no trabajar en main", ¿por qué yo trabajo en `main`?

Porque son **dos repositorios completamente distintos** con contextos diferentes:

| | **Tu monorepo** (`jdfesa/poo-2026`) | **Repo del profesor** (`ramblas98/POO26_0N`) |
|---|---|---|
| **¿Quién trabaja?** | Solo vos | Todos los alumnos + el profesor |
| **¿En qué rama?** | `main` (sos el único dueño) | `jose-david` (tu rama aislada) |

Cuando el profesor dice *"no trabajen en main"*, le habla a los alumnos que clonan **su** repositorio directamente y trabajan dentro de él. Ellos necesitan ramas para no pisarse entre sí.

Vos tenés tu **propio repositorio** donde sos el único contribuidor — no necesitás ramas para aislarte de nadie. Cuando ejecutás `git subtree push`, el comando extrae tu código y lo envía a tu rama `jose-david` en el repo del profesor, respetando su regla sin que vos tengas que cambiar tu forma de trabajar.

**En resumen:** Trabajás en `main` en tu repo → `git subtree push` → llega a `jose-david` en el repo del profesor. Lo mejor de los dos mundos.