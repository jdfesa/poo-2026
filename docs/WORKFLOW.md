# Flujo de Trabajo y Entregas (Workflow)

Este documento detalla el problema de sincronización académica y la arquitectura de Git adoptada para resolverlo, manteniendo buenas prácticas de desarrollo.

## 🛑 El Problema
La cátedra de la UNSa requiere que las entregas se realicen en repositorios individuales generados por el profesor para cada Trabajo Práctico (ej. `ramblas98/POO26_TP1`). 
Trabajar directamente clonando cada repositorio fragmenta el historial de código, ensucia el perfil de GitHub con decenas de repositorios pequeños y dificulta el mantenimiento de un portfolio unificado.

## ✅ La Solución: Monorepo + Git Subtree
Se adoptó una arquitectura de *Monorepo*. Todo el código se desarrolla en `poo-2026`. Para las entregas, se utiliza el comando `git subtree`, el cual permite extraer únicamente la carpeta correspondiente a un TP específico (con todo su historial de commits) y enviarla al repositorio remoto del profesor.

---

## 💻 Flujo de Trabajo Diario (Sincronización)
El desarrollo se alterna entre dos equipos físicos (Hackintosh y MacBook). Para evitar conflictos, se sigue estrictamente este flujo:

1. **Al iniciar la jornada (Obligatorio):**
   ```bash
   git pull origin main
   ```

2. **Desarrollo y Commits:**
   Se utiliza el estándar *Conventional Commits* para mantener un historial semántico:
   - `feat(unsa-tp1): resolver ejercicio de herencia`
   - `fix(ies-tp2): corregir error de identación en python`
   - `refactor(unsa-tp1): optimizar bucle for`
   - `docs(general): actualizar readme`

3. **Al finalizar la jornada:**
   ```bash
   git push origin main
   ```

---

## 🚀 Proceso de Entrega de TPs al Profesor

Cuando un TP está finalizado dentro del monorepo y listo para ser evaluado:

**Paso 1: Agregar el remoto del profesor (Solo una vez por TP)**
```bash
git remote add profe-tp1 https://github.com/ramblas98/POO26_TP1.git
```

**Paso 2: Enviar la carpeta específica mediante Subtree**
Reemplazar `main` por el nombre de la rama requerida por la cátedra si es necesario.

```bash
git subtree push --prefix UNSa/TP01 profe-tp1 main
```

Este comando aísla la carpeta `UNSa/TP01`, preserva sus convenciones de commits y la empuja al repositorio destino.