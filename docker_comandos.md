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

## 2. Gestión de Imágenes
Operaciones relacionadas con la búsqueda, descarga y creación de imágenes.

### Búsqueda y Descarga
```bash
# Buscar una imagen en Docker Hub
docker search nombre_contenedor

# Descargar una imagen desde el registro
docker pull nombre_imagen
```

### Listado y Organización
```bash
# Listar todas las imágenes instaladas localmente
docker images

# Crear una etiqueta (tag) personalizada para una imagen existente
docker tag b72889fa879c oldlts:latest
```

### Creación de Imágenes
```bash
# Crear una nueva imagen a partir de los cambios de un contenedor (Commit)
docker commit -a "información creador" -m "versión" id_container nombre_repositorio:tag
```

## 3. Ejecución de Contenedores (docker run)
Comandos para crear y poner en marcha contenedores con diferentes configuraciones.

### Ejecución Básica e Interactiva
```bash
# Iniciar un contenedor básico
docker run nombre_imagen

# Ejecutar y acceder a la terminal interactiva del contenedor
docker run -it id_imagen_o_nombre /bin/bash

# Ejecutar usando una etiqueta personalizada
docker run -it oldlts:latest /bin/bash
```

### Ejecución con Parámetros Avanzados
```bash
# Ejecutar en segundo plano (Modo Detached)
docker run -d identificador_imagen

# Configurar reinicio automático (Siempre activo)
docker run --restart always nombre_imagen

# Ejecutar con nombre personalizado y mapeo de puertos
docker run -d --name web1 -p 8081:80 nginx
```

### Mapeo de Puertos
```bash
# Un solo puerto (Host:Contenedor)
docker run -d -p 8080:80 nombre_imagen

# Múltiples puertos
docker run -d -p 8080:80 -p 8081:81 nombre_imagen

# Rango de puertos
docker run -d -p 8080-8085:80 nombre_imagen
```

## 4. Administración de Contenedores Activos
Comandos para inspeccionar y manipular contenedores que ya están corriendo.

### Visualización y Estado
```bash
# Ver solo los contenedores en ejecución
docker ps

# Ver todos los contenedores (incluyendo los detenidos)
docker ps -a
```

### Inspección y Logs
```bash
# Ver los logs de un contenedor
docker logs id_contenedor

# Seguir los logs en tiempo real
docker logs -f id_contenedor

# Obtener la ruta del archivo de registro (JSON log)
docker inspect --format='{{.LogPath}}' id_contenedor
```

### Interacción con el Contenedor
```bash
# Acoplarse a la salida de un contenedor en ejecución
docker attach id_o_nombre

# Ejecutar un comando (ej: ls) sin entrar al contenedor
docker exec id_contenedor ls

# Abrir una terminal en un contenedor que ya está en marcha
docker exec -it id_contenedor bash
```

> Nota: Para salir de un terminal de Docker sin apagar el contenedor, usa la combinación **Ctrl + P** seguido de **Ctrl + Q**.

## 5. Control de Ciclo de Vida y Limpieza
Comandos para detener, iniciar y eliminar recursos del sistema.

### Detención e Inicio
```bash
# Poner en marcha un contenedor detenido
docker start id_o_nombre

# Detener un contenedor en ejecución
docker stop id_o_nombre

# Parar TODOS los contenedores activos
docker stop $(docker ps -a -q)
```

### Eliminación de Recursos
```bash
# Borrar un contenedor específico (debe estar detenido)
docker rm id_o_nombre

# Borrar TODOS los contenedores del sistema
docker rm $(docker ps -a -q)

# Borrar todas las imágenes instaladas
docker rmi $(docker images -q)

# Eliminar todos los contenedores parados de una sola vez
docker container prune
```

## 6. Dockerfile y Construcción de Imágenes
Un **Dockerfile** es un archivo de texto que contiene una serie de instrucciones que Docker ejecuta para construir una imagen. Cada instrucción crea una **capa** en la imagen final.

### Instrucciones Básicas de un Dockerfile
```dockerfile
FROM        # Imagen base
RUN         # Ejecuta comandos durante la construcción
COPY        # Copia archivos del host a la imagen
WORKDIR     # Define el directorio de trabajo
CMD         # Comando por defecto al iniciar el contenedor
ENTRYPOINT  # Comando fijo al iniciar el contenedor
```

