**Inventory Management System**

Este proyecto es una aplicación de backend robusta desarrollada en Java utilizando el framework Spring Boot y PostgreSQL como motor de base de datos relacional. 

El objetivo principal es ofrecer una API eficiente para el control de stock, productos y almacenamiento, aplicando las mejores prácticas del desarrollo de software.

---

**Tecnologías y Herramientas**

**Lenguaje:** Java 25
**Framework Principal:** Spring Boot (Data JPA, Web)
**Base de Datos:** PostgreSQL
**Gestor de Dependencias:** Maven
**Control de Versiones:** Git & GitHub

---

Arquitectura del Proyecto

El proyecto está estructurado siguiendo una arquitectura en capas para garantizar la escalabilidad, el desacoplamiento y la facilidad de mantenimiento:

**`model` / `entity`:** Definición de las entidades que mapean directamente con las tablas de PostgreSQL (JPA).
**`repository`:** Interfaces que extienden de `JpaRepository` para el acceso a datos y consultas optimizadas.
**`service`:** Capa de lógica de negocio donde se procesan las reglas del sistema de inventario.
**`controller`:** Controladores REST encargados de exponer los endpoints y recibir las peticiones HTTP.

---

**Estado Actual del Proyecto**

El puente de comunicación y el repositorio base en GitHub ya están completamente configurados y sincronizados mediante Git. Actualmente, el proyecto ha superado su configuración inicial y se encuentra en pleno desarrollo de la capa de datos y transferencia.

**Avances completados:**
- [x] **Configuración Base:** Estructura limpia de paquetes generada en el entorno local.
- [x] **Propiedades del Sistema:** Configuración completa de las propiedades de conexión a la base de datos PostgreSQL (`application.properties`).
- [x] **Modelo de Datos:** Modelado y actualización de las entidades principales en Java (como `Product.java`).
- [x] **Capa de Transferencia (DTOs):** Creación e implementación de todos los Data Transfer Objects (DTOs) de las clases del sistema para desacoplar la base de datos de la vista.

**Próximos Pasos en Desarrollo:**
- [ ] Implementación de los componentes de mapeo (`mappers`) para la conversión Entidad-DTO.
- [ ] Configuración de la capa de persistencia mediante repositorios de Spring Data JPA (`repository`).
- [ ] Construcción de la lógica de negocio en la capa de servicios (`service`).
