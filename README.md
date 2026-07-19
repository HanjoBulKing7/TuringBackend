# Arpegio Backend

Tienda de instrumentos musicales — API REST con Spring Boot.

## Requisitos
- Java 21
- Maven 3.9+
- PostgreSQL (o usa H2 en memoria para pruebas rápidas, ya configurado)

## Stack
- Spring Boot 3.5.4
- Spring Security + JWT
- Spring Data JPA
- PostgreSQL
- MapStruct

## Configuración
1. Clona el repo:
git clone https://github.com/HanjoBulKing7/TuringBackend.git
cd TuringBackend
2. Configura tu base de datos en `src/main/resources/application.properties`:
spring.datasource.url=jdbc:postgresql://localhost:5432/arpegio
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password
3. Ejecuta:
./mvnw spring-boot:run
4. La API corre en `http://localhost:8080`

## Autenticación
1. Crea un usuario admin (se genera automático al arrancar: usuario `admin`, password `admin1234`) o regístrate en `POST /api/auth/signup`.
2. Login en `POST /api/auth/login` con `{ "username": "...", "password": "..." }`.
3. Copia el token de la respuesta y agrégalo como header: `Authorization: Bearer <token>`.

## Colección de Postman
Importa `docs/Arpegio.postman_collection.json` y `postman/Arpegio.postman_environment.json` para probar todos los endpoints ya configurados.

## Endpoints principales
- `GET/POST/PUT/DELETE /api/categories`
- `GET/POST/PUT/DELETE /api/instruments`
- `GET /api/instruments/category/{id}`
- `POST /api/auth/login`
