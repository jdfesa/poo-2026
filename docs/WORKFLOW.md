# Flujo de Trabajo y Sincronización (Workflow)

Este documento es una guía rápida de referencia con los comandos necesarios para el desarrollo diario en el monorepo y la entrega de trabajos prácticos.

Para comprender **por qué** se diseñó esta arquitectura, consulta el [ADR 0001: Estrategia de Monorepo y Git Subtree](./adr/0001-estrategia-monorepo.md).

---

## 💻 Flujo de Trabajo Diario

El desarrollo se alterna entre dos equipos físicos (Hackintosh y MacBook). Sigue estrictamente este flujo para evitar conflictos:

1. **Al iniciar la jornada (Obligatorio):**
   ```bash
   git pull origin main
   ```

2. **Desarrollo y Commits Semánticos:**
   Usa el estándar *Conventional Commits* para mantener un historial legible. A continuación, se detalla cuándo usar cada tipo en el contexto de la cursada:

   - `feat` (Feature): Para añadir un nuevo ejercicio, una nueva clase o una funcionalidad principal.
     *Ej: `feat(unsa-tp1): implementar patrón Strategy para cálculo de impuestos`*
   - `fix` (Bug Fix): Para corregir un error en un ejercicio o lógica existente.
     *Ej: `fix(ies-tp2): corregir desbordamiento de índice en la lista de alumnos`*
   - `refactor` (Refactor): Para mejorar el código existente sin añadir funcionalidades nuevas ni arreglar bugs (ej. renombrar variables, extraer métodos).
     *Ej: `refactor(unsa-tp1): modularizar clases de persistencia de datos`*
   - `docs` (Documentation): Para cambios exclusivos en archivos `README.md`, diagramas o comentarios.
     *Ej: `docs(general): actualizar diagramas UML en el README`*
   - `chore` (Tareas de mantenimiento): Para configuración de proyectos, IDEs (NetBeans/IntelliJ), cambios en `pom.xml`, o inicializar carpetas. Son tareas que no afectan al código fuente del usuario directamente.
     *Ej: `chore(unsa-repaso): inicializar proyecto Maven JavaCodingChallenge en NetBeans`*
   - `test` (Testing): Para añadir o modificar pruebas unitarias.
     *Ej: `test(ies-tp1): agregar pruebas unitarias para clase Calculadora`*

3. **Al finalizar la jornada:**
   ```bash
   git push origin main
   ```

---

## 🚀 Proceso de Entrega de TPs al Profesor

Cuando un TP ha sido completado y testeado localmente, se procede a la entrega oficial hacia el repositorio asignado por la cátedra.

### Paso 1: Configurar el remoto del profesor
*Este paso se realiza **una sola vez** por cada Trabajo Práctico.*
Se añade el repositorio destino como un nuevo "remote" local.

```bash
git remote add profe-tp1 https://github.com/ramblas98/POO26_TP1.git
```

### Paso 2: Envío mediante Subtree
Este comando extrae únicamente el historial de la carpeta del TP y lo empuja a la rama principal (`main` o `master`) del remoto configurado en el Paso 1.

*(Nota: Reemplazar `main` por el nombre de la rama requerida por la cátedra si fuese distinto).*

```bash
git subtree push --prefix UNSa/TP01 profe-tp1 main
```

## 🚨 FAQ / Troubleshooting (Problemas Comunes con Git)

### 1. Archivos "Untracked" al crear un nuevo proyecto en subcarpetas

**Problema:** Creaste un nuevo proyecto (ej. en NetBeans o IntelliJ) dentro de una subcarpeta (como `UNSa/desafio_repaso/JavaCodingChallenge`) y al hacer `git status`, la carpeta entera aparece en rojo como `Untracked files`.

**Por qué sucede:** Git detecta archivos nuevos que aún no están siendo rastreados por el control de versiones. Es el comportamiento normal de Git.

**Solución Correcta:**
1. **NO ejecutes `git init`** dentro de la nueva carpeta. El monorepo ya está inicializado en la raíz. Hacerlo crearía un submódulo accidental y rompería el repositorio.
2. Agrega la carpeta al área de preparación (staging) desde la raíz del monorepo:
   ```bash
   git add ruta/a/tu/nueva/carpeta/
   ```
3. Crea el commit y haz push normalmente:
   ```bash
   git commit -m "chore: inicializar nuevo proyecto [Nombre]"
   git push
   ```
