Perfecto, aquí tienes el mismo documento adaptado para **PostgreSQL**, listo para copiar y pegar en un archivo `.md`:

````markdown
## Acceder a PostgreSQL

Sin especificar credenciales (usuario actual del sistema):

```bash
psql
````

Con usuario y contraseña (la password la pide por pantalla):

```bash
psql -U postgres -h localhost -W
```

---

## Bases de datos

Mostrar todas las bases de datos:

```sql
\l
```

Crear base de datos:

```sql
CREATE DATABASE <base_de_datos>;
```

Borrar base de datos:

```sql
DROP DATABASE <base_de_datos>;
```

---

## Tablas

Consultar tablas en la base de datos actual:

```sql
\dt
```

Describir los atributos de una tabla:

```sql
\d <tabla>
```

Crear tabla:

```sql
CREATE TABLE <tabla>(
    id SERIAL PRIMARY KEY,
    nombre CHAR(30) NOT NULL,
    edad INTEGER,
    salario INTEGER
);
```

Insertar datos:

```sql
INSERT INTO <tabla> (nombre, edad, salario) VALUES
('Pedro', 24, 21000),
('Maria', 26, 24000),
('Juan', 28, 25000),
('Luis', 35, 28000),
('Monica', 42, 30000),
('Rosa', 43, 25000),
('Susana', 45, 39000);
```

Actualizar datos:

```sql
UPDATE <tabla> SET nombre = 'Pedro' WHERE id = 1;
```

Obtener datos:

```sql
SELECT * FROM <tabla>;
```

Borrar datos:

```sql
DELETE FROM <tabla> WHERE id = 1;
```

---

## Salir de PostgreSQL

Para salir del cli interactivo de psql se puede usar:

```sql
\q
```
