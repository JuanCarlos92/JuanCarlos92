Podemos insertar, modificar y borrar datos de las tablas a través de consultas de SQL en Oracle. Podemos usar los comandos `INSERT`, `UPDATE` y `DELETE`.

En Oracle no se usa el comando `USE` para seleccionar la base de datos; en su lugar, nos conectamos directamente al esquema deseado al iniciar sesión.

## Insert - Insertar datos

Para insertar datos, podemos usar el comando `INSERT`.

```sql
INSERT INTO <tabla> (<atributos>) VALUES (<valores>);
```

Por ejemplo:

```sql
INSERT INTO persona (nombre, edad, salario) VALUES ('Juan', 30, 1000);
```

Las inserciones también se pueden realizar con subconsultas:

```sql
INSERT INTO persona (nombre, edad, salario) 
VALUES ('Juan', 30, (SELECT salario FROM persona WHERE nombre = 'Juan'));
```

## Insert con select - Insertar datos con select

Para insertar datos con un `SELECT`, usamos la sintaxis:

```sql
INSERT INTO <tabla> (<atributos>) SELECT <valores> FROM <tabla>;
```

Ejemplo: insertar datos de una tabla en otra:

```sql
INSERT INTO persona (nombre, edad, salario) SELECT nombre, edad, salario FROM persona;
```

Combinar datos del `SELECT` con datos estáticos:

```sql
INSERT INTO persona (nombre, edad, salario) 
SELECT nombre, edad, 1600 FROM persona WHERE nombre = 'Juan';
```

Operaciones sobre datos del `SELECT`, como duplicar el salario:

```sql
INSERT INTO persona (nombre, edad, salario) 
SELECT nombre, edad, salario * 2 FROM persona WHERE nombre = 'Juan';
```

## Update - Modificar datos

Para modificar datos, usamos `UPDATE`. Es recomendable usar `WHERE` para limitar los registros a actualizar.

```sql
UPDATE <tabla> SET <atributos> = <valores> WHERE <condiciones>;
```

Ejemplo:

```sql
UPDATE persona SET nombre = 'Pedro' WHERE id = 1;
```

Actualizar múltiples columnas de una fila:

```sql
UPDATE persona SET nombre = 'Pedro', edad = 30 WHERE id = 1;
```

## Delete - Borrar datos

Para borrar datos usamos `DELETE`.

```sql
DELETE FROM <tabla> WHERE <condiciones>;
```

Ejemplo:

```sql
DELETE FROM persona WHERE id = 1;
```