### Ejemplo 1: Dockerfile para Nginx
Publicar un archivo `index.html` usando Nginx.

```dockerfile
# Imagen base oficial de Nginx
FROM nginx:alpine

# Copiamos el fichero index.html al directorio web
COPY index.html /usr/share/nginx/html/index.html
```

Construcción y ejecución:
```bash
docker build -t mi-nginx .
docker run -d --name mi-nginx -p 8080:80 mi-nginx
```

### Ejemplo 2: Dockerfile para Python (simple)
Ejecutar un script de Python dentro de un contenedor.

```dockerfile
FROM python:alpine

WORKDIR /app

COPY script.py .

CMD ["python", "script.py"]
```

### Ejemplo 3: Dockerfile para Python con dependencias
Incluyendo instalación de dependencias con `requirements.txt`.

```dockerfile
FROM python:alpine

WORKDIR /app

COPY requirements.txt .

RUN pip install -r requirements.txt

COPY script.py .

CMD ["python", "script.py"]
```

### Orden y Optimización de Instrucciones
Docker ejecuta las instrucciones **de arriba a abajo** y reutiliza capas si no han cambiado. Para optimizar tiempos de construcción:

- Copia primero los ficheros que cambian menos (`requirements.txt`)
- Instala dependencias antes de copiar el código

Esto evita reinstalar dependencias en cada cambio de código.

### Docker Build
El comando `docker build` construye una imagen a partir de un Dockerfile.

```bash
# Sintaxis general
docker build -t nombre_imagen directorio_contexto

# Ejemplo
docker build -t mi-python .
```

### Ejecución de Imágenes Construidas
```bash
# Ejecutar contenedor desde la imagen creada
docker run -d --name mi-python mi-python
```

El nombre de la imagen se utiliza para ejecutarla, etiquetarla o subirla a un registro.

## 7. Dockerfile para Microservicio Spring Boot
Un microservicio en **Spring Boot** se suele empaquetar como un **JAR ejecutable**, lo que lo hace perfecto para ejecutarse dentro de un contenedor Docker.

Lo habitual es usar **multi-stage build** para:
- Compilar el proyecto con Maven
- Generar una imagen final ligera solo con Java y el JAR

### Dockerfile Spring Boot (Multi-stage con Maven)
```dockerfile
# -------- FASE 1: BUILD --------
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copiamos pom.xml y descargamos dependencias (cache)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamos el resto del código
COPY src ./src

# Compilamos el proyecto
RUN mvn clean package -DskipTests

# -------- FASE 2: RUNTIME --------
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copiamos el JAR generado desde la fase build
COPY --from=build /app/target/*.jar app.jar

# Damos permisos de ejecución al JAR
RUN chmod +x app.jar

# Puerto típico de Spring Boot
EXPOSE 8080

# Comando de arranque
ENTRYPOINT ["java", "-jar", "app.jar"]
```

### Construcción de la Imagen
Desde el directorio del microservicio:
```bash
docker build -t usuario-dockerhub/mi-microservicio:1.0 .
```

### Ejecución del Microservicio
```bash
docker run -d --name mi-microservicio -p 8080:8080 usuario-dockerhub/mi-microservicio:1.0
```

### ¿Estas imágenes se suben a Docker Hub?
Sí exactamente igual que **nginx**, **mysql** o cualquier otra imagen oficial.

Flujo típico:
1. Construyes la imagen con `docker build`
2. Inicias sesión en Docker Hub
3. Subes la imagen

```bash
docker login

docker push usuario-dockerhub/mi-microservicio:1.0
```

Una vez subida:
- Puede ejecutarse en **cualquier máquina con Docker**
- Puede usarse en **Docker Compose, Kubernetes, Render, Railway, etc.**
- Se ejecuta igual que Nginx:

```bash
docker run usuario-dockerhub/mi-microservicio:1.0
```

### Resumen rápido
- Un microservicio Spring Boot → **imagen Docker estándar**
- Se sube a Docker Hub como cualquier otra imagen
- Se ejecuta con `docker run`
- Multi-stage build = imágenes más pequeñas y profesionales

Este es el enfoque que se usa en **entornos reales y productivos**.

