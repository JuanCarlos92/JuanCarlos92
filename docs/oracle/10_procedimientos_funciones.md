## Introducción

Con el fin de mejorar la eficiencia y reutilizar las consultas SQL, se ha desarrollado una serie de procedimientos y funciones que permiten realizar operaciones de forma más eficiente.

Estos objetos se almacenan en la base de datos y se pueden utilizar en las consultas SQL.

## Procedimientos y funciones

Sus principales diferencias son:

* Valores de retorno: Los procedimientos no tienen porque retornar ningún valor, mientras que las funciones siempre retornan un valor.
* Tipos de valores de retorno: Los procedimientos pueden mostrar resultados de cualquier tipo (listas, tablas), mientras que las funciones siempre retornan un valor concreto (NUMBER, VARCHAR2, etc.).
* Parámetros: Los procedimientos pueden tener parámetros múltiples valores de entrada y salida (`IN`, `OUT`, `IN OUT`), mientras que las funciones siempre tienen un valor de retorno y parámetros de entrada.

## Procedimientos

Los procedimientos son rutinas o subprogramas compuestos por un conjunto
nombrado de sentencias SQL agrupadas lógicamente para realizar una tarea
específica, que se guardan en la base de datos y que se ejecutan como una
unidad cuando son invocados por su nombre. Es decir, nos permiten agrupar un conjunto de sentencias para lanzarlas en bloque.

El procedimiento consta de las siguientes partes:

* Definición del nombre del procedimiento.
* Parámetros de entrada o salida.
* Sentencias SQL.

Sintaxis básica de procedimientos almacenados en Oracle:

```plsql
CREATE OR REPLACE PROCEDURE nombre_procedimiento (
    parametro_entrada IN VARCHAR2,
    parametro_salida OUT NUMBER
) IS
BEGIN
    SELECT edad INTO parametro_salida FROM usuarios WHERE nombre = parametro_entrada;
END;
/
```

Podemos ejecutar el procedimiento usando la siguiente sintaxis en Oracle:

```sql
BEGIN
    nombre_procedimiento('Pablo', :edad);
END;
/
```

## Funciones

Las funciones son rutinas o subprogramas compuestos por un conjunto de sentencias. Siempre tienen un valor de retorno, cuyo tipo depende de la declaración de la función y se devuelve con la instrucción `RETURN`.

Por ejemplo, la siguiente función devuelve el nombre de un usuario:

```plsql
CREATE OR REPLACE FUNCTION nombre_usuario (id_usuario IN NUMBER) RETURN VARCHAR2 IS
    nombre_obtenido VARCHAR2(50);
BEGIN
    SELECT nombre INTO nombre_obtenido FROM usuarios WHERE id_usuario = id_usuario;
    RETURN nombre_obtenido;
END;
/
```

Podemos ejecutar la función usando un `SELECT`:

```sql
SELECT nombre_usuario(1) FROM dual;
```

## Borrado de procedimientos y funciones

Para borrar un procedimiento o función en Oracle:

```sql
DROP PROCEDURE nombre_procedimiento;
DROP FUNCTION nombre_funcion;
```

Oracle no soporta `IF EXISTS`, así que debemos verificar previamente si el objeto existe antes de intentar borrarlo.
