# Instalación de Oracle Database

## 1. Instalar Oracle Database

### En Windows

1. Descargar el instalador desde [Oracle Database Downloads](https://www.oracle.com/database/technologies/).
2. Ejecutar el instalador y seguir los pasos: seleccionar “Desktop Class” o “Server Class”.
3. Configurar contraseña del usuario SYS y SYSTEM.
4. Seleccionar iniciar el servicio de Oracle automáticamente.

**Instalar Oracle SQL Developer:**

* Descarga SQL Developer desde [SQL Developer Downloads](https://www.oracle.com/tools/downloads/sql-developer-downloads.html).
* No requiere instalación, solo descomprimir y ejecutar.

---

### En Linux / Ubuntu (con Oracle XE)

Actualizar repositorios:

```bash
sudo apt update
```

Descargar el paquete Oracle XE desde [Oracle Database Express Edition](https://www.oracle.com/database/technologies/xe-downloads.html) y luego instalarlo:

```bash
sudo dpkg -i oracle-xe_18c.deb
```

Configurar Oracle XE:

```bash
sudo /etc/init.d/oracle-xe configure
```

---

### En macOS

Oracle Database no se instala nativamente en macOS, se recomienda usar Docker:

```bash
docker pull gvenzl/oracle-xe
```

Iniciar contenedor:

```bash
docker run -d -p 1521:1521 -e ORACLE_PASSWORD=miPassword gvenzl/oracle-xe
```

---

## 2. Configuración inicial de seguridad

* Configurar contraseña segura para los usuarios SYS y SYSTEM.
* Configurar privilegios según el usuario de base de datos.

---

## 3. Acceder a Oracle Database

### Con SQL*Plus (terminal)

```bash
sqlplus sys/contraseña@XE as sysdba
```

O con otro usuario:

```bash
sqlplus usuario/contraseña@XE
```

### Con SQL Developer (GUI)

* Abrir SQL Developer.
* Crear nueva conexión: especificar usuario, contraseña y SID (por ejemplo XE).
* Probar conexión y conectar.

---

## 4. Comprobar la versión de Oracle

```sql
SELECT * FROM v$version;
```

---

## 5. Primeros comandos básicos

### Mostrar esquemas/bases de datos

```sql
SELECT username FROM all_users;
```

### Crear un esquema/usuario

```sql
CREATE USER mi_usuario IDENTIFIED BY contraseña;
GRANT CONNECT, RESOURCE TO mi_usuario;
```

### Borrar un esquema/usuario

```sql
DROP USER mi_usuario CASCADE;
```

---

## 6. Crear tabla y asignar permisos (opcional)

```sql
-- Crear tabla
CREATE TABLE mi_usuario.empleados (
    id NUMBER PRIMARY KEY,
    nombre VARCHAR2(50),
    salario NUMBER
);

-- Dar permisos a otro usuario
GRANT SELECT, INSERT, UPDATE ON mi_usuario.empleados TO otro_usuario;
```

---

## 7. Conexión remota (opcional)

* Asegurarse de que el listener de Oracle esté activo y el puerto 1521 abierto.
* Modificar `tnsnames.ora` o usar la cadena de conexión directa para conectarse desde otro equipo:

```text
usuario/contraseña@IP:1521/XE
```
