En Oracle, las variables funcionan de manera diferente a MySQL. No existe un comando `SHOW VARIABLES` ni `SET` global como en MySQL. En Oracle se usan **variables de sesión** y **bind variables**.

## Consultar parámetros de sesión y sistema

Podemos consultar los valores de parámetros usando `SHOW PARAMETER`:

```sql
SHOW PARAMETER nombre_parametro;
```

O usando `V$PARAMETER`:

```sql
SELECT name, value FROM v$parameter WHERE name LIKE '%optimizer%';
```

## Variables de sesión

Para cambiar un parámetro de sesión temporalmente:

```sql
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';
```

> 💡 Este cambio solo afecta la sesión actual.

## Variables en PL/SQL

Se pueden declarar y usar variables en bloques PL/SQL o scripts SQL*Plus:

```sql
DECLARE
  v_salario NUMBER := 1000;
BEGIN
  DBMS_OUTPUT.PUT_LINE('El salario es: ' || v_salario);
END;
/
```

## Bind variables en SQL*Plus

Se pueden usar variables para consultas interactivas:

```sql
VARIABLE v_num NUMBER;
EXEC :v_num := 10;
PRINT v_num;
```
