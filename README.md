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

El backend del sistema se encuentra completamente estructurado, funcional y probado de punta a punta. La API cuenta con todas sus capas de desarrollo configuradas, comunicadas y sincronizadas con el repositorio en GitHub, incluyendo manejo de errores y validaciones robustas.

**Avances completados:**

* Configuración Base: Estructura limpia de paquetes y propiedades de conexión a PostgreSQL (`application.properties`).
* Modelo de Datos: Entidades principales modeladas en Java mediante JPA/Hibernate.
* Capa de Transferencia (DTOs): Creación e implementación de los Data Transfer Objects para desacoplar las entidades.
* Mapeo de Datos: Configuración de componentes `mappers` para la conversión limpia entre Entidades y DTOs.
* Capa de Persistencia (Repositories): Implementación de interfaces que heredan de Spring Data JPA para el acceso a datos.
* Lógica de Negocio (Services): Construcción de los servicios que manejan las reglas del negocio del sistema, incluyendo control de stock automático en compras y ventas.
* Capa de Exposición (Controllers): Creación de los controladores REST para exponer los endpoints de la API.
* Manejo Global de Excepciones: Implementación de `@RestControllerAdvice` para capturar errores de forma centralizada y devolver respuestas HTTP limpias y consistentes (404, 400, 500).
* Validaciones: Incorporación de Bean Validation (`@NotBlank`, `@NotNull`, `@Positive`, `@Email`) en los DTOs de entrada, con manejo automático de errores de validación.
* Test: Pruebas y validación de endpoints utilizando dependencia Swagger UI (springdoc-openapi).

**Próximos pasos en desarrollo:**

* Autenticación y autorización de usuarios con Spring Security y JWT.
