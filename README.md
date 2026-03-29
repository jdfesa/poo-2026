# POO 2026 - Monorepo Académico

Este repositorio contiene los trabajos prácticos, ejercicios y proyectos de la materia Programación Orientada a Objetos (POO), cursada en paralelo durante el ciclo lectivo 2026 en dos instituciones:
- **UNSa (Universidad Nacional de Salta):** Desarrollo enfocado en Java.
- **IES N° 6023:** Desarrollo enfocado en Python.

## 📂 Estructura del Repositorio

El proyecto está organizado como un *monorepo* para separar los entornos y lenguajes de cada institución:

```text
poo-2026/
├── IES6023/                 # Entorno Python
│   ├── TP01/
│   └── TP02/
├── UNSa/                    # Entorno Java
│   ├── TP01/
│   └── TP02/
└── docs/                    # Documentación interna
    └── WORKFLOW.md          # Guía del flujo de trabajo y entregas
```

## ⚙️ Flujo de Trabajo

Para mantener el control del historial de versiones en un único lugar y al mismo tiempo cumplir con los requisitos de entrega individuales de cada cátedra, este proyecto utiliza una estrategia de múltiples remotos combinada con `git subtree`.

Para ver el detalle de los comandos de sincronización, convenciones de commits y el proceso de entrega, por favor revisa el archivo [WORKFLOW.md](./docs/WORKFLOW.md).