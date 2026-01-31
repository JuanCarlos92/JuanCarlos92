Exportar e importar bases de datos es un proceso crítico y totalmente necesario para proteger nuestros datos.

Estas exportaciones se pueden hacer con clientes como SQL Developer, Oracle SQL*Plus, etc. En la práctica, suele haber incompatibilidades entre algunas versiones de los clientes con el servidor de bases de datos. Personalmente, siempre recomiendo utilizar las utilidades que proporciona Oracle para minimizar la posibilidad de errores.

A continuación, una lista de cómo exportar e importar bases de datos SQL clasificados por tecnología:

## Oracle

### Exportar

Podemos exportar con el siguiente comando usando `exp` o `expdp` (Data Pump Export):

```bash
expdp usuario/password@servicio DIRECTORY=directorio_dump DUMPFILE=salida.dmp SCHEMAS=esquema
```

Ejemplo real:

```bash
expdp system/mi_password@orcl DIRECTORY=dpump_dir1 DUMPFILE=database1.dmp SCHEMAS=HR
```

Exportar múltiples esquemas:

```bash
expdp system/mi_password@orcl DIRECTORY=dpump_dir1 DUMPFILE=databases.dmp SCHEMAS=HR,SCOTT,SALES
```

Exportar tablas específicas:

```bash
expdp system/mi_password@orcl DIRECTORY=dpump_dir1 DUMPFILE=tables.dmp TABLES=employees,departments,jobs
```

### Importar

Podemos importar con el siguiente comando usando `imp` o `impdp` (Data Pump Import):

```bash
impdp usuario/password@servicio DIRECTORY=directorio_dump DUMPFILE=salida.dmp SCHEMAS=esquema
```
