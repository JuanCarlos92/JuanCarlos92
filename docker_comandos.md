---
keywords: [docker, comandos docker, cheatsheet docker, docker tutorial, docker desde cero, docker para principiantes, docker avanzado, docker en producción, gestión de contenedores, gestión de imágenes, volúmenes docker, redes docker]
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
