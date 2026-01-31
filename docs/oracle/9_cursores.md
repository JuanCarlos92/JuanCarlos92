Un cursor en Oracle PL/SQL es una consulta declarada que permite recorrer los resultados de una consulta fila por fila. Los cursores se usan dentro de bloques PL/SQL, procedimientos o funciones y se deben declarar después de las variables locales.

Para usar un cursor, debemos:

* Declarar el cursor.
* Abrir el cursor.
* Recuperar las filas con `FETCH`.
* Cerrar el cursor con `CLOSE`.

## Sintaxis básica

```plsql
DECLARE
    v_variable empleados.salario%TYPE;
    CURSOR c_empleados IS SELECT salario FROM empleados;
BEGIN
    OPEN c_empleados;
    FETCH c_empleados INTO v_variable;
    DBMS_OUTPUT.PUT_LINE(v_variable);
    CLOSE c_empleados;
END;
/
```

## Uso con bucles

Para leer todos los valores de un cursor, lo habitual es usar un bucle `LOOP` o un bucle `FOR` implícito.

### Con LOOP (todos los valores)

```plsql
DECLARE
    v_total NUMBER := 0;
    v_precio productos.precio%TYPE;
    c_productos CURSOR IS SELECT precio FROM productos;
BEGIN
    OPEN c_productos;
    LOOP
        FETCH c_productos INTO v_precio;
        EXIT WHEN c_productos%NOTFOUND;
        v_total := v_total + v_precio;
    END LOOP;
    CLOSE c_productos;
    DBMS_OUTPUT.PUT_LINE('Total: ' || v_total);
END;
/
```

### Con FOR LOOP implícito (más simple)

```plsql
DECLARE
    v_total NUMBER := 0;
BEGIN
    FOR rec IN (SELECT precio FROM productos) LOOP
        v_total := v_total + rec.precio;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Total: ' || v_total);
END;
/
```

> 💡 Nota: En Oracle PL/SQL no se utiliza `REPEAT UNTIL` ni `HANDLER` como en MySQL; se usa `EXIT WHEN` para terminar bucles o se aprovecha el bucle FOR implícito para recorrer todos los registros del cursor.
