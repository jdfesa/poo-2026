# Arquitectura y Flujo de Trabajo (Workflow)

Este documento detalla la estrategia adoptada para la gestión del código fuente en este monorepo. El objetivo principal es mantener un historial de desarrollo limpio, centralizado y semántico, cumpliendo al mismo tiempo con los requisitos académicos de entrega en repositorios individuales.

## 🛑 El Problema: Fragmentación del Historial
Las cátedras, en particular la de la UNSa, exigen que cada Trabajo Práctico (TP) se entregue en un repositorio individual pre-generado (por ejemplo, `ramblas98/POO26_TP1`). 
Si se clonara y trabajara directamente en cada uno de estos repositorios, se generarían los siguientes inconvenientes:
1. **Fragmentación del conocimiento:** El código y la evolución del aprendizaje quedarían dispersos en decenas de repositorios inconexos.
2. **Dificultad de mantenimiento:** Actualizar configuraciones compartidas o reutilizar código entre TPs se vuelve tedioso y propenso a errores.
3. **Impacto en el Portfolio:** Un perfil de GitHub lleno de repositorios minúsculos ("micro-repos") no refleja adecuadamente la capacidad de un desarrollador para gestionar proyectos complejos o estructurar arquitecturas escalables.

## ✅ La Solución: Monorepo + Git Subtree
Para resolver este conflicto entre la *necesidad académica* (repositorios separados) y la *buena práctica de ingeniería* (código centralizado y mantenible), se adoptó una arquitectura de **Monorepo**.

Todo el ciclo de vida del desarrollo ocurre dentro del repositorio `poo-2026`. Para satisfacer las entregas, se utiliza el comando `git subtree`. 

### ¿Por qué `git subtree`?
A diferencia de `git submodule` (que enlaza repositorios externos hacia adentro) o de copiar archivos manualmente (que pierde el historial de commits), `git subtree` permite **extraer una subcarpeta específica junto con todo su historial de commits** y enviarla a un repositorio remoto independiente.

**Beneficios de esta arquitectura:**
- **Single Source of Truth:** Un único lugar donde buscar cualquier código escrito durante el año.
- **Historial Preservado:** Cuando el profesor revisa el repositorio del TP, no ve un único commit masivo ("subiendo archivos"), sino el historial detallado y paso a paso del desarrollo (demostrando el uso de *Conventional Commits*).
- **Demostración de Seniority:** Evidencia la capacidad de resolver problemas de infraestructura de código y el dominio de herramientas avanzadas de Git.

---

## 💻 Flujo de Trabajo Diario (Sincronización)
El desarrollo se alterna entre dos equipos físicos (Hackintosh y MacBook). Para garantizar la consistencia y evitar conflictos, se sigue un flujo de trabajo estricto:

1. **Al iniciar la jornada (Sincronización inicial):**
   ```bash
   git pull origin main
   ```

2. **Desarrollo y Commits Semánticos:**
   Se utiliza el estándar *Conventional Commits* para mantener un historial legible y autodescriptivo. Ejemplos:
   - `feat(unsa-tp1): implementar patrón Strategy para cálculo de impuestos`
   - `fix(ies-tp2): corregir desbordamiento de índice en la lista de alumnos`
   - `refactor(unsa-tp1): modularizar clases de persistencia de datos`
   - `docs(general): actualizar diagramas UML en el README`

3. **Al finalizar la jornada (Respaldo):**
   ```bash
   git push origin main
   ```

---

## 🚀 Proceso de Entrega de TPs al Profesor

Una vez que un TP ha sido completado y testeado localmente dentro del monorepo, se procede a la entrega oficial. Este proceso extrae la carpeta del TP y la envía al repositorio designado por la cátedra.

**Paso 1: Configurar el remoto del profesor (Solo una vez por TP)**
Se añade el repositorio destino como un nuevo "remote" local.
```bash
git remote add profe-tp1 https://github.com/ramblas98/POO26_TP1.git
```

**Paso 2: Aislamiento y envío mediante Subtree**
Este es el comando clave. Se le indica a Git que tome únicamente el historial que afectó a la carpeta `UNSa/TP01` y lo empuje a la rama `main` del remoto `profe-tp1`.

*(Nota: Reemplazar `main` por el nombre de la rama requerida por la cátedra si fuese distinto, ej. `master`).*

```bash
git subtree push --prefix UNSa/TP01 profe-tp1 main
```

**Resultado:** El profesor recibe un repositorio que contiene únicamente los archivos de su materia, en la raíz del mismo, pero con todo el historial de commits detallado que demuestra cómo se construyó la solución paso a paso.