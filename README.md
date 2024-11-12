# Foro Alura: Un espacio para conectar y aprender

Este proyecto es un foro online desarrollado con **Spring Boot**, donde los usuarios pueden crear temas, responder a otros y participar en conversaciones.

## Características

- **Creación de temas**: Los usuarios pueden crear nuevos temas con un título y un mensaje.
- **Respuestas**: Los usuarios pueden responder a los temas existentes, creando una conversación.
- **Lista de temas**: Se puede visualizar una lista de todos los temas creados.
- **Autenticación**: Se requiere autenticación con **JWT** para crear o eliminar temas.

## Tecnologías

- **Spring Boot**: Framework Java para desarrollo web.
- **Java**: Lenguaje de programación.
- **Spring Security**: Framework para la gestión de seguridad.
- **JSON Web Tokens (JWT)**: Para la autenticación de usuarios.
- **MySQL**: Sistema de gestión de bases de datos.
- **Flyway**: Herramienta para la gestión de migraciones de la base de datos.
- **Lombok**: Biblioteca para reducir la verbosidad del código Java.
- **Maven**: Gestor de dependencias y herramienta de construcción.
- **Swagger**: Herramienta para documentar y probar la API de forma visual.

## Cómo ejecutar el proyecto

1. Clona el repositorio:
   ```bash
   git clone https://github.com/Abner-Hernandez/Foro_Hub_API
   ```
2. Instala las dependencias:
   ```bash
   mvn install
   ```
3. Configura la base de datos:
    - Crea una base de datos llamada `foro_alura`.
    - Configura las credenciales de la base de datos en el archivo `application.properties`.
4. Ejecuta las migraciones de Flyway:
   ```bash
   mvn flyway:migrate
   ```
5. Ejecuta la aplicación:
   ```bash
   mvn spring-boot:run
   ```

## Documentación de la API

### Swagger

El proyecto utiliza **Swagger** para documentar y probar la API de manera interactiva. Puedes acceder a la interfaz de Swagger en la siguiente URL después de haber iniciado la aplicación:

- [Server Host]/swagger-ui.html

Además, puedes obtener la documentación de la API en formato JSON a través de la ruta:

- [Server Host]/v3/api-docs

**Nota:** La configuración de seguridad permite el acceso a la documentación de Swagger y los endpoints de la API sin autenticación previa:

```java
.requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll()
```

### Postman

También puedes acceder a la documentación de la API en Postman a través del siguiente enlace:

[Documentación de Postman](https://crimson-equinox-101308.postman.co/workspace/Trabajo~0a45147a-ab98-42b7-9f74-1d98468c6be2/collection/23720129-fab89419-7b46-45b7-9e7b-b4eda9f3895d?action=share&creator=23720129&active-environment=23720129-cb34fd85-c6a4-48c7-ad77-ef0ae1e59e9c)

## Información adicional

- El proyecto utiliza **Lombok** para reducir la verbosidad del código Java.
- **Flyway** se encarga de gestionar las migraciones de la base de datos.
- **Spring Security** con **JWT** se utiliza para la autenticación de usuarios.
- **Maven** se utiliza para gestionar las dependencias y construir el proyecto.
 solo está documentado en Postman, sino que también tiene un acceso fácil a través de Swagger UI. ¡Todo está listo para ser probado y documentado de manera eficiente!
