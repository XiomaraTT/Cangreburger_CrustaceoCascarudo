# Sistema Cangreburger - Crustáceo Cascarudo

Proyecto desarrollado en Java que simula el sistema de gestión de pedidos del restaurante ficticio **Crustáceo Cascarudo**, inspirado en el universo de Bob Esponja.

El sistema permite gestionar clientes, mesas, pedidos y el menú del restaurante utilizando diferentes estructuras de datos y patrones de diseño, aplicando conceptos fundamentales de la Ingeniería de Software.

---

## Tecnologías utilizadas

* Java
* Maven
* Spring Boot
* Thymeleaf
* HTML
* IntelliJ IDEA

---

## Estructuras de Datos Implementadas

Este proyecto utiliza distintas estructuras de datos para representar el funcionamiento interno del restaurante.

| Estructura | Uso en el sistema                            |
| ---------- | -------------------------------------------- |
| Árbol      | Gestión y organización del menú de platos    |
| Cola       | Procesamiento de pedidos en orden de llegada |
| Lista      | Registro y almacenamiento de clientes        |
| Pila       | Historial de acciones realizadas             |
| Arreglo    | Gestión de mesas disponibles                 |

Estas estructuras permiten simular de forma eficiente el flujo de información dentro del sistema.

---

## Arquitectura del proyecto

El sistema sigue una organización basada en una estructura similar al patrón **MVC (Model - View - Controller)**.

Estructura del proyecto:
```
src
├── Controller
│   ├── ClienteController
│   ├── MesaController
│   ├── PedidoController
│   ├── MenuController
│   └── HistorialController
│
├── Repository
│   ├── ClienteRepository
│   ├── MesaRepository
│   ├── PedidoRepository
│   ├── PlatoRepository
│   └── HistorialAccionRepository
│
├── Estructuras
│   ├── Arbol
│   ├── Cola
│   ├── Lista
│   ├── Pila
│   └── Arreglo
│
├── Patrones
│   └── Singleton
│
└── resources
    └── templates
```
---

## Funcionalidades del sistema

* Gestión de clientes
* Gestión de mesas
* Registro y procesamiento de pedidos
* Visualización del menú de platos
* Historial de acciones del sistema
* Simulación del flujo de pedidos dentro del restaurante

---

## Objetivo del proyecto

El objetivo de este proyecto es aplicar conceptos de **estructuras de datos, patrones de diseño y organización de software** en un sistema práctico que represente la operación básica de un restaurante.

Además, busca reforzar el uso de **arquitecturas organizadas y buenas prácticas en el desarrollo de software**.

---

## Cómo ejecutar el proyecto

1. Clonar el repositorio: git clone https://github.com/XiomaraTT/Cangreburger_CrustaceoCascarudo.git
2. Abrir el proyecto en IntelliJ IDEA.
3. Ejecutar la clase principal: Main.java
4. Abrir el navegador en: http://localhost:8080

---

## Autora

Xiomara Torres Tupia - 
Estudiante de Ingeniería de Software

Proyecto académico enfocado en la aplicación práctica de estructuras de datos y diseño de software.
