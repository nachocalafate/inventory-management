Inventory Management System

Este proyecto es una aplicación de backend robusta desarrollada en Java utilizando el framework Spring Boot y PostgreSQL como motor de base de datos relacional. 

El objetivo principal es ofrecer una API eficiente para el control de stock, productos y almacenamiento, aplicando las mejores prácticas del desarrollo de software.

---

Tecnologías y Herramientas

* Lenguaje: Java 25
* Framework Principal: Spring Boot (Data JPA, Web)
* Base de Datos: PostgreSQL
* Gestor de Dependencias: Maven
* Control de Versiones: Git & GitHub

---

Arquitectura del Proyecto

El proyecto está estructurado siguiendo una arquitectura en capas para garantizar la escalabilidad, el desacoplamiento y la facilidad de mantenimiento:

**`model` / `entity`:** Definición de las entidades que mapean directamente con las tablas de PostgreSQL (JPA).
**`repository`:** Interfaces que extienden de `JpaRepository` para el acceso a datos y consultas optimizadas.
**`service`:** Capa de lógica de negocio donde se procesan las reglas del sistema de inventario.
**`controller`:** Controladores REST encargados de exponer los endpoints y recibir las peticiones HTTP.

---

Estado Actual del Proyecto

El puente de comunicación y el repositorio base en GitHub ya están completamente configurados y sincronizados mediante Git. 

Actualmente, el proyecto se encuentra en la fase inicial de desarrollo, enfocada en:
1. El modelado de las entidades de la base de datos en PostgreSQL.
2. La configuración de las propiedades de conexión de la app (`application.properties`).
3. La creación de la estructura limpia de paquetes en el entorno local.
