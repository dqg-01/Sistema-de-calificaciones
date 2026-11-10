
# Sistema de Calificaciones - UCO

Proyecto académico desarrollado en Java con Spring Boot y MySQL para gestionar calificaciones de estudiantes.

## Funcionalidades

- Registrar y consultar estudiantes.
- Registrar y consultar materias.
- Registrar calificaciones entre 0.0 y 5.0.
- Registrar incidentes de uso del celular en clase.
- Descontar 0.1 puntos por incidente.
- Consultar la nota original, los incidentes, el descuento y la nota final.
- Evitar que la nota final sea inferior a 0.

## Tecnologías

- Java 26
- Spring Boot 4.1.2
- Spring Data JPA
- MySQL 8
- Swagger UI
- Maven
- Git y GitHub

## Requisitos

- Java 26
- MySQL 8
- Base de datos llamada `uco_calificaciones`
- Usuario MySQL con permisos sobre esa base de datos

## Ejecución

1. Crear la base de datos en MySQL:

   CREATE DATABASE uco_calificaciones;

2. Configurar el usuario de MySQL en `application.properties`.

3. Configurar la variable de entorno `DB_PASSWORD`.

4. Ejecutar desde la carpeta del proyecto:

   .\mvnw.cmd spring-boot:run

5. Abrir Swagger UI:

   http://localhost:8080/swagger-ui.html

## Ejemplo

Un estudiante obtiene una nota original de 4.5.

Si registra dos incidentes de uso del celular:

- Nota original: 4.5
- Descuento: 0.2
- Nota final: 4.3

La nota original se conserva y el descuento se calcula automáticamente.

