# Comandos básicos de Angular CLI

Angular CLI (`ng`) es la herramienta oficial para crear, desarrollar y
mantener aplicaciones Angular.

------------------------------------------------------------------------

## Instalación de Angular CLI

Instalar Angular CLI globalmente:

``` bash
npm install -g @angular/cli
```

Verificar instalación:

``` bash
ng version
```

Actualizar Angular CLI:

``` bash
npm install -g @angular/cli@latest
```

------------------------------------------------------------------------

## Crear un nuevo proyecto

Crear un nuevo proyecto Angular:

``` bash
ng new nombre-proyecto
```

Crear un proyecto sin instalar dependencias automáticamente:

``` bash
ng new nombre-proyecto --skip-install
```

Crear un proyecto usando módulos clásicos (sin standalone):

``` bash
ng new nombre-proyecto --standalone=false
```

------------------------------------------------------------------------

## Servidor de desarrollo

Levantar el servidor de desarrollo:

``` bash
ng serve
```

Levantar el servidor y abrir el navegador automáticamente:

``` bash
ng serve --open
```

Cambiar el puerto por defecto:

``` bash
ng serve --port 4201
```

Permitir acceso desde la red local:

``` bash
ng serve --host 0.0.0.0
```

Modo producción:

``` bash
ng serve --configuration production
```

------------------------------------------------------------------------

## Construcción del proyecto

Construir el proyecto:

``` bash
ng build
```

Construcción para producción:

``` bash
ng build --configuration production
```

Indicar carpeta de salida:

``` bash
ng build --output-path dist
```

Analizar el bundle generado:

``` bash
ng build --stats-json
```

------------------------------------------------------------------------

## Generación de código (Scaffolding)

Generar un componente:

``` bash
ng generate component nombre-componente
```

Versión corta:

``` bash
ng g c nombre-componente
```

Generar componente en carpeta específica:

``` bash
ng g c carpeta/nombre-componente
```

Versión corta + omitir test:

``` bash
ng g c nombre-componente --skip-tests
```

Versión con template y estilos inline + omitir test:

``` bash
ng g c nombre-componente --inline-template --inline-style --skip-tests
```

------------------------------------------------------------------------

Generar un servicio:

``` bash
ng generate service nombre-servicio
```

Versión corta:

``` bash
ng g s nombre-servicio
```

Versión corta + omitir test:

``` bash
ng g s nombre-servicio --skip-tests
```

------------------------------------------------------------------------

Generar un módulo:

``` bash
ng generate module nombre-modulo
```

Versión corta:

``` bash
ng g m nombre-modulo
```

Generar módulo con routing:

``` bash
ng g m nombre-modulo --routing
```

Versión corta + omitir test:

``` bash
ng g m nombre-modulo --skip-tests
```

------------------------------------------------------------------------

Generar una clase:

``` bash
ng generate class nombre-clase
```

Generar una interfaz:

``` bash
ng generate interface nombre-interfaz
```

Generar un enum:

``` bash
ng generate enum nombre-enum
```

Generar un pipe:

``` bash
ng generate pipe nombre-pipe
```

Generar una directiva:

``` bash
ng generate directive nombre-directiva
```

Generar un guard:

``` bash
ng generate guard nombre-guard
```

------------------------------------------------------------------------

## Actualización del proyecto

Actualizar Angular y dependencias:

``` bash
ng update
```

Actualizar Angular core y CLI:

``` bash
ng update @angular/core @angular/cli
```

------------------------------------------------------------------------

## Tests

Ejecutar tests unitarios:

``` bash
ng test
```

Ejecutar tests sin modo watch:

``` bash
ng test --watch=false
```

------------------------------------------------------------------------

## Producción

Generar versión optimizada para producción:

``` bash
ng build --configuration=production
```

Versión corta (deprecated en Angular moderno):

``` bash
ng build --prod
```

------------------------------------------------------------------------

## Otros comandos útiles

Mostrar versión de Angular:

``` bash
ng version
```

Mostrar ayuda:

``` bash
ng help
```

Mostrar ayuda de un comando específico:

``` bash
ng help build
```

Limpiar caché:

``` bash
ng cache clean
```

------------------------------------------------------------------------

## Notas

-   Angular CLI requiere Node.js y npm.
-   Todos los comandos `ng generate` tienen forma corta `ng g`.
-   Se recomienda usar la versión LTS de Node.js.
-   La configuración de producción aplica optimizaciones, minimización y
    compilación AOT.
