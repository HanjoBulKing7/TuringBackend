# Arpegio Backend 🎛️🍃

API REST con Spring Boot para gestionar el catálogo, usuarios y la lógica de negocio de la tienda de instrumentos musicales Arpegio.

## 🛠️ Stack y Dependencias Principales

La arquitectura está diseñada para ser robusta y escalable:

*   **Java 21 & Spring Boot 3.5.4:** Base del framework.
*   **Spring Web:** Para la construcción de los controladores y endpoints RESTful.
*   **Spring Security + JJWT:** Capa de seguridad que gestiona la autenticación, autorización y la validación de tokens JWT sin estado.
*   **Spring Data JPA & Hibernate:** ORM para la persistencia y consulta de datos.
*   **PostgreSQL:** Base de datos principal (el proyecto está preparado para conectarse a instancias en la nube como Supabase).
*   **H2 Database:** Base de datos relacional en memoria, disponible para pruebas locales rápidas sin configuración externa.
*   **MapStruct:** Generador de código para el mapeo automático y eficiente entre Entidades de base de datos y objetos de transferencia (DTOs).
*   **Lombok:** Herramienta que reduce el código repetitivo en tiempo de compilación (getters, setters, constructores).
*   **Spring Validation:** Para validar la integridad de los datos entrantes en los *payloads* de las peticiones.

## 🚀 Requisitos y Configuración Local

Asegúrate de tener instalado:
* Java 21
* Maven 3.9+

1. **Clonar el repositorio:**
```bash
   git clone [https://github.com/HanjoBulKing7/TuringBackend.git](https://github.com/HanjoBulKing7/TuringBackend.git)
   cd TuringBackend
```
Configurar la base de datos:
Modifica tu archivo src/main/resources/application.properties o inyecta variables de entorno con tus credenciales locales/remotas:

### Properties
spring.datasource.url=jdbc:postgresql://localhost:5432/arpegio
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password

_(Nota: La consola de H2 está habilitada en /h2-console si necesitas inspeccionar datos en memoria durante el desarrollo)_

2. **Ejecutar el proyecto:**

````
./mvnw spring-boot:run
````

_La API estará disponible en:_

http://localhost:8080

# 🔐 Autenticación
Crea un usuario admin (se genera automático al arrancar: username: "admin", password: "admin1234") o regístrate a través de POST /api/auth/signup.

Inicia sesión en POST /api/auth/login enviando:

### JSON
````
{
  "username": "tu_usuario",
  "password": "tu_password"
}
`````
Copia el token JWT devuelto en la respuesta y agrégalo como header en tus peticiones protegidas:
Authorization: Bearer <token>

_La colección de Postman exportada en este repositorio incluye un script en la request para iniciar sesión donde asigna el token a una variable de entorno que se incrusta en automatico a cada request para ahorrar tiempo_

### 📚 Colección de Postman
Importa los archivos docs/Arpegio.postman_collection.json y postman/Arpegio.postman_environment.json en Postman para probar todos los endpoints preconfigurados.

Endpoints principales:

GET / POST / PUT / DELETE /api/categories

GET / POST / PUT / DELETE /api/instruments

GET /api/instruments/category/{id}

POST /api/auth/login


### Por:

_Johan Yahir Villalpando Ibarra_

Ingeniero en Desarrollo y Gestión de Software
