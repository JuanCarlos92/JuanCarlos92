### 1. Instalación y Configuración del Entorno

- **Instalar Docker Engine (Linux)**
```bash title="Instalación de Docker Engine en Linux"
curl -fsSL https://get.docker.com -o get-docker.sh y luego sh get-docker.sh
```

- **Añadir usuario al grupo docker**
``` shell
sudo usermod -aG docker $USER
```

- **Refrescar grupo sin tener que reiniciar**
``` shell
newgrp docker
```

- **Comprobar versión instalada**
``` shell
docker --version
```

### 2. Gestión de Contenedores (Ciclo de Vida)

- **Crear y arrancar un contenedor**
``` shell
docker run <imagen>
```

    - En segundo plano (modo demonio)
        docker run -d <imagen>

    - Mapear puertos
        docker run -p <puerto_host>:<puerto_contenedor> <imagen>

    - Asignar nombre personalizado
        docker run --name <nombre> <imagen>
    
    - Modo interactivo (bash)
        docker run -it <imagen> /bin/bash
    
    - Modo interactivo (sh)
        docker run -it <imagen> /bin/bash

    - Eliminar al terminar
        docker run --rm <imagen>

    - Variables de entorno
        docker run -e <VAR=valor> o --env-file <archivo>

    - Política de reinicio
        docker run --restart <politica> <imagen>
        *(ej: always, unless-stopped)*

    - Arquitectura específica
        docker run --platform <arquitectura> <imagen>

- **Listar contenedores**
``` shell
- En ejecución
docker ps
```

``` shell
- Solo IDs
docker ps -q
```

``` shell
- Todos (incluidos parados)
docker ps -a
```

- **Detener un contenedor**
``` shell
docker stop <ID_o_nombre>
```

- **Iniciar un contenedor parado**
``` shell
docker start <ID_o_nombre>
```

- **Reiniciar un contenedor**
``` shell
docker restart <ID_o_nombre>
```

- **Eliminar contenedor**
``` shell
- Eliminar contenedor
docker rm <ID_o_nombre>
```

``` shell
- Forzar eliminación
docker rm -f <ID_o_nombre>
```

- **Limpieza masiva**

``` shell
- Parar todos los contenedores
docker stop $(docker ps -aq)
```

``` shell
- Eliminar todos los contenedores
docker rm $(docker ps -aq)
```

``` shell
- Eliminar contenedores parados
docker container prune
```

### 3. Interacción y Monitoreo

- **Ver logs**
``` shell
docker logs <ID_o_nombre> (usar -f para tiempo real)
```

- **Conectarse al proceso principal**
``` shell
docker attach <ID_o_nombre>
```

- **Ejecutar comandos en un contenedor activo (terminal)**
``` shell
docker exec -it <ID_o_nombre> <comando> (ej: bash o sh)
```
        - Acceso con bash
            docker exec -it <contenedor> /bin/bash

        - Acceso con sh
            docker exec -it <contenedor> /bin/sh

- **Inspeccionar detalles (ruta de registro, IP, etc.)**
``` shell
docker inspect <ID_o_nombre>
```

- **Obtener solo la ruta de log**
``` shell
docker inspect --format='{{.LogPath}}' <ID_o_nombre>
```

- **Desacoplarse sin apagar**
``` shell
Control + P y luego Control + Q
```

### 4. Gestión de Imágenes

- **Buscar imágenes en Docker Hub**
``` shell
docker search <nombre>
```

- **Descargar una imagen**
``` shell
docker pull <imagen>
```

- **Listar imágenes locales**
``` shell
docker images
```

- **Construir imagen desde Dockerfile**
``` shell
docker build -t <nombre:tag> <contexto>
```
    - Con argumentos
        docker build --build-arg <VAR=valor> -t <nombre>

- **Eliminar una imagen**
``` shell
docker rmi <ID_o_nombre>
```

- **Eliminar Todas las imagenes**
``` shell
docker rmi $(docker images -q)
```


- **Eliminar imágenes no usadas**
``` shell
docker image prune
```

- **Ver capas/historial**
``` shell
docker history <imagen>
```

- **Etiquetar una imagen**
``` shell
docker tag <origen> <nuevo_nombre:tag>
```

- **Subir a un registro**
``` shell
docker push <usuario/imagen>
```

- **Crear imagen desde un contenedor (snapshot)**
``` shell
docker commit <ID_contenedor> <nombre_imagen>
```

- **Crear imagen desde un contenedor (completa con metadata)**
``` shell
docker commit -a "<autor>" -m "<mensaje>" <contenedor> <imagen:tag>
```

- **Exportar imagen a .tar**
``` shell
docker save -o <nombre.tar> <imagen>
```

- **Importar imagen desde .tar**
``` shell
docker load -i <nombre.tar>
```

### 5. Volúmenes y Archivos

- **Crear un volumen**
``` shell
docker volume create <nombre>
```

- **Listar volúmenes**
``` shell
docker volume ls
```

- **Inspeccionar volumen**
``` shell
docker volume inspect <nombre>
```

