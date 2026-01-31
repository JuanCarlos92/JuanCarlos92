## Creación de usuarios

Podemos crear usuarios para que accedan a la base de datos. Para ello, utilizamos el comando `CREATE USER`:

```sql
CREATE USER usuario IDENTIFIED BY password;
```

El comando anterior crea un usuario llamado `usuario` con contraseña `password`.

## Modificación de usuarios

Podemos modificar la contraseña de un usuario con el comando `ALTER USER`:

```sql
ALTER USER usuario IDENTIFIED BY nueva_password;
```

Podemos modificar el nombre de un usuario con el comando `ALTER USER` y `RENAME` no existe en Oracle de forma directa. Se recomienda crear un nuevo usuario y transferir objetos si es necesario.

## Eliminación de usuarios

Podemos eliminar un usuario con el comando `DROP USER`:

```sql
DROP USER usuario CASCADE;
```

## Bloqueo y desbloqueo de usuarios

Si en algún momento queremos bloquear a un usuario:

```sql
ALTER USER usuario ACCOUNT LOCK;
```

Podemos desbloquear a un usuario:

```sql
ALTER USER usuario ACCOUNT UNLOCK;
```
