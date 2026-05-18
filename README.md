# 🔴 Pokémon Rojo Fuego - Database Manager

Este proyecto es una aplicación de escritorio desarrollada en **Java** como trabajo final para el módulo de **Programacion** (DAW). Se trata de un gestor avanzado que permite administrar entrenadores y sus equipos Pokémon, utilizando persistencia de datos y una interfaz gráfica moderna.

## 🚀 Funcionalidades Principales

### 👨‍🏫 Gestión de Entrenadores (Relación "Uno")
* **CRUD Completo**: Registro, edición, consulta y borrado de entrenadores.
* **Visualización de Equipos**: Al seleccionar un entrenador, se muestran automáticamente sus Pokémon asociados gracias a la relación `OneToMany`.
* **Cálculos en tiempo real**: Sistema para actualizar masivamente el dinero de los entrenadores o contar sus Pokémon.

### 🦅 Gestión de Pokémon (Relación "Muchos")
* **Inventario Global**: Lista paginada de todos los Pokémon registrados en la base de datos.
* **Sistema de Sprites (BLOB)**: Almacenamiento y recuperación de imágenes reales de Pokémon directamente desde la base de datos SQLite.
* **Buscador Dinámico**: Filtro en tiempo real por nombre, especie o ID.
* **Validaciones de Reglas de Negocio**:
    * Nivel limitado entre 1 y 100.
    * Restricción de máximo 6 Pokémon por equipo de entrenador.

## 🛠️ Stack Tecnológico

* **Lenguaje:** Java 17+
* **Persistencia:** JPA (EclipseLink)
* **Base de Datos:** SQLite
* **Interfaz Gráfica:** Swing + FlatLaf (Look and Feel moderno)
* **Gestión de dependencias:** Maven
* **Arquitectura:** Patrón DAO (Data Access Object)

## 📋 Requisitos Técnicos Implementados

- [x] **Relación OneToMany:** Mapeo bidireccional entre `Entrenador` y `Pokemon`.
- [x] **Paginación:** Navegación por registros de 10 en 10 mediante consultas nativas (`LIMIT` / `OFFSET`).
- [x] **Gestión de Imágenes:** Uso de objetos `BLOB` para los sprites.
- [x] **Consultas Personalizadas:** Uso de `NamedQueries` y consultas JPA para lógica específica.
- [x] **UI Avanzada:** Renderizadores personalizados para mostrar imágenes en `JTable` y alineación de datos.

## 🎨 Look & Feel
La aplicación utiliza la librería **FlatLaf** para ofrecer una estética limpia y profesional, alejándose del diseño estándar de Swing y permitiendo una mejor experiencia de usuario.

## 📦 Instalación y Ejecución

1. Clonar el repositorio:
   ```bash
   git clone [https://github.com/KuroiRyuuDev/PokemonRFDBM.git]
