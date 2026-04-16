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
     *Ej: `feat(unsa-tp2): implementar clase Persona con atributos básicos`*
   - `fix` (Bug Fix): Para corregir un error en un ejercicio o lógica existente.
     *Ej: `fix(unsa-tp2): corregir validación de edad negativa en Persona`*
   - `refactor` (Refactor): Para mejorar el código existente sin añadir funcionalidades nuevas ni arreglar bugs (ej. renombrar variables, extraer métodos).
     *Ej: `refactor(unsa-tp2): extraer método validar() en clase Persona`*
   - `docs` (Documentation): Para cambios exclusivos en archivos `README.md`, diagramas o comentarios.
     *Ej: `docs(general): actualizar diagramas UML en el README`*
   - `chore` (Tareas de mantenimiento): Para configuración de proyectos, IDEs (NetBeans/IntelliJ), cambios en `pom.xml`, o inicializar carpetas. Son tareas que no afectan al código fuente del usuario directamente.
     *Ej: `chore(unsa-tp2): inicializar proyecto NetBeans para TP02`*
   - `test` (Testing): Para añadir o modificar pruebas unitarias.
     *Ej: `test(unsa-tp2): agregar pruebas unitarias para clase Calculadora`*

3. **Al finalizar la jornada:**
   ```bash
   git push origin main
   ```

---

## 🚀 Proceso de Entrega de TPs al Profesor (UNSa)

Esta sección documenta el proceso completo para enviar tu código desde el monorepo hacia el repositorio del profesor. El flujo soporta **envíos incrementales** (podés enviar tu progreso varias veces, no solo al final).

### Conceptos Clave

- **Remoto (`remote`):** Es un "alias" que apunta a un repositorio externo. Tu monorepo tiene `origin` (tu GitHub personal) y un remoto por cada TP del profesor (ej. `profe-tp2`).
- **`git subtree push`:** Extrae únicamente los commits que afectan a una carpeta específica del monorepo y los envía al remoto destino. Es "inteligente": cada vez que lo ejecutás, solo envía los commits **nuevos** que aún no están en el remoto.
- **Tu rama:** Cada alumno trabaja en su propia rama en el repo del profesor. Tu rama es `jose-david`.

### Paso a Paso: Setup Inicial (una sola vez por TP)

> ⚠️ **Requisito previo:** Debés haber aceptado la invitación de colaborador que el profesor envía por correo para cada repositorio de TP.

#### 1. Agregar el remoto del profesor

Creás un alias local que apunta al repositorio del TP. El nombre sigue la convención `profe-tpN`:

```bash
git remote add profe-tpN https://github.com/ramblas98/POO26_0N.git
```

**Ejemplo concreto para TP02:**
```bash
git remote add profe-tp2 https://github.com/ramblas98/POO26_02.git
```

> 💡 **¿Cómo saber la URL?** Entrá a la página de GitHub del repositorio del profesor, hacé clic en el botón verde **"Code"**, y copiá la URL HTTPS.

#### 2. Descargar las referencias del remoto

Esto descarga la información de las ramas del repositorio del profesor sin modificar nada en tu código local:

```bash
git fetch profe-tpN
```

Después de ejecutarlo, podés ver las ramas que existen con:
```bash
git branch -r | grep profe-tpN
```

#### 3. Crear tu rama personal en el repositorio del profesor

Este comando crea la rama `jose-david` en el repositorio remoto, basándola en la rama `main` del profesor:

```bash
git push profe-tpN profe-tpN/main:refs/heads/jose-david
```

**¿Qué significa este comando?**
- `profe-tpN/main` → "Tomá el commit al que apunta la rama `main` del profesor"
- `refs/heads/jose-david` → "Y creá una nueva rama llamada `jose-david` en el remoto que empiece en ese punto"

> ✅ **Verificación:** Entrá a la página de GitHub del repositorio del profesor. Hacé clic en el selector de ramas (donde dice "main") y confirmá que `jose-david` aparece en la lista.

#### 4. Verificar la configuración final

Para confirmar que todo quedó configurado correctamente:

```bash
git remote -v
```

Deberías ver algo como:
```
origin      https://github.com/jdfesa/poo-2026.git (fetch)
origin      https://github.com/jdfesa/poo-2026.git (push)
profe-tp2   https://github.com/ramblas98/POO26_02.git (fetch)
profe-tp2   https://github.com/ramblas98/POO26_02.git (push)
```

---

### Paso a Paso: Envío de Progreso (repetir cuantas veces quieras)