- **Eliminar un volumen**
``` shell
docker volume rm <nombre>
```

- **Copiar archivos entre host y contenedor**
``` shell
docker cp <origen> <destino>
```

### 6. Redes (Networking)

- **Crear una red**
``` shell
docker network create <nombre>
```

- **Listar redes**
``` shell
docker network ls
```

- **Inspeccionar red**
``` shell
docker network inspect <nombre>
```

- **Conectar/Desconectar contenedor**
``` shell
docker network connect/disconnect <red> <contenedor>
```

- **Eliminar red**
``` shell
docker network rm <nombre>
```

### 7. Docker Compose

- **Levantar servicios**
``` shell
docker compose up (usar -d para segundo plano)
```

- **Bajar servicios**
``` shell
docker compose down (usar -v para borrar volúmenes)
```

- **Estado y logs**
``` shell
docker compose ps
```

``` shell
docker compose logs
```

- **Ejecutar comando en servicio**
``` shell
docker compose exec <servicio> <comando>
```

### 8. Docker Swarm

- **Iniciar Swarm**
``` shell
docker swarm init
```

- **Unirse como trabajador**
``` shell
docker swarm join --token <token> <IP:puerto>
```

- **Salir de Swarm**
``` shell
docker swarm leave
```

- **Gestión de servicios**
``` shell
docker service create, ls, inspect, logs, scale, update, rollback, rm
```

- **Stacks (Compose en Swarm)**
``` shell
docker stack deploy, ls, inspect, rm
```

### 9. Comandos Avanzados

- **Modificar límites en caliente**
``` shell
docker update --memory <limite> --cpus <limite> <contenedor>
```

- **Docker Buildx (Multiarquitectura)**
``` shell
docker buildx create, ls, use, build --platform
```

``` shell
docker run -p <puerto_host>:<puerto_contenedor> <imagen>
```

Mapear puertos
``` shell
docker run -p <puerto_host>:<puerto_contenedor> <imagen>
```

Buscar un contenedor para descargar
``` shell
docker search [nombre_contenedor]
```
 
Instalar una imagen
``` shell
docker pull [nombre_imagen]
```
 
Listar imágenes instaladas
``` shell
docker images
```

Ver imágenes ejecutándose
``` shell
docker ps
```
 
Iniciar una imagen
``` shell
docker run [nombre_imagen]
```
 
Para acceder al contenedor, además de crearlo, se puede hacer de dos maneras. Una es haciendo referencia al IMAGE ID y otra al repositorio (REPOSITORY) y la etiqueta (TAG).
``` shell
docker run -i -t b72889fa879c /bin/bash
```
``` shell
docker run -i -t ubuntu:14.04 /bin/bash
```
 
El usuario también puede ponerle una etiqueta personalizada que haga referencia a una imagen instalada en su sistema.
``` shell
docker tag b72889fa879c oldlts:latest
```
 
Para crear el contenedor y ponerlo en marcha hay que seguir el mismo paso de antes, pero cambiando la referencia por la etiqueta creada por el usuario.
``` shell
docker run -i -t oldlts:latest /bin/bash
```
 
Para iniciar un contenedor en modo demonio
``` shell
docker run -d [identificador_imagen]
```
 
 
Como ya hemos comentado, cada vez que ejecutamos el comando run estamos creando un contenedor nuevo, por lo que lo recomendable es ejecutarlo tan solo una vez. Luego podemos listar los contenedores disponibles a través del siguiente comando.
``` shell
docker ps -a
```
 
Hay dos maneras de poner en marcha el contenedor a través del mismo comando, pudiéndose utilizar su identificador (CONTAINER ID) o su nombre (NAMES).
``` shell
docker start ef7e107e0aae
```
``` shell
docker start lonely_wing
```
 
Si se quiere acceder  (attach, que se podría traducir por adjuntar o unir) al contenedor se puede recurrir a una de estas dos opciones.
``` shell
docker attach ef7e107e0aae
```
``` shell
docker attach lonely_wing
```

Salir del terminal de docker sin apagarlo
Control + P  & Control + Q 

Para detener un contenedor
``` shell
docker stop ef7e107e0aae
```

``` shell
docker stop lonely_wing
```
 
Para borrar un contenedor
``` shell
docker rm ef7e107e0aae
```
``` shell
docker rm lonely_wing
```

Parar todos los contenedores
``` shell
docker stop $(docker ps -a -q)
```

Terminal de un contenedor arrancado
``` shell
docker exec -ti f38197856de0 /bin/bash
```
 
Eliminar todos los contenedores
``` shell
docker rm $(docker ps -a -q)
```
 
Eliminar todas las imágenes
``` shell
docker rmi $(docker images -q)
```
 
Realizar commit de una imagen
``` shell
docker commit -a "[información creador]" -m "[versión del programa]" [identificador_container] [nombre_repositorio:nombre_TAG]
```
 
Obtener la ruta del registro de un contenedor
``` shell
docker inspect --format='{{.LogPath}}' $ID_CONTENEDOR
```
