# Hexagon-Migration-Service

Sistema de gestión de ventas, productos y pedidos implementado con Arquitectura Hexagonal (Ports & Adapters).  
Este repositorio contiene la migración del proyecto anterior (migration-service-rest) a una arquitectura hexagonal para aislar la lógica de negocio de las tecnologías e infraestructuras.

## Tabla de contenidos
- [Visión general](#visión-general)
- [Arquitectura](#arquitectura)
- [Requisitos](#requisitos)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Cómo ejecutar](#cómo-ejecutar)
- [Configuración (ejemplo)](#configuración-ejemplo)
- [Base de datos](#base-de-datos)
- [Pruebas](#pruebas)
- [Despliegue con Docker (opcional)](#despliegue-con-docker-opcional)
- [Contribuir](#contribuir)
- [Licencia](#licencia)
- [Contacto](#contacto)

## Visión general
Hexagon-Migration-Service es una API de ventas que gestiona clientes, productos y pedidos. Ha sido reorganizada en una arquitectura hexagonal para:
- Mantener el dominio (reglas de negocio) independiente de frameworks y detalles de infraestructura.
- Facilitar reemplazo de tecnología (p. ej. JPA, DB) sin tocar la lógica de negocio.
- Hacer el código más testeable y con desacoplamiento de capas.

La imagen incluida en el repositorio (o la que acompaña a este README) muestra el flujo principal:
- Adaptadores de entrada: REST API (controladores), validaciones, manejo de excepciones.
- Capa de aplicación: Use Cases (crear/actualizar/listar).
- Dominio: entidades, reglas de negocio y puertos (interfaces).
- Adaptadores de salida: JPA Repositories, mappers y persistencia.
- Infraestructura: configuración de Spring, datasource, transacciones y DB (MariaDB).

## Arquitectura
La aplicación sigue el patrón Hexagonal (Ports & Adapters):
- Dominio (núcleo): entidades y reglas de negocio.
- Puertos: interfaces (ej. ClienteRepository, ProductoRepository, PedidoRepository).
- Adaptadores de entrada (Driving Adapters): REST controllers, validaciones, exception handlers.
- Adaptadores de salida (Driven Adapters): Implementaciones de repositorios (JPA), mappers y conexión a la base de datos.

Beneficios clave:
- Dominio independiente de frameworks y DB.
- Reglas de negocio en el centro.
- Fácil reemplazo de tecnologías.
- Código más testeable y preparado para escalar a microservicios.

## Requisitos
- Java 11+ (ajustar según el proyecto)
- Maven o Gradle (verifica el build tool en el repo)
- MariaDB (o MySQL compatible) para persistencia
- (Opcional) Docker / Docker Compose para levantar servicios localmente

## Estructura del proyecto (ejemplo conceptual)
- src/main/java
  - com.tuempresa.hexagon.domain        # Entidades y lógica de dominio
  - com.tuempresa.hexagon.application   # Use cases / casos de uso
  - com.tuempresa.hexagon.adapters.in   # Controladores REST, validaciones
  - com.tuempresa.hexagon.adapters.out  # Implementaciones de puertos (JPA adapters)
  - com.tuempresa.hexagon.infrastructure # Configuraciones, datasource, transacciones
- src/test/java                         # Tests unitarios e integraciones

> Nota: Ajusta los paquetes según la organización real del repositorio.

## Cómo ejecutar

1. Clona el repositorio:
   git clone https://github.com/victordaniel123rt-lang/Hexagon-Migration-Service.git
   cd Hexagon-Migration-Service

2. Build (Maven):
   - Si el proyecto usa Maven:
     - Con wrapper (si existe): ./mvnw clean package
     - Sin wrapper: mvn clean package
   - Si el proyecto usa Gradle:
     - ./gradlew build
     - o gradle build

3. Ejecutar:
   - Con Spring Boot empaquetado:
     java -jar target/*.jar
   - O desde el IDE ejecutando la clase principal de Spring Boot.

4. Verificar endpoints (ejemplos representativos):
   - GET  /api/clientes
   - POST /api/clientes
   - GET  /api/productos
   - POST /api/pedidos
   Ajusta las rutas reales según los controladores del proyecto.

## Configuración (ejemplo para Spring Boot)
En application.yml o application.properties configura la conexión a la base de datos:

application.yml (ejemplo)
```yaml
spring:
  datasource:
    url: jdbc:mariadb://localhost:3306/hexagon_db
    username: hex_user
    password: hex_password
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

Variables de entorno sugeridas:
- SPRING_DATASOURCE_URL
- SPRING_DATASOURCE_USERNAME
- SPRING_DATASOURCE_PASSWORD

## Base de datos
- Recomendado: MariaDB (imagen/versión compatible con MySQL).
- Asegúrate de crear la base de datos o permitir que JPA la cree según la propiedad `spring.jpa.hibernate.ddl-auto`.

## Pruebas
- Ejecuta tests unitarios/integración con:
  - Maven: mvn test
  - Gradle: ./gradlew test

Se recomienda agregar tests de unidad para:
- Reglas del dominio (validaciones, cálculos).
- Use cases (casos de uso).
- Adaptadores (mockear puertos para pruebas del dominio/aplicación).

## Despliegue con Docker (ejemplo básico)
docker-compose.yml (ejemplo)
```yaml
version: "3.8"
services:
  db:
    image: mariadb:10.11
    environment:
      MYSQL_DATABASE: hexagon_db
      MYSQL_USER: hex_user
      MYSQL_PASSWORD: hex_password
      MYSQL_ROOT_PASSWORD: root_password
    ports:
      - "3306:3306"
    volumes:
      - db_data:/var/lib/mysql

volumes:
  db_data:
```

Levantar:
- docker-compose up -d
- Ajustar SPRING_DATASOURCE_URL para apuntar a `jdbc:mariadb://db:3306/hexagon_db` cuando la app esté en otro contenedor.

## Buenas prácticas y recomendaciones
- Mantener el dominio libre de dependencias de frameworks.
- Implementar mappers entre entidad de dominio y entidad JPA en adaptadores de salida.
- Centralizar validaciones en el dominio cuando correspondan a reglas de negocio.
- Añadir pruebas de integración con una base de datos en memoria o contenedores (Testcontainers).

## Contribuir
1. Abre un issue para discutir cambios mayores.
2. Crea una rama feature/bugfix a partir de la rama principal.
3. Envía un Pull Request con descripción clara y pruebas cuando sea necesario.

## Licencia
Incluye aquí la licencia que prefieras (por ejemplo MIT). Si quieres, puedo añadir un archivo LICENSE con el texto correspondiente.

## Contacto
Mantente en contacto con el autor o el equipo del proyecto. Para cambios significativos, abre un issue primero.