Una vez que el setup inicial está hecho, enviar tu progreso es **un solo comando**:

```bash
git subtree push --prefix UNSa/TPxx profe-tpN jose-david
```

**Ejemplo concreto para TP02:**
```bash
git subtree push --prefix UNSa/TP02 profe-tp2 jose-david
```

**¿Qué hace este comando internamente?**
1. Git recorre todo el historial de commits de tu monorepo.
2. Filtra únicamente los commits que modificaron archivos dentro de `UNSa/TP02/`.
3. "Replanta" esos commits de forma que la raíz sea `UNSa/TP02/` (es decir, elimina ese prefijo de las rutas).
4. Envía solamente los commits que **aún no existen** en la rama `jose-david` del remoto.

> 💡 **¿Es seguro ejecutarlo varias veces?** Sí. Si no hay commits nuevos, simplemente mostrará `Everything up-to-date`. No duplica commits ni rompe nada.

#### ¿Cuándo ejecutarlo?

- **Mínimo:** Al finalizar cada TP (entrega obligatoria).
- **Recomendado:** Cada vez que completes un avance significativo (1-3 veces por TP), para que el profesor pueda ver tu progreso continuo.
- **Por ejemplo:** Después de implementar una clase importante, después de completar un grupo de ejercicios, o antes de la fecha de revisión.

#### ¿Qué verá el profesor?

Al entrar a su repositorio en GitHub y seleccionar tu rama `jose-david`, verá:
- Únicamente los archivos de tu TP (sin la estructura del monorepo).
- Tu historial de commits con los mensajes descriptivos de Conventional Commits.
- Tu `.gitignore` de Java, demostrando buenas prácticas.

---

### 📋 Registro de Remotos Configurados

| TP   | Nombre del Remoto | URL del Repositorio                              | Tu Rama        | Estado     |
|------|--------------------|--------------------------------------------------|----------------|------------|
| TP02 | `profe-tp2`        | `https://github.com/ramblas98/POO26_02.git`      | `jose-david`   | ✅ Activo   |

> 📝 **Instrucciones de mantenimiento:** Al comenzar cada nuevo TP, agregá una fila a esta tabla con los datos correspondientes. La URL seguirá el patrón `https://github.com/ramblas98/POO26_0N.git` y el nombre del remoto será `profe-tpN`.

---

### 🆘 Cheat Sheet: Resumen de Comandos

```bash
# ─── SETUP INICIAL (una sola vez por TP) ───────────────────────

# 1. Agregar remoto del profesor
git remote add profe-tpN https://github.com/ramblas98/POO26_0N.git

# 2. Descargar referencias
git fetch profe-tpN

# 3. Crear tu rama en el remoto
git push profe-tpN profe-tpN/main:refs/heads/jose-david

# ─── ENVÍO DE PROGRESO (repetir cuantas veces quieras) ────────

git subtree push --prefix UNSa/TPxx profe-tpN jose-david

# ─── VERIFICACIÓN ─────────────────────────────────────────────

# Ver todos los remotos configurados
git remote -v

# Ver ramas del remoto del profesor
git branch -r | grep profe-tpN
```

---

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

### 2. El `git subtree push` tarda mucho o se queda procesando

**Por qué sucede:** `git subtree push` recorre **todo** el historial de commits del monorepo buscando los que afectan al prefijo indicado. En repositorios con muchos commits, esto puede tardar unos segundos.

**Qué hacer:** Es normal. Esperá a que termine. Verás mensajes como `1/XX (0)`, `2/xx (0)`, etc. mientras procesa los commits. Al finalizar, mostrará los objetos enviados o `Everything up-to-date` si no hay nada nuevo.

### 3. Error: `Updates were rejected because the tip of your current branch is behind`

**Por qué sucede:** Alguien (probablemente el profesor) modificó tu rama remota directamente. Esto no debería ocurrir en el flujo normal.

**Solución:** Contactá al profesor para confirmar si hizo cambios en tu rama. Si es necesario, podés forzar el envío (con precaución):
```bash
git push profe-tpN $(git subtree split --prefix UNSa/TPxx):jose-david --force
```

### 4. Error: `fatal: 'profe-tpN' does not appear to be a git repository`

**Por qué sucede:** El remoto no está configurado. Probablemente estás en otro equipo (cambiaste de Hackintosh a MacBook o viceversa) y olvidaste configurar el remoto allí.

**Solución:** Ejecutá el setup inicial (Paso 1 y 2 de la sección anterior). Los remotos son configuraciones locales y deben existir en cada equipo donde trabajes.
