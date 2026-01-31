## Creación de permisos

Podemos crear permisos para que los usuarios puedan acceder a la base de datos. En Oracle se utiliza también el comando `GRANT`:

```sql
GRANT ALL PRIVILEGES TO usuario;
```

Si queremos darle permisos específicos, podemos hacerlo de la siguiente manera:

```sql
GRANT SELECT, INSERT, UPDATE, DELETE ON nombre_tabla TO usuario;
```

Para dar permisos sobre objetos concretos, como una tabla en particular:

```sql
GRANT SELECT, INSERT, UPDATE, DELETE ON tabla TO usuario;
```

Para permitir que el usuario pueda otorgar estos permisos a otros usuarios:

```sql
GRANT SELECT, INSERT ON tabla TO usuario WITH GRANT OPTION;
```

## Permisos sobre vistas

Los permisos sobre vistas se otorgan igual que sobre tablas:

```sql
GRANT SELECT ON vista TO usuario;
```

## Consultar permisos

Podemos consultar los permisos de un usuario mediante las vistas del diccionario de datos:

```sql
SELECT * FROM DBA_TAB_PRIVS WHERE GRANTEE = 'USUARIO';
```

## Eliminación de permisos

Para eliminar permisos se utiliza `REVOKE`:

Eliminar todos los permisos otorgados a un usuario sobre un objeto:

```sql
REVOKE ALL PRIVILEGES ON tabla FROM usuario;
```

Eliminar permisos específicos:

```sql
REVOKE SELECT, INSERT, UPDATE, DELETE ON tabla FROM usuario;
```
