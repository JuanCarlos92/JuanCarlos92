# Comandos básicos de la Terminal Linux

Este documento recopila los comandos más utilizados en Linux, organizados por categorías para facilitar su consulta.

---

## Comandos básicos de archivos y directorios

| Comando | Descripción |
|-------|-------------|
| `ls` | Lista archivos y carpetas del directorio actual |
| `ls -l` | Lista detallada (permisos, tamaño, propietario) |
| `ls -a` | Muestra archivos ocultos |
| `cd <carpeta>` | Cambia de directorio |
| `cd ..` | Sube un nivel en el directorio |
| `cd ~` | Va al directorio personal |
| `pwd` | Muestra el directorio actual |
| `mkdir <nombre>` | Crea un nuevo directorio |
| `mkdir -p ruta/completa` | Crea directorios anidados |
| `rmdir <nombre>` | Elimina un directorio vacío |
| `rm <archivo>` | Elimina un archivo |
| `rm -r <carpeta>` | Elimina un directorio y su contenido |
| `rm -rf <carpeta>` | Elimina sin pedir confirmación |
| `cp <origen> <destino>` | Copia archivos |
| `cp -r <origen> <destino>` | Copia carpetas |
| `mv <origen> <destino>` | Mueve o renombra |
| `touch <archivo>` | Crea archivo vacío |
| `file <archivo>` | Indica el tipo de archivo |
| `stat <archivo>` | Información detallada del archivo |
| `cat <archivo>` | Muestra contenido |
| `more <archivo>` | Muestra contenido paginado |
| `less <archivo>` | Visualización avanzada |
| `head <archivo>` | Primeras líneas |
| `tail <archivo>` | Últimas líneas |
| `tail -f <archivo>` | Sigue un archivo en tiempo real |

---

## Gestión de procesos

| Comando | Descripción |
|-------|-------------|
| `ps` | Procesos activos |
| `ps aux` | Lista completa de procesos |
| `top` | Monitor en tiempo real |
| `htop` | Versión mejorada de `top` |
| `kill <PID>` | Finaliza proceso |
| `kill -9 <PID>` | Finaliza forzosamente |
| `killall <nombre>` | Mata procesos por nombre |
| `jobs` | Trabajos en background |
| `bg` | Reanuda en background |
| `fg` | Pasa a foreground |
| `nohup comando &` | Ejecuta sin depender de la terminal |

---

## Gestión de usuarios y permisos

| Comando | Descripción |
|-------|-------------|
| `whoami` | Usuario actual |
| `id` | UID, GID y grupos |
| `who` | Usuarios conectados |
| `sudo <comando>` | Ejecuta como root |
| `su` | Cambia a root |
| `su usuario` | Cambia de usuario |
| `chmod` | Cambia permisos |
| `chmod 755 archivo` | Permisos numéricos |
| `chown usuario archivo` | Cambia propietario |
| `chgrp grupo archivo` | Cambia grupo |
| `passwd` | Cambia contraseña |

---

## Redes y conectividad

| Comando | Descripción |
|-------|-------------|
| `ping <host>` | Comprueba conexión |
| `ip addr` | Interfaces de red |
| `ip link` | Estado de interfaces |
| `ip route` | Tabla de rutas |
| `ifconfig` | Obsoleto |
| `netstat` | Conexiones de red |
| `ss` | Alternativa moderna |
| `wget <url>` | Descargas |
| `curl <url>` | Peticiones HTTP |
| `ssh usuario@host` | Conexión SSH |
| `scp archivo usuario@host:/ruta` | Copia remota |
| `ftp` | Conexión FTP |

---

## Gestión de paquetes (Debian / Ubuntu)

| Comando | Descripción |
|-------|-------------|
| `apt update` | Actualiza repositorios |
| `apt upgrade` | Actualiza paquetes |
| `apt install <paquete>` | Instala |
| `apt remove <paquete>` | Elimina |
| `apt purge <paquete>` | Elimina con configuración |
| `apt search <paquete>` | Busca paquetes |
| `apt show <paquete>` | Información del paquete |

---

## Gestión de paquetes (Fedora / RedHat)

| Comando | Descripción |
|-------|-------------|
| `dnf update` | Actualiza sistema |
| `dnf install <paquete>` | Instala |
| `dnf remove <paquete>` | Elimina |
| `dnf search <paquete>` | Busca paquetes |
| `dnf info <paquete>` | Información |

---

## Archivos comprimidos

| Comando | Descripción |
|-------|-------------|
| `tar -cvf archivo.tar carpeta/` | Crear tar |
| `tar -xvf archivo.tar` | Extraer tar |
| `tar -czvf archivo.tar.gz carpeta/` | Crear tar.gz |
| `tar -xzvf archivo.tar.gz` | Extraer tar.gz |
| `zip archivo.zip carpeta/` | Comprimir zip |
| `unzip archivo.zip` | Extraer zip |
| `gzip archivo` | Comprimir gzip |
| `gunzip archivo.gz` | Descomprimir gzip |

---

## Búsqueda de archivos y contenido

| Comando | Descripción |
|-------|-------------|
| `find <ruta> -name "<patrón>"` | Buscar archivos |
| `locate archivo` | Búsqueda rápida |
| `updatedb` | Actualiza base de `locate` |
| `grep "<texto>" <archivo>` | Buscar texto |
| `grep -r "<texto>" <carpeta>` | Búsqueda recursiva |
| `grep -i "<texto>" <archivo>` | Ignora mayúsculas |

---

## Variables y entorno

| Comando | Descripción |
|-------|-------------|
| `echo $VARIABLE` | Muestra variable |
| `export VARIABLE=valor` | Define variable |
| `env` | Variables de entorno |
| `printenv` | Variables |
| `set` | Variables y funciones |
| `unset VARIABLE` | Elimina variable |

---

## Otras utilidades útiles

| Comando | Descripción |
|-------|-------------|
| `clear` | Limpia pantalla |
| `history` | Historial |
| `alias nombre='comando'` | Alias |
| `unalias nombre` | Elimina alias |
| `date` | Fecha y hora |
| `uptime` | Tiempo encendido |
| `df -h` | Espacio en disco |
| `du -sh <carpeta>` | Tamaño carpeta |
| `free -h` | Memoria RAM |
| `watch comando` | Ejecuta comando periódicamente |
| `man comando` | Manual |
| `--help` | Ayuda rápida |

---
