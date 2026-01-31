## Cláusulas en Oracle SQL

Las consultas en Oracle SQL son una forma de acceder a la base de datos.

Estas consultas tienen diferentes cláusulas:

* `FROM`: Selecciona la tabla.
* `WHERE`: Selecciona los registros que cumplan con una condición.
* `ORDER BY`: Ordena los registros por un atributo.
* `GROUP BY`: Agrupa los registros por un atributo.
* `FETCH FIRST n ROWS ONLY`: Limita el número de registros a devolver (equivalente a LIMIT en MySQL).
* `HAVING`: Selecciona los registros que cumplan con una condición. Opera sobre los registros agrupados.

La siguiente consulta devolvería todos los registros de la tabla `tabla`.

```sql
SELECT * FROM tabla;
```

Ejemplo WHERE:
La siguiente consulta devolvería el registro con el id 1 de la tabla `tabla`.

```sql
SELECT * FROM tabla WHERE id = 1;
```

Ejemplo ORDER BY:
Por defecto, `ORDER BY` devolvería todos los registros de la tabla `tabla` ordenados por el `id` de forma ascendente (sin especificar nada). Para orden descendente se usa `DESC`.

```sql
SELECT * FROM tabla ORDER BY id DESC;
```

Ejemplo GROUP BY:
La siguiente consulta devolvería todos los registros agrupados por el campo `nombre`.

```sql
SELECT * FROM tabla GROUP BY nombre;
```

Ejemplo límite de filas (equivalente a LIMIT en MySQL):
La siguiente consulta devolvería los primeros 5 registros de la tabla `tabla`.

```sql
SELECT * FROM tabla FETCH FIRST 5 ROWS ONLY;
```

Ejemplo HAVING:

```sql
SELECT nombre, COUNT(*)
FROM tabla
GROUP BY nombre
HAVING COUNT(*) > 1;
```
