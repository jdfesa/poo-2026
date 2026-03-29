# ADR 0001: Estrategia de Monorepo y Git Subtree

**Fecha:** 2026-03-29
**Estado:** Aceptado

## Contexto
El desarrollo de la materia Programación Orientada a Objetos (POO) en 2026 requiere la resolución de Trabajos Prácticos (TPs) para dos instituciones distintas (UNSa e IES N° 6023). 
Particularmente, la cátedra de la UNSa exige que cada TP sea entregado en un repositorio remoto individual creado específicamente para esa tarea (ej. `ramblas98/POO26_TP1`).

Si se trabajara clonando directamente cada repositorio generado por el profesor:
- **Fragmentación del conocimiento:** El código fuente y el progreso del aprendizaje estarían dispersos en múltiples repositorios aislados.
- **Micro-repos en el Portfolio:** El perfil de GitHub se saturaría de proyectos muy pequeños que no reflejan la capacidad de organizar sistemas complejos.
- **Mantenimiento deficiente:** Reutilizar utilidades o configuraciones entre distintos trabajos prácticos sería complicado.

## Decisión
Se decidió adoptar una arquitectura de **Monorepo** (`poo-2026`) para todo el ciclo de desarrollo, centralizando el código de ambas instituciones.

Para cumplir con el requisito de entrega en repositorios individuales, se utiliza el comando **`git subtree`**. 
Esta herramienta permite extraer una subcarpeta específica del monorepo junto con todo su historial de commits y empujarla hacia un remoto externo e independiente.

## Consecuencias

### Positivas
- **Single Source of Truth (Única fuente de verdad):** Existe un solo lugar donde encontrar y buscar todo el código cursado durante el año.
- **Historial Limpio y Profesional:** Al empujar con `subtree`, se conservan los mensajes de los commits originales (ideal para demostrar el uso de *Conventional Commits*), enviando al profesor un repositorio limpio que refleja el proceso de desarrollo paso a paso, no solo el resultado final.
- **Portfolio Sólido:** En lugar de decenas de repositorios pequeños, se presenta un único proyecto estructurado, demostrando conocimientos avanzados en control de versiones y arquitectura de repositorios.

### Negativas
- **Complejidad operativa:** Requiere recordar comandos más avanzados de Git (`git subtree push --prefix ...`) en lugar de un simple `git push`. (Mitigado mediante la documentación del flujo en [WORKFLOW.md](../WORKFLOW.md)).