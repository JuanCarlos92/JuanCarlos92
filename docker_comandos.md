# Cheat Sheet de Comandos Docker

---

## **Keywords:** docker, comandos docker, cheatsheet docker, docker tutorial, docker desde cero, gestión de contenedores, gestión de imágenes, volúmenes docker, redes docker

---

## 1. Instalación y Configuración del Entorno

Comandos iniciales para preparar Docker y gestionar permisos de usuario en sistemas Linux.

### Instalación de Docker Engine

```bash
# Instalación automática mediante script oficial
curl -fsSL https://get.docker.com -o get-docker.sh && sh get-docker.sh

# Ver ayuda y lista de comandos de Docker
docker
```

### Gestión de Usuarios y Permisos

```bash
# Introducir usuario actual en el grupo docker para evitar usar sudo
sudo usermod -a -G docker nombre_usuario

# Refrescar los grupos en la sesión actual sin reiniciar
newgrp docker
```

---

## 2. Gestión de Imágenes

Operaciones relacionadas con la búsqueda, descarga, exportación y versionado de imágenes.

### Búsqueda y Descarga

```bash
# Buscar una imagen en Docker Hub
docker search nginx

# Descargar una imagen desde el registro
docker pull nginx
```

### Listado

```bash
# Listar todas las imágenes instaladas localmente
docker images
```

### Tags: nombre y versión de imágenes

Las imágenes se identifican por `nombre:tag`. El tag suele representar la versión.

```bash
# Cambiar nombre o etiqueta de una imagen
docker tag mi-imagen:latest mi-imagen-v1:latest
```

Esto es clave para:

* versionado
* subida a repositorios
* despliegues controlados

---

## 3. Creación de Imágenes

### Crear imagen desde un contenedor (docker commit)

Permite crear una imagen a partir del estado actual de un contenedor (similar a un snapshot).

```bash
docker commit <container_id> <nombre_imagen>
```

Ejemplo:

```bash
docker commit 1234567890ab mi-imagen
```

Uso puntual. En entornos profesionales se prefiere **Dockerfile**.

---

### Exportar e importar imágenes (save / load)

Útil para mover imágenes entre sistemas sin usar repositorios remotos.

```bash
# Exportar imagen a fichero tar
docker save -o mi-imagen.tar mi-imagen

# Importar imagen desde fichero tar
docker load -i mi-imagen.tar
```

---

## 4. Ejecución de Contenedores (docker run)

### Ejecución básica

```bash
docker run nombre_imagen
```

### Modo interactivo

```bash
docker run -it nombre_imagen /bin/bash
```

### Modo detached y puertos

```bash
# Segundo plano + nombre + puerto
docker run -d --name web1 -p 8081:80 nginx
```

### Mapeo de puertos

```bash
# Host:Contenedor
docker run -d -p 8080:80 nombre_imagen

# Múltiples puertos
docker run -d -p 8080:80 -p 8081:81 nombre_imagen
```

---

## 5. Administración de Contenedores

### Visualización

```bash
# Contenedores activos
docker ps

# Todos los contenedores
docker ps -a
```

### Logs e inspección

```bash
docker logs id_contenedor
docker logs -f id_contenedor
docker inspect id_contenedor
```

### Interacción

```bash
# Ejecutar comando dentro del contenedor
docker exec id_contenedor ls

# Terminal interactiva
docker exec -it id_contenedor bash
```

Salir sin detener el contenedor:

> **Ctrl + P + Ctrl + Q**

---

## 6. Ciclo de Vida y Limpieza

### Start / Stop

```bash
docker start id_contenedor
docker stop id_contenedor
```

### Eliminación

```bash
# Eliminar contenedor
docker rm id_contenedor

# Eliminar todos los contenedores
docker rm $(docker ps -a -q)

# Eliminar imágenes
docker rmi $(docker images -q)

# Limpiar contenedores parados
docker container prune
```

---

## 7. Dockerfile y Build de Imágenes

Un **Dockerfile** define cómo se construye una imagen, capa a capa.

### Instrucciones principales

```dockerfile
FROM        # Imagen base
RUN         # Comandos de build
COPY        # Copiar archivos
WORKDIR     # Directorio de trabajo
CMD         # Comando por defecto
ENTRYPOINT  # Comando fijo
```

### Ejemplo Nginx

```dockerfile
FROM nginx:alpine
COPY index.html /usr/share/nginx/html/index.html
```

```bash
docker build -t mi-nginx .
docker run -d -p 8080:80 mi-nginx
```

### Ejemplo Python (simple)

```dockerfile
FROM python:alpine

WORKDIR /app

COPY script.py .

CMD ["python", "script.py"]
```

