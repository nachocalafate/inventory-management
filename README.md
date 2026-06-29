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
### Estado Actual del Proyecto 🚀

El backend del sistema se encuentra completamente estructurado y con su arquitectura base finalizada. La API cuenta con todas sus capas de desarrollo configuradas, comunicadas y sincronizadas con el repositorio en GitHub.

**Avances e Hitos Completados:**
- [x] **Configuración Base:** Estructura limpia de paquetes y propiedades de conexión a PostgreSQL (`application.properties`).
- [x] **Modelo de Datos:** Entidades principales modeladas en Java mediante JPA/Hibernate.
- [x] **Capa de Transferencia (DTOs):** Creación e implementación de los Data Transfer Objects para desacoplar las entidades.
- [x] **Mapeo de Datos:** Configuración de componentes `mappers` para la conversión limpia entre Entidades y DTOs.
- [x] **Capa de Persistencia (Repositories):** Implementación de interfaces que heredan de Spring Data JPA para el acceso a datos.
- [x] **Lógica de Negocio (Services):** Construcción de los servicios que manejan las reglas del negocio del sistema.
- [x] **Capa de Exposición (Controllers):** Creación de los controladores REST para exponer los endpoints de la API.
- [x] **Test:** Pruebas y validación de endpoints utilizando dependencia Swagger UI.

**Próximos Pasos en Desarrollo:**
- [ ] Implementación de validaciones personalizadas en los DTOs (`@Valid`, `@NotNull`, etc.).
- [ ] Manejo global de excepciones (`@ControllerAdvice`) para respuestas limpias ante errores.
