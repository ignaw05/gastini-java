# ========================================
# ETAPA 1: BUILD (Compilación)
# ========================================
FROM alpine:latest as build

WORKDIR /app

# Actualizar e instalar OpenJDK 21
RUN apk update && apk add openjdk21

# Copiar archivos de configuración de Gradle
COPY build.gradle settings.gradle ./
COPY gradle ./gradle
COPY gradlew ./

# Dar permisos de ejecución al script gradlew
RUN chmod +x ./gradlew

# Descargar dependencias
RUN ./gradlew dependencies --no-daemon

# Copiar el código fuente
COPY src ./src

# Construir la aplicación
RUN ./gradlew bootJar --no-daemon

# ========================================
# ETAPA 2: RUNTIME (Ejecución)
# ========================================
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Crear usuario no-root por seguridad
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copiar el JAR generado
COPY --from=build /app/build/libs/gastini-0.0.1-SNAPSHOT.jar app.jar

# Exponer puerto (documentación)
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]