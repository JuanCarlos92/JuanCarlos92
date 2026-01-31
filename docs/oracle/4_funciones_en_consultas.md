## Funciones en consultas de selección en Oracle SQL

Estas se utilizan para manipular y filtrar los datos que se devuelven en una consulta. Se pueden usar en las cláusulas `WHERE` y `HAVING`, pero lo más común es usarlas en las cláusulas `SELECT`.
Esta consulta de ejemplo nos permitiría obtener el salario redondeado de todos los empleados y modificar la salida (sin alterar el registro de la base de datos):

```sql
SELECT nombre, ROUND(salario) FROM empleados;
```

### Funciones aritméticas

Nos permiten realizar operaciones aritméticas sobre los valores de los campos.

| Función    | Descripción                                                           |
| ---------- | --------------------------------------------------------------------- |
| ABS(n)     | Valor absoluto                                                        |
| ROUND(n,d) | Redondea el valor "n" con el número de decimales especificados en "d" |
| FLOOR(n)   | Redondea hacia abajo                                                  |
| CEIL(n)    | Redondea hacia arriba                                                 |
| SQRT(n)    | Raíz cuadrada                                                         |
| POWER(x,y) | Potencia: x elevado a y                                               |

### Funciones de cadenas de texto

Nos permiten manipular textos de las consultas.

| Función          | Descripción                                                                                             |   |            |
| ---------------- | ------------------------------------------------------------------------------------------------------- | - | ---------- |
| CONCAT(s1, s2)   | Concatena dos cadenas de texto (también se puede usar                                                   |   | en Oracle) |
| SUBSTR(c, m, n)  | Devuelve una sub-cadena obtenida de la cadena “c”, a partir de la posición “m” y tomando “n” caracteres |   |            |
| LENGTH(c)        | Devuelve la longitud de una cadena de texto                                                             |   |            |
| UPPER(c)         | Convierte una cadena de texto a mayúsculas                                                              |   |            |
| LOWER(c)         | Convierte una cadena de texto a minúsculas                                                              |   |            |
| REPLACE(c, b, s) | Reemplaza en la cadena "c" el valor buscado en "b" por el valor indicado en "s"                         |   |            |
| TRIM(c)          | Elimina los espacios en blanco de una cadena de texto                                                   |   |            |
| RPAD(c, n)       | Rellena la cadena "c" hasta longitud "n" (similar a repetir o extender)                                 |   |            |

### Funciones de fecha

Nos permiten manipular fechas de las consultas.

| Función                | Descripción                                               |
| ---------------------- | --------------------------------------------------------- |
| TO_DATE(c, f)          | Convierte una cadena de texto a fecha usando el formato f |
| TO_CHAR(f, m)          | Convierte una fecha a cadena de texto con el formato m    |
| SYSDATE                | Devuelve la fecha y hora actuales                         |
| EXTRACT(YEAR FROM f)   | Devuelve el año de una fecha                              |
| EXTRACT(MONTH FROM f)  | Devuelve el mes de una fecha                              |
| EXTRACT(DAY FROM f)    | Devuelve el día de una fecha                              |
| EXTRACT(HOUR FROM f)   | Devuelve la hora de una fecha                             |
| EXTRACT(MINUTE FROM f) | Devuelve los minutos de una fecha                         |
| EXTRACT(SECOND FROM f) | Devuelve los segundos de una fecha                        |
| ADD_MONTHS(f, n)       | Suma n meses a la fecha f                                 |
| MONTHS_BETWEEN(f1, f2) | Devuelve el número de meses entre f1 y f2                 |