```bash
docker build -t mi-python .
docker run --rm mi-python
```

### Ejemplo Python con dependencias

```dockerfile
FROM python:alpine

WORKDIR /app

COPY requirements.txt .
RUN pip install -r requirements.txt

COPY script.py .

CMD ["python", "script.py"]
```

```bash
docker build -t mi-python-deps .
docker run --rm mi-python-deps
```

---

## 8. Dockerfile para Microservicio Spring Boot

### Multi-stage build (Maven + JRE)

```dockerfile
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
RUN chmod +x app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

```bash
docker build -t usuario/mi-microservicio:1.0 .
docker run -d --name mi-microservicio -p 8080:8080 usuario/mi-microservicio:1.0
```

---

## 9. Repositorios y Docker Hub

### Subir imágenes a Docker Hub

```bash
# Login
docker login

# Etiquetar imagen
docker tag mi-imagen:latest usuario/mi-imagen:latest

# Subir imagen
docker push usuario/mi-imagen:latest
```

### Descargar imagen

```bash
docker pull usuario/mi-imagen:latest
```

### Repositorios remotos alternativos

```bash
docker tag mi-imagen:latest github.com/usuario/mi-imagen:latest
docker push github.com/usuario/mi-imagen:latest
```

---

## 10. ENTRYPOINT, CMD, ARG y Variables de Entorno

### ENTRYPOINT vs CMD

```dockerfile
FROM alpine
ENTRYPOINT ["echo", "Hola"]
CMD ["Mundo"]
```

```bash
docker run saludador        # Hola Mundo
docker run saludador Docker # Hola Docker
```

### ARG (build-time)

```dockerfile
ARG NOMBRE="Mundo"
RUN echo "Hola $NOMBRE"
```

```bash
docker build --build-arg NOMBRE=Dockerman .
```

### Variables de entorno (runtime)

```bash
docker run -e DEBUG=1 mi-app
docker run -e SPRING_PROFILES_ACTIVE=prod -p 8080:8080 mi-microservicio
```

### Filosofía

* Contenedores agnósticos
* Configuración por variables
* Misma imagen para dev, test y prod

Esto es Docker en **entornos reales y profesionales**.

---

## 11. Volúmenes (Persistencia de Datos)

Los **volúmenes** permiten persistir datos fuera del ciclo de vida del contenedor.

### Crear y listar volúmenes

```bash
docker volume create mi-volumen
docker volume ls
```

### Usar volumen en un contenedor

```bash
# Volumen gestionado por Docker
docker run -d -v mi-volumen:/data nginx

# Bind mount (ruta del host)
docker run -d -v /ruta/host:/data nginx
```

### Inspeccionar y eliminar volúmenes

```bash
docker volume inspect mi-volumen
docker volume rm mi-volumen
docker volume prune
```

---

## 12. Redes Docker

Docker crea redes virtuales para comunicar contenedores.

### Listar y crear redes

```bash
docker network ls
docker network create mi-red
```

### Ejecutar contenedores en la misma red

```bash
docker run -d --name app --network mi-red mi-app
docker run -d --name db --network mi-red mysql
```

Los contenedores pueden comunicarse usando el **nombre del contenedor** como hostname.

---

## 13. Attach vs Exec

### Attach

Conecta al proceso principal del contenedor.

```bash
docker attach id_contenedor
```

Salir sin detenerlo:

> **Ctrl + P + Ctrl + Q**

### Exec (recomendado)

Ejecuta comandos adicionales dentro del contenedor.

```bash
docker exec -it id_contenedor /bin/bash
```

---

## 14. Comandos Útiles de Administración

### Parar y eliminar todo

```bash
# Parar todos los contenedores
docker stop $(docker ps -a -q)

# Eliminar todos los contenedores
docker rm $(docker ps -a -q)

# Eliminar todas las imágenes
docker rmi $(docker images -q)
```

### Commit avanzado

```bash
docker commit -a "Autor" -m "v1.0" id_contenedor repo:tag
```

### Obtener ruta de logs del contenedor

```bash
docker inspect --format='{{.LogPath}}' id_contenedor
```

---

## 15. Buenas Prácticas en Producción

* Usar **Dockerfile** en lugar de `docker commit`
* Imágenes pequeñas (alpine, distroless)
* Multi-stage builds
* Variables de entorno para configuración
* Un proceso por contenedor
* Versionar imágenes (evitar `latest` en prod)
* Usar volúmenes para datos persistentes

---

## 16. Limpieza General del Sistema

```bash
# Limpieza completa (cuidado)
docker system prune -a
```

Ideal para entornos de desarrollo.
