# POO 2026 - Monorepo Académico

Este repositorio contiene los trabajos prácticos, ejercicios y proyectos de la materia Programación Orientada a Objetos (POO), cursada en paralelo durante el ciclo lectivo 2026 en dos instituciones:
- **[UNSa (Universidad Nacional de Salta)](./UNSa/README.md):** Desarrollo enfocado en Java.
- **IES N° 6023:** Desarrollo enfocado en Python.

## 📂 Estructura del Repositorio

El proyecto está organizado como un *monorepo* para separar los entornos y lenguajes de cada institución:

```text
poo-2026/
├── IES6023/                 # Entorno Python
│   ├── TP01/
│   └── TP02/
├── UNSa/                    # Entorno Java
│   ├── desafio_repaso/      # Ejercicios de programación estructurada extra
│   ├── TP01/
│   └── TP02/
└── docs/                    # Documentación interna
    ├── adr/
    │   └── 0001-estrategia-monorepo.md # Justificación arquitectónica
    │   └── 0002-estrategia-gitignore-multinivel.md
    └── WORKFLOW.md          # Guía del flujo de trabajo y entregas
```

## ⚙️ Flujo de Trabajo y Decisiones de Diseño

Para mantener el control del historial de versiones en un único lugar y al mismo tiempo cumplir con los requisitos de entrega individuales de cada cátedra, este proyecto utiliza una estrategia de múltiples remotos combinada con `git subtree`.

La documentación del proyecto se divide siguiendo las mejores prácticas en la industria del software:

* **[Flujo de Trabajo (WORKFLOW.md)](./docs/WORKFLOW.md):** Manual operativo para el día a día. Contiene los comandos exactos de sincronización y publicación de las entregas usando *Conventional Commits*.
* **[Decisiones de Diseño (ADR 0001)](./docs/adr/0001-estrategia-monorepo.md):** Explica en detalle *por qué* se eligió usar un Monorepo con `git subtree`, abordando el problema de la fragmentación del historial y demostrando prácticas avanzadas de ingeniería de software.
* **[Estrategia .gitignore Multinivel (ADR 0002)](./docs/adr/0002-estrategia-gitignore-multinivel.md):** Justifica la arquitectura de exclusión de archivos multinivel adoptada para asegurar que el repositorio de destino (el del profesor) reciba un código fuente limpio y bien configurado.