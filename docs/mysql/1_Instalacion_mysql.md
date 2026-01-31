# Instalación de MySQL

## 1. Instalar MySQL

### En Ubuntu / Debian

Actualizar los repositorios:

```bash
sudo apt update
```

Instalar MySQL:

```bash
sudo apt install mysql-server
```

Verificar el estado del servicio:

```bash
sudo systemctl status mysql
```

Iniciar MySQL (si no está corriendo):

```bash
sudo systemctl start mysql
```

Habilitar MySQL al iniciar el sistema:

```bash
sudo systemctl enable mysql
```

---

### En Windows

1. Descargar el instalador desde [MySQL Downloads](https://dev.mysql.com/downloads/installer/).
2. Ejecutar el instalador y seguir los pasos: seleccionar “Developer Default”.
3. Configurar contraseña del usuario root.
4. Seleccionar iniciar MySQL automáticamente.

**Instalar MySQL Workbench:**

* En el mismo instalador de MySQL puedes seleccionar Workbench.
* Alternativamente, descargarlo desde [MySQL Workbench Downloads](https://dev.mysql.com/downloads/workbench/).

---

### En macOS

Usando Homebrew:

```bash
brew update
brew install mysql
brew services start mysql
```

---

## 2. Configuración inicial de seguridad

Ejecutar el script de seguridad:

```bash
sudo mysql_secure_installation
```

Opciones comunes:

* Configurar contraseña de root
* Eliminar usuarios anónimos
* Deshabilitar login remoto de root
* Eliminar base de datos de prueba

---

## 3. Acceder a MySQL

### Sin especificar credenciales

```bash
mysql
```

### Con usuario y contraseña (la password la pide por pantalla)

```bash
mysql -u root -p
```

---

## 4. Comprobar la versión de MySQL

```bash
mysql --version
```

---

## 5. Primeros comandos básicos

### Mostrar bases de datos

```sql
show databases;
```

### Crear una base de datos

```sql
create database mi_base_de_datos;
```

### Borrar una base de datos

```sql
drop database mi_base_de_datos;
```

---

## 6. Crear usuario y asignar permisos (opcional)

```sql
-- Crear usuario
CREATE USER 'usuario'@'localhost' IDENTIFIED BY 'contraseña';

-- Dar permisos completos sobre una base de datos
GRANT ALL PRIVILEGES ON mi_base_de_datos.* TO 'usuario'@'localhost';

-- Aplicar cambios
FLUSH PRIVILEGES;
```

---

## 7. Conexión remota (opcional)

```sql
-- Permitir conexión desde cualquier host
CREATE USER 'usuario'@'%' IDENTIFIED BY 'contraseña';
GRANT ALL PRIVILEGES ON mi_base_de_datos.* TO 'usuario'@'%';
FLUSH PRIVILEGES;
```

Nota: Para conexiones remotas, asegúrate de que el puerto 3306 esté abierto en el firewall.
