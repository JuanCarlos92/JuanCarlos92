# Lista completa y detallada de comandos CMD en Windows

Este documento recopila los comandos más importantes del **Símbolo del sistema (CMD)** en Windows, organizados por categorías para facilitar su consulta.

---

## Comandos básicos de navegación y gestión de archivos

| Comando | Descripción |
|-------|-------------|
| `dir` | Lista archivos y carpetas del directorio actual |
| `dir /a` | Muestra también archivos ocultos |
| `cd` / `chdir` | Cambia o muestra el directorio actual |
| `md` / `mkdir` | Crea un directorio nuevo |
| `rd` / `rmdir` | Elimina un directorio (usar `/S` para eliminar contenido) |
| `copy` | Copia uno o varios archivos |
| `xcopy` | Copia archivos y directorios (más opciones que `copy`) |
| `robocopy` | Copia avanzada y robusta |
| `del` / `erase` | Elimina archivos |
| `ren` / `rename` | Cambia nombre de archivos o carpetas |
| `attrib` | Cambia atributos (oculto, solo lectura, etc.) |
| `assoc` | Muestra o cambia asociaciones de archivos |
| `compact` | Gestiona compresión NTFS |
| `label` | Cambia etiqueta de un volumen |
| `move` | Mueve archivos |
| `type` | Muestra contenido de un archivo |
| `tree` | Muestra estructura de directorios en árbol |
| `where` | Localiza ejecutables en el PATH |

---

## Gestión de discos y archivos

| Comando | Descripción |
|-------|-------------|
| `diskpart` | Administrador de discos y particiones |
| `format` | Formatea discos o particiones |
| `chkdsk` | Comprueba y repara errores de disco |
| `chkntfs` | Configura comprobación de discos al inicio |
| `fsutil` | Administración avanzada de sistemas de archivos |
| `recover` | Recupera datos de discos dañados |
| `expand` | Extrae archivos comprimidos CAB |
| `mountvol` | Gestiona puntos de montaje de volúmenes |

---

## Gestión de procesos y sistema

| Comando | Descripción |
|-------|-------------|
| `tasklist` | Lista procesos en ejecución |
| `taskkill` | Finaliza procesos por PID o nombre |
| `systeminfo` | Información detallada del sistema |
| `sfc /scannow` | Repara archivos del sistema |
| `shutdown` | Apaga o reinicia el sistema |
| `gpupdate` | Actualiza políticas de grupo |
| `gpresult` | Resultados de políticas aplicadas |
| `driverquery` | Lista controladores instalados |
| `perfmon` | Monitor de rendimiento |

---

## Red y conectividad

| Comando | Descripción |
|-------|-------------|
| `ipconfig` | Configuración de red |
| `ipconfig /all` | Información detallada de red |
| `ping` | Comprueba conectividad |
| `tracert` | Rastrea ruta a un host |
| `pathping` | Combina ping y tracert |
| `netstat` | Conexiones y puertos abiertos |
| `nslookup` | Consultas DNS |
| `arp` | Tabla ARP |
| `getmac` | Dirección MAC |
| `hostname` | Nombre del equipo |
| `route` | Tabla de rutas |
| `ftp` | Cliente FTP |
| `telnet` | Cliente Telnet (opcional) |
| `netsh` | Configuración avanzada de red |
| `winrm` | Administración remota |

---

## Usuarios y permisos

| Comando | Descripción |
|-------|-------------|
| `net user` | Administra usuarios |
| `net localgroup` | Administra grupos |
| `runas` | Ejecuta comandos con otro usuario |
| `whoami` | Usuario actual |
| `cacls` | Permisos ACL (obsoleto) |
| `icacls` | Permisos NTFS avanzados |
| `logoff` | Cierra sesión |

---

## Variables de entorno y sistema

| Comando | Descripción |
|-------|-------------|
| `set` | Muestra o define variables |
| `echo` | Muestra texto o variables |
| `path` | Configura rutas de ejecución |
| `cls` | Limpia pantalla |
| `prompt` | Cambia el prompt |
| `ver` | Versión de Windows |
| `vol` | Información del volumen |
| `verify` | Verificación de escritura |
| `time` | Muestra o cambia la hora |
| `date` | Muestra o cambia la fecha |

---

## Automatización y scripts batch

| Comando | Descripción |
|-------|-------------|
| `call` | Llama a otro script |
| `exit` | Cierra CMD o script |
| `pause` | Pausa ejecución |
| `for` | Bucles |
| `if` | Condicional |
| `goto` | Salto a etiqueta |
| `shift` | Gestiona parámetros |
| `setlocal` | Variables locales |
| `endlocal` | Finaliza variables locales |
| `rem` | Comentarios |
| `choice` | Entrada del usuario |

---

## Servicios y administración

| Comando | Descripción |
|-------|-------------|
| `sc` | Gestiona servicios |
| `schtasks` | Programa tareas |
| `tasklist` | Lista tareas |
| `taskkill` | Finaliza tareas |
| `gpupdate` | Actualiza GPO |
| `gpresult` | Resultados GPO |

---

## Utilidades varias

| Comando | Descripción |
|-------|-------------|
| `cipher` | Cifrado NTFS |
| `openfiles` | Archivos abiertos remotamente |
| `powercfg` | Gestión de energía |
| `wevtutil` | Logs de eventos |
| `clip` | Copia salida al portapapeles |
| `doskey` | Historial y macros |
| `mklink` | Enlaces simbólicos |
| `pushd` / `popd` | Pila de directorios |
| `subst` | Asigna unidad a carpeta |
| `start` | Ejecuta programas |
| `sort` | Ordena texto |

---

## Windows Subsystem for Linux (WSL)

| Comando | Descripción |
|-------|-------------|
| `wsl` | Ejecuta WSL |
| `wsl --list` | Lista distribuciones |
| `wsl --shutdown` | Apaga WSL |
| `wslconfig` | Configuración WSL |

---

## Comandos especiales y otros

| Comando | Descripción |
|-------|-------------|
| `color` | Cambia colores |
| `title` | Cambia título de ventana |
| `reset` | Reinicia terminal (limitado) |
| `help` | Ayuda general |
| `comando /?` | Ayuda específica |

---
