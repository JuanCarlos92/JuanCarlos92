Cifrar y descifrar datos es una tarea muy común en la programación. En este artículo vamos a ver cómo hacerlo en Oracle.

## Cifrado sin reversibilidad

Estos métodos de cifrado no permiten descifrar el texto cifrado. Es decir, no se puede obtener el texto original a partir del texto cifrado. Se utilizan para almacenar contraseñas en la base de datos. El valor cifrado se llama hash. Este hash se puede comparar con otro hash para comprobar si la contraseña es correcta o no. Así se evita que un atacante pueda obtener las contraseñas de los usuarios.

### SHA1

El algoritmo SHA1 es un algoritmo de cifrado sin reversibilidad. Se utiliza para generar hashes de 40 caracteres. El hash se genera a partir de un texto plano. El texto plano no se puede obtener a partir del hash.

En Oracle se puede usar la función `DBMS_CRYPTO.HASH` con el parámetro `DBMS_CRYPTO.HASH_SH1`:

```sql
SELECT RAWTOHEX(DBMS_CRYPTO.HASH(UTL_I18N.STRING_TO_RAW('texto_plano', 'AL32UTF8'), DBMS_CRYPTO.HASH_SH1)) AS hash_valor FROM dual;
```

## Cifrados con reversibilidad

Estos métodos de cifrado permiten descifrar el texto cifrado. Es decir, se puede obtener el texto original a partir del texto cifrado. Se utilizan para almacenar datos sensibles en la base de datos.

En Oracle se puede usar `DBMS_CRYPTO.ENCRYPT` y `DBMS_CRYPTO.DECRYPT`. Estas funciones requieren de una clave de cifrado. Esta clave debe ser la misma para cifrar y descifrar los datos.

Ejemplo:

```plsql
DECLARE
    v_texto_plano  VARCHAR2(100) := 'texto_plano';
    v_clave         RAW(32) := UTL_RAW.cast_to_raw('clave_cifrado');
    v_texto_cifrado RAW(200);
    v_texto_descifrado VARCHAR2(100);
BEGIN
    v_texto_cifrado := DBMS_CRYPTO.ENCRYPT(
        src => UTL_RAW.cast_to_raw(v_texto_plano),
        typ => DBMS_CRYPTO.AES_CBC_PKCS5,
        key => v_clave
    );

    v_texto_descifrado := UTL_RAW.cast_to_varchar2(
        DBMS_CRYPTO.DECRYPT(
            src => v_texto_cifrado,
            typ => DBMS_CRYPTO.AES_CBC_PKCS5,
            key => v_clave
        )
    );

    DBMS_OUTPUT.PUT_LINE('Texto descifrado: ' || v_texto_descifrado);
END;
/
```
