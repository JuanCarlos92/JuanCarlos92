---
keywords: [docker, comandos docker, cheatsheet docker, docker tutorial, docker desde cero, docker para principiantes, docker avanzado, docker en producción, gestión de contenedores, gestión de imágenes, volúmenes docker, redes docker]
---
Instalación de Docker Engine (Linux)

Se encarga de instalar todas las dependencias necesarias y configurar el sistema para que Docker funcione correctamente.
    
```bash title="Instalación de Docker Engine en Linux"
curl -fsSL https://get.docker.com -o get-docker.sh && sh get-docker.sh
```

Ver comandos docker
``` shell
docker
```

Buscar un contenedor para descargar
``` shell
docker search [nombre_contenedor]
```

Instalar una imagen
``` shell
docker pull [nombre_imagen]
```

Realizar commit de una imagen
``` shell
docker commit -a "[información creador]" -m "[versión del programa]" [identificador_container] [nombre_repositorio:nombre_TAG]
```

Listar imágenes instaladas
``` shell
docker images
```

Ver imágenes ejecutándose
``` shell
docker ps
```

Podemos listar los contenedores disponibles a través del siguiente comando
``` shell
docker ps -a
```

Logs del contenedor
``` shell
docker logs [id_contenedor]
```

Logs del contenedor -f -->  en tiempo real
``` shell
docker logs -f [id_contenedor]
```

Acoplarnos al contenedor y ver la salida en tiempo real
``` shell
docker attach ef7e107e0aae
```
``` shell
docker attach lonely_wing
```

Iniciar una imagen
``` shell
docker run [nombre_imagen]
```

Ejecutar un contenedor  -d  --> en segundo plano
``` shell
docker run -d [identificador_imagen]
```
 
Para acceder al contenedor, además de crearlo
``` shell
docker run -i -t b72889fa879c /bin/bash
```
``` shell
docker run -i -t ubuntu:14.04 /bin/bash
```

Se reinicie siempre que falle o se reinicie el servidor anfitrión (Siempre ON)
``` shell
docker run --restart always [nombre_imagen]
```

Ejecutar un contenedor. -P  -->  Nos permite mapear un puerto del host a un puerto del contenedor
``` shell
docker run -d -p 8080:80 [nombre_imagen]
```

Ejecutar un contenedor. -P  -->  Nos permite mapear varios puerto del host
``` shell
docker run -d -p 8080:80 -p 8081:81 [nombre_imagen]
```

Ejecutar un contenedor. -P  -->  Nos permite mapear un rango de puertoS
``` shell
docker run -d -p 8080-8085:80 [nombre_imagen]
```
Ejecutar un contenedor con un nombre y un puerto
``` shell
docker run -d --name web1 8081:80 nginx
```
``` shell
docker run -d --name web2 8082:80 nginx
```
``` shell
docker run -d --name web3 8083:80 nginx
```

Ver lo que contiene el contenedor
``` shell
doker exec [id_contenedor] ls
```

Terminal de un contenedor arrancado
``` shell
doker exec -it [id_contenedor] bash
```

Poner en marcha el contenedor
``` shell
docker start ef7e107e0aae
```
``` shell
docker start lonely_wing
```

Para detener un contenedor
``` shell
docker stop ef7e107e0aae
```
``` shell
docker stop lonely_wing
```

Borrar todos los contenedores parados
```shell
docker container prune
```

Parar todos los contenedores
``` shell
docker stop $(docker ps -a -q)
```

Para borrar un contenedor
``` shell
docker rm ef7e107e0aae
```
``` shell
docker rm lonely_wing
```

Eliminar todos los contenedores
``` shell
docker rm $(docker ps -a -q)
```
 
Eliminar todas las imágenes
``` shell
docker rmi $(docker images -q)
```
























Introducir usuario en el grupo docker
``` shell
sudo usermod -a -G docker [nombre_usuario]
```
 
Refrescar grupo sin tener que reiniciar
``` shell
newgrp docker
```
 
Buscar un contenedor para descargar
``` shell
docker search [nombre_contenedor]
```

 






 
El usuario también puede ponerle una etiqueta personalizada que haga referencia a una imagen instalada en su sistema.
``` shell
docker tag b72889fa879c oldlts:latest
```
 
Para crear el contenedor y ponerlo en marcha hay que seguir el mismo paso de antes, pero cambiando la referencia por la etiqueta creada por el usuario.
``` shell
docker run -i -t oldlts:latest /bin/bash
```
 

 

 



Salir del terminal de docker sin apagarlo
Control + P  & Control + Q 




Terminal de un contenedor arrancado
``` shell
docker exec -ti f38197856de0 /bin/bash
```
 

 

 
Obtener la ruta del registro de un contenedor
``` shell
docker inspect --format='{{.LogPath}}' $ID_CONTENEDOR
```
